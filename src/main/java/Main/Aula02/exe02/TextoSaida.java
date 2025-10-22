package Main.Aula02.exe02;

public class TextoSaida {
    String texto;
    int tamanhoLetra;
    EnumCor CorFonte;
    EnumCor CorFundo;
    EnumTipoComponente TipoComponente;

    TextoSaida (String texto, int tamanhoLetra, EnumCor CorFonte, EnumCor CorFundo, EnumTipoComponente TipoComponente)
    {
        this.texto = texto;
        this.tamanhoLetra = tamanhoLetra;
        this.CorFonte = CorFonte;
        this.CorFundo = CorFundo;
        this.TipoComponente = TipoComponente;
    }

}
