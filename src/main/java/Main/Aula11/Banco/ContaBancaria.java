package Main.Aula11.Banco;

import java.util.ArrayList;

public class ContaBancaria {
    private ArrayList<Operacao> Operacoes;
    private String numeroConta;
    private double saldo;
    private String tipo;

    public ContaBancaria(String numeroConta, double saldo, String tipo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.tipo = tipo;
        Operacoes = new ArrayList<>();
    }

    public void extratoOperacoes() {
        System.out.println("--- Operações da Conta Bancária ---");

        if (Operacoes.isEmpty()) {
            System.out.println("Nenhuma Operação realizada na Conta");
            return;
        }

        for (int i = Operacoes.size()-1;  i >= 0 ; i-- ) {
            Operacao operacaoAtual = Operacoes.get(i);
            String tipoOperacao;
            if (operacaoAtual.getTipo() == 'D') {
                tipoOperacao = "Depósito";
            } else {
                tipoOperacao = "Saque";
            }
            System.out.print(i + 1 + ". - Tipo: "
                    + tipoOperacao + " / Saldo: "
                    + String.format("R$ %.2f", operacaoAtual.getValor())
            );
        }
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
