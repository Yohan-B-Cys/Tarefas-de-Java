import java.util.Scanner;

public class Determinante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] m = new double[3][3];
        
        System.out.println("Preencha a matriz 3x3:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("Elemento [%d][%d]: ", i, j);
                m[i][j] = sc.nextDouble();
            }
        }
        
        // Aplicação direta da Regra de Sarrus
        double det = (m[0][0] * m[1][1] * m[2][2] + m[0][1] * m[1][2] * m[2][0] + m[0][2] * m[1][0] * m[2][1])
                   - (m[0][2] * m[1][1] * m[2][0] + m[0][0] * m[1][2] * m[2][1] + m[0][1] * m[1][0] * m[2][2]);
                   
        System.out.printf("\nO determinante da matriz é: %.2f\n " , det);
        sc.close();
    }
}