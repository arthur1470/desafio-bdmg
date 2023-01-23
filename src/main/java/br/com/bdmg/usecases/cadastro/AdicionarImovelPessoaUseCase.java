package br.com.bdmg.usecases.cadastro;

import br.com.bdmg.exception.DomainException;
import br.com.bdmg.repository.PessoaRepository;

public class AdicionarImovelPessoaUseCase {
    private final PessoaRepository repository = PessoaRepository.getInstance();

    public void execute(final AdicionarImovelPessoaInput input) {
        final var documento = input.documento();

        final var pessoa = repository.findByDocument(documento)
                .orElseThrow(() -> new DomainException("Pessoa %s nao cadastrada".formatted(documento)));

        pessoa.adicionarImovel(input.nomeImovel(), input.valorImovel());
    }
}
