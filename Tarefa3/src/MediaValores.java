import java.util.Scanner;

public class MediaValores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double soma = 0;
        int cont = 0;
        
        while (true) {
            System.out.print("Digite um valor numérico (ou 'S' para sair): ");
            String entrada = sc.nextLine();
            
            if (entrada.equalsIgnoreCase("S")) {
                break;
            }
            
            try {
                double valor = Double.parseDouble(entrada);
                soma += valor;
                cont++;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Por favor, digite novamente.");
            }
        }
        
        if (cont > 0) {
            System.out.printf("Média dos valores: %.2f\n", soma / cont);
        } else {
            System.out.println("Nenhum valor válido foi inserido.");
        }
        sc.close();
    }
}