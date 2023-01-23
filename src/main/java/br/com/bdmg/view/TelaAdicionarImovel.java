package br.com.bdmg.view;

import br.com.bdmg.exception.DomainException;
import br.com.bdmg.usecases.cadastro.AdicionarImovelPessoaInput;
import br.com.bdmg.usecases.cadastro.AdicionarImovelPessoaUseCase;

import static br.com.bdmg.util.ScannerUtil.*;
import static java.lang.System.out;

public class TelaAdicionarImovel {
    private TelaAdicionarImovel() {
    }

    public static void exibir() {
        out.println("############# ADICIONAR IMOVEL A PESSOA #############");
        out.println("# Agora informe o documento da pessoa: ");
        final var documento = solicitarDocumento();
        final var nomeImovel = solicitarTexto("Digite o nome do imovel: ");
        final var valorImovel = solicitarNumeroDecimal("Digite o valor do imovel: ");

        try {
            final var input = new AdicionarImovelPessoaInput(documento, nomeImovel, valorImovel);
            new AdicionarImovelPessoaUseCase().execute(input);
            out.println("# Imovel adicionado com sucesso");
        } catch (DomainException ex) {
            out.println("### Erro ao adicionar imovel.");
            out.println("# -> " + ex.getMessage());
        }

        final var opcao =
                solicitarTexto("Digite 0 para sair ou qualquer tecla para cadastrar novamente: ");

        if (!opcao.equals("0")) exibir();
    }
}
