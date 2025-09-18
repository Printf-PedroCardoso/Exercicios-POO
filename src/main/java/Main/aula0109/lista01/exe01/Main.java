package Main.aula0109.lista01.exe01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pessoa pedro = new Pessoa();

        int totalDias;

        System.out.println("Digite a sua Idade em Anos:");
        pedro.Anos = scanner.nextInt();
        System.out.println(pedro.Anos);

        System.out.println("Digite a sua Idade em Meses:");
        pedro.Meses = scanner.nextInt();

        System.out.println("Digite a sua Idade em Dias:");
        pedro.Dias = scanner.nextInt();

        totalDias = pedro.calcularTotalDias();

        System.out.println(totalDias + " dias");
    }
}

