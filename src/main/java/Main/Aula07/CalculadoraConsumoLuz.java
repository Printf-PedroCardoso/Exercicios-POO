package Main.Aula07;

import java.util.Scanner;

public class CalculadoraConsumoLuz extends Calculo {
    private double consumoKw;
    private double custoPorKw;
    private double custoTotal;

    public CalculadoraConsumoLuz() {
        consumoKw = 0;
        custoPorKw = 0;
        custoTotal = 0;
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
                    System.out.print("Digite o Consumo (em kilowatts): ");
                    setConsumoKw(scanner.nextDouble());
                    if (opcaoCalculadora != 1) break;
                case 3:
                    System.out.print("Digite o custo por kilowatt: ");
                    setCustoPorKw(scanner.nextDouble());
                    break;
                case 4:
                    setCustoTotal(custoPorKw * consumoKw);
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
        System.out.println("O custo total é de " + String.format("R$ %.2f", getCustoTotal()));
    }

    @Override
    public void exibirOpcoes() {
        System.out.println("\n===== Calculadora de Consumo de Luz =====");
        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("1 - Alterar todos os parâmetros.");
        System.out.println("2 - Alterar consumo (em Kilowatts)  (Atual: " + String.format("%.2f", getConsumoKw()) + "Kw)");
        System.out.println("3 - Alterar custo por Kilowatt.     (Atual:" + String.format("R$ %.2f", getCustoPorKw()) + ")");
        System.out.println("4 - Executar cálculo");
        System.out.println("5 - Mostrar custo total");
        System.out.println("0 - Voltar ao Menu");
        System.out.print("Sua opção: ");
    }

    public double getConsumoKw() {
        return consumoKw;
    }

    public void setConsumoKw(double consumoKw) {
        this.consumoKw = consumoKw;
    }

    public double getCustoPorKw() {
        return custoPorKw;
    }

    public void setCustoPorKw(double custoPorKw) {
        this.custoPorKw = custoPorKw;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }
}

