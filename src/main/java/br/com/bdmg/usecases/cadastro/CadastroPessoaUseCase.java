package br.com.bdmg.usecases.cadastro;

import br.com.bdmg.exception.DomainException;
import br.com.bdmg.model.Pessoa;
import br.com.bdmg.model.PessoaJuridica;
import br.com.bdmg.repository.PessoaRepository;

public class CadastroPessoaUseCase {

    private final PessoaRepository repository = PessoaRepository.getInstance();

    public void execute(final CadastroPessoaInput input) {
        final var nome = input.nome();
        final var documento = input.documentoPessoa();
        final var documentoSocio = input.documentoSocio();

        if (repository.existsByDocument(documento)) {
            throw new DomainException("O documento %s ja esta cadastrado.".formatted(documento));
        }

        if (!documentoSocio.isBlank()) {
            final var socio = repository.findByDocument(documentoSocio)
                    .orElseThrow(() -> new DomainException("O socio informado nao esta cadastrado"));

            repository.save(PessoaJuridica.novaPessoa(nome, documento, socio));
        } else {
            repository.save(Pessoa.novaPessoa(nome, documento));
        }
    }
}
