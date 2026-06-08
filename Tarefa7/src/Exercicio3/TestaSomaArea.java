package Exercicio3;

import java.util.Scanner;

public class TestaSomaArea {

	
	public static void main (String [] args) {
		double somaAreas = 0 ;
		SomadorDeArea somador = new SomadorDeArea();
		Scanner leitor = new Scanner (System.in);
		
		while(somador.InserirForma(leitor));
		
		somaAreas = somador.somarAreas();
		
		System.out.printf("O valor da soma de todas as areas de todas as formas do vetor é %.2f \n" , somaAreas );
		
	}
}
