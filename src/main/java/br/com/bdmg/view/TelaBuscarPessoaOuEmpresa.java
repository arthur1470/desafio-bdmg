package br.com.bdmg.view;

import br.com.bdmg.exception.DomainException;
import br.com.bdmg.usecases.busca.BuscarPessoaUseCase;
import br.com.bdmg.util.ScannerUtil;

import static br.com.bdmg.util.ScannerUtil.solicitarTexto;
import static java.lang.System.out;

public final class TelaBuscarPessoaOuEmpresa {
    private TelaBuscarPessoaOuEmpresa() {
    }

    public static void exibir() {
        out.println("############# BUSCAR PESSOA OU EMPRESA #############");
        final var documento = ScannerUtil.solicitarDocumento();
        out.println();

        try {
            final var pessoa = new BuscarPessoaUseCase().execute(documento);
            out.println(pessoa);
        } catch (final DomainException ex) {
            out.println("### Erro ao buscar pessoa");
            out.println("# -> " + ex.getMessage());
        }

        out.println("####################################################");
        out.println();

        final var opcao =
                solicitarTexto("Digite 0 para sair ou qualquer tecla para buscar novamente: ");

        if (!opcao.equals("0")) exibir();
    }
}
