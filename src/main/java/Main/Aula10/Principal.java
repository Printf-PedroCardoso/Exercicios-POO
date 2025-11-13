package Main.Aula10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Principal {
    /* atributos */
    private String nomeDoArquivo;

    /* construtor */
    public Principal(String nomeArquivo) {
        this.nomeDoArquivo = nomeArquivo;
    }

    /* métodos */
    public void inserirDados(String registro) {
        File fArquivo = null;
        try {
            fArquivo = new File(this.nomeDoArquivo);
            FileWriter fwArquivo = null;

            // Verifica se o arquivo existe
            // Se existir, ele abre par adicionar dados
            // se nao existir, ele cria o arquivo
            if (fArquivo.exists() == true) {
                fwArquivo = new FileWriter(fArquivo, true);
            } else {
                fwArquivo = new FileWriter(fArquivo);
            }

            BufferedWriter bw = new BufferedWriter(fwArquivo);

            //escreve o registro no arquivo e pula uma linha com o \n
            bw.write(registro + "\n");

            System.out.println("Registro adicionado com sucesso...");

            //fecha o arquivo
            bw.close();
            fwArquivo.close();

        } catch (Exception e) {
            System.err.println("Erro ao inserir linhas no arquivo: " + fArquivo);
        }
    }

    public void listarDados() {
        Scanner lendoArquivo = null;
        File arquivo = null;
        try {
            // abrindo o arquivo para leitura
            // se o arquivo nao existir será disparada uma exceção
            arquivo = new File(this.nomeDoArquivo);
            lendoArquivo = new Scanner(arquivo);

            // leia o arquivo linha por linha até chegar ao seu fim
            while (lendoArquivo.hasNextLine()) {
                this.processandoLinha(lendoArquivo.nextLine());
            }


        } catch (FileNotFoundException e) { // tratando quando o arquivo nao existe
            System.err.println("Erro: arquivo nao existe. " + arquivo);
        } finally {
            // fechando o scanner
            try {
                lendoArquivo.close();
            } catch (Exception e) {
            }
        }
    }

    private void processandoLinha(String linha) {
        // toda linha do arquivo segue o formato:
        // nome:telefone
        if (linha != null && !linha.trim().isEmpty()) {
            try {
                // separando os campos através do delimitador ':'
                String[] campos = linha.split(":");

                if (campos.length >= 2)
                {
                    Contato contato = new Contato(campos[0].trim(), campos[1].trim());
                    System.out.println(contato);
                } else {
                    System.err.println("[ERRO] Linha com formato inválido no arquivo: " + linha);
                }

            } catch (Exception Ex) {
                System.err.println("[ERRO INESPERADO] Falha ao processar linha: " + linha);
            }
        }
    }

    private void buscaDados(String nomeBusca){
        Scanner lendoArquivo = null;
        File arquivo = null;
        try {
            arquivo = new File(this.nomeDoArquivo);
            lendoArquivo = new Scanner(arquivo);

            // leia o arquivo linha por linha até chegar ao seu fim
            while (lendoArquivo.hasNextLine()) {
                String linha = lendoArquivo.nextLine();
                String[] campos = linha.split(":");
                Contato contato = new Contato(campos[0].trim(), campos[1].trim());

                if (campos[0].trim().equalsIgnoreCase(nomeBusca)) {
                    System.out.println(contato);
                    return;
                }
            }

            System.out.println("O contato " + nomeBusca + " não está na agenda");

        } catch (FileNotFoundException e) { // tratando quando o arquivo nao existe
            System.err.println("Erro: arquivo nao existe. " + arquivo);
        } finally {
            // fechando o scanner
            try {
                lendoArquivo.close();
            } catch (Exception e) {
            }
        }
    }

    public void menu() {
        // passando para o objeto da classe Scanner o dispositivo de entrada padrão
        // que é o teclado
        Scanner teclado = new Scanner(System.in);
        int op = 0;
        do {
            System.out.println("..:: Trabalhando com Arquivos Texto ::..");
            System.out.println("1 - Inserir linha");
            System.out.println("2 - Listar todo arquivo");
            System.out.println("3 - Sair");
            System.out.println("4 - Buscar por Nome");
            System.out.print("Entre com uma opcao: ");
            op = teclado.nextInt();

            System.out.println();
            switch (op) {
                case 1:
                    teclado.nextLine();
                    String nome;
                    String telefone;
                    System.out.println("Entre com os dados:");
                    System.out.print("Nome: ");
                    nome = teclado.nextLine();
                    System.out.print("Fone: ");
                    telefone = teclado.nextLine();
                    this.inserirDados(nome + ":" + telefone);
                    break;
                case 2:
                    this.listarDados();
                    break;
                case 3:
                    System.out.println("Saindo!");
                    break;
                case 4:
                    String nomeBusca;
                    System.out.print("Insira o nome: ");
                    nomeBusca = teclado.next();
                    this.buscaDados(nomeBusca);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println();

        } while (op != 3);
    }

    public static void main(String[] args) {
        Principal p = new Principal("src\\main\\java\\Main\\Aula10\\agenda-poo.txt");

        p.menu();
    }
}
