package br.com.bdmg.usecases.cadastro;

public record CadastroPessoaInput(
        String nome,
        String documentoPessoa,
        String documentoSocio
) {
    public static CadastroPessoaInput novoInput(
            final String nome,
            final String documentoPessoa,
            final String documentoSocio
    ) {
        return new CadastroPessoaInput(nome, documentoPessoa, documentoSocio);
    }
}
