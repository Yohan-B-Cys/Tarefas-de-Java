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
		setSize(800,600);
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

		// Muda o Layout para uma grade de 10 linhas e 1 coluna (com 5 pixels de espaço)
		JPanel painelTopo = new JPanel(new GridLayout(10, 1, 5, 5));
		painelTopo.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		JLabel label = new JLabel("SISTEMA ACADEMICO ESCOLHA A OPÇAO DESEJADA:");
		painelTopo.add(label);
		painelTopo.add(op1);
		painelTopo.add(op2);
		painelTopo.add(op3);
		painelTopo.add(op4);
		painelTopo.add(op5);
		painelTopo.add(op6);
		painelTopo.add(op7);
		painelTopo.add(op8);
		painelTopo.add(op9);
		
		getContentPane().add(painelTopo);
		
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
		        TelaExcluirAluno telaExcluir = new TelaExcluirAluno();
		        telaExcluir.setVisible(true);
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

