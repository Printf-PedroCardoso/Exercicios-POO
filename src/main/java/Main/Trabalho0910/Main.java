package Main.Trabalho0910;

public class Main {
    public static void main(String[] args) {


        System.out.println("### 1. Criando Akuma no Mi ###");
        AkumaNoMi gomuGomu = new AkumaNoMi("Gomu Gomu no Mi", TipoFruta.PARAMECIA, "Transforma o corpo do usuário em borracha.");
        AkumaNoMi meraMera = new AkumaNoMi("Mera Mera no Mi", TipoFruta.LOGIA, "Permite ao usuário criar, controlar e se transformar em fogo.");

        System.out.println("Testando poder da " + gomuGomu.getNome() + ":");
        gomuGomu.mostraPoder();
        System.out.println("----------------------------------------\n");

        System.out.println("### 2. Criando Piratas ###");
        Pirata luffy = new Pirata("Monkey D. Luffy", 19, 1500000000, "Capitão", gomuGomu);
        Pirata zoro = new Pirata("Roronoa Zoro", 21, 320000000, "Espadachim");
        Pirata sanji = new Pirata("Sanji", 21, 330000000, "Cozinheiro");

        System.out.println("Apresentando piratas individualmente:");
        luffy.apresentarPirata();
        System.out.println();
        zoro.apresentarPirata();
        System.out.println("----------------------------------------\n");

        System.out.println("### 3. Gerenciando a Tripulação ###");
        Tripulacao chapeusDePalha = new Tripulacao("Chapéus de Palha", "Thousand Sunny", "East Blue");
        System.out.println("Tripulação '" + chapeusDePalha.getNome() + "' criada!");

        chapeusDePalha.adicionarPirata(luffy);
        chapeusDePalha.adicionarPirata(zoro);
        chapeusDePalha.adicionarPirata(sanji);
        System.out.println("Piratas adicionados ao navio " + chapeusDePalha.getNavio() + ".");
        System.out.println();

        System.out.println("Lista de tripulantes a bordo:");
        chapeusDePalha.listarPiratas();
        System.out.println();

        int recompensaTotal = chapeusDePalha.calcularRecompensaTotal();
        System.out.println("A recompensa total da tripulação é: " + recompensaTotal + " Berries.");
        System.out.println("----------------------------------------\n");

        System.out.println("### 4. Demonstrando a classe Marinheiro ###");
        Marinheiro smoker = new Marinheiro("Smoker", 36, 0, "Vice-Almirante", PostoMarinheiro.ALMIRANTE);

        System.out.println("Apresentando o Marinheiro:");
        smoker.apresentarPirata();
        System.out.println("----------------------------------------\n");
    }
}