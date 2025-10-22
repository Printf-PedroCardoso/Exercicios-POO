package Main.aula01.lista01.exe05;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario();
        float SM;
        float qntdSM;

        System.out.println("Digite o valor do salário mínimo");
        SM = scanner.nextFloat();

        System.out.println("Digite o valor do seu salário");
        usuario.salario = scanner.nextFloat();

        qntdSM = usuario.quantosSM(SM);

        System.out.println("Quantidade de salários Mínimos: " + qntdSM);
    }
}
