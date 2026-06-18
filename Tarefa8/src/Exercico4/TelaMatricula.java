package Exercico4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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

public class TelaMatricula extends JFrame {

    private DefaultTableModel modeloAlunos, modeloDisciplinas;
    private JTable tabelaAlunos, tabelaDisciplinas;
    private TableRowSorter<DefaultTableModel> sorterAlunos, sorterDisciplinas;
    private JButton salvar;

    public TelaMatricula() {
        setTitle("MATRICULAR ALUNO");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // --- PAINEL DA ESQUERDA: SELEÇÃO DE ALUNO ---
        JPanel painelEsquerda = new JPanel(new BorderLayout(5, 5));
        painelEsquerda.setBorder(BorderFactory.createTitledBorder("1. Selecione o Aluno"));
        
        JTextField buscaAluno = new JTextField();
        painelEsquerda.add(buscaAluno, BorderLayout.NORTH);

        modeloAlunos = new DefaultTableModel(new String[]{"Nome", "Curso"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tabelaAlunos = new JTable(modeloAlunos);
        tabelaAlunos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sorterAlunos = new TableRowSorter<>(modeloAlunos);
        tabelaAlunos.setRowSorter(sorterAlunos);
        painelEsquerda.add(new JScrollPane(tabelaAlunos), BorderLayout.CENTER);

        // --- PAINEL DA DIREITA: SELEÇÃO DE DISCIPLINA ---
        JPanel painelDireita = new JPanel(new BorderLayout(5, 5));
        painelDireita.setBorder(BorderFactory.createTitledBorder("2. Selecione a Disciplina"));
        
        JTextField buscaDisciplina = new JTextField();
        painelDireita.add(buscaDisciplina, BorderLayout.NORTH);

        modeloDisciplinas = new DefaultTableModel(new String[]{"Disciplina"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tabelaDisciplinas = new JTable(modeloDisciplinas);
        tabelaDisciplinas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sorterDisciplinas = new TableRowSorter<>(modeloDisciplinas);
        tabelaDisciplinas.setRowSorter(sorterDisciplinas);
        painelDireita.add(new JScrollPane(tabelaDisciplinas), BorderLayout.CENTER);

        // --- LISTENERS DE FILTRO (BUSCA EM TEMPO REAL) ---
        configurarFiltro(buscaAluno, sorterAlunos);
        configurarFiltro(buscaDisciplina, sorterDisciplinas);

        // --- PAINEL CENTRAL (JUNÇÃO DAS DUAS TABELAS) ---
        JPanel painelCentral = new JPanel(new GridLayout(1, 2, 10, 10));
        painelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        painelCentral.add(painelEsquerda);
        painelCentral.add(painelDireita);

        // --- BOTÃO SALVAR ---
        salvar = new JButton("EFETUAR MATRÍCULA");
        salvar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idxAluno = tabelaAlunos.getSelectedRow();
                int idxDisc = tabelaDisciplinas.getSelectedRow();

                if (idxAluno == -1 || idxDisc == -1) {
                    JOptionPane.showMessageDialog(null, "Selecione um aluno E uma disciplina antes de salvar.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    int realIdxAluno = tabelaAlunos.convertRowIndexToModel(idxAluno);
                    int realIdxDisc = tabelaDisciplinas.convertRowIndexToModel(idxDisc);

                    String nomeAluno = (String) modeloAlunos.getValueAt(realIdxAluno, 0);
                    String nomeDisciplina = (String) modeloDisciplinas.getValueAt(realIdxDisc, 0);

                    Aluno alunoMatricula = SistemaAcademico.getInstancia().buscarAlunoPorNome(nomeAluno);
                    Disciplina disciplinaMatricula = SistemaAcademico.getInstancia().buscarDisciplinaPorNome(nomeDisciplina);

                    if (alunoMatricula == null || disciplinaMatricula == null) {
                        throw new IllegalArgumentException("Erro ao localizar registros no sistema.");
                    }

                    SistemaAcademico.getInstancia().matricularAlunoEmDisciplina(alunoMatricula, disciplinaMatricula);
                    JOptionPane.showMessageDialog(null, "Aluno Matriculado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    dispose();

                } catch (IllegalArgumentException e2) {
                    JOptionPane.showMessageDialog(null, e2.getMessage(), "Aviso de Validação", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // --- ORGANIZAÇÃO DA JANELA ---
        setLayout(new BorderLayout());
        add(painelCentral, BorderLayout.CENTER);
        add(salvar, BorderLayout.SOUTH);

        // Atualização automática ao abrir/focar a tela
        addWindowFocusListener(new WindowAdapter() {
            @Override public void windowGainedFocus(WindowEvent e) { carregarDados(); }
        });

        pack();
        setSize(850, 450); // Define um tamanho inicial confortável para a exibição dupla
        setLocationRelativeTo(null);
    }

    private void configurarFiltro(JTextField campo, TableRowSorter<DefaultTableModel> sorter) {
        campo.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { filtrar(); }
            @Override public void removeUpdate(DocumentEvent e) { filtrar(); }
            @Override public void changedUpdate(DocumentEvent e) { filtrar(); }
            private void filtrar() {
                String t = campo.getText();
                if (t.trim().length() == 0) sorter.setRowFilter(null);
                else sorter.setRowFilter(RowFilter.regexFilter("(?i)" + t));
            }
        });
    }

    private void carregarDados() {
        modeloAlunos.setRowCount(0);
        List<Aluno> listaAlunos = SistemaAcademico.getInstancia().getAluno();
        for (Aluno a : listaAlunos) {
            modeloAlunos.addRow(new Object[]{a.getNome(), a.getCurso()});
        }

        modeloDisciplinas.setRowCount(0);
        String[] listaDisc = SistemaAcademico.getInstancia().nomeDasDisciplinas();
        for (String d : listaDisc) {
            modeloDisciplinas.addRow(new Object[]{d});
        }
    }
}