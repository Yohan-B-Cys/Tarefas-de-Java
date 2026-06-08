
import java.util.Scanner;
public class DistanciaPontos {
    public static void main (String[] args){
        double[] pontoA = new double[2] , pontoB = new double[2];
        double distancia ,distanciaX,distanciaY ;
         Scanner leitor = new Scanner(System.in);
        
         System.out.print("Digite o valor de X do ponto A =>");
         pontoA[0] = leitor.nextDouble();

         System.out.print("Digite o valor de Y do ponto A =>");
         pontoA[1] = leitor.nextDouble();

         System.out.print("Digite o valor de X do ponto B =>");
         pontoB[0] = leitor.nextDouble();

         System.out.print("Digite o valor de Y do ponto B =>");
         pontoB[1] = leitor.nextDouble();

         leitor.close();

         distanciaX = Math.pow(pontoA[0]-pontoB[0],2);
         distanciaY = Math.pow(pontoA[1]-pontoB[1],2);

         distancia = Math.sqrt(distanciaX + distanciaY);

         System.out.printf("A distancia dos pontos A e B é : %.2f",distancia);




    }

}
