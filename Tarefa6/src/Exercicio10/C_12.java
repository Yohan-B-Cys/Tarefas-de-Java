package Exercicio10;

import java.util.Iterator;

public class C_12 extends C implements I1,I2 {
	private float[][] atributo3;

	public C_12() {
		super();
		this.atributo3 = new float [2][2];
	}
	
	public C_12 (String p1 , float p2) {
		super(p1,p2);
		this.atributo3 = new float [3][3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.atributo3[i][j] = 1 ;
			}
		}
	}
	
	
	@Override
    public void operacao1() {
        System.out.println("Passou por operacao1()");
        System.out.println("Atributo1: " + atributo1 + " | Atributo2: " + atributo2);
    }
	
	@Override
    public void operacao2() {
        System.out.println("Passou por operacao2()");
    }
}
