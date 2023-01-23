package br.com.bdmg.view;

import br.com.bdmg.exception.DomainException;
import br.com.bdmg.usecases.calculo.ComprometimentoFinanceiroUseCase;
import br.com.bdmg.util.ScannerUtil;

import static br.com.bdmg.util.ScannerUtil.solicitarTexto;
import static java.lang.System.out;

public final class TelaCalculoFinanceiro {
    private TelaCalculoFinanceiro() {
    }

    public static void exibir() {
        out.println("############# CALCULO COMPROMETIMENTO FINANCEIRO #############");
        final var documento = ScannerUtil.solicitarCnpj();

        try {
            final var totalComprometimentoFinanceiro =
                    new ComprometimentoFinanceiroUseCase().execute(documento);
            out.println("# Total do comprometimento financeiro: " + totalComprometimentoFinanceiro);
        } catch (final DomainException ex) {
            out.println("### Erro ao buscar empresa");
            out.println("# -> " + ex.getMessage());
        }

        out.println("####################################################");
        out.println();

        final var opcao =
                solicitarTexto("Digite 0 para sair ou qualquer tecla para consultar novamente: ");

        if (!opcao.equals("0")) exibir();
    }
}
