package exercicio2;

public class MarchaInvalidaException extends Exception {
	 int marchaInvalida ;
	 
	 public MarchaInvalidaException (Object Bicicleta , int marchaInvalida) {
		 super("Bloqueio de Segurança: Marcha " + marchaInvalida + " não suportada pelo sistema.");
	        this.marchaInvalida = marchaInvalida;
	 }
	 
	 
	 public int getMarchaInvalida() {
		 return marchaInvalida;
	 }
}
