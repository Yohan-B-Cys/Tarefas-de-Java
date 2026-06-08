package Exercicio13;

public class Aviao extends VeiculoAereo {
	private double envergadura , altura;
	private int qtdTurbinas;
	private String categoria ;
	private boolean tremPousoRecolhido ;
	public Aviao(String nome, String marca, int qtdPassageiros, double altitudeMax, double autonomiaVoo,
			double envergadura, int qtdTurbinas, String categoria) {
		super(nome, marca, qtdPassageiros, altitudeMax, autonomiaVoo);
		this.envergadura = envergadura;
		this.qtdTurbinas = qtdTurbinas;
		this.categoria = categoria;
	}
	@Override
	public void andar() {
		System.out.println("=== DECOLAGEM AUTORIZADA: " + getNome() + " ===");
	    subir(); // Chama o método de subir
	    System.out.println("Avião em cruzeiro. Categoria: " + categoria);
		
	}
	public double getEnvergadura() {
		return envergadura;
	}
	public void setEnvergadura(double envergadura) {
		this.envergadura = envergadura;
	}
	public int getQtdTurbinas() {
		return qtdTurbinas;
	}
	public void setQtdTurbinas(int qtdTurbinas) {
		this.qtdTurbinas = qtdTurbinas;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public boolean isTremPousoRecolhido() {
		return tremPousoRecolhido;
	}
	public void setTremPousoRecolhido(boolean tremPouseRecolhido) {
		this.tremPousoRecolhido = tremPouseRecolhido;
	}
	
	public void RecolherTremPouso () {
		tremPousoRecolhido = true ;
	}
	
	public void subir () {
		System.out.println("Iniciando subida...");
	    // Sobe de 5000 em 5000 até o máximo
	    for (int i = 0; i <= getAltitudeMax(); i += 5000) {
	        System.out.println("Altitude atual: " + i + " pés.");
	        
	        // No meio do caminho, recolhe o trem de pouso automaticamente
	        if (i >= 2000 && !tremPousoRecolhido) {
	            RecolherTremPouso();
	            System.out.println("-> Trem de pouso recolhido.");
	        }
	    }
	}
}
