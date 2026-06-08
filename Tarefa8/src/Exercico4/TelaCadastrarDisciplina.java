package Exercico4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaCadastrarDisciplina extends JFrame {

	JTextField nome ;
	JTextField professor ;
	JTextField qtdAlunos;
	JButton salvar ;
	
	public TelaCadastrarDisciplina() {
		setTitle("CADASTRO DE DISCIPLINA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(700,300);
		setResizable(false);
		setLocationRelativeTo(null);
		
		nome = new JTextField();
		professor = new JTextField();
		qtdAlunos = new JTextField();
		JComboBox<String> profs = new JComboBox<String>(SistemaAcademico.getInstancia().nomeDosProf());
		salvar = new JButton("SALVAR");
		
		salvar.setHorizontalAlignment(SwingConstants.CENTER);
		salvar.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		JPanel painel = new JPanel(new GridLayout(3,3,5,5));
		painel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		

		painel.add(new JLabel("Nome :"));
		painel.add(nome);
		painel.add(new Label(" Professor :"));
		painel.add(profs);
		painel.add(new JLabel("Quantidade de Alunos :"));
		painel.add(qtdAlunos);
		
		add(painel, BorderLayout.NORTH);
		add(salvar, BorderLayout.SOUTH);
		
		salvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String nomeDigitao = nome.getText();
					String profesorDigitado = (String) profs.getSelectedItem();
					String qtdAlunoDigitada = qtdAlunos.getText();
					int qtdAlunos = Integer.parseInt(qtdAlunoDigitada);
					if ( qtdAlunos < 1) {
						throw new IllegalArgumentException("Não se pode criar uma Disciplina sem alunos");
					}
					Professor profDisciplina = SistemaAcademico.getInstancia().buscarProfessorPorNome(profesorDigitado);
					
					if (profDisciplina == null) {
						throw new IllegalArgumentException("Erro: Professor/a não foi encotrado: " + profesorDigitado);
					}
					Disciplina novaDisciplina = new Disciplina(nomeDigitao, profDisciplina, qtdAlunos);
					SistemaAcademico.getInstancia().cadastrarDisciplina(novaDisciplina);
					JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Erro: Por favor, insere apenas valores válidos!", "Entrada Inválida", JOptionPane.ERROR_MESSAGE);
				} catch (IllegalArgumentException e3) {
					JOptionPane.showMessageDialog(null,  e3.getMessage(), "Aviso validação ", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		KeyAdapter garanteNumero = new KeyAdapter() {

			@Override 
			public void keyTyped(KeyEvent e) {
				char caractere = e.getKeyChar();

				if (!Character.isDigit(caractere)) {
					e.consume();
				}
			}
		};
		
		qtdAlunos.addKeyListener(garanteNumero);
	}
}
