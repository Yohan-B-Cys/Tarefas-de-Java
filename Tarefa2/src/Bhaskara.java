
import java.util.Scanner;
public class Bhaskara {
    public static void main(String[] args){
        double A , B , C , delta, x1, x2;
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o valor de A (x^2) =>");
        A = leitor.nextDouble();

        System.out.print("Digite o valor de B (x) =>");
        B = leitor.nextDouble();

        System.out.print("Digite o valor de C (int) =>");
        C = leitor.nextDouble();
        leitor.close();

        delta = Math.pow(B, 2) - 4*A*C ;

        x1= (-B - Math.sqrt(delta))/(2*A);

        x2= (-B + Math.sqrt(delta))/(2*A);

        System.out.printf("O valor de X1 é %.2f " ,x1);
        System.out.printf("O valor de X2 é %.2f " ,x2);
    }

}
