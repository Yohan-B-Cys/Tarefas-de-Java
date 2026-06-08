package Exercico4;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TelaPrincipal extends JFrame {
	
	JButton op1,op2,op3,op4,op5,op6,op7,op8,op9;
	
	public TelaPrincipal(){
		setTitle("SISTEMA ACADEMICO  ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,1000);
		setResizable(false);
		setLocationRelativeTo(null);
		
		op1 = new JButton("1 - CADASTRAR ALUNO");
		op2 = new JButton("2 - EXCLUIR ALUNO");
		op3 = new JButton("3 - LISTAR ALUNOS");
		op4 = new JButton("4 - MATRICULAR ALUNO EM DISCIPLINA");
		op5 = new JButton("5 - CANCELAR MATRICULA");
		op6 = new JButton("6 - IMPRIMIR ALUNOS E DISCIPLINAS MATRICULADAS");
		op7 = new JButton("7 - CADASTRAR PROFESSOR");
		op8 = new JButton("8 - CADASTRAR DISCIPLINA");
		op9 = new JButton("9 - LISTAR PROFESSORES E SUAS DISCIPLINAS");
		
		JPanel painelTopo = new JPanel(new GridLayout(10,1,5,5));
		painelTopo.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		painelTopo.add(new JLabel("SISTEMA ACADEMICO ESCOLHA A OPÇAO DESEJADA:"));
		painelTopo.add(op1);
		painelTopo.add(op2);
		painelTopo.add(op3);
		painelTopo.add(op4);
		painelTopo.add(op5);
		painelTopo.add(op6);
		painelTopo.add(op7);
		painelTopo.add(op8);
		painelTopo.add(op9);
		
		add(painelTopo);
		
		op1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarAluno telaCadastro = new TelaCadastrarAluno();
				telaCadastro.setVisible(true);
				telaCadastro.setLocationRelativeTo(null);
				
			}
		});
		
		op2.addActionListener(new ActionListener() {
		    
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // 1. Pega a lista de alunos direto do sistema
		        List<Aluno> listaAlunos = SistemaAcademico.getInstancia().getAluno();
		        
		        // 2. Se a lista estiver vazia, nem abre o pop-up, já avisa e sai
		        if (listaAlunos.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Não há alunos cadastrados para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
		            return;
		        }
		        
		        // 3. Converte a lista de alunos para um Vetor de Nomes (String[])
		        String[] nomesAlunos = new String[listaAlunos.size()];
		        for (int i = 0; i < listaAlunos.size(); i++) {
		            nomesAlunos[i] = listaAlunos.get(i).getNome();
		        }
		        
		        // 4. A MÁGICA DO DROPDOWN: Usamos a versão do showInputDialog que recebe o vetor!
		        String nomeBusca = (String) JOptionPane.showInputDialog(
		            null, 
		            "Selecione o aluno que deseja excluir:", 
		            "Excluir Aluno", 
		            JOptionPane.QUESTION_MESSAGE, 
		            null,           // Ícone padrão
		            nomesAlunos,    // <-- AQUI ESTÁ O VETOR QUE VIRA O COMBOBOX!
		            nomesAlunos[0]  // Opção que já vem selecionada por padrão
		        );
		        
		        // 5. Se clicou em cancelar (ou no 'X'), retorna null
		        if (nomeBusca == null) {
		            return; 
		        }
		        
		        // Repare que tiramos a validação de .isEmpty(), porque agora é impossível ele deixar em branco!
		        
		        // 6. Faz a exclusão
		        Aluno alunoExcluir = SistemaAcademico.getInstancia().buscarAlunoPorNome(nomeBusca);
		        
		        if (alunoExcluir != null) {
		            SistemaAcademico.getInstancia().excluirAluno(alunoExcluir);
		            JOptionPane.showMessageDialog(null, "O aluno " + nomeBusca + " foi removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            // Isso aqui dificilmente vai acontecer agora, mas é bom manter por segurança
		            JOptionPane.showMessageDialog(null, "Erro aluno não encontrado : " + nomeBusca, "Não encontrado", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});		
		op3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Aluno> lista = SistemaAcademico.getInstancia().getAluno();
				
				if (lista.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado no momento!", "Aviso", JOptionPane.WARNING_MESSAGE);
					return;
				}
				StringBuilder relatorio = new StringBuilder();
				
				for (Aluno aluno : lista) {
					relatorio.append(aluno.toString()).append("\n");
				
					
				
				}
				JTextArea areaTexto = new JTextArea(relatorio.toString());
				areaTexto.setEditable(false);
				JScrollPane painel = new JScrollPane(areaTexto);
				painel.setPreferredSize(new Dimension(600, 500)); 
		        
		        // 5. Exibe o pop-up na tela!
		        JOptionPane.showMessageDialog(null, painel, "Lista de Alunos", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		op4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaMatricula matricula = new TelaMatricula();
				matricula.setVisible(true);
				matricula.setLocationRelativeTo(null);
				
			}
		});
		
		op5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCancelarMatricula cancela = new TelaCancelarMatricula();
				cancela.setVisible(true);
				cancela.setLocationRelativeTo(null);
				
			}
		});
		
		op6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String listaAlunos = SistemaAcademico.getInstancia().ListaDeAlunoseDisciplinas();
				JTextArea at = new JTextArea(listaAlunos);
				at.setEditable(false);
				at.setFont(new Font("Monospaced", Font.PLAIN, 12));
				JScrollPane painel = new JScrollPane(at);
				painel.setPreferredSize(new Dimension(600, 500));
				
				JOptionPane.showMessageDialog(null, painel, "Alunos e Disciplinas", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		op7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarProfessor cadastroProf = new TelaCadastrarProfessor();
				cadastroProf.setVisible(true);
				cadastroProf.setLocationRelativeTo(null);
				
			}
		});
		
		op8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarDisciplina cadastroDisc = new TelaCadastrarDisciplina();
				cadastroDisc.setVisible(true);
				cadastroDisc.setLocationRelativeTo(null);
			}
		});
		
		op9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String listaProfessores = SistemaAcademico.getInstancia().imprimeProfessoresDisciplinas();
				
				JTextArea areaTexto = new JTextArea(listaProfessores);
		        areaTexto.setEditable(false);
		        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 12)); 
		        
		        // 3. Adiciona a barra de rolagem e mostra na tela!
		        JScrollPane painel = new JScrollPane(areaTexto);
		        painel.setPreferredSize(new Dimension(700, 500)); 
		        
		        JOptionPane.showMessageDialog(null, painel, "Professores e Disciplinas", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
	}
	
	
	
	public static void main (String[] args) {
		TelaPrincipal tela = new TelaPrincipal();
		tela.setVisible(true);
	}
}

