package Main.aula0109.lista01.exe01;

public class Pessoa {
    int Anos;
    int Meses;
    int Dias;

    public int calcularTotalDias ()
    {
        return (Anos * 365) + (Meses * 30) + Dias;
    }
}
