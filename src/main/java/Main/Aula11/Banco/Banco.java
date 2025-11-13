package Main.Aula11.Banco;

import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    private ArrayList<Cliente> clientes;

    public Banco() {
        clientes = new ArrayList<>();
        Cliente Ana = new Cliente("Ana","123.456.789-00");
        Ana.CriarContaBancaria("123",10.2,"Poupança");
        clientes.add(Ana);

        Cliente Joao = new Cliente("João","222.222.222-00");
        Joao.CriarContaBancaria("222",222.2,"Poupança");
        clientes.add(Joao);

        Cliente Thiago = new Cliente("Thiago Nigro","333.333.333-00");
        Thiago.CriarContaBancaria("333",333.33,"Poupança");
        Thiago.CriarContaBancaria("444",444.44,"Corrente");
        clientes.add(Thiago);

        Cliente Bruno = new Cliente("Bruno Perini","555.555.555-00");
        Bruno.CriarContaBancaria("555",555.55,"Poupança");
        Bruno.CriarContaBancaria("666",666.66,"Corrente");
        clientes.add(Bruno);

        Cliente Raul = new Cliente("Raul Senna","777.777.777-00");
        Bruno.CriarContaBancaria("777",777.77,"Poupança");
        Bruno.CriarContaBancaria("888",888.88,"Corrente");
        Bruno.CriarContaBancaria("999",999.99,"Empresarial");
        clientes.add(Raul);
    }

    public void menu() {
        Scanner teclado = new Scanner(System.in);
        int op = 0;
        do {
            System.out.println("..:: Sistema Bancário ::..");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Conta Bancária");
            System.out.println("3 - Listar Clientes");
            System.out.println("4 - Listar Contas Bancárias de Cliente (por CPF)");
            System.out.println("5 - Consultar extrato de Conta");
            System.out.println("6 - Realizar Depósito");
            System.out.println("7 - Realizar Saque");
            System.out.println("8 - Listar Todas as Contas Bancárias");
            System.out.println("9 - Listar Todas as Contas Bancárias");


            System.out.print("Entre com uma opcao: ");
            op = teclado.nextInt();

            System.out.println();
            switch (op) {
                case 1:
                    teclado.nextLine();
                    String nome;
                    String cpf;
                    System.out.println("Entre com os dados:");
                    System.out.print("Nome: ");
                    nome = teclado.nextLine();
                    System.out.print("cpf: ");
                    cpf = teclado.nextLine();
                    Cliente NovoCliente = new Cliente(nome,cpf);
                    clientes.add(NovoCliente);
                    break;
                case 2:
                    teclado.nextLine();
                    String cpfCliente;
                    String numeroConta;
                    double saldoInicial;
                    String tipo;

                    System.out.println("Entre com os dados da nova Conta Bancária:");

                    System.out.println("CPF do cliente da Conta:");
                    cpfCliente = teclado.next();

                    Cliente clienteConta = this.buscaClientePorCPF(cpfCliente);

                    if (clienteConta == null) {
                        System.out.println("Cliente não encontrado, não é possível continuar.");
                        break;
                    }
                    System.out.println("Cliente Selecionado: " + clienteConta.getNome());

                    System.out.print("Numero da Conta: ");
                    numeroConta = teclado.nextLine();
                    System.out.print("saldoInicial: ");
                    saldoInicial = teclado.nextDouble();
                    System.out.print("Tipo da Conta: ");
                    tipo = teclado.nextLine();
                    ContaBancaria novaContaBancaria = new ContaBancaria(numeroConta,saldoInicial,tipo);
                    clienteConta.CriarContaBancaria(numeroConta,saldoInicial,tipo);
                    break;
                case 3:

                    break;
                case 4:
                    String nomeBusca;
                    System.out.print("Insira o nome: ");
                    nomeBusca = teclado.next();
                    this.buscaDados(nomeBusca);
                    break;
                case 9:
                    System.out.println("Saindo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println();

        } while (op != 9);

}


