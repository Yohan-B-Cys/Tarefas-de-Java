package Exercicio11;

public class TestaSuperficie {
	public static void main(String[] args) {
		
		Superficie s ;
		
		s = new Quadrado("Quadrado Alfredo", 2.5);
		System.out.println("Área do quadrado por interface : " + s.area());
		
		
		s = new Circunferencia("Pizza", 20);
		System.out.println("Area da circunferencia por interface : " + s.area());
	}
}
