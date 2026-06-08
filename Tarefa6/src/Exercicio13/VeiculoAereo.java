package Exercicio13;

public abstract class VeiculoAereo extends Veiculo {
	private double altitudeMax , autonomiaVoo ;
	private boolean voando = false ;
	public VeiculoAereo(String nome, String marca, int qtdPassageiros, double altitudeMax, double autonomiaVoo) {
		super(nome, marca, qtdPassageiros);
		this.altitudeMax = altitudeMax;
		this.autonomiaVoo = autonomiaVoo;
	}
	@Override
	public abstract void andar() ;
	public double getAltitudeMax() {
		return altitudeMax;
	}
	public void setAltitudeMax(double altitudeMax) {
		this.altitudeMax = altitudeMax;
	}
	public double getAutonomiaVoo() {
		return autonomiaVoo;
	}
	public void setAutonomiaVoo(double autonomiaVoo) {
		this.autonomiaVoo = autonomiaVoo;
	}
	
	
	
	
}
