package Exercicio14;

public class Circunferencia extends Forma implements Superficie {
	private double raio;

	public Circunferencia(String nome, double raio) {
		super(nome);
		this.raio = raio;
	}
	
	@Override
	public double getArea() {
		return area();
	}

	@Override
	public double area() {
		return Math.PI * Math.pow(raio, 2);
		
	}
}
