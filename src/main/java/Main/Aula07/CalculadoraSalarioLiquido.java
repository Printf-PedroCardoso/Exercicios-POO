package Main.Aula07;

import java.util.Scanner;

public class CalculadoraSalarioLiquido extends Calculo{

    private double salarioBruto;
    private double descontos;
    private double beneficios;
    private double salarioLiquido;

    public CalculadoraSalarioLiquido() {
        this.salarioBruto = 0;
        this.descontos = 0;
        this.beneficios = 0;
        this.salarioLiquido = 0;
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
                    System.out.print("Digite o novo valor de Salario Bruto: ");
                    salarioBruto = scanner.nextDouble();
                    if (opcaoCalculadora != 1) break;
                case 3:
                    System.out.print("Digite o novo valor de Descontos: ");
                    descontos = scanner.nextDouble();
                    if (opcaoCalculadora != 1) break;
                case 4:
                    System.out.print("Digite o novo valor de Benefícios: ");
                    beneficios = scanner.nextDouble();
                    break;
                case 5:
                    this.salarioLiquido = salarioBruto - descontos + beneficios;
                    System.out.println("Cálculo executado");
                    break;
                case 6:
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
        System.out.println("O seu salário líquido é de R$ " + String.format("R$ %.2f", this.salarioLiquido));
    }

    @Override
    public void exibirOpcoes() {
        System.out.println("\n===== Calculadora de Salário Líquido =====");
        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("1 - Alterar todos os parâmetros.");
        System.out.println("2 - Alterar Salario Bruto. (Atual:" + String.format("R$ %.2f", salarioBruto) + ")");
        System.out.println("3 - Alterar Descontos.     (Atual:" + String.format("R$ %.2f", descontos) + ")");
        System.out.println("4 - Alterar Benefícios.    (Atual:" + String.format("R$ %.2f", beneficios) + ")");
        System.out.println("5 - Executar cálculo");
        System.out.println("6 - Mostrar resultado");
        System.out.println("0 - Voltar ao Menu");
        System.out.print("Sua opção: ");
    }
}

