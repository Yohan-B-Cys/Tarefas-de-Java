package Exercicio3;

public class Retangulo extends Forma implements Superficie {
	private double base , altura ;

	public Retangulo(String nome, double base, double altura) {
		super(nome);
		
		if (base < 0 || altura < 0) {
			throw new IllegalArgumentException(" Base e Altura não podem ser negativas !");
		}
		
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
