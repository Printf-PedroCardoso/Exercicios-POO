package Main.Aula06.Ex05;

public class ContaBancaria implements Autenticavel, Registravel{

    @Override
    public void autenticar(String Senha) {
        if (Senha == "123")
        {
            System.out.println("Senha aceita. Ela é indecifrável, parabéns pela sua senha forte.");
            System.out.println("Chamando operação...");
            registrar();
        } else {
            System.out.println(("Senha errada, troxa"));
        }
    }

    @Override
    public void registrar() {
        System.out.println("Operação Registrada");
    }
}
