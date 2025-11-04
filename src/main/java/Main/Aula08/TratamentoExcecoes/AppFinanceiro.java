package Main.Aula08.TratamentoExcecoes;

public class AppFinanceiro {

    public static void main(String[] args) {
// Testando cálculo
        System.out.println("Teste 1: Divisão normal");
        calcularDivisao(10, 2);
        System.out.println("Teste 2: Divisão por zero");
        calcularDivisao(10, 0);
// Testando cadastro
        CadastroCliente cadastro = new CadastroCliente();
        try {
            System.out.println("Tentando cadastrar cliente...");
            cadastro.cadastrar("", 16);
        } catch (DadosInvalidosException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    static void calcularDivisao(int a, int b) {
        try {
            int resultado = a / b;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: Divisão por zero não é permitida.");
        } finally {
            System.out.println("Operação finalizada com sucesso. ");
            System.out.println();
        }
    }
}
