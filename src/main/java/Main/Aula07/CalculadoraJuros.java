package Main.Aula07;

import java.util.Scanner;

public class CalculadoraJuros extends Calculo {
    private char tipoJuros;
    private double jurosMensal;
    private double capital;
    private double tempoMeses;
    private double montante;

    public CalculadoraJuros() {
        tipoJuros = 'S';
        capital = 0;
        jurosMensal = 0;
        montante = 0;
        tempoMeses = 0;
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
                    System.out.print("Digite o tipo de Juros: ");
                    System.out.print("S - Simples  | C - Composto: ");
                    char charLido = scanner.next().charAt(0);
                    setTipoJuros(Character.toUpperCase(charLido));
                    if (opcaoCalculadora != 1) break;
                case 3:
                    System.out.print("Digite a Taxa de Juros Mensal: ");
                    setJurosMensal(scanner.nextDouble());
                    if (opcaoCalculadora != 1) break;
                case 4:
                    System.out.print("Digite o Capital: ");
                    setCapital(scanner.nextDouble());
                    if (opcaoCalculadora != 1) break;
                case 5:
                    System.out.print("Digite o tempo (em meses): ");
                    setTempoMeses(scanner.nextDouble());
                    break;
                case 6:
                    double juros = 0;
                    if (getTipoJuros() == 'S')
                        juros = capital * (jurosMensal/100) * tempoMeses;
                    if (getTipoJuros() == 'C')
                        juros = (capital * Math.pow(1 + jurosMensal/100, tempoMeses)) - capital;
                    setMontante(capital + juros);
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
        System.out.println("Montante final é de " + String.format("R$ %.2f", montante));
    }

    @Override
    public void exibirOpcoes() {
        String tipoJurosExtenso = "###";
        if (getTipoJuros() == 'S') tipoJurosExtenso = "Simples";
        if (getTipoJuros() == 'C') tipoJurosExtenso = "Composto";

        System.out.println("\n===== Calculadora de Juros =====");
        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("1 - Alterar todos os parâmetros.");
        System.out.println("2 - Alterar tipo de juros         (Atual: " + tipoJurosExtenso + ")");
        System.out.println("3 - Alterar juros mensal.         (Atual:" + String.format("$ %.2f", getJurosMensal()) + ")");
        System.out.println("4 - Alterar capital.              (Atual:" + String.format("$ %.2f", getCapital()) + ")");
        System.out.println("5 - Alterar tempo (em Meses).     (Atual:" + String.format(" %.1f meses", getTempoMeses()) + ")");
        System.out.println("6 - Executar cálculo");
        System.out.println("7 - Mostrar Montante");
        System.out.println("0 - Voltar ao Menu");
        System.out.print("Sua opção: ");
    }

    public char getTipoJuros() {
        return tipoJuros;
    }

    public void setTipoJuros(char tipoJuros) {
        if (tipoJuros == 'S' || tipoJuros == 'C')
            this.tipoJuros = tipoJuros;
    }

    public double getJurosMensal() {
        return jurosMensal;
    }

    public void setJurosMensal(double jurosMensal) {
        this.jurosMensal = jurosMensal;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getTempoMeses() {
        return tempoMeses;
    }

    public void setTempoMeses(double tempoMeses) {
        this.tempoMeses = tempoMeses;
    }

    public double getMontante() {
        return montante;
    }

    public void setMontante(double montante) {
        this.montante = montante;
    }
}

