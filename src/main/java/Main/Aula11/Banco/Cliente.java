package Main.Aula11.Banco;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<ContaBancaria> ContasBancarias = new ArrayList<>();

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void CriarContaBancaria (String numeroConta, double saldo, String tipo) {
        ContaBancaria novaContaBancaria = new ContaBancaria(numeroConta, saldo, tipo);

        ContasBancarias.add(novaContaBancaria);
    }

    public void listarContasBancarias() {
        System.out.println("--- Contas Bancárias de " + this.nome + " ---");

        if (ContasBancarias.isEmpty()) {
            System.out.println("Nenhuma Conta Bancária Cadastrada");
        } else {
            for (int i = 0 ; i < ContasBancarias.size() ; i++ ) {
                ContaBancaria conta = ContasBancarias.get(i);
                System.out.println(
                        i+1 + ". "
                                + conta.getNumeroConta() + " / Numero Conta:"
                                + conta.getTipo() + " / Tipo:"
                                + conta.getSaldo() + "/");
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
