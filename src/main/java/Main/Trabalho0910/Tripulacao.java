package Main.Trabalho0910;

import java.util.ArrayList;

public class Tripulacao {

    private String nome;
    private String navio;
    private String marDeOrigem;
    private ArrayList<Pirata> tripulacao;

    public Tripulacao(String nome, String navio, String marDeOrigem) {
        this.nome = nome;
        this.navio = navio;
        this.marDeOrigem = marDeOrigem;
        this.tripulacao = new ArrayList<>();
    }

    public void adicionarPirata (Pirata p) {
        tripulacao.add(p);
    }

    public void listarPiratas () {
        for (int N=0 ; N < tripulacao.size() ; N++)
        {
            Pirata p = tripulacao.get(N);
            System.out.println(N+1 + " - " + p.getNome());
        }
    }

    public int calcularRecompensaTotal() {
        int sum = 0;
        for (Pirata pirata : tripulacao)
        {
            sum += pirata.getRecompensa();
        }
        return sum;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNavio() {
        return navio;
    }

    public void setNavio(String navio) {
        this.navio = navio;
    }

    public String getMarDeOrigem() {
        return marDeOrigem;
    }

    public void setMarDeOrigem(String marDeOrigem) {
        this.marDeOrigem = marDeOrigem;
    }

    public ArrayList<Pirata> getTripulacao() {
        return tripulacao;
    }

    public void setTripulacao(ArrayList<Pirata> tripulacao) {
        this.tripulacao = tripulacao;
    }
}
