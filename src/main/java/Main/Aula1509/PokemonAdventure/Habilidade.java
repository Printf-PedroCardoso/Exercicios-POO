package Main.Aula1509.PokemonAdventure;

public class Habilidade {
    private String nome;
    private String tipo;
    private int poder;

    public Habilidade(String nome, String tipo, int poder) {
        this.nome = nome;
        this.tipo = tipo;
        this.poder = poder;
    }

    public void usar ()
    {

    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPoder() {
        return poder;
    }

}
