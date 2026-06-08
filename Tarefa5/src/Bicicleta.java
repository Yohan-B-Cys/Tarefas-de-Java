/**
 *
 * @author rafae
 */
public class Bicicleta {
    private double velocidade = 0.0;
    private int marcha = 1, maxmarcha = 0;
    
    
    public double getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(double velocidade) {
		this.velocidade = velocidade;
	}
	public int getMarcha() {
		return marcha;
	}
	public void setMarcha(int marcha) {
		this.marcha = marcha;
	}
	public int getMaxmarcha() {
		return maxmarcha;
	}
	public void setMaxmarcha(int maxmarcha) {
		this.maxmarcha = maxmarcha;
	}
	
	public Bicicleta(int maxmarcha) {
		super();
		this.maxmarcha = maxmarcha;
		this.velocidade = 0 ;
	}
	
	public Bicicleta() {
		super();
		this.maxmarcha = 18 ;
		this.velocidade = 0 ;
	}
	public void mudarMarcha(int novoValor){
       if (novoValor > maxmarcha || novoValor < 1) {
		System.out.println("essa marcha não existe !");
		return ;
	}
		marcha = novoValor;
    }
    public void pedalar(int pedalada, double forca){
        velocidade = velocidade + pedalada*forca;
    }
    public void frear(double forca){
        velocidade = velocidade - forca*velocidade;
    }
    public void imprimeEstado(){
        
        System.out.println(
            " velocidade="+velocidade+"\n"+
            " marcha="+marcha);
    }
}