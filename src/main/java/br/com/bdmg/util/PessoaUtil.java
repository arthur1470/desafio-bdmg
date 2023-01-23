package br.com.bdmg.util;

import br.com.bdmg.model.EstruturaSocietaria;
import br.com.bdmg.model.Pessoa;
import br.com.bdmg.model.PessoaJuridica;

import java.util.Set;

public final class PessoaUtil {

    private PessoaUtil() {
    }

    public static Set<Pessoa> buscarTodosSocios(
            final Set<Pessoa> pessoasLidas,
            final EstruturaSocietaria estruturaSocietaria
    ) {
        estruturaSocietaria.getSocios().forEach(pessoa -> {
            final var socioJaContabilizado = pessoasLidas.contains(pessoa);

            if (socioJaContabilizado) return;

            pessoasLidas.add(pessoa);

            if (pessoa instanceof PessoaJuridica pj) {
                buscarTodosSocios(pessoasLidas, pj.getEstruturaSocietaria());
            }
        });

        return pessoasLidas;
    }
}
