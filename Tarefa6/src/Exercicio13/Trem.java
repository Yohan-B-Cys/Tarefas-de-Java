package Exercicio13;

public class Trem extends VeiculoTerrestre {
	private int qtdVagoes ;
	private String registro , categoria  ;
	private double velocidade = 0 ;
	
	

	public Trem(String nome, String marca, int qtdPassageiros, double quilometragem, int qtdRodas,
			String tipoCombustivel, int qtdVagoes, String registro, String categoria) {
		super(nome, marca, qtdPassageiros, quilometragem, qtdRodas, tipoCombustivel);
		this.qtdVagoes = qtdVagoes;
		this.registro = registro;
		this.categoria = categoria;
	}

	@Override
	public void andar() {
		System.out.printf(" O trem %s está em repouso na estação \n" , getNome());
		acelerar(5 , 1.5);
		System.out.printf(" O trem %s sai da estação a %.2f km/h  \n" , getNome() , velocidade);
		acelerar(20 , 3);
		
		System.out.printf("O trem %s acelera e agora está a %.2f km/h \n" , getNome() , velocidade);
		
	}
	
	public void acelerar ( int acelerada , double forca) {
		velocidade += (acelerada * forca );
}

	public void frear( double forca) {
	velocidade = velocidade - forca * velocidade ;
}
	public int getQtdVagoes() {
		return qtdVagoes;
	}
	public void setQtdVagoes(int qtdVagoes) {
		this.qtdVagoes = qtdVagoes;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
}
