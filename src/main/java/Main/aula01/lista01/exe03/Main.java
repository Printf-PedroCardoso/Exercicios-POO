package Main.aula01.lista01.exe03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    float salario;
    salario = scanner.nextFloat();

    float reajuste = salario + (salario/100);
        System.out.println("Salario: " + salario);
        System.out.println("Salario com reajuste: " + reajuste);
    }
}
