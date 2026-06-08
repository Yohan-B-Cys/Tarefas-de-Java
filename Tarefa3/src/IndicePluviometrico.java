import java.util.Scanner;

public class IndicePluviometrico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] chuva = new double[7];
        double soma = 0, max = Double.MIN_VALUE, min = Double.MAX_VALUE;
        int diaMax = 0, diaMin = 0;
        
        for (int i = 0; i < 7; i++) {
            System.out.print("Digite o índice pluviométrico do dia " + (i + 1) + ": ");
            chuva[i] = sc.nextDouble();
            soma += chuva[i];
            
            if (chuva[i] > max) { 
                max = chuva[i]; 
                diaMax = i + 1; 
            }
            if (chuva[i] < min) { 
                min = chuva[i]; 
                diaMin = i + 1; 
            }
        }
        
        System.out.printf("\nMédia da semana: %.2f\n", soma / 7);
        System.out.println("Índice Máximo: " + max + " (ocorrido no dia " + diaMax + ")");
        System.out.println("Índice Mínimo: " + min + " (ocorrido no dia " + diaMin + ")");
        sc.close();
    }
}