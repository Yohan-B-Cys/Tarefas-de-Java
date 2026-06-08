package Exercicio14;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class SomadorDeArea {
	private List<Forma> formas = new ArrayList <Forma>();
	
	public  boolean InserirForma(Scanner leitor) {
		int tipo = 0 ;
		String nome ;
		double lado , raio , altura , base ;
		System.out.println("Digite o numero correspondende a formula que queira adicionar 0 para sair");
		System.out.println("1 - Quadrado | 2 - Circufenrencia | 3 - Retangulo | 4 - Triangulo ");
		tipo = leitor.nextInt();leitor.nextLine();
		
		if (tipo == 0) {
			return false ;
		}
		
		if (tipo == 1) {
			System.out.print("Nome do Quadrado : " ); nome = leitor.nextLine();
			System.out.print("Valor do lado do Quadrado : " ); lado = leitor.nextDouble();leitor.nextLine();
			Quadrado novoQuadrado = new Quadrado(nome, lado);
			formas.add(novoQuadrado);
		}
		else if (tipo == 2) {
			System.out.print("Nome da Circunferencia : " ); nome = leitor.nextLine();
			System.out.print("Valor do raio da Circunferencia : " ); raio = leitor.nextDouble();leitor.nextLine();
			Circunferencia novaCircunferencia = new Circunferencia(nome, raio);
			formas.add(novaCircunferencia);
		}
		else if (tipo == 3) {
			System.out.print("Nome do Retangulo : " ); nome = leitor.nextLine();
			System.out.print("Valor da base do Retangulo : " ); base = leitor.nextDouble();leitor.nextLine();
			System.out.print("Valor da altura do Retangulo : " ); altura = leitor.nextDouble();leitor.nextLine();
			Retangulo novoRetangulo = new Retangulo(nome, base, altura);
			formas.add(novoRetangulo);
		}
		else if (tipo == 4) {
			System.out.print("Nome do Triangulo : " ); nome = leitor.nextLine();
			System.out.print("Valor da base do Triangulo : " ); base = leitor.nextDouble();leitor.nextLine();
			System.out.print("Valor da altura do Triangulo : " ); altura = leitor.nextDouble();leitor.nextLine();
			Triangulo novoTriangulo = new Triangulo(nome, base, altura);
			formas.add(novoTriangulo);
		}
		
		return true ;
	}
	
	public double somarAreas() {
		double somatorio = 0 ;
		for (Forma forma : formas) {
			somatorio += forma.getArea();
		}
		return somatorio;
		
	}
	
	
	
}
