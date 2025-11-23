import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // VERIFICAÇÃO DE ARGUMENTOS DE LINHA DE COMANDO (CLI)
        // Se houver argumentos passados no comando "java Main ...", entra no modo rápido
        if (args.length > 0) {
            executarModoCLI(args);
        } else {
            // Se não houver argumentos, executa o modo interativo (Menu)
            executarModoInterativo();
        }
    }

    // --- MODO LINHA DE COMANDO (Rápido) ---
    // Exemplo de uso: java Main "Joao Silva" 12345 500.00
    private static void executarModoCLI(String[] args) {
        System.out.println("=== MODO CLI INICIADO ===");
        
        try {
            // 1. Validação básica de quantidade de argumentos
            if (args.length < 3) {
                System.out.println("Erro: Para usar o modo CLI, forneça: <Nome> <NumeroConta> <DepositoInicial>");
                return;
            }

            String nome = args[0].replace("_", " "); // Truque para nomes compostos via terminal sem aspas
            int numero = Integer.parseInt(args[1]);
            double depositoInicial = Double.parseDouble(args[2]);

            // 2. Criação e Manipulação
            ContaBancaria conta = new ContaBancaria(nome, numero);
            System.out.println("Conta criada via argumentos.");
            
            conta.depositar(depositoInicial);
            
            // Simulação de um saque automático para demonstrar funcionamento
            System.out.println("Simulando saque de teste (R$ 50,00)...");
            conta.sacar(50.0);

            // 3. Resultado Final
            System.out.println("\n--- ESTADO FINAL (CLI) ---");
            System.out.println(conta.toString()); // Usa o toString que criamos na classe ContaBancaria

            // NOTA SOBRE PERSISTÊNCIA:
            // Aqui seria o local para implementar salvamento em arquivo ou banco de dados,
            // caso fosse um requisito, mas para simplicidade, estou omitindo essa parte.

        } catch (NumberFormatException e) {
            System.out.println("Erro nos argumentos: Verifique se o número da conta e valor são numéricos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de regra de negócio: " + e.getMessage());
        }
    }

    // --- MODO INTERATIVO (Menu Original) ---
    private static void executarModoInterativo() {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = null;
        boolean condicaoFuncionamento = true;

        while (condicaoFuncionamento) {
            System.out.println("\n=== SISTEMA BANCÁRIO (Interativo) ===");
            System.out.println("1. Criar Conta Bancária");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Consultar Saldo");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = -1;
            try {
                // Tenta ler a linha inteira e converter, para evitar problemas de buffer
                String entrada = scanner.nextLine();
                if (!entrada.isEmpty()) {
                    opcao = Integer.parseInt(entrada);
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite apenas números.");
                continue;
            }

            switch (opcao) {
                case 1:
                    conta = criarContaInterativo(scanner);
                    break;

                case 2:
                    if (verificarContaExiste(conta)) {
                        System.out.print("Digite o valor do depósito: ");
                        double valorDep = lerDouble(scanner);
                        conta.depositar(valorDep);
                        System.out.println("Saldo atual: " + conta.getSaldo());
                    }
                    break;

                case 3:
                    if (verificarContaExiste(conta)) {
                        System.out.print("Digite o valor do saque: ");
                        double valorSaque = lerDouble(scanner);
                        conta.sacar(valorSaque);
                        System.out.println("Saldo atual: " + conta.getSaldo());
                    }
                    break;

                case 4:
                    if (verificarContaExiste(conta)) {
                        System.out.println("\n--- Consulta de Saldo ---");
                        System.out.println("Titular: " + conta.getTitular());
                        System.out.println("Saldo disponível: R$ " + conta.getSaldo());
                    }
                    break;

                case 5:
                    condicaoFuncionamento = false;
                    System.out.println("Encerrando sistema. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }

    // Separei a criação de conta do modo interativo para organizar melhor
    public static ContaBancaria criarContaInterativo(Scanner scanner) {
        System.out.print("Digite o nome do titular: ");
        String titular = scanner.nextLine();

        System.out.print("Digite o número da conta (Numérico): ");
        int numero;
        try {
            numero = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Erro: O número da conta deve conter apenas dígitos.");
            return null;
        }

        try {
            ContaBancaria novaConta = new ContaBancaria(titular, numero);
            System.out.println("Conta criada com sucesso!");
            
            System.out.print("Deseja realizar um depósito inicial? (s/n): ");
            String resp = scanner.nextLine();
            if (resp.equalsIgnoreCase("s")) {
                System.out.print("Valor inicial: ");
                double valorIni = lerDouble(scanner);
                novaConta.depositar(valorIni);
            }
            return novaConta;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar conta: " + e.getMessage());
            return null;
        }
    }

    private static boolean verificarContaExiste(ContaBancaria conta) {
        if (conta == null) {
            System.out.println("⚠️ Nenhuma conta ativa. Crie uma conta primeiro (Opção 1).");
            return false;
        }
        return true;
    }

    private static double lerDouble(Scanner scanner) {
        try {
            String linha = scanner.nextLine();
            if (linha.isEmpty()) return 0.0;
            // Trata tanto ponto quanto vírgula se necessário, mas Java padrão usa ponto no parseDouble
            return Double.parseDouble(linha.replace(",", "."));
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido, assumindo 0.0");
            return 0.0;
        }
    }
}