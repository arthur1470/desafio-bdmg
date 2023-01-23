package br.com.bdmg.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class PessoaJuridica extends Pessoa {
    private EstruturaSocietaria estruturaSocietaria;

    private PessoaJuridica(
            final String nome,
            final String documento,
            final Set<Imovel> imoveis
    ) {
        super(nome, documento, imoveis);
    }

    public static PessoaJuridica novaPessoa(final String nome, final String documento, final Pessoa... pessoas) {
        final var pessoaJuridica = new PessoaJuridica(
                nome,
                documento,
                new HashSet<>()
        );

        pessoaJuridica.estruturaSocietaria = EstruturaSocietaria.novaEstrutura(pessoaJuridica, pessoas);

        return pessoaJuridica;
    }

    public PessoaJuridica adicionarSocio(final Pessoa pessoa) {
        this.estruturaSocietaria.adicionarSocio(pessoa);
        return this;
    }

    public PessoaJuridica removerSocio(final Pessoa pessoa) {
        this.estruturaSocietaria.removerSocio(pessoa);
        return this;
    }

    @Override
    public PessoaJuridica adicionarImovel(final Imovel imovel) {
        super.adicionarImovel(imovel);
        return this;
    }

    @Override
    public PessoaJuridica adicionarImovel(final String nome, final double valor) {
        super.adicionarImovel(nome, valor);
        return this;
    }

    public EstruturaSocietaria getEstruturaSocietaria() {
        return estruturaSocietaria;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome()
                + " CNPJ: " + this.getDocumento()

                + "\n        Imoveis: " + getImoveis().stream()
                                        .map(i -> "Nome: " + i.getNome() + ", Valor: " + i.getValor())
                                        .collect(Collectors.joining("\n                 "))

                + "\n        " + estruturaSocietaria;
    }
}
