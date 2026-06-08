package Exercicio13;

public abstract class Veiculo {
	private String nome ,marca ;
	private int qtdPassageiros;
	
	
	
	

	public Veiculo(String nome, String marca, int qtdPassageiros) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.qtdPassageiros = qtdPassageiros;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getQtdPassageiros() {
		return qtdPassageiros;
	}

	public void setQtdPassageiros(int qtdPassageiros) {
		this.qtdPassageiros = qtdPassageiros;
	}

	public abstract void andar();
	
	
}
