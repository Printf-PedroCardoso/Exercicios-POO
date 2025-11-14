package Main.Aula11.Banco;

public class Operacao {
    char Tipo;
    double valor;

    public Operacao(char tipo, double valor) {
        Tipo = tipo;
        this.valor = valor;
    }

    public char getTipo() {
        return Tipo;
    }

    public double getValor() {
        return valor;
    }
}
