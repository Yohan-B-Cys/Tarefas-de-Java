package Exercicio3;

public class Triangulo extends Forma implements Superficie {
	private double base , altura ;

	

	
	public Triangulo(String nome, double base, double altura) {
		super(nome);
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double area() {	
		return (base * altura) /2;
	}

	@Override
	public double getArea() {
		return area();
	}
	
	
}
