package Exercicio13;

public abstract class VeiculoAquatico extends Veiculo {
	private double calado , deslocamento ;
	private String tipoAgua ;
	private boolean ancorado = true ;
	public VeiculoAquatico(String nome, String marca, int qtdPassageiros, double calado, double deslocamento,
			String tipoAgua) {
		super(nome, marca, qtdPassageiros);
		this.calado = calado;
		this.deslocamento = deslocamento;
		this.tipoAgua = tipoAgua;
	}
	@Override
	public abstract void andar() ;
	public double getCalado() {
		return calado;
	}
	public void setCalado(double calado) {
		this.calado = calado;
	}
	public double getDeslocamento() {
		return deslocamento;
	}
	public void setDeslocamento(double deslocamento) {
		this.deslocamento = deslocamento;
	}
	public String getTipoAgua() {
		return tipoAgua;
	}
	public void setTipoAgua(String tipoAgua) {
		this.tipoAgua = tipoAgua;
	}
	public boolean isAncorado() {
		return ancorado;
	}
	public void setAncorado(boolean ancorado) {
		this.ancorado = ancorado;
	}
	
	
	
	
}
