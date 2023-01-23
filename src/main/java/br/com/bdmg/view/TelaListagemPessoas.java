package br.com.bdmg.view;

import br.com.bdmg.usecases.busca.ListarPessoasUseCase;
import br.com.bdmg.util.ScannerUtil;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.out;

public final class TelaListagemPessoas {
    private TelaListagemPessoas() {
    }

    public static void exibir() {
        final var useCase = new ListarPessoasUseCase();

        out.println();
        out.println("############# PESSOAS #############");
        final var index = new AtomicInteger();
        useCase.execute()
                .forEach(p -> out.println("#" + index.incrementAndGet() + " - " + p + "\n"));
        out.println("####################################");
        out.println();

        ScannerUtil.solicitarTexto("Digite qualquer tecla para continuar");
    }
}
