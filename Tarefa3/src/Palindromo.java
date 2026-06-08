import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite a frase (sem acentuação): ");
        String frase = sc.nextLine();
        
        // Expressão regular (Regex) para remover espaços e pontuações, e converte para minúsculo
        String fraseLimpa = frase.replaceAll("[^a-zA-Z]", "").toLowerCase();
        
        // StringBuilder tem a função pronta para inverter a String
        String fraseInvertida = new StringBuilder(fraseLimpa).reverse().toString();
        
        if (fraseLimpa.equals(fraseInvertida)) {
            System.out.println("A frase é um palíndromo!");
        } else {
            System.out.println("A frase NÃO é um palíndromo.");
        }
        
        sc.close();
    }
}