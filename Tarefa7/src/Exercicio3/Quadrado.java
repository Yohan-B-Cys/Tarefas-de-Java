package Exercicio3;

public class Quadrado extends Forma implements Superficie {
	private double lado ;
	
	public Quadrado(String nome , double lado) {
		super(nome);
		this.lado = lado;
		
	}

	@Override
	public double getArea() {
		return area();
	}

	@Override
	public double area() {
		return  lado * lado;
	}

}
