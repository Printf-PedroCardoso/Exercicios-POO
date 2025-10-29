package Main.Aula07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcaoMenu = -1;

        Calculo calculadoraSelecionada = null;

        while (opcaoMenu != 0) {
            exibirMenu();
            opcaoMenu = scanner.nextInt();

            switch (opcaoMenu) {
                case 1:
                    calculadoraSelecionada = new CalculadoraSalarioLiquido();
                    break;
                case 2:
                    calculadoraSelecionada = new CalculadoraIMC();
                    break;
                case 3:
                    calculadoraSelecionada = new CalculadoraCambio();
                    break;
                case 4:
                    calculadoraSelecionada = new CalculadoraJuros();
                    break;
                case 5:
                    calculadoraSelecionada = new CalculadoraConsumoLuz();
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

            if (calculadoraSelecionada != null) {
                calculadoraSelecionada.executar();
                calculadoraSelecionada = null;
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("\n===== Central das Calculadoras  =====");
        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("1 - Calcular Salário Líquido");
        System.out.println("2 - Calcular IMC");
        System.out.println("3 - Converter Moeda");
        System.out.println("4 - Calcular Juros (Simples e Compostos)");
        System.out.println("5 - Calcular Consumo de Energia");
        System.out.println("0 - Sair");
        System.out.print("Sua opção: ");
    }
}

