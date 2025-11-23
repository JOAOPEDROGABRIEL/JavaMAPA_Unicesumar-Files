# Atividade MAPA: Programação Orientada a Objetos

**LINGUAGEM UTILIZADA:** 
        
    Java


## Introdução

**Proposta de Atividade**

    Você está trabalhando em uma empresa que está desenvolvendo um sistema de gerenciamento de contas 
    bancárias. Seu líder de equipe pediu que você implementasse a primeira versão da classe ContaBancaria, 
    utilizando os princípios de encapsulamento e aplicando corretamente os modificadores de acesso do Java.

    Seu desafio é garantir que os atributos da conta (como saldo e titular) sejam protegidos contra 
    alterações indevidas e que somente métodos específicos possam acessar ou modificar esses dados de forma 
    segura.
                (elaborado pelo autor) 

    Questão 1: Crie uma classe chamada ContaBancaria com os seguintes atributos:

        titular : String
        numeroConta : int
        saldo : double

    Aplique os modificadores de acesso adequados para garantir o encapsulamento dos dados.

        Implemente métodos públicos para:
        Consultar o saldo (método getSaldo)
        Depositar um valor (método depositar)
        Sacar um valor (método sacar, com verificação de saldo suficiente)

    No método main, crie uma instância da classe ContaBancaria, faça um depósito e um saque, e imprima o 
    saldo final.

    Questão 2: Por fim, responda, qual a importância do encapsulamento na segurança e manutenção do código?

**Resolução**

    Para começar, vamos considerar a criação da classe ContaBancaria, com enfoque no desenvolvimento de suas 
    funções e abstrair somente os principais métodos para interação interno ao Objeto da Classe.

**Estrutura classe ```ContaBancaria```**

Atributos:

    - titular : String    < Nome do Cliente
    - numeroConta : int   < Número da Conta
    - saldo : double      < Saldo

Métodos:

    //Construtores
    + ContaBancaria()           < Construtor principal

    //Getters e Setters
    + getTitutlar() : String    < Consulta Titular
    + getNumeroConta() : int    < Consulta Número da Conta
    + getSaldo() : double       < Consulta Saldo
    + setTitular(string) : void < Altera valor 'Titular'

    //Métodos Exclusivos
    + depositar(double) : void  < Deposita valor específico
    + sacar(double) : boolean   < Saca valor específico

    //Formatação e Saída
    + toString() : String       < Retorna dados com formatação prioritária

## Como Executar o Projeto

O projeto possui um método main híbrido que detecta automaticamente se deve rodar o menu ou executar diretamente 
via argumentos.

**Opção A:** Modo Interativo (Menu)

Execute sem argumentos para abrir o sistema de menus.

    java Main


**Opção B:** Modo "Live Function" (CLI)

Para agilizar testes ou consultas rápidas, passe os dados diretamente na linha de comando.
Sintaxe: java Main "Nome Titular" <Numero> <DepositoInicial>

    java Main "Joao Silva" 12345 500.00


Saída esperada: Cria a conta, deposita 500.00, simula um saque de teste e exibe o relatório final.


### Resolução da Questão 2:

    O Encapsulamento é uma das diversas técnicas para manter objetos e seus métodos seguros de operações externas, 
    e com isso, traz oportunidades de implementação de serviços de monitoramento como log de servidor, ou manipulação 
    de atributos de objetos, ou seja, é possível monitorar qualquer atividade a partir do encapsulamento, e com isso 
    trazer segurança, já que os atributos dos seus respectivos objetos estarão bloqueados para alteração por classes 
    externas a sua própria classe de construção.

    Além disso, é crucial para a manutenção do código: ao centralizar a lógica de acesso aos dados dentro da própria 
    classe, cria-se a oportunidade de alterar regras de negócio internas ou corrigir bugs sem precisar reescrever o 
    código das outras partes do sistema que utilizam esses objetos (baixo acoplamento).

## Anotações Extras:

    A classe Main, tem por objetivo realizar integração com a classe ContaBancaria, para isso temos dois métodos que 
    realizam essa interação, justamente as duas funções possíveis e mensionadas anteriormente, com o modo de 
    funcionamento em CLI, e um Modo Interativo.

    No modo interativo, se trata de um menu onde se é capaz de cadastrar uma conta bancária e a partir disso realizar 
    as operações desejadas, já no modo CLI, se trata de uma visualização rápida de como aquele objeto deve parecer, é 
    um caso bem comum em ambientes em servidores que necessitam de comunicação com outros recursos, entretanto para 
    este projeto, como não há persistência de dados, acaba se tornando uma função obsoleta, já que somente realiza 
    uma sequência pré-programada de operações, e após isso perde os dados, o objetivo de implementação, é para teste 
    de integração e para uma possível integração futura de recursos live server, e para facilitar avaliação. Ao 
    iniciar o modo Interativo será necessário criar uma conta para utilização do sistema, já para o modo CLI a criação 
    já é feita automática, entretanto não entra no modo de execução interativo, e em ambos os casos, todo e qualquer 
    dado coletado será armazenado temporáriamente até o momento de finalização do sistema, após isso, todos os dados 
    coletados serão excluídos.

    As classes são protegidas por excessões, ou seja, na classe ContaBancaria, uma excessão impedirá a contrução de 
    um objeto inválido, garantindo integridade da estrutura, já a classe Main, trata as exceções com o 'try-catch' 
    notificando o usuário do motivo causador da mesma.