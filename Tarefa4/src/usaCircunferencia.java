
public class usaCircunferencia {
	public static void main(String[] args){
		Circunferencia c1 = new Circunferencia(2.0);
		
		System.out.println(c1);
		
		double area = c1.cauculaArea();
		System.out.printf("Area calculada é %.2f  ",area );
	}

}
