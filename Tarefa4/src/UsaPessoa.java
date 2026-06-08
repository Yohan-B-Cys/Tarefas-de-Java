import java.util.Scanner ;
public class UsaPessoa {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		Pessoa p1 = new Pessoa();
		
		System.out.print("Digite o nome:");
		p1.nome = leitor.nextLine();
		
		System.out.print("Digite a idade:");
		p1.idade = leitor.nextInt();
		leitor.nextLine();
		
		System.out.print("Digite o endereço:");
		p1.endereco = leitor.nextLine();
		
		leitor.close();
		
		p1.imprime();
		
		p1.aniversario();
		
		System.out.println("Depois de um aniversario ");
		
		p1.imprime();
		
		p1.aniversario();
		p1.aniversario();
		p1.aniversario();
		
		System.out.println("Depois de 3 aniversarios  ");
		
		p1.imprime();
	}
}
