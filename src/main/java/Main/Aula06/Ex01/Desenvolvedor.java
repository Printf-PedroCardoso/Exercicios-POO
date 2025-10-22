package Main.Aula06.Ex01;

public class Desenvolvedor extends Funcionario {

    public Desenvolvedor(String nome, int salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    int calcularSalario() {
        return this.getSalarioBase() * 10;
    }
}
