
import java.util.Scanner;
public class Fibonacci {
    public static void main(String[] args){
        int num ,  fn=0, f1=0, f2=1;
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite um numero inteiro positivo =>");
        num = leitor.nextInt();
        leitor.close();

        if (num < 0) {
            System.err.println("Numero negativo não pode!");
        } else {

            System.err.print(f1);
             while (fn <= num) {
                System.out.print(", "+f2);
                fn = f1 + f2;
                f1 = f2 ;
                f2 = fn ;
                
                
            }

        }

    }

}
