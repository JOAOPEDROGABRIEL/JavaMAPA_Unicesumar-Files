public class ContaBancaria {
    // Atributos privados (Encapsulamento)
    private String titular;
    private int numeroConta;
    private double saldo;

    // Construtor
    public ContaBancaria(String titular, int numeroConta) {
        // Validação do titular
        if (titular == null || titular.trim().length() < 3) {
            throw new IllegalArgumentException("Nome do titular deve ter pelo menos 3 caracteres.");
        }
        
        // Validação simples para garantir que o número da conta seja positivo
        if (numeroConta <= 0) {
            throw new IllegalArgumentException("O número da conta deve ser positivo.");
        }

        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = 0.0; // Saldo inicializa zerado por padrão
    }

    // --- Métodos Getters (Acesso) ---
    public String getTitular() {
        return titular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    // --- Métodos Setters (Modificação com Proteção) ---
    public void setTitular(String titular) {
        if (titular != null && titular.trim().length() >= 3) {
            this.titular = titular;
        } else {
            System.out.println("Erro: Nome inválido para alteração.");
        }
    }

    // --- Métodos de Negócio ---

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Erro: O valor do depósito deve ser positivo.");
        }
    }

    public boolean sacar(double valor) {
        // Verificação de saldo suficiente (Regra de negócio)
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
            return true;
        } else {
            System.out.println("Erro: Saldo insuficiente ou valor inválido.");
            return false;
        }
    }

    // Método extra para exibir dados formatados
    @Override
    public String toString() {
        return String.format("Conta: %d | Titular: %s | Saldo: R$ %.2f", numeroConta, titular, saldo);
    }
}