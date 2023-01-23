package br.com.bdmg.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Pessoa {
    private String documento;
    private String nome;
    private Set<Imovel> imoveis;

    protected Pessoa(final String nome, final String documento, final Set<Imovel> imoveis) {
        this.nome = nome;
        this.documento = documento;
        this.imoveis = imoveis;
    }

    public static Pessoa novaPessoa(
            final String nome,
            final String documento
    ) {
        return new Pessoa(
                nome,
                documento,
                new HashSet<>()
        );
    }

    public Pessoa adicionarImovel(final Imovel imovel) {
        this.imoveis.add(imovel);
        return this;
    }

    public Pessoa adicionarImovel(final String nome, final double valor) {
        return adicionarImovel(Imovel.novoImovel(nome, valor));
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public Set<Imovel> getImoveis() {
        return Collections.unmodifiableSet(imoveis);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return getDocumento().equals(pessoa.getDocumento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDocumento());
    }

    @Override
    public String toString() {
        return "Nome: " + nome
                + " CPF: " + documento
                + "\n        Imoveis: " + getImoveis().stream()
                                            .map(i -> "Nome: " + i.getNome() + ", Valor: " + i.getValor())
                                            .collect(Collectors.joining("\n                 "));
    }
}
