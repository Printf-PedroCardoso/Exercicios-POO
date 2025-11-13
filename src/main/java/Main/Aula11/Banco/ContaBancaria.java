package Main.Aula11.Banco;

public class ContaBancaria {
    private String numeroConta;
    private double saldo;
    private String tipo;

    public ContaBancaria(String numeroConta, double saldo, String tipo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.tipo = tipo;
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
