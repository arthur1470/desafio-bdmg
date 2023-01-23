package br.com.bdmg.usecases.busca;

import br.com.bdmg.exception.DomainException;
import br.com.bdmg.model.Imovel;
import br.com.bdmg.model.Pessoa;
import br.com.bdmg.model.PessoaJuridica;
import br.com.bdmg.repository.PessoaRepository;
import br.com.bdmg.util.PessoaUtil;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BuscarPessoaUseCase {
    private final PessoaRepository repository = PessoaRepository.getInstance();

    public BuscarPessoaOutput execute(final String documento) {
        final var pessoa = repository.findByDocument(documento)
                .orElseThrow(() -> new DomainException("Pessoa com documento %s nao encontrada.".formatted(documento)));

        final var todosSocios = getSocios(pessoa);
        final var imoveisSocios = getImoveisSocios(pessoa, todosSocios);

        return new BuscarPessoaOutput(
                pessoa.getNome(),
                pessoa.getDocumento(),
                todosSocios,
                pessoa.getImoveis(),
                imoveisSocios
        );
    }

    private Set<Pessoa> getSocios(final Pessoa pessoa) {
        if (pessoa instanceof PessoaJuridica pj) {
            final var estruturaSocietaria = pj.getEstruturaSocietaria();

            final var socios = PessoaUtil.buscarTodosSocios(
                    new HashSet<>(Set.of(estruturaSocietaria.getPessoaJuridica())),
                    estruturaSocietaria
            );
            socios.remove(pessoa);

            return socios;
        }

        return Collections.emptySet();
    }

    private Set<Imovel> getImoveisSocios(final Pessoa pessoa, final Set<Pessoa> todosSocios) {
        final var imoveisSocios = todosSocios.stream()
                .flatMap(p -> p.getImoveis().stream())
                .collect(Collectors.toSet());

        imoveisSocios.removeAll(pessoa.getImoveis());

        return imoveisSocios;
    }
}
