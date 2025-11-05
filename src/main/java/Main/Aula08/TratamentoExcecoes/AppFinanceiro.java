package Main.Aula08.TratamentoExcecoes;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class AppFinanceiro {

    public static void main(String[] args) {
        System.out.println("Teste 1: Divisão normal");
        calcularDivisao(10, 2);
        System.out.println("Teste 2: Divisão por zero");
        calcularDivisao(10, 0);

        CadastroCliente cadastro = new CadastroCliente();
        try {
            System.out.println("Tentando cadastrar cliente...");
            cadastro.cadastrar("", 16);
        } catch (DadosInvalidosException e) {
            String mensagem = e.getMessage();
            System.out.println("Erro: " + mensagem);
            logarErro(mensagem);
        }
    }

    static void calcularDivisao(int a, int b) {
        try {
            int resultado = a / b;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            String mensagem = "Divisão por zero não é permitida.";
            System.out.println("Erro: " + mensagem);
            logarErro(mensagem + " (Detalhe: " + e.getMessage() + ")");
        } finally {
            System.out.println("Operação finalizada com sucesso. ");
            System.out.println();
        }
    }

    private static void logarErro(String mensagemErro) {
        try (FileWriter writer = new FileWriter("src\\main\\java\\Main\\Aula08\\TratamentoExcecoes\\log_erros.txt", true)) {
            String timestamp = LocalDateTime.now().toString();
            String logEntry = timestamp + " - ERRO: " + mensagemErro + System.lineSeparator();

            writer.write(logEntry);

        } catch (IOException ioEx) {
            System.err.println("Erro ao Logar!! : " + ioEx.getMessage());
        }
    }
}