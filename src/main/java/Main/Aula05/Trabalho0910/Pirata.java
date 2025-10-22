package Main.Aula05.Trabalho0910;

public class Pirata {

    String nome;
    private int idade;
    private int recompensa;
    private String funcao;
    private AkumaNoMi akumaNoMi;


    public Pirata(String nome, int idade, int recompensa, String funcao) {
        this.nome = nome;
        this.idade = idade;
        this.recompensa = recompensa;
        this.funcao = funcao;
        this.akumaNoMi = null;
    }

    public Pirata(String nome, int idade, int recompensa, String funcao, AkumaNoMi akumaNoMi) {
        this(nome, idade, recompensa, funcao);
        this.akumaNoMi = akumaNoMi;
    }

    public void apresentarPirata()
    {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Recompensa: " + this.recompensa);
        System.out.println("Função: " + this.funcao);
        if (this.akumaNoMi != null) {
            System.out.println("Akuma no Mi: " + this.akumaNoMi.getNome());
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
