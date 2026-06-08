package Exercicio13;

public abstract class VeiculoTerrestre extends Veiculo {
	private double quilometragem ;
	private int qtdRodas  ;
	private String tipoCombustivel ;
	

	public VeiculoTerrestre(String nome, String marca, int qtdPassageiros, double quilometragem, int qtdRodas,
			String tipoCombustivel) {
		super(nome, marca, qtdPassageiros);
		this.quilometragem = quilometragem;
		this.qtdRodas = qtdRodas;
		this.tipoCombustivel = tipoCombustivel;
	}



	public double getQuilometragem() {
		return quilometragem;
	}



	public void setQuilometragem(double quilometragem) {
		this.quilometragem = quilometragem;
	}



	public int getQtdRodas() {
		return qtdRodas;
	}



	public void setQtdRodas(int qtdRodas) {
		this.qtdRodas = qtdRodas;
	}


	public String getTipoCombustivel() {
		return tipoCombustivel;
	}



	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}



	@Override
	public abstract void andar();

}
