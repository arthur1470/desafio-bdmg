package br.com.bdmg.usecases.calculo;

import br.com.bdmg.exception.DomainException;
import br.com.bdmg.model.Imovel;
import br.com.bdmg.model.PessoaJuridica;
import br.com.bdmg.repository.PessoaRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static br.com.bdmg.util.PessoaUtil.buscarTodosSocios;

public class ComprometimentoFinanceiroUseCase {
    private final PessoaRepository repository = PessoaRepository.getInstance();

    public Double execute(final String cnpj) {
        final var empresa = (PessoaJuridica) repository.findByDocument(cnpj)
                .orElseThrow(() -> new DomainException("Empresa com CNPJ %s nao encontrada.".formatted(cnpj)));

        final var estruturaSocietaria = empresa.getEstruturaSocietaria();

        final var todosSocios = buscarTodosSocios(
                new HashSet<>(Set.of(estruturaSocietaria.getPessoaJuridica())),
                estruturaSocietaria
        );

        final var todosImoveis = todosSocios.stream()
                .flatMap(p -> p.getImoveis().stream())
                .collect(Collectors.toSet());

        return todosImoveis.stream()
                .map(Imovel::getValor)
                .reduce(0.0, Double::sum);
    }
}
