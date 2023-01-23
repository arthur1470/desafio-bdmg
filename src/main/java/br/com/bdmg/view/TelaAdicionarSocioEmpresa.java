package br.com.bdmg.view;

import br.com.bdmg.exception.DomainException;
import br.com.bdmg.usecases.cadastro.AdicionarSocioEmpresaInput;
import br.com.bdmg.usecases.cadastro.AdicionarSocioEmpresaUseCase;

import static br.com.bdmg.util.ScannerUtil.*;
import static java.lang.System.out;

public final class TelaAdicionarSocioEmpresa {
    private TelaAdicionarSocioEmpresa() {
    }

    public static void exibir() {
        out.println("############# ADICIONAR SOCIO A EMPRESA #############");
        final var documentoEmpresa = solicitarCnpj();
        out.println("# Agora informe o documento do socio: ");
        final var documentoSocio = solicitarDocumento();

        try {
            final var input = new AdicionarSocioEmpresaInput(documentoEmpresa, documentoSocio);
            new AdicionarSocioEmpresaUseCase().execute(input);
            out.println("# Socio adicionado a pessoa com sucesso");
        } catch (DomainException ex) {
            out.println("### Erro no cadastro de pessoa.");
            out.println("# -> " + ex.getMessage());
        }

        final var opcao =
                solicitarTexto("Digite 0 para sair ou qualquer tecla para cadastrar novamente: ");

        if (!opcao.equals("0")) exibir();
    }
}
