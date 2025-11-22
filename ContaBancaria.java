public class ContaBancaria {
    private String Titular;
    private String NumeroConta;
    private double Saldo;

    public ContaBancaria(String titular, String numeroConta) {
        //Validar os parâmetros de entrada
        if (numeroConta.length() != 5) {
            throw new IllegalArgumentException("Número da conta deve ter 5 dígitos.");
        }
        for (char c : numeroConta.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Número da conta deve conter apenas dígitos.");
            }
        }
        if (titular.length() < 3) {
            throw new IllegalArgumentException("Nome do titular deve ter pelo menos 3 caracteres.");
        }
        for (char c : titular.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                throw new IllegalArgumentException("Nome do titular deve conter apenas letras e espaços.");
            }
        }

        //Definir os atributos
        Titular = titular != null ? titular : "";
        NumeroConta = numeroConta != null ? numeroConta : "";
        Saldo = 0.0;
    }

    public String getTitular() {
        //Retornar o nome do titular
        return Titular;
    }

    public String getNumeroConta() {
        //Retornar o número da conta
        return NumeroConta;
    }

    public double getSaldo() {
        //Retornar o saldo da conta
        return Saldo;
    }

    public void setTitular(String titular) {
        //Definir o nome do titular apenas se tiver pelo menos 3 caracteres
        if (titular != null && titular.length() >= 3) {
            //Verificar se todos os caracteres são letras ou espaços
            for (char c : titular.toCharArray()) {
                if (!Character.isLetter(c) && c != ' ') {
                    System.out.println("Nome do titular deve conter apenas letras e espaços.");
                    return;
                }
            }
        } else {
            //Nome do titular inválido
            System.out.println("Nome do titular deve ter pelo menos 3 caracteres.");
            return;
        }
        Titular = titular;
    }

    public void setNumeroConta(String numeroConta) {
        //Definir o número da conta apenas se tiver 5 dígitos
        if (numeroConta != null && numeroConta.length() == 5) {
            //Verificar se todos os caracteres são dígitos
            for (char c : numeroConta.toCharArray()) {
                if (!Character.isDigit(c)) {
                    System.out.println("Número da conta deve conter apenas dígitos.");
                    return;
                }
            }
        } else {
            //Número da conta inválido
            System.out.println("Número da conta deve ter 5 dígitos.");
            return;
        }
        NumeroConta = numeroConta;
    }

    public void depositar(double valor) {
        //Adicionar o valor ao saldo da conta
        if (valor < 0) {
            throw new IllegalArgumentException("O valor do depósito não pode ser negativo.");
        }
        
        Saldo += valor;
        System.out.println("Depósito realizado com sucesso!\n\nTitular: " + this.Titular + "\nNúmero da Conta: " + this.NumeroConta + "\nValor depositado: " + valor);
    }

    public boolean sacar(double valor) {
        //Verificar se há saldo suficiente para o saque
        if (valor <= Saldo) {
            //Realizar o saque
            Saldo -= valor;
            System.out.println("Saque realizado com sucesso!\nValor sacado: " + valor + "\nSaldo restante: " + this.Saldo);
            return true;
        } else {
            //Saldo insuficiente para o saque
            throw new IllegalArgumentException("Saldo insuficiente para o saque.");
        }
    }

    public void transferir(ContaBancaria destino, double valor) {
        //Tentar sacar o valor da conta atual
        if (sacar(valor)) {
            //Se o saque for bem-sucedido, depositar o valor na conta de destino
            destino.depositar(valor);
        }
    }

    protected String formatarTextoCaixaAlta(String titular) {
        //Verificar se o titular é nulo
        if (titular == null) return "";

        //Definir nome do titular inteiramente em caixa alta
        return titular.toUpperCase();
    }
}
