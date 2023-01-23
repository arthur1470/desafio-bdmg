package br.com.bdmg.usecases.cadastro;

public record AdicionarImovelPessoaInput(
        String documento,
        String nomeImovel,
        double valorImovel
) {
}
