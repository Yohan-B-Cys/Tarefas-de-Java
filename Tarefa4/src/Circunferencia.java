
public class Circunferencia {
	private double raio ;

	public Circunferencia(double raio) {
		super();
		this.raio = raio;
	}
	
	public double cauculaArea() {
		double area ;
		area = Math.PI * Math.pow(raio, 2);
		return area ;
	}

	@Override
	public String toString() {
		return "Circunferencia [raio=" + raio + ", cauculaArea()=" + cauculaArea() + "]";
	}


	
	
	

}
