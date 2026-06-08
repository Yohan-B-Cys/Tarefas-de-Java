package Execicio3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ConversorGalãoLitroGUI extends JFrame {
	private JLabel resultado ;
	private JTextField entrada ;
	private JButton botaoConversor;
	
	public ConversorGalãoLitroGUI() {
		setTitle("Conversor Litro para Galão  ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,200);
		setResizable(false);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		resultado = new JLabel("Resultado da Conversão : ");
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		entrada = new JTextField();
		botaoConversor = new JButton("Converter");
		JPanel painelTopo = new JPanel(new GridLayout(3,1,5,5));
		painelTopo.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		painelTopo.add(new JLabel("INFORME EM LITROS PARA A CONVERSÂO  : "));
		painelTopo.add(entrada);
		painelTopo.add(botaoConversor);
		add(painelTopo,BorderLayout.NORTH);
		add(resultado, BorderLayout.SOUTH);
		
		botaoConversor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String texto = entrada.getText();
					double numero = Double.parseDouble(texto);
					double galao = numero / 3.785;
					String resultadoFormatado = String.format("Resultado da Conversão: %.2f Litros equivale a %.2f Galões " , numero , galao);
					resultado.setText(resultadoFormatado);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Erro: Por favor, insere apenas números válidos!", "Entrada Inválida", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
	}
	
	public static void main(String[] args) {
	ConversorGalãoLitroGUI tela = new ConversorGalãoLitroGUI() ;
	tela.setVisible(true);
	}	
}
