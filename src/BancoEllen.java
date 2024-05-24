import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BancoEllen {

    

    public static void main(String[] args) {
        List<ContaBancaria> contas = carregarContas();

        for (ContaBancaria conta : contas) {
            System.out.println(conta);
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu");
            System.out.println("1 – Depósito");
            System.out.println("2 – Saque");
            System.out.println("3 – Transferência");
            System.out.println("4 – Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 4) {
                break;
            }

            System.out.print("Digite o número da conta: ");
            int numeroConta = scanner.nextInt();

            ContaBancaria conta = null;
            for (ContaBancaria c : contas) {
                if (c.getNumero() == numeroConta) {
                    conta = c;
                    break;
                }
            }

            if (conta == null) {
                System.out.println("Conta não encontrada.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor para depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso.");
                    break;
                case 2:
                    System.out.print("Digite a senha: ");
                    int senha = scanner.nextInt();
                    if (!conta.verificarSenha(senha)) {
                        System.out.println("Senha incorreta.");
                        break;
                    }
                    System.out.print("Digite o valor para sacar: ");
                    double valorSaque = scanner.nextDouble();
                    if (conta.sacar(valorSaque)) {
                        System.out.println("Saque realizado com sucesso.");
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;
                case 3:
                    System.out.print("Digite a senha: ");
                    senha = scanner.nextInt();
                    if (!conta.verificarSenha(senha)) {
                        System.out.println("Senha incorreta.");
                        break;
                    }
                    System.out.print("Digite o número da conta destino: ");
                    int numeroContaDestino = scanner.nextInt();

                    ContaBancaria contaDestino = null;
                    for (ContaBancaria c : contas) {
                        if (c.getNumero() == numeroContaDestino) {
                            contaDestino = c;
                            break;
                        }
                    }

                    if (contaDestino == null) {
                        System.out.println("Conta destino não encontrada.");
                        break;
                    }

                    System.out.print("Digite o valor para transferir: ");
                    double valorTransferencia = scanner.nextDouble();
                    if (conta.sacar(valorTransferencia)) {
                        contaDestino.depositar(valorTransferencia);
                        System.out.println("Transferência realizada com sucesso.");
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
    
    
    
    public static List<ContaBancaria> carregarContas() {
        List<ContaBancaria> contas = new ArrayList<>();
        contas.add(new ContaBancaria(45787985, 111, "Jaqueline", 4566.25, 10000.00));
        contas.add(new ContaBancaria(4567, 222, "Maria", 4575.00, 1000.00));
        contas.add(new ContaBancaria(47845, 333, "Odair", 5874.00, 55000.00));
        contas.add(new ContaBancaria(451278, 444, "JOao", 89714.00, 20000.00));
        contas.add(new ContaBancaria(48578, 555, "Paulo", 5600.00, 10000.00));
        contas.add(new ContaBancaria(456135998, 666, "Clara", 58421.00, 58000.00));
        contas.add(new ContaBancaria(45465, 777, "Josefa", 1654.00, 2000.00));
        contas.add(new ContaBancaria(45894312, 888, "Mara", 45000.00, 110000.00));
        contas.add(new ContaBancaria(451211, 999, "Jose Paulo", 88450.00, 50000.00));
        return contas;
    }
}
