package Main.Aula06.Ex03;

import Main.Aula06.Ex02.Imprimivel;

public class Circulo extends FormaGeometrica implements Colorivel, Imprimivel {

    @Override
    public void colorir(String Cor) {
        System.out.println("Agora a cor do circulo é " + Cor);
    }

    @Override
    int calcularArea() {
        return 2 * 3;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimindo circulo");
    }
}
