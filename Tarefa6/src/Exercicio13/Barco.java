package Exercicio13;

public class Barco extends VeiculoAquatico {
	private double comprimento ;
	private int numMotores ;
	private boolean temCabine ;
	public Barco(String nome, String marca, int qtdPassageiros, double calado, double deslocamento, String tipoAgua,
			double comprimento, int numMotores, boolean temCabine) {
		super(nome, marca, qtdPassageiros, calado, deslocamento, tipoAgua);
		this.comprimento = comprimento;
		this.numMotores = numMotores;
		this.temCabine = temCabine;
	}
	@Override
	public void andar() {
	    System.out.println("\n[SISTEMA DE NAVEGAÇÃO - " + getNome() + "]");
	    
	    if (this.isAncorado()) {
	        System.out.println("Levantando âncora... Aguarde.");
	        this.setAncorado(false); 
	    }

	    System.out.println("Ligando motores: " + numMotores + " unidade(s) ativa(s).");
	    System.out.printf("Navegando em %s a uma profundidade de %.2f metros (Calado).\n", 
	                      getTipoAgua(), getCalado());
	    System.out.println("Status: Estabilizado em 25 nós.");
	}
	public double getComprimento() {
		return comprimento;
	}
	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}
	public int getNumMotores() {
		return numMotores;
	}
	public void setNumMotores(int numMotores) {
		this.numMotores = numMotores;
	}
	public boolean isTemCabine() {
		return temCabine;
	}
	public void setTemCabine(boolean temCabine) {
		this.temCabine = temCabine;
	}
	
	
}
