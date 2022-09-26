package br.com.DIO.BancoDigital;

public class Main {

    public static void main(String[] args) {
    Cliente Douglas = new Cliente("Douglas");
    Cliente Andressa = new Cliente("Andressa");

        Conta cc = new ContaCorrente(Douglas);
        Conta cp = new ContaPoupanca(Andressa);

        cc.depositar(100);
        cp.depositar(200);

        cc.sacar(20);
        cc.depositar(20);
        cc.transferir(10,cp);

        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }
}
