package br.com.bdmg.usecases.busca;

import br.com.bdmg.model.Imovel;
import br.com.bdmg.model.Pessoa;

import java.util.Set;
import java.util.stream.Collectors;

public record BuscarPessoaOutput(
        String nome,
        String documento,
        Set<Pessoa> socios,
        Set<Imovel> imoveisPessoa,
        Set<Imovel> imoveisSocios
) {

    @Override
    public String toString() {
        final var isEmpresa = documento.length() > 11;

        final var textoNome = (isEmpresa ? "Nome da Empresa: " : "Nome da Pessoa: ") + nome + ", ";
        final var textoDocumento = (isEmpresa ? "CNPJ: " : "CPF: ") + documento;

        final var textoSocios = "             Socios: " +
                socios.stream()
                        .map(p -> "Nome: " + p.getNome() + (p.getDocumento().length() > 11 ? ", CNPJ: " : " CPF: ") + p.getDocumento())
                        .collect(Collectors.joining("\n                     "));

        final var textoImoveisPessoa = (isEmpresa ? "Imoveis da Empresa: " : "Imoveis da Pessoa: ") +
                imoveisPessoa().stream()
                        .map(i -> "Nome: " + i.getNome() + ", Valor: " + i.getValor())
                        .collect(Collectors.joining("\n                    "));

        final var textoImoveisSocios = "Imoveis dos Socios: " +
                imoveisSocios().stream()
                        .map(i -> "Nome: " + i.getNome() + ", Valor: " + i.getValor())
                        .collect(Collectors.joining("\n                    "));

        return textoNome
                + textoDocumento + "\n"
                + textoSocios + "\n\n"
                + textoImoveisPessoa + "\n\n"
                + textoImoveisSocios;
    }
}
