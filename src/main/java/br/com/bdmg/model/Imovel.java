package br.com.bdmg.model;

import java.util.Objects;
import java.util.UUID;

public class Imovel {
    private UUID id;
    private String nome;
    private double valor;

    private Imovel(
            final UUID id,
            final String nome,
            final double valor
    ) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public static Imovel novoImovel(final String nome, final double valor) {
        return new Imovel(
                UUID.randomUUID(),
                nome,
                valor
        );
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imovel imovel = (Imovel) o;
        return getId().equals(imovel.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Imovel: "
                + "nome: " + nome
                + ", valor: " + valor;
    }
}
