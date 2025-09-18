package aula0109.lista01.exe02;

public class Main {
    public static void main(String[] args) {
        int a1 = 8, a2 = 9, a3 = 7;
        int b1 = 4, b2 = 5, b3 = 6;
        int media1, media2, somaMedias;
        Calculadora calculadora = new Calculadora();

        media1 = calculadora.media3(a1,a2,a3);
        System.out.println("media 1: " + media1);

        media2 = calculadora.media3(b1,b2,b3);
        System.out.println("media 2: " + media2);

        somaMedias = media1 + media2;
        System.out.println("Soma das medias: " + somaMedias);
    }
}
