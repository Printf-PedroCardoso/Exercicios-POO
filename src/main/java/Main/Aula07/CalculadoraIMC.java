package Main.Aula07;

import java.util.Scanner;

public class CalculadoraIMC extends Calculo {

    private double peso;
    private double altura;
    private double IMC;

    public CalculadoraIMC() {
        this.peso = 0;
        this.altura = 0;
        this.IMC = 0;
    }

    @Override
    public void executar() {
        Scanner scanner = new Scanner(System.in);

        int opcaoCalculadora = -1;
        while (opcaoCalculadora != 0)
        {
            exibirOpcoes();

            opcaoCalculadora = scanner.nextInt();

            switch (opcaoCalculadora) {
                case 1:
                case 2:
                    System.out.print("Digite o novo peso (em kilogramas): ");
                    peso = scanner.nextDouble();
                    if (opcaoCalculadora != 1) break;
                case 3:
                    System.out.print("Digite a nova altura (em metros): ");
                    altura = scanner.nextDouble();
                    break;
                case 4:
                    IMC = peso / (altura * altura);
                    System.out.println("Cálculo executado");
                    break;
                case 5:
                    exibirResultado();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }

    @Override
    public void exibirResultado() {
        System.out.println("Seu IMC é: " + String.format("%.2f", IMC));
        System.out.print("Classificação: ");
        if (IMC < 16)
            System.out.print("Magreza grave");
        if (IMC >= 16 && IMC < 17)
            System.out.print("Magreza moderada");
        if (IMC >= 17 && IMC < 18.5)
            System.out.print("Magreza leve");
        if (IMC >= 18.5 && IMC < 25)
            System.out.print("Saudável");
        if (IMC >= 25 && IMC < 30)
            System.out.print("Sobrepeso");
        if (IMC >= 30 && IMC < 35)
            System.out.print("Obesidade Grau I");
        if (IMC >= 35 && IMC < 40)
            System.out.print("Obesidade Grau II");
        if (IMC >= 40)
            System.out.print("Obesidade Grau III");
    }

    @Override
    public void exibirOpcoes() {
        System.out.println("\n\n");
        System.out.println("===== Calculadora de IMC =====");
        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("1 - Alterar todos os parâmetros.");
        System.out.println("2 - Alterar peso.       (Atual:" + String.format("R$ %.2f", peso) + "Kg)");
        System.out.println("3 - Alterar altura.     (Atual:" + String.format("R$ %.2f", altura) + "m)");
        System.out.println("4 - Executar cálculo");
        System.out.println("5 - Mostrar resultado");
        System.out.println("0 - Voltar ao Menu");
        System.out.print("Sua opção: ");
    }
}
