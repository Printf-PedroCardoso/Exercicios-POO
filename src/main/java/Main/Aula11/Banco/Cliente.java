package Main.Aula11.Banco;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<ContaBancaria> ContasBancarias;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        ContasBancarias = new ArrayList<>();
    }

    public void CriarContaBancaria (String numeroConta, double saldo, String tipo) {
        ContaBancaria novaContaBancaria = new ContaBancaria(numeroConta, saldo, tipo);

        ContasBancarias.add(novaContaBancaria);
    }

    public void listarContasBancarias() {
        System.out.println("Contas Bancárias de " + this.nome + " CPF: "+ this.cpf);

        if (ContasBancarias.isEmpty()) {
            System.out.println("Nenhuma Conta Bancária Cadastrada");
            return;
        }

        for (int i = 0 ; i < ContasBancarias.size() ; i++ ) {
            ContaBancaria conta = ContasBancarias.get(i);
            System.out.println(
                    i+1 + ". Numero: "
                            + conta.getNumeroConta() + " / Tipo: "
                            + conta.getTipo() + " / Saldo: "
                            + String.format("R$ %.2f", conta.getSaldo())
            );
        }
    }

    public ContaBancaria buscaContaBancariaPorNumero (String numeroCBBusca)
    {

        for (ContaBancaria CBAtual: ContasBancarias)
        {
            String numeroCBAtual = CBAtual.getNumeroConta().trim();
            if (numeroCBAtual.equalsIgnoreCase(numeroCBBusca.trim()))
                return CBAtual;
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
