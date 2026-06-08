import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TestaPonto3d {
	
	@Test
	public void testaCalculoDistancia() {
		Ponto3d p1 = new Ponto3d() ;
		Ponto3d p2 = new Ponto3d() ;
		
		p1.setX(0.0);
        p1.setY(0.0);
        p1.setZ(0.0);

        p2.setX(3.0);
        p2.setY(4.0);
        p2.setZ(0.0);
     
        double dist = p1.calculaDistancia(p2);
        
        assertEquals(5.0,dist,0.001);
        
	}
	
	@Test
	
	public void testGettersSetters() {
		
		Ponto3d p = new Ponto3d();
        p.setCor("Azul");
        
      
        assertEquals("Azul", p.getCor());
		
	}
}
