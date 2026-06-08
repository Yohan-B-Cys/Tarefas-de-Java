import java.util.Scanner;
public class DesvioPadrao {
	
	public static void main(String[] args) {
		int tamanho ;
		double media, soma = 0, somaVariancia = 0 , desvioPadrao  ;
		Scanner leitor = new Scanner(System.in) ;
		
		System.out.print("Digite o numero de amostras =>");
		tamanho = leitor.nextInt();
		if (tamanho <= 1) {
		    System.err.println("São necessárias pelo menos 2 amostras para o cálculo.");
		    leitor.close();
		    return; // Encerra o programa
		}
		
		double[] amostras = new double [tamanho];
		
		for(int i = 0 ; i < tamanho; i++) {
			System.out.printf("Digite o Valor da amostra %d =>", i+1);
			while (!leitor.hasNextDouble()) {
				System.out.print("O numero precisa ser decimal digite novamente =>");
				leitor.next();
			}
			amostras[i] = leitor.nextDouble();
			soma += amostras[i];
			
		}
		leitor.close();
		media = soma / tamanho ;
		
		for (int i = 0 ; i < tamanho ; i++) {
			somaVariancia += Math.pow(amostras[i]-media, 2);
		}
		
		desvioPadrao = Math.sqrt((somaVariancia / (tamanho - 1)));
		
		System.out.printf("O desvio padrão das amostras é %.2f",desvioPadrao);
	}
}
