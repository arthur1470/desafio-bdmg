<center>
  <h1 align="center">Desafio Java BDMG</h1>
  <p align="center">
    Aplicação no estilo Java Console Application, que calcula o comprometimento financeiro de uma empresa, 
    levando em conta o total de bens imóveis desta empresa e de seus sócios.
  </p>
</center>
<br />

## Ferramentas necessárias

- JDK 17
- IDE de sua preferência

## Como executar?

1. Clonar o repositório:
```sh
git clone https://github.com/arthur1470/desafio-bdmg.git
```

2. Executar a aplicação no terminal:
```shell
./gradlew run --console=plain
``` 

> Ou se preferir, execute através de sua IDE:
> método main() na classe Main.java do pacote br.com.bdmg

## Objetivo Principal

O objetivo principal, era de conseguir calcular o comprometimento financeiro de uma empresa, através de sua estrutura societária.
Como a estrutura societária de uma empresa pode se estender a níveis infinitos, pois a empresa A pode ter como sócio a empresa B, e a empresa B pode ter
como sócio a empresa C, e assim por diante infinitamente, para que nossa função conseguisse percorrer toda a extensão de estruturas societárias,
foi utilizado o conceito de Recursividade, assim nosso algoritmo consegue percorrer toda a estrutura, e trazer todos os sócios para realizar o cálculo. 

> O Código que realiza o cálculo, está no pacote br.com.bdmg.usecases.calculo, na classe ComprometimentoFinanceiroUseCase.java
