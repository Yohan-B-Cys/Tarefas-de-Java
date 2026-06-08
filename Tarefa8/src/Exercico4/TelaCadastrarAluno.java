package Exercico4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaCadastrarAluno extends JFrame {
	JTextField nome ;
	JTextField endereco ;
	JTextField idade ;
	JTextField matricula ;
	JTextField curso ;
	JTextField periodo ;
	JTextField qtdDisciplinas ;
	JButton salvar ;
	
	public TelaCadastrarAluno() {
		setTitle("CADASTRO DE ALUNO ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(700,300);
		setResizable(false);
		setLocationRelativeTo(null);
		
		nome = new JTextField();
		idade = new JTextField();
		endereco = new JTextField() ;
		matricula = new JTextField();
		curso = new JTextField();
		periodo = new JTextField();
		qtdDisciplinas = new JTextField();
		salvar = new JButton("SALVAR");
		
		salvar.setHorizontalAlignment(SwingConstants.CENTER);
		salvar.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		JPanel painel = new JPanel(new GridLayout(7,7,5,5));
		painel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		painel.add(new JLabel("Nome :"));
		painel.add(nome);
		painel.add(new JLabel("Idade :"));
		painel.add(idade);
		painel.add(new JLabel("Endereço :"));
		painel.add(endereco);
		painel.add(new JLabel("Matricula :"));
		painel.add(matricula);
		painel.add(new JLabel("Curso :"));
		painel.add(curso);
		painel.add(new JLabel("Periodo :"));
		painel.add(periodo);
		painel.add(new JLabel("Quantidade de Disciplinas :"));
		painel.add(qtdDisciplinas);
		
		add(painel, BorderLayout.NORTH);
		add(salvar, BorderLayout.SOUTH);
		
		salvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			try {
				String nomeDigitao = nome.getText();
				String idadeDigitada = idade.getText();
				int idade = Integer.parseInt(idadeDigitada);
				String enderecoDigitado = endereco.getText();
				String matriculaDigitada = matricula.getText();
				String cursoDigitado = curso.getText();
				String periodoDigitado = periodo.getText();
				int periodo = Integer.parseInt(periodoDigitado);
				String qtdDiscDigitado = qtdDisciplinas.getText();
				int qtdDisciplina = Integer.parseInt(qtdDiscDigitado);
				if (idade < 0 || periodo < 1 || qtdDisciplina < 1) {
					throw new IllegalArgumentException("Idade não pode ser negativa , periodo e qtdDisciplina nao podem ser menor que 1");
				}
				
				Aluno novoAluno = new Aluno(nomeDigitao, enderecoDigitado, idade, matriculaDigitada, cursoDigitado, periodo, qtdDisciplina);
				SistemaAcademico.getInstancia().cadastrarAluno(novoAluno);
				JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				dispose();
				
			
			} catch ( NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "Erro: Por favor, insere apenas números válidos!", "Entrada Inválida", JOptionPane.ERROR_MESSAGE);
			}catch (IllegalArgumentException e3) {
				JOptionPane.showMessageDialog(null,  e3.getMessage(), "Valor Inválido idade , periodo ou quantidade de Disciplinas nao pode ser negativo", JOptionPane.WARNING_MESSAGE);
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
		idade.addKeyListener(garanteNumero);
		periodo.addKeyListener(garanteNumero);
		qtdDisciplinas.addKeyListener(garanteNumero);
	}
	
	
}
