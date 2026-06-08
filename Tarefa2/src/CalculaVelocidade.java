

import java.util.Scanner;

public class CalculaVelocidade {

    public static void main (String[] arg) {
    double distancia , tempo , velocidade ;

    Scanner leitor = new Scanner(System.in);

    System.out.print("Digite a distancia =>");
    distancia = leitor.nextDouble();
   
    System.out.print("Digite o tempo =>");
    tempo = leitor.nextDouble();

    leitor.close();

    if (tempo == 0) {
        System.err.println("Valor de tempo invalido !");
        
    } else {

    velocidade = distancia / tempo ;

    System.out.printf(" A velocidade média é %.2f km/h " ,velocidade);
    }


    }
}
