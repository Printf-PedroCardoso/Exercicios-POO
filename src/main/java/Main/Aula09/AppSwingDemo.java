package Main.Aula09;

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
        JMenuItem itemSair = new JMenuItem("Sair");
        itemSair.addActionListener(e -> System.exit(0));
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

        // ====== EVENTOS ======
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

            for (int i = linhasSelecionadas.length - 1; i >= 0; i--) {
                int linhaView = linhasSelecionadas[i];
                int linhaModelo = tabela.convertRowIndexToModel(linhaView);
                modelo.removeRow(linhaModelo);
            }

        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppSwingDemo().setVisible(true));
    }
}