package Main.Aula06.Ex01;

public class Gerente extends Funcionario {

    public Gerente(String nome, int salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    int calcularSalario() {
        return super.getSalarioBase() * 3;
    }
}
