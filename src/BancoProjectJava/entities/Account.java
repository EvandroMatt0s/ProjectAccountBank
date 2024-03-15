package BancoProjectJava.entities;

import BancoProjectJava.ultilitarios.Util;

public class Account {

    private static int plusOfAccount = 1;
    private int NumberAccount;
    private Double saldo = 0.0;
    private Peoplee people;

    public Account(Peoplee people) {
        this.NumberAccount = plusOfAccount;
        this.people = people;
        plusOfAccount += 1;
    }

    public int getNumberAccount() {
        return NumberAccount;
    }

    public void setNumberAccount(int numberAccount) {
        NumberAccount = numberAccount;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Peoplee getPeople() {
        return people;
    }

    public void setPeople(Peoplee people) {
        this.people = people;
    }

    public void deposito(Double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("deposito criado com sucesso");
        } else {
            System.out.println("Não foi possivel realizar o deposito");
        }
    }

    public void sacar(Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque criado com sucesso");
        } else {
            System.out.println("Não foi possivel realizar o Saque!");
        }
    }
    public void trasferir(Account contaParaDeposito, Double valor){
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferencia realizada com sucesso!");
        }else {
            System.out.println("Não foi possivel realizar a Transferência!");
        }

    }

    public String toString() {
        return "\nNumero da conta: " + this.getNumberAccount()
                + "\nNome: " + this.people.getName()
                + "\nCPF: " + this.people.getCpf()
                + "\nEmail " + this.people.getEmail()
                + "\nSaldo: " + Util.doubleToString(this.getSaldo())
                + "\n";
    }
}
