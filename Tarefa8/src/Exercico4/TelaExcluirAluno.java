package Exercico4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TelaExcluirAluno extends JFrame {

    private DefaultTableModel modeloTabela;
    private JTable tabelaAlunos;
    private TableRowSorter<DefaultTableModel> sorter;

    public TelaExcluirAluno() {
        setTitle("Excluir Aluno");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 1. CRIANDO A TABELA 
        String[] colunas = {"Nome", "Matrícula", "Curso"};
        modeloTabela = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Impede que o usuário edite o texto direto na célula
            }
        };

        tabelaAlunos = new JTable(modeloTabela);
        tabelaAlunos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        
        sorter = new TableRowSorter<>(modeloTabela);
        tabelaAlunos.setRowSorter(sorter);

        JScrollPane painelTabela = new JScrollPane(tabelaAlunos);

        // 2. PAINEL SUPERIOR: CAMPO DE BUSCA
        JPanel painelBusca = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelBusca.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        painelBusca.add(new JLabel("Pesquisar: "));
        
        JTextField campoBusca = new JTextField(30);
        painelBusca.add(campoBusca);

        // Listener que escuta cada letra digitada no campo de texto para filtrar a tabela em tempo real
        campoBusca.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { pesquisar(); }
            @Override
            public void removeUpdate(DocumentEvent e) { pesquisar(); }
            @Override
            public void changedUpdate(DocumentEvent e) { pesquisar(); }

            private void pesquisar() {
                String texto = campoBusca.getText();
                if (texto.trim().length() == 0) {
                    sorter.setRowFilter(null); // Mostra tudo se estiver vazio
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
                }
            }
        });

        // 3. PAINEL INFERIOR: BOTÃO DE EXCLUIR
        JPanel painelBotoes = new JPanel();
        JButton btnExcluir = new JButton("Excluir Selecionado");
        painelBotoes.add(btnExcluir);
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionadaVisivel = tabelaAlunos.getSelectedRow();

                if (linhaSelecionadaVisivel == -1) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um aluno na tabela primeiro.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

       
                int linhaRealNoModelo = tabelaAlunos.convertRowIndexToModel(linhaSelecionadaVisivel);
                
                String nomeAluno = (String) modeloTabela.getValueAt(linhaRealNoModelo, 0); // Pega o nome na coluna 0
                
                int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o aluno: " + nomeAluno + "?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
                
                if (confirmacao == JOptionPane.YES_OPTION) {
                    Aluno alunoExcluir = SistemaAcademico.getInstancia().buscarAlunoPorNome(nomeAluno);
                    if (alunoExcluir != null) {
                        SistemaAcademico.getInstancia().excluirAluno(alunoExcluir);
                        JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");
                        carregarDadosTabela(); 
                        dispose();
                    }
                }
            }
        });

        // 4. MONTANDO A JANELA
        setLayout(new BorderLayout(10, 10)); // Espaçamento entre os painéis
        add(painelBusca, BorderLayout.NORTH);
        add(painelTabela, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        // 5. ATUALIZAÇÃO DINÂMICA
        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                carregarDadosTabela();
            }
        });

        // 6. RESPONSIVIDADE
        pack();
        setLocationRelativeTo(null); // Centraliza na tela depois do pack()
    }

    private void carregarDadosTabela() {
        modeloTabela.setRowCount(0); // Limpa as linhas antigas
        
        List<Aluno> listaAlunos = SistemaAcademico.getInstancia().getAluno();
        for (Aluno a : listaAlunos) {
            // Adiciona uma linha nova com Nome, Matrícula e Curso
            modeloTabela.addRow(new Object[]{
                a.getNome(), 
                a.getMatricula(), 
                a.getCurso()
            });
        }
    }
}