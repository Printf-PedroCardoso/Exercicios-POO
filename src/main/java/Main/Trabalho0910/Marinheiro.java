package Main.Trabalho0910;

public class Marinheiro extends Pirata{

    PostoMarinheiro posto;

    public Marinheiro(String nome, int idade, int recompensa, String funcao, PostoMarinheiro posto) {
        super(nome, idade, recompensa, funcao);
        this.posto = posto;
    }

    @Override
    public void apresentarPirata() {
        super.apresentarPirata();
        System.out.println("Posto: " + this.posto);
    }

    public PostoMarinheiro getPosto() {
        return posto;
    }

    public void setPosto(PostoMarinheiro posto) {
        this.posto = posto;
    }
}
