package Exercicio4;

import java.util.Scanner;

public class MediaValidada {
	public static void main (String[] args) {
		double soma = 0 , media =0 , numero ;
		int i = 1 ;
		Scanner leitor = new Scanner(System.in) ;
		String entrada = " " ;
		boolean continuar = true ;
		
		while (continuar){
			System.out.println("Informe os numeros na sequencia solicitada");
			System.out.println("Para sair digite 'S'");
			System.out.printf("Numero %d : " , i);
			
			entrada = leitor.nextLine();
			
			if (entrada.equalsIgnoreCase("s")) {
				continuar = false ;
			} else {
				try {
					numero = Double.parseDouble(entrada);
					soma += numero ;
					i ++ ;
				} catch (NumberFormatException e) {
					System.out.printf("Erro na entrada %s não é um numero valido \n" , entrada);
				}
			}
		}
	
		if (i == 1) { // Verifica se o contador não subiu
			System.out.println("Nenhum numero valido foi digitado.");
		} else {
			media = soma / (i - 1) ;
			System.out.printf("A soma dos numeros digitados é = %.2f \n" , soma);
			System.out.printf("A media dos numeros digitados é = %.2f \n" , media);
		}
		leitor.close();
	}
	

}
