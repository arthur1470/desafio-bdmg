package br.com.bdmg.usecases.cadastro;

import br.com.bdmg.exception.DomainException;
import br.com.bdmg.model.PessoaJuridica;
import br.com.bdmg.repository.PessoaRepository;

public class AdicionarSocioEmpresaUseCase {

    private final PessoaRepository repository = PessoaRepository.getInstance();

    public void execute(final AdicionarSocioEmpresaInput input) {
        final var documentoEmpresa = input.documentoEmpresa();
        final var documentoSocio = input.documentoSocio();

        final var empresa = (PessoaJuridica) repository.findByDocument(documentoEmpresa)
                .orElseThrow(() -> new DomainException("Empresa %s nao cadastrada".formatted(documentoEmpresa)));

        final var socio = repository.findByDocument(documentoSocio)
                .orElseThrow(() -> new DomainException("Socio %s nao cadastrado".formatted(documentoSocio)));

        empresa.adicionarSocio(socio);
    }
}
