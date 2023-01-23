package br.com.bdmg.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EstruturaSocietaria {
    private PessoaJuridica pessoaJuridica;
    private Set<Pessoa> socios;

    private EstruturaSocietaria(final PessoaJuridica proprietario, final Set<Pessoa> socios) {
        this.pessoaJuridica = proprietario;
        this.socios = socios;
    }

    public static EstruturaSocietaria novaEstrutura(
            final PessoaJuridica proprietario,
            final Pessoa... socios
    ) {
        return new EstruturaSocietaria(
                proprietario,
                new HashSet<>(Set.of(socios))
        );
    }

    public EstruturaSocietaria adicionarSocio(final Pessoa pessoa) {
        this.socios.add(pessoa);

        return this;
    }

    public EstruturaSocietaria removerSocio(final Pessoa pessoa) {
        this.socios.remove(pessoa);

        return this;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public Set<Pessoa> getSocios() {
        return Collections.unmodifiableSet(socios);
    }

    @Override
    public String toString() {
        return " Socios: " +
                socios.stream()
                        .map(p -> "Nome: " + p.getNome() +
                                (p.getDocumento().length() > 11 ? ", CNPJ: " : " CPF: ") + p.getDocumento()
                        )
                        .collect(Collectors.joining("\n                 "));
    }
}
