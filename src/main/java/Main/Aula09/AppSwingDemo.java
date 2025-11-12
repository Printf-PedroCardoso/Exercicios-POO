package Main.Aula09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AppSwingDemo extends JFrame {

    public AppSwingDemo() {
        setTitle("Aplicação de Teste - Java Swing");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // IMPORTANT
        setLocationRelativeTo(null); // Centraliza a janela

        // Painel principal com layout gerenciado
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        add(painelPrincipal);

        // ====== MENU SUPERIOR ======
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem itemCarregar = new JMenuItem("Carregar");
        JMenuItem itemSalvar = new JMenuItem("Salvar");
        JMenuItem itemSair = new JMenuItem("Sair");
        itemSair.addActionListener(e -> System.exit(0));

        menuArquivo.add(itemCarregar);
        menuArquivo.add(itemSalvar);
        menuArquivo.addSeparator();
        menuArquivo.add(itemSair);
        menuBar.add(menuArquivo);
        setJMenuBar(menuBar);

        // ====== PAINEL SUPERIOR ======
        JPanel painelSuperior = new JPanel(new FlowLayout());
        JLabel lblTitulo = new JLabel("Demonstração de Componentes Swing");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        painelSuperior.add(lblTitulo);
        painelPrincipal.add(painelSuperior, BorderLayout.NORTH);

        // ====== PAINEL CENTRAL ======
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new GridLayout(6, 2, 5, 5));

        painelCentral.add(new JLabel("Nome:"));
        JTextField txtNome = new JTextField();
        painelCentral.add(txtNome);

        painelCentral.add(new JLabel("Gênero:"));
        String[] generos = {"Masculino", "Feminino", "Outro"};
        JComboBox<String> cbGenero = new JComboBox<>(generos);
        painelCentral.add(cbGenero);

        painelCentral.add(new JLabel("Preferência:"));
        JCheckBox chkEmail = new JCheckBox("Receber e-mails");
        painelCentral.add(chkEmail);

        painelCentral.add(new JLabel("Tipo de usuário:"));
        JPanel painelRadios = new JPanel();
        JRadioButton rbAluno = new JRadioButton("Aluno XPTO");
        JRadioButton rbProfessor = new JRadioButton("Professor XPTO");
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rbAluno);
        grupo.add(rbProfessor);
        painelRadios.add(rbAluno);
        painelRadios.add(rbProfessor);
        painelCentral.add(painelRadios);

        painelCentral.add(new JLabel("Comentários:"));
        JTextArea txtComentarios = new JTextArea(3, 20);
        painelCentral.add(new JScrollPane(txtComentarios));

        painelPrincipal.add(painelCentral, BorderLayout.CENTER);

        // ====== PAINEL INFERIOR (TABELA + BOTÕES) ======
        JPanel painelInferior = new JPanel(new BorderLayout()); // 1. Painel que agrupa tabela e botões

        // ====== TABELA ======
        String[] colunas = {"Nome", "Gênero", "Tipo"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);
        JScrollPane scrollTabela = new JScrollPane(tabela);
        scrollTabela.setPreferredSize(new Dimension(0, 150));
        painelInferior.add(scrollTabela, BorderLayout.CENTER);

        // ====== PAINEL DE BOTÕES ======
        JPanel painelBotoes = new JPanel();
        JButton btnSalvar = new JButton("Adicionar");
        JButton btnLimpar = new JButton("Limpar Campos");
        JButton btnExcluir = new JButton("Excluir Selecionados");
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnLimpar);
        painelBotoes.add(btnExcluir);
        painelInferior.add(painelBotoes, BorderLayout.SOUTH);

        // Adiciona o painel inferior completo ao painel principal
        painelPrincipal.add(painelInferior, BorderLayout.SOUTH);

        // ====== EVENTOS DE BOTÕES ======
        btnSalvar.addActionListener((ActionEvent e) -> {
            String nome = txtNome.getText();
            String genero = (String) cbGenero.getSelectedItem();
            String tipo = rbAluno.isSelected() ? "Aluno" :
                    rbProfessor.isSelected() ? "Professor" : "Não informado";

            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, informe o nome.",
                        "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            modelo.addRow(new Object[]{ nome, genero, tipo});
            JOptionPane.showMessageDialog(this, "Registro adicionado com sucesso!");
        });

        btnLimpar.addActionListener(e -> {
            txtNome.setText("");
            cbGenero.setSelectedIndex(0);
            grupo.clearSelection();
            chkEmail.setSelected(false);
            txtComentarios.setText("");
        });

        btnExcluir.addActionListener(e -> {
            int[] linhasSelecionadas = tabela.getSelectedRows();

            if (linhasSelecionadas.length == 0) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, selecione as linhas que deseja excluir.",
                        "Nenhuma linha selecionada",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            int resposta = JOptionPane.showConfirmDialog(
                    this,
                    "Deseja realmente excluir as " + linhasSelecionadas.length + " linhas selecionadas?",
                    "Confirmar Exclusão",
                    JOptionPane.YES_NO_OPTION
            );

            if (resposta != JOptionPane.YES_OPTION)
                return;

            try {
                for (int i = linhasSelecionadas.length - 1; i >= 0; i--) {
                    int linhaView = linhasSelecionadas[i];
                    int linhaModelo = tabela.convertRowIndexToModel(linhaView);
                    modelo.removeRow(linhaModelo);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Erro ao excluir linhas: " + ex.getMessage(),
                        "Erro de Exclusão",
                        JOptionPane.ERROR_MESSAGE);
            }

        });

        // ====== EVENTOS DE ARQUIVO ======

        //Salvar
        itemSalvar.addActionListener(e -> {
            JFileChooser seletorArquivo = new JFileChooser();
            seletorArquivo.setDialogTitle("Salvar como");
            // Filtro para sugerir/mostrar apenas .txt
            seletorArquivo.setFileFilter(new javax.swing.filechooser.FileFilter() {
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".txt") || f.isDirectory();
                }
                public String getDescription() {
                    return "Arquivo de Texto (.txt)";
                }
            });

            int resultado = seletorArquivo.showSaveDialog(this);

            if (resultado == JFileChooser.APPROVE_OPTION) {
                File arquivoParaSalvar = seletorArquivo.getSelectedFile();

                // Garante que o arquivo tenha a extensão .txt
                String caminho = arquivoParaSalvar.getAbsolutePath();
                if (!caminho.toLowerCase().endsWith(".txt")) {
                    arquivoParaSalvar = new File(caminho + ".txt");
                }

                // Bloco Try-With-Resources: fecha o 'writer' automaticamente
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoParaSalvar))) {

                    // Salva os dados da tabela (Nome, Genero, Tipo)
                    for (int i = 0; i < modelo.getRowCount(); i++) {
                        String nome = (String) modelo.getValueAt(i, 0);
                        String genero = (String) modelo.getValueAt(i, 1);
                        String tipo = (String) modelo.getValueAt(i, 2);

                        writer.write(nome + ";" + genero + ";" + tipo);
                        writer.newLine();
                    }

                    JOptionPane.showMessageDialog(this,
                            "Registros salvos com sucesso!",
                            "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this,
                            "Erro ao salvar o arquivo: " + ex.getMessage(),
                            "Erro de I/O",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Carregar
        itemCarregar.addActionListener(e -> {
            JFileChooser seletorArquivo = new JFileChooser();
            seletorArquivo.setDialogTitle("Abrir arquivo");
            // Filtro para mostrar apenas .txt
            seletorArquivo.setFileFilter(new javax.swing.filechooser.FileFilter() {
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".txt") || f.isDirectory();
                }
                public String getDescription() {
                    return "Arquivo de Texto (.txt)";
                }
            });

            int resultado = seletorArquivo.showOpenDialog(this);

            if (resultado == JFileChooser.APPROVE_OPTION) {
                File arquivoParaCarregar = seletorArquivo.getSelectedFile();

                // Validar se arquivo é .txt
                if (!arquivoParaCarregar.getName().toLowerCase().endsWith(".txt")) {
                    JOptionPane.showMessageDialog(this,
                            "Por favor, selecione um arquivo .txt válido.",
                            "Tipo de Arquivo Inválido",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                List<String[]> dadosValidos = new ArrayList<>();

                // Bloco Try-With-Resources
                try (BufferedReader reader = new BufferedReader(new FileReader(arquivoParaCarregar))) {

                    String linha;
                    int numeroLinha = 1;

                    while ((linha = reader.readLine()) != null) {
                        // Ignora linhas em branco
                        if (linha.trim().isEmpty()) {
                            continue;
                        }

                        String[] dados = linha.split(";");

                        // Validar estrutura da linha
                        if (dados.length != 3) {
                            JOptionPane.showMessageDialog(this,
                                    "O arquivo está corrompido ou em formato inválido.\n" +
                                            "Erro na linha " + numeroLinha + ": A estrutura não corresponde (Nome;Genero;Tipo).",
                                    "Erro de Formato",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Adicionar linha válida aos dados temporários
                        dadosValidos.add(dados);
                        numeroLinha++;
                    }

                    // Limpa tabela e adiciona dados
                    modelo.setRowCount(0);
                    for (String[] dados : dadosValidos) {
                        modelo.addRow(dados);
                    }

                    JOptionPane.showMessageDialog(this,
                            "Registros carregados com sucesso!",
                            "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this,
                            "Erro ao ler o arquivo: " + ex.getMessage(),
                            "Erro de I/O",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppSwingDemo().setVisible(true));
    }
}