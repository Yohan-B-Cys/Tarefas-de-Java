
public class Ponto3d {
	private double x,y,z,intensidade;
	private String Cor ;
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public double getIntensidade() {
		return intensidade;
	}
	public void setIntensidade(double intensidade) {
		this.intensidade = intensidade;
	}
	public String getCor() {
		return Cor;
	}
	public void setCor(String cor) {
		Cor = cor;
	}
	
	public double calculaDistancia(Ponto3d p) {
		double distancia;
		
		distancia = Math.sqrt(
				Math.pow(p.getX() - this.x , 2)+
				Math.pow(p.getY() - this.y , 2)+
				Math.pow(p.getZ() - this.z , 2)
				) ;
		return distancia;		
	}
	

}
