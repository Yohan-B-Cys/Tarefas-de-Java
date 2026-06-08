
import java.util.Scanner;
public class CalculaBonus {
    public static void main(String[] args){

        int opcao, departamentos, pessoas  ;
        double salario,bonus;

        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o numero referente ao seu cargo");
        System.out.println("1- Diretor");
        System.out.println("2- Gerente");
        System.out.println("3- Analista");
        System.out.println("4- Programador");
        System.out.println("5- Auxiliar de Limpeza");

        opcao = leitor.nextInt();

        System.out.print("Digite o seu salario atual =>");
        salario = leitor.nextDouble();
        
        switch (opcao) {
            case 1:
                System.out.print("Digite o numero de departamentos gerenciados =>");
                departamentos = leitor.nextInt();
                bonus = (4*salario) + (3000*departamentos) ;
                
                break;
            case 2:
                System.out.print("Digite o numero de pessoas gerenciadas=>");
                pessoas = leitor.nextInt();
                bonus = (2*salario) + (100*pessoas) ;
                break;
            
            case 3:
                bonus = salario ;
                break;    
            
            case 4:
                bonus = salario*0.8 ;
                break;    

            case 5:
                bonus = salario*0.5 ;
                break;        
            default:
                System.err.println("Opção Invalida!");
                return;
        }

        System.out.printf("O valor do seu bonus equivale a R$%.2f",bonus );
    }

}
