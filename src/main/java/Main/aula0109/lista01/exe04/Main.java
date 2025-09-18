package aula0109.lista01.exe04;
/*
4. Escrever um algoritmo que lê:
        - a porcentagem do IPI a ser acrescido no valor das peças
        - o código da peça 1, valor unitário da peça 1, quantidade de peças 1
        - o código da peça 2, valor unitário da peça 2, quantidade de peças 2
O algoritmo deve calcular o valor total a ser pago e apresentar o resultado.
Fórmula : (valor1*quant1 + valor2*quant2)*(IPI/100 + 1)
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float IPI;
        float total;
        Peca peca1 = new Peca();
        Peca peca2 = new Peca();

        IPI = scanner.nextFloat();

        peca1.codigo = scanner.nextInt();
        peca1.valorUnitario = scanner.nextFloat();
        peca1.quantidade = scanner.nextInt();

        peca2.codigo = scanner.nextInt();
        peca2.valorUnitario = scanner.nextFloat();
        peca2.quantidade = scanner.nextInt();

        total = (peca1.valorUnitario * peca1.quantidade + peca2.valorUnitario * peca2.quantidade) * (IPI/100 + 1);

        System.out.println("total= " + total);
    }
}
