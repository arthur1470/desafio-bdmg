package br.com.bdmg.view;

import br.com.bdmg.usecases.geracao.GerarEstruturaExemploUseCase;
import br.com.bdmg.util.ScannerUtil;

import static java.lang.System.out;

public final class TelaInicio {
    private TelaInicio() {
    }

    public static void exibir() {
        out.println("###############################################################");
        out.println("#  Console Application Desafio Java                           #");
        out.println("#                                                             #");
        out.println("#  Calculo comprometimento financeiro                         #");
        out.println("#  ---------------------------------------------------------- #");
        out.println("# 1 - Gerar estrutura de exemplo do desafio                   #");
        out.println("# 2 - Cadastrar Pessoa ou Empresa                             #");
        out.println("# 3 - Listar todas Pessoas cadastradas                        #");
        out.println("# 4 - Listar todas Empresas cadastradas                       #");
        out.println("# 5 - Adicionar novo Socio a uma Empresa                      #");
        out.println("# 6 - Remover socio da empresa                                #");
        out.println("# 7 - Adicionar imovel a uma Pessoa ou Empresa                #");
        out.println("# 8 - Buscar uma Pessoa ou Empresa                            #");
        out.println("# 9 - Executar Calculo Comprometimento Financeiro da Empresa  #");
        out.println("###############################################################");
        final var opcao = ScannerUtil.solicitarNumero("Digite a opcao ou 0 para sair: ");

        switch (opcao) {
            case 0 -> out.println("Encerrando programa!");
            case 1 -> {
                GerarEstruturaExemploUseCase.execute();
                out.println("Estrutura gerada com sucesso!");
                exibir();
            }
            case 2 -> {
                TelaCadastroPessoa.exibir();
                exibir();
            }
            case 3 -> {
                TelaListagemPessoas.exibir();
                exibir();
            }
            case 4 -> {
                TelaListagemEmpresas.exibir();
                exibir();
            }
            case 5 -> {
                TelaAdicionarSocioEmpresa.exibir();
                exibir();
            }
            case 6 -> {
                TelaRemoverSocioEmpresa.exibir();
                exibir();
            }
            case 7 -> {
                TelaAdicionarImovel.exibir();
                exibir();
            }
            case 8 -> {
                TelaBuscarPessoaOuEmpresa.exibir();
                exibir();
            }
            case 9 -> {
                TelaCalculoFinanceiro.exibir();
                exibir();
            }
            default -> exibir();
        }
    }
}