
public class UsaPonto3d {
	public static void main (String[] args) {
		Ponto3d p1 = new Ponto3d() ;
		
		p1.setCor("Vermelho"); p1.setIntensidade(5);p1.setX(10); p1.setY(10); p1.setZ(10);
		
		Ponto3d p2 = new Ponto3d();
		p2.setCor("Roxo"); p2.setIntensidade(5);p2.setX(100); p2.setY(100); p2.setZ(100);
		
		double distancia =p1.calculaDistancia(p2);
		
		System.out.printf("A distancia dos pontos 1 e 2 é %.2f", distancia);
	}

}
