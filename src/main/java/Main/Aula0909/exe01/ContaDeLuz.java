package Main.Aula0909.exe01;

import java.util.Date;

public class ContaDeLuz {
    Date dataLeitura;
    int numeroLeitura;
    int kwGasto;
    float valorAPagar;
    Date dataPagamento;
    float mediaConsumo;

    void CriarConta (Date dataLeitura, int numeroLeitura,int kwGasto,
                     float valorAPagar, Date dataPagamento, float mediaConsumo)
    {
        this.dataLeitura = dataLeitura;
        this.numeroLeitura = numeroLeitura;
        this.kwGasto = kwGasto;
        this.valorAPagar = valorAPagar;
        this.dataPagamento = dataPagamento;
        this.mediaConsumo = mediaConsumo;
    }

    String verificarMesMaiorConsumo ()
    {
        return "";
    }

    String verificarMesMenorConsumo ()
    {
        return "";
    }




}
