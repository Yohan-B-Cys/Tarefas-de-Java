package Exercico4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaCancelarMatricula extends JFrame {


	
	JButton salvar ;
	
	public TelaCancelarMatricula() {
		setTitle("CANCELAR MATRICULAR");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(700,300);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JComboBox<String> alunos = new JComboBox<String>(SistemaAcademico.getInstancia().nomeDosAluno());
		JComboBox<String> disciplinas = new JComboBox<String>(SistemaAcademico.getInstancia().nomeDasDisciplinas());
		salvar = new JButton("SALVAR");
		
		salvar.setHorizontalAlignment(SwingConstants.CENTER);
		salvar.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		JPanel painel = new JPanel(new GridLayout(2,2,5,5));
		painel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		

		painel.add(new JLabel("Nome do aluno :"));
		painel.add(alunos);
		painel.add(new JLabel("Disciplina para cancelar Matricula :"));
		painel.add(disciplinas);
		
		
		add(painel, BorderLayout.NORTH);
		add(salvar, BorderLayout.SOUTH);
		
		salvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String nomeAluno = (String) alunos.getSelectedItem();
					Aluno alunoMatricula = SistemaAcademico.getInstancia().buscarAlunoPorNome(nomeAluno);
					if (alunoMatricula == null) {
						throw new IllegalArgumentException("Erro: Aluno não foi encotrado: " + nomeAluno);
					}
					String nomeDisciplina = (String) disciplinas.getSelectedItem();
					Disciplina disciplinaMatricula = SistemaAcademico.getInstancia().buscarDisciplinaPorNome(nomeDisciplina);
					if (disciplinaMatricula == null) {
						throw new IllegalArgumentException("Erro: Disciplina não foi encotrada: " + nomeDisciplina);
					}
					
					SistemaAcademico.getInstancia().cancelarMatricula(alunoMatricula, disciplinaMatricula);
					JOptionPane.showMessageDialog(null, " Matricula cancelada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					
				} catch (IllegalArgumentException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Aviso de Validação", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
	}
}
