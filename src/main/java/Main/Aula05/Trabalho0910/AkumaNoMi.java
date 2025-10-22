package Main.Aula05.Trabalho0910;

public class AkumaNoMi {

    private String nome;
    private TipoFruta tipo;
    private String descricao;

    public AkumaNoMi(String nome, TipoFruta tipo, String descricao) {
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public void mostraPoder () {
        System.out.println("Poder da Fruta:");
        System.out.println(this.descricao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoFruta getTipo() {
        return tipo;
    }

    public void setTipo(TipoFruta tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
