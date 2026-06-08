
public class Pessoa {
	public String nome  ;
	public int idade ;
	public String endereco ;
	
	public void aniversario () {
		this.idade ++ ;
	}
	
	public void imprime() {
		
		System.out.println("---Dados Pessoais ---");
		System.out.println("Nome:" + nome);
		System.out.println("idade:"+ idade);
		System.out.println("Endereço:" + endereco);
		System.out.println("---------------------");
	}
	

}
