package Main.Aula06.Ex01;

public abstract class Funcionario {
    private String nome;
    private int salarioBase;

    public Funcionario(String nome, int salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    abstract int calcularSalario();

    public void exibirDados()
    {
        System.out.println("Nome: " + this.nome);
        System.out.println("Salário Base: " + this.nome);
    }

    public int getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(int salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
