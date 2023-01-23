package br.com.bdmg.usecases.remove;

import br.com.bdmg.exception.DomainException;
import br.com.bdmg.model.PessoaJuridica;
import br.com.bdmg.repository.PessoaRepository;

public class RemoveSocioEmpresaUseCase {
    private final PessoaRepository repository = PessoaRepository.getInstance();

    public void execute(final RemoveSocioEmpresaInput input) {
        final var documentoEmpresa = input.documentoEmpresa();
        final var documentoSocio = input.documentoSocio();

        final var empresa = (PessoaJuridica) repository.findByDocument(documentoEmpresa)
                .orElseThrow(() -> new DomainException("Empresa %s nao cadastrada".formatted(documentoEmpresa)));

        final var socio = repository.findByDocument(documentoSocio)
                .orElseThrow(() -> new DomainException("Socio %s nao cadastrado".formatted(documentoSocio)));

        empresa.removerSocio(socio);
    }
}
