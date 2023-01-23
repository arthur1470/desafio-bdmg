package br.com.bdmg.view;

import br.com.bdmg.exception.DomainException;
import br.com.bdmg.usecases.cadastro.CadastroPessoaInput;
import br.com.bdmg.usecases.cadastro.CadastroPessoaUseCase;

import static br.com.bdmg.util.ScannerUtil.solicitarDocumento;
import static br.com.bdmg.util.ScannerUtil.solicitarTexto;
import static java.lang.System.out;

public final class TelaCadastroPessoa {
    private TelaCadastroPessoa() {
    }

    public static void exibir() {
        out.println("############# CADASTRAR PESSOA #############");

        final var documento = solicitarDocumento();
        final var tipoPessoa = documento.length() > 11 ? "empresa" : "pessoa";
        final var nome = solicitarTexto("Digite o nome da " + tipoPessoa);
        var documentoSocio = "";

        if (tipoPessoa.equalsIgnoreCase("empresa")) {
            out.println("Agora preencha o documento do socio");
            documentoSocio = solicitarDocumento();
        }

        final var input =
                CadastroPessoaInput.novoInput(nome, documento, documentoSocio);
        try {
            new CadastroPessoaUseCase().execute(input);
        } catch (DomainException ex) {
            out.println("### Erro no cadastro de pessoa.");
            out.println("# -> " + ex.getMessage());
        }

        final var opcao =
                solicitarTexto("Digite 0 para sair ou qualquer tecla para cadastrar novamente: ");

        if (!opcao.equals("0")) exibir();
    }
}
