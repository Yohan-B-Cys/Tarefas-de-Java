package Exercicio3;

public abstract class Forma {
	private String nome ;
	
	public Forma(String nome) {
		this.nome = nome ;
	}
	
	public abstract double getArea();
	
	public String getNome() {
		return nome;
	}
}
