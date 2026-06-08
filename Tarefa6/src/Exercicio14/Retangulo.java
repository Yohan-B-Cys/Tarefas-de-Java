package Exercicio14;

public class Retangulo extends Forma implements Superficie {
	private double base , altura ;

	public Retangulo(String nome, double base, double altura) {
		super(nome);
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double area() {
		return base * altura ;
	}

	@Override
	public double getArea() {
		return area();
	}
	
	
}
