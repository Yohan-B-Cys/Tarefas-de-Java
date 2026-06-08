import java.util.Scanner;

public class SomaPar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int soma = 0;
        int lidos = 0;
        
        while (lidos < 20) {
            System.out.print("Digite o " + (lidos + 1) + "º número inteiro: ");
            try {
                int num = Integer.parseInt(sc.nextLine());
                if (num % 2 == 0) {
                    soma += num;
                }
                lidos++;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número numérico válido.");
            }
        }
        
        System.out.println("Soma total dos números pares: " + soma);
        sc.close();
    }
}