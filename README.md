# Atividade MAPA: Programação Orientada a Objetos

**LINGUAGEM UTILIZADA:** 
        
    Java


## Introdução

**Proposta de Atividade**

    Você está trabalhando em uma empresa que está desenvolvendo um sistema de gerenciamento de contas bancárias. Seu líder de equipe pediu que você implementasse a primeira versão da classe ContaBancaria, utilizando os princípios de encapsulamento e aplicando corretamente os modificadores de acesso do Java.

    Seu desafio é garantir que os atributos da conta (como saldo e titular) sejam protegidos contra alterações indevidas e que somente métodos específicos possam acessar ou modificar esses dados de forma segura.
                (elaborado pelo autor) 

        Questão 1: 
    Crie uma classe chamada ContaBancaria com os seguintes atributos:

        titular : String
        numeroConta : int
        saldo : double

    Aplique os modificadores de acesso adequados para garantir o encapsulamento dos dados.

        Implemente métodos públicos para:
        Consultar o saldo (método getSaldo)
        Depositar um valor (método depositar)
        Sacar um valor (método sacar, com verificação de saldo suficiente)

    No método main, crie uma instância da classe ContaBancaria, faça um depósito e um saque, e imprima o saldo final.

        Questão 2:
    Por fim, responda: 
    
    Qual a importância do encapsulamento na segurança e manutenção do código?

**Resolução**

    Para começar, vamos considerar a criação da classe ContaBancaria, com enfoque no desenvolvimento de suas funções e abstrair somente os principais métodos para interação interno ao Objeto da Classe.

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

