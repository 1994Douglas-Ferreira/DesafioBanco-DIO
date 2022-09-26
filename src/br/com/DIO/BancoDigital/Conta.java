package br.com.DIO.BancoDigital;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
        System.out.println("--- Saque realizado ---");
        System.out.println("Conta de: "+ cliente.getNome());
        System.out.println("Valor: " + valor);
        System.out.println("Seu saldo agora é de : " + getSaldo());
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("--- Deposito realizado ---");
        System.out.println("Conta de: "+ cliente.getNome());
        System.out.println("Valor: " + valor);
        System.out.println("Seu saldo agora é de : " + getSaldo());
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        System.out.println("--- Transferencia realizada ---");
        System.out.println("Valor: " + valor);
        System.out.println("Conta de: "+ cliente.getNome());
        System.out.println("Conta de destino: " + contaDestino.cliente.getNome());
        System.out.println("Seu saldo agora é de : " + getSaldo());
    }

    protected void imprimirInfosComuns() {
        System.out.printf("Agencia: %d", this.agencia);
        System.out.println();
        System.out.printf("Numero: %d", this.numero);
        System.out.println();
        System.out.printf("Saldo: %.2f", this.saldo);
        System.out.println();
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }


}
