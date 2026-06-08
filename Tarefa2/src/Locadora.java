import java.util.Scanner;

/**
 * Representa a administração de alugueis de uma locadora de DVD,
 * calculando o faturamento a partir de alugueis e multas.
 * * @author Yohan Brancalhão Cys
 * @version 1.0
 */
public class Locadora {

    /**
     * Ponto de entrada do programa. Lê dados do usuário e exibe os resultados financeiros
     * formatados com duas casas decimais.
     * * @param arg Argumentos de linha de comando.
     */
    public static void main (String[] arg) {

        int quantidade; 
        double valor, faturamentoAnual, faturamentoMensal, faturamentoMulta; 
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite a quantidade de DVDs =>");
        quantidade = leitor.nextInt(); 

        System.out.print("Digite o valor mensal do aluguel =>");
        valor = leitor.nextDouble();
        leitor.close();

        double dvdsAlugadosMes = quantidade / 3.0;
        
        faturamentoMulta = (dvdsAlugadosMes / 10.0) * (valor * 0.1); 
        faturamentoMensal = (dvdsAlugadosMes * valor) + faturamentoMulta; 
        faturamentoAnual = faturamentoMensal * 12; 

        System.out.printf("O Faturamento anual é R$%.2f\n", faturamentoAnual);
        System.out.printf("O Faturamento mensal é R$%.2f\n", faturamentoMensal);
        System.out.printf("O Faturamento das multas por mes é R$%.2f\n", faturamentoMulta);
    }
}