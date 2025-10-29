package Main.Aula07;

import java.util.Scanner;

public class CalculadoraCambio extends Calculo {
    private String moedaOriginal;
    private double valorOriginal;
    private double cotacao;
    private String moedaConvertida;
    private double valorConvertido;

    public CalculadoraCambio() {
        this.moedaOriginal = "#";
        this.valorOriginal = 0;
        this.cotacao = 0;
        this.moedaConvertida = "#";
        this.valorConvertido = 0;

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
                    System.out.print("Digite o código da moeda original: ");
                    moedaOriginal = scanner.next();
                    if (opcaoCalculadora != 1) break;
                case 3:
                    System.out.print("Digite o montante na moeda original: ");
                    valorOriginal = scanner.nextDouble();
                    if (opcaoCalculadora != 1) break;
                case 4:
                    System.out.print("Digite o valor da Cotação: ");
                    cotacao = scanner.nextDouble();
                    if (opcaoCalculadora != 1) break;
                case 5:
                    System.out.print("Digite o código da moeda convertida: ");
                    moedaConvertida = scanner.next();
                    break;
                case 6:
                    this.valorConvertido = valorOriginal * cotacao;
                    System.out.println("Cálculo executado");
                    break;
                case 7:
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
        String original = String.format("$ %.2f", valorOriginal) + " " + moedaOriginal;
        String convertido = String.format("$ %.2f", valorConvertido) + " " + moedaConvertida;
        System.out.println(original + " equivalem  à " + convertido);
    }

    @Override
    public void exibirOpcoes() {
        System.out.println("\n===== Calculadora de Câmbio  =====");
        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("1 - Alterar todos os parâmetros.");
        System.out.println("2 - Alterar Código da moeda original.     (Atual: " + moedaOriginal + ")");
        System.out.println("3 - Alterar valor original.               (Atual:" + String.format("$ %.2f", valorOriginal) + ")");
        System.out.println("4 - Alterar cotação.                      (Atual:" + String.format("$ %.2f", cotacao) + ")");
        System.out.println("5 - Alterar Código da moeda convertida.   (Atual: " + moedaConvertida + ")");
        System.out.println("6 - Executar cálculo");
        System.out.println("7 - Mostrar resultado");
        System.out.println("0 - Voltar ao Menu");
        System.out.print("Sua opção: ");
    }
}
