package Main.Aula10;

public class Contato {
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        // Usando String.format() conforme solicitado
        return String.format("Contato [Nome: %s, Telefone: %s]", this.nome, this.telefone);
    }
}
