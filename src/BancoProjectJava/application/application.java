package BancoProjectJava.application;

import BancoProjectJava.entities.Account;
import BancoProjectJava.entities.Peoplee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class application {


    static Scanner sc = new Scanner(System.in);
    static List<Account> contasBancarias;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        contasBancarias = new ArrayList<Account>();
        operacoes();

    }

    public static void operacoes() {

        System.out.println("--------------------------------------------------------");
        System.out.println("--------------Bem vindos a nossa Agência----------------");
        System.out.println("--------------------------------------------------------");
        System.out.println("*****  Selecione uma operação que deseja realizar  *****");
        System.out.println("--------------------------------------------------------");
        System.out.println("|       Opção 1 - Criar conta       |");
        System.out.println("|       Opção 2 - Depositar         |");
        System.out.println("|       Opção 3 - Sacar             |");
        System.out.println("|       Opção 4 - Transferir        |");
        System.out.println("|       Opção 5 - Listar            |");
        System.out.println("|       Opção 6 - Sair              |");

        int operacao = sc.nextInt();

        switch (operacao) {
            case 1:
                criaConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println("Obrigado por Usar Nossa agência");
                System.exit(0);

            default:
                System.out.println("Opçao inválida");
                operacoes();
        }
    }

    public static void criaConta() {

        System.out.print("Nome: ");
        sc.nextLine();
        String nome = sc.nextLine();

        System.out.print("\nCPF: ");
        String Cpf = sc.nextLine();

        System.out.print("\nEmail: ");
        String email = sc.nextLine();

        Peoplee peoplee = new Peoplee(nome, Cpf, email);
        Account account = new Account(peoplee);

        contasBancarias.add(account);
        System.out.println("sua conta foi criada com sucesso! ");

        operacoes();
    }

    public static Account encontrarConta(int numeroConta) {
        Account account = null;
        if (contasBancarias.size() > 0) {
            for (Account c : contasBancarias) {
                if (c.getNumberAccount() == numeroConta) {
                    account = c;
                }
            }
        }
        return account;
    }

    public static void depositar() {
        System.out.println("Numero da conta: ");
        int numeroConta = sc.nextInt();
        Account account = encontrarConta(numeroConta);

        if (account != null) {
            System.out.println("qual valor deseja depositar: ");
            double valorDeposito = sc.nextDouble();
            account.deposito(valorDeposito);
            System.out.println("Valor depositado com sucesso! ");
        } else {
            System.out.println("Conta não encontrada! ");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Numero da conta: ");
        int numeroConta = sc.nextInt();
        Account account = encontrarConta(numeroConta);

        if (account != null) {
            System.out.println("qual valor deseja Sacar? ");
            double valorSaque = sc.nextDouble();
            account.sacar(valorSaque);
        } else {
            System.out.println("Conta não encontrada! ");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Numero da Conta remetente: ");
        int numeroContaRemetente = sc.nextInt();

        Account contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null) {
            System.out.println("Numero da conta do Destinatario: ");
            int numeroContaDestinatario = sc.nextInt();

            Account contaDestinatario = encontrarConta(numeroContaDestinatario);

            if (contaDestinatario != null) {
                System.out.println("Valor da transferência: ");
                double valor = sc.nextDouble();

                contaRemetente.trasferir(contaDestinatario, valor);
            } else {
                System.out.println("A conta para depósito não foi encontrada");
            }
        } else {
            System.out.println("Conta para transferencia não encontrada");
        }
        operacoes();
    }

    public static void listarContas() {
        if (contasBancarias.size() > 0) {
            for (Account account : contasBancarias) {
                System.out.println(account);
            }
        } else {
            System.out.println("não há contas");
        }
        operacoes();
    }

}
