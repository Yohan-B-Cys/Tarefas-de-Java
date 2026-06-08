package Exercicio13;

public class Carro extends VeiculoTerrestre {
	private String placa , tipoCarroceria ;
	private int qtdPortas , qtdMarchas , marcha = 0 ;
	private double velocidade ;
	private boolean automatico ;
	
	

	public Carro(String nome, String marca, int qtdPassageiros, double quilometragem, int qtdRodas,
			String tipoCombustivel, String placa, String tipoCarroceria, int qtdPortas, int qtdMarchas, int marcha,
			boolean automatico) {
		super(nome, marca, qtdPassageiros, quilometragem, qtdRodas, tipoCombustivel);
		this.placa = placa;
		this.tipoCarroceria = tipoCarroceria;
		this.qtdPortas = qtdPortas;
		this.qtdMarchas = qtdMarchas;
		this.marcha = marcha;
		this.automatico = automatico;
	}



	@Override
	public void andar() {
		System.out.println("\n--- INICIANDO TRAJETO: " + getNome() + " ---");
	    
	    // Simula a saída
	    mudarMarcha(1);
	    acelerar(10, 1.5);
	    System.out.printf("Engatando 1ª... Velocidade: %.2f km/h\n", velocidade);
	    
	    if(!automatico) {
	        mudarMarcha(2);
	        acelerar(20, 1.2);
	        System.out.printf("Passando para a 2ª... Velocidade: %.2f km/h\n", velocidade);
	    }

	    System.out.println("Status: O carro de placa " + placa + " está em movimento constante.");
		
	}



	public String getPlaca() {
		return placa;
	}



	public void setPlaca(String placa) {
		this.placa = placa;
	}



	public String getTipoCarroceria() {
		return tipoCarroceria;
	}



	public void setTipoCarroceria(String tipoCarroceria) {
		this.tipoCarroceria = tipoCarroceria;
	}



	public int getQtdPortas() {
		return qtdPortas;
	}



	public void setQtdPortas(int qtdPortas) {
		this.qtdPortas = qtdPortas;
	}



	public int getQtdMarchas() {
		return qtdMarchas;
	}



	public void setQtdMarchas(int qtdMarchas) {
		this.qtdMarchas = qtdMarchas;
	}



	public boolean isAutomatico() {
		return automatico;
	}



	public void setAutomatico(boolean automatico) {
		this.automatico = automatico;
	}
	
	public void mudarMarcha ( int novoValor) {
		marcha = novoValor;
	}
	
	public void acelerar ( int acelerada , double forca) {
			velocidade += (acelerada * forca * marcha);
	}
	
	public void frear( double forca) {
		velocidade = velocidade - forca * velocidade ;
	}
	
	
}
