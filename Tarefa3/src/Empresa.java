import java.util.Scanner;

public class Empresa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Quantos funcionários existem na empresa? ");
        int n = Integer.parseInt(sc.nextLine());
        
        String[] nomes = new String[n];
        double[] salarios = new double[n];
        double somaSalarios = 0;
        
        for (int i = 0; i < n; i++) {
            String nome = "";
            while (nome.length() < 3) {
                System.out.print("Nome do funcionário " + (i + 1) + " (mínimo 3 letras): ");
                nome = sc.nextLine();
            }
            nomes[i] = nome;
            
            boolean salarioValido = false;
            while (!salarioValido) {
                System.out.print("Salário de " + nome + ": ");
                try {
                    salarios[i] = Double.parseDouble(sc.nextLine());
                    somaSalarios += salarios[i];
                    salarioValido = true;
                } catch (NumberFormatException e) {
                    System.out.println("Salário inválido. Digite novamente usando ponto para decimais.");
                }
            }
        }
        
        double media = somaSalarios / n;
        System.out.printf("\nMédia salarial da empresa: R$ %.2f\n", media);
        System.out.println("Funcionários acima da média:");
        
        for (int i = 0; i < n; i++) {
            if (salarios[i] > media) {
                System.out.printf("%s - R$ %.2f\n", nomes[i], salarios[i]);
            }
        }
        sc.close();
    }
}