package br.com.bdmg.view;

import br.com.bdmg.exception.DomainException;
import br.com.bdmg.usecases.remove.RemoveSocioEmpresaInput;
import br.com.bdmg.usecases.remove.RemoveSocioEmpresaUseCase;

import static br.com.bdmg.util.ScannerUtil.*;
import static java.lang.System.out;

public final class TelaRemoverSocioEmpresa {
    private TelaRemoverSocioEmpresa() {
    }

    public static void exibir() {
        out.println("############# REMOVER SOCIO #############");
        final var documentoEmpresa = solicitarCnpj();
        out.println("# Agora informe o documento do socio: ");
        final var documentoSocio = solicitarDocumento();

        try {
            final var input = new RemoveSocioEmpresaInput(documentoEmpresa, documentoSocio);
            new RemoveSocioEmpresaUseCase().execute(input);
            out.println("# Socio removido da empresa com sucesso");
        } catch (DomainException ex) {
            out.println("### Erro na remocao de socio");
            out.println("# -> " + ex.getMessage());
        }

        final var opcao =
                solicitarTexto("Digite 0 para sair ou qualquer tecla para tentar novamente: ");

        if (!opcao.equals("0")) exibir();
    }
}
