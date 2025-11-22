import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean condicaoFuncionamento = true;

        while (condicaoFuncionamento) {
            System.out.println("Bem-vindo ao sistema bancário!");
            System.out.println("1. Criar Conta Bancária");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Consultar Saldo");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            Scanner scanner = new Scanner(System.in);
            int opcao = scanner.nextInt();
            ContaBancaria conta = null;
            
            switch (opcao) {
                case 1:
                    conta = criarConta();
                    if (conta != null) {
                        //Conta criada com sucesso, prosseguir com outras operações
                        System.out.println("Conta criada para o titular: " + conta.getTitular());
                        System.out.println("Número da conta: " + conta.getNumeroConta());
                        System.out.println("Saldo: " + conta.getSaldo());
                    }
                    break;
                case 2:
                    if (conta == null) {
                        System.out.println("Nenhuma conta encontrada. Criando nova conta...");
                        conta = criarConta();
                        if (conta == null) {
                            System.out.println("Conta não foi criada. Operação cancelada.");
                            break;
                        }
                    }
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine();
                    conta.depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso! Saldo atual: " + conta.getSaldo());
                    break;

                    
                case 3:
                    // TODO:Implementar lógica para sacar
                   
                    break;
                case 4:
                    // TODO:Implementar lógica para transferir
                    break;
                case 5:
                    // TODO:Implementar lógica para consultar saldo
                    break;
                case 6:
                    condicaoFuncionamento = false;
                    System.out.println("Saindo do sistema. Obrigado por usar nosso banco!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
            scanner.close();
        }
    }

    public static ContaBancaria criarConta() {
        /* O retorno foi definido como ContaBancaria para facilitar 
        a criação e manipulação da conta durante a resolução da 
        atividade MAPA, entretanto o retorno original do método 
        deve ser do tipo "boolean". */

        //Criar um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        //Perguntar o nome do titular
        System.out.print("Digite o nome do titular da conta: ");
        String titular = scanner.nextLine();

        //Perguntar o número da conta
        System.out.print("Digite o número da conta (5 dígitos): ");
        String numeroConta = scanner.nextLine();

        //Perguntar se deseja definir um saldo inicial
        System.out.print("Deseja definir um saldo inicial? (s/n): ");
        char resposta = scanner.nextLine().charAt(0);

        //Objeto ContaBancaria
        ContaBancaria conta = null;

        //Tentar criar a conta bancária
        try {
            conta = new ContaBancaria(titular, numeroConta);
        } catch (IllegalArgumentException e) {
            //Erro na criação da conta
            System.out.println(e.getMessage());
            scanner.close();
            return null;
        }

        //Definir o saldo inicial se o usuário desejar
        double saldo = 0.0;

        //Se a resposta for 's' ou 'S', pedir o saldo inicial
        if (resposta == 's' || resposta == 'S') {
            System.out.print("Digite o saldo inicial da conta: ");
            saldo = scanner.nextDouble();
            scanner.nextLine();
            conta.depositar(saldo);
        }

        //Conta criada com sucesso
        System.out.println("Conta criada com sucesso!");
        scanner.close();
        return conta;
    }

    //Restante dos Métodos da classe Main...
    /*TODOs:
        - Implementar método para realizar Login e autenticação
        - Implementar menu para operações bancárias
        - Implementar interface gráfica (opcional)
        - Implementar persistência de dados (opcional)
        - Implementar testes unitários (opcional)
        - Implementar funcionalidades adicionais conforme necessário
    */
}