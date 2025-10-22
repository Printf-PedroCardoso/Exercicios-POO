package Main.aula01.lista01.exe06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num;
        num = scanner.nextInt();
        System.out.println("Antecessor = " + (num-1));
        System.out.println("Sucessor = " + (num+1));
    }
}
