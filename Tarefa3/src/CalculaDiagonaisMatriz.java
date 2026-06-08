
import java.util.Scanner;
public class CalculaDiagonaisMatriz {
    

   public static void preencherMatriz (double[][] matriz, Scanner leitor){

    int tamanho = matriz.length ;
        for( int i =0 ; i < tamanho ; i++){
            for( int j = 0 ; j < tamanho ; j++) {
                System.out.printf("Digite o valor referente a posição [%d]x[%d] na matriz =>" ,i,j);
                matriz[i][j] = leitor.nextDouble();
            }
        }
    }


    public static void calculaDiagonal(double[][] matriz){
        int tamanho = matriz.length;
        double diagonalPrincipal = 0 , diagonalSecundaria = 0 ;

        for(int i = 0 ; i < tamanho ; i++){
            diagonalPrincipal += matriz[i][i];
            diagonalSecundaria += matriz[i][tamanho -1 -i];
        }
        System.out.printf("O valor da diagonal principal é %.2f \n" , diagonalPrincipal);
        System.out.printf("O valor da diagonal secundaria é %.2f \n" , diagonalSecundaria);
        System.out.printf("A soma das duas diagonais é %.2f \n" , diagonalPrincipal + diagonalSecundaria);
    }

    public static void main (String[] args){
    int tamanho = 0 ;

    Scanner leitor = new Scanner(System.in);

    System.out.print("Digite o tamanho da sua matriz =>");
    tamanho = leitor.nextInt();

    double[][] matriz = new double[tamanho][tamanho] ;

     preencherMatriz(matriz,leitor);

     calculaDiagonal(matriz);

     leitor.close();

    }

}
