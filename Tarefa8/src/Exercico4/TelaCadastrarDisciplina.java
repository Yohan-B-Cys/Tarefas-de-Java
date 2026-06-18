package Exercico4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

public class TelaCadastrarDisciplina extends JFrame {

    private JTextField nome;
    private JTextField qtdAlunos;
    private JTextField buscaProf;
    private DefaultTableModel modeloProfessores;
    private JTable tabelaProfessores;
    private TableRowSorter<DefaultTableModel> sorterProf;
    private JButton salvar;

    public TelaCadastrarDisciplina() {
        setTitle("CADASTRO DE DISCIPLINA");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // --- PAINEL SUPERIOR: DADOS DA DISCIPLINA ---
        JPanel painelFormulario = new JPanel(new GridLayout(2, 2, 5, 5));
        painelFormulario.setBorder(BorderFactory.createTitledBorder("Informações Básicas"));
        
        nome = new JTextField();
        qtdAlunos = new JTextField();
        
        painelFormulario.add(new JLabel("Nome da Disciplina:"));
        painelFormulario.add(nome);
        painelFormulario.add(new JLabel("Quantidade MÁX de Alunos (Limite):"));
        painelFormulario.add(qtdAlunos);

        // Restrição numérica usando KeyAdapter igual às suas outras telas
        qtdAlunos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });

        // --- PAINEL CENTRAL: SELEÇÃO DE PROFESSOR COM TABELA ---
        JPanel painelProf = new JPanel(new BorderLayout(5, 5));
        painelProf.setBorder(BorderFactory.createTitledBorder("Selecione o Professor Responsável"));
        
        buscaProf = new JTextField();
        painelProf.add(buscaProf, BorderLayout.NORTH);

        modeloProfessores = new DefaultTableModel(new String[]{"Professor / Docente"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tabelaProfessores = new JTable(modeloProfessores);
        tabelaProfessores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sorterProf = new TableRowSorter<>(modeloProfessores);
        tabelaProfessores.setRowSorter(sorterProf);
        painelProf.add(new JScrollPane(tabelaProfessores), BorderLayout.CENTER);

        // Filtro em tempo real para os Professores
        buscaProf.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { filtrar(); }
            @Override public void removeUpdate(DocumentEvent e) { filtrar(); }
            @Override public void changedUpdate(DocumentEvent e) { filtrar(); }
            private void filtrar() {
                String t = buscaProf.getText();
                if (t.trim().length() == 0) sorterProf.setRowFilter(null);
                else sorterProf.setRowFilter(RowFilter.regexFilter("(?i)" + t));
            }
        });

        // --- BOTÃO SALVAR ---
        salvar = new JButton("CADASTRAR DISCIPLINA");
        salvar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idxProf = tabelaProfessores.getSelectedRow();
                
                if (idxProf == -1) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um professor na tabela.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    String nomeDisciplina = nome.getText();
                    String qtdAlunoDigitada = qtdAlunos.getText();
                    
                    if (nomeDisciplina.trim().isEmpty() || qtdAlunoDigitada.trim().isEmpty()) {
                        throw new IllegalArgumentException("Todos os campos básicos devem ser preenchidos.");
                    }
                    
                    int limiteAlunos = Integer.parseInt(qtdAlunoDigitada);
                    if (limiteAlunos < 1) {
                        throw new IllegalArgumentException("Não se pode criar uma Disciplina sem alunos.");
                    }

                    int realIdxProf = tabelaProfessores.convertRowIndexToModel(idxProf);
                    String nomeProfSelecionado = (String) modeloProfessores.getValueAt(realIdxProf, 0);
                    
                    Professor profDisciplina = SistemaAcademico.getInstancia().buscarProfessorPorNome(nomeProfSelecionado);
                    if (profDisciplina == null) {
                        throw new IllegalArgumentException("Professor não encontrado no banco de dados.");
                    }

                    Disciplina novaDisciplina = new Disciplina(nomeDisciplina, profDisciplina, limiteAlunos);
                    SistemaAcademico.getInstancia().cadastrarDisciplina(novaDisciplina);
                    
                    JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    dispose();

                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "Insira apenas números inteiros válidos!", "Entrada Inválida", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException e3) {
                    JOptionPane.showMessageDialog(null, e3.getMessage(), "Aviso de Validação", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // --- ESTRUTURA FINAL DA JANELA ---
        JPanel painelConteudo = new JPanel(new BorderLayout(10, 10));
        painelConteudo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        painelConteudo.add(painelFormulario, BorderLayout.NORTH);
        painelConteudo.add(painelProf, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(painelConteudo, BorderLayout.CENTER);
        add(salvar, BorderLayout.SOUTH);

        addWindowFocusListener(new WindowAdapter() {
            @Override public void windowGainedFocus(WindowEvent e) { carregarProfessores(); }
        });

        pack();
        setSize(550, 450);
        setLocationRelativeTo(null);
    }

    private void carregarProfessores() {
        modeloProfessores.setRowCount(0);
        String[] listaProf = SistemaAcademico.getInstancia().nomeDosProf();
        for (String p : listaProf) {
            modeloProfessores.addRow(new Object[]{p});
        }
    }
}