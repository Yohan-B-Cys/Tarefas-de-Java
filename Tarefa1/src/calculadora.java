
import java.util.Scanner;

public class calculadora {
// eu fiz metade do codigo usando scanner dai que eu vi que era argumento dai eu fiz os dois :)
  public static void main(String[] args){ 
     double resultado = 0, n1,n2; 
     char operacao ;

     if (args.length >=3) {
        n1 = Double.parseDouble(args[0]);
        n2 = Double.parseDouble(args[1]);
        operacao = args[2].charAt(0);

        
     } else {
    Scanner leitor = new Scanner(System.in);

    System.out.print("Digite o primeiro numero =>") ;
     n1 = leitor.nextDouble();
    System.out.print("\nDigite o segundo numero =>") ;
     n2 = leitor.nextDouble();

    System.out.print("\nDigite a operação =>");
    operacao = leitor.next().charAt(0);

   

    leitor.close();
     }
    switch (operacao) {
        case '+':
            resultado = n1 + n2 ;
           
            
            break;
        case '-':
            resultado = n1 - n2 ;
            break;

        case '/':
            if (n2 == 0) {
                System.out.println("Não pode divisão por zero !");
                return ;
            }
            resultado = n1 / n2 ;
            break;

        case 'X':
            resultado = n1 * n2 ;
            break;    
        default:
            System.out.println("Operador Invalido!");
            return;
    }

     System.out.printf(" %.2f \n" , resultado);

  }
}
