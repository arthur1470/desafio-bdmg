package br.com.bdmg.usecases.geracao;

import br.com.bdmg.model.Pessoa;
import br.com.bdmg.model.PessoaJuridica;
import br.com.bdmg.repository.PessoaRepository;

import static java.util.Set.of;

public final class GerarEstruturaExemploUseCase {

    private GerarEstruturaExemploUseCase() {
    }

    public static void execute() {
        final var repository = PessoaRepository.getInstance();

        final var pf1 = Pessoa.novaPessoa("Pessoa Fisica 1", "00000000001")
                .adicionarImovel("Pf1 casa", 1000);

        final var pf2 = Pessoa.novaPessoa("Pessoa Fisica 2", "00000000002")
                .adicionarImovel("Pf2 casa", 1000);

        final var pf3 = Pessoa.novaPessoa("Pessoa Fisica 3", "00000000003")
                .adicionarImovel("Pf3 casa", 1000);

        final var pf4 = Pessoa.novaPessoa("Pessoa Fisica 4", "00000000004")
                .adicionarImovel("Pf4 casa", 1000);

        final var pf5 = Pessoa.novaPessoa("Pessoa Fisica 5", "00000000005")
                .adicionarImovel("Pf5 casa", 1000);

        final var empresaA = PessoaJuridica.novaPessoa("Empresa A", "00000000000001", pf1, pf2)
                .adicionarImovel("EmpresaA imovel", 1000);

        final var empresaB = PessoaJuridica.novaPessoa("Empresa B", "00000000000002", pf3, empresaA)
                .adicionarImovel("EmpresaB imovel", 1000);

        final var empresaC = PessoaJuridica.novaPessoa("Empresa C", "00000000000003", pf1, empresaA, empresaB)
                .adicionarImovel("EmpresaC imovel", 1000);
        empresaC.adicionarSocio(empresaC);

        final var empresaD = PessoaJuridica.novaPessoa("Empresa D", "00000000000004", pf4, pf5, empresaC)
                .adicionarImovel("EmpresaD imovel", 1000);
        empresaA.adicionarSocio(empresaD);

        repository.saveAll(of(pf1, pf2, pf3, pf4, pf5, empresaA, empresaB, empresaC, empresaD));
    }
}
