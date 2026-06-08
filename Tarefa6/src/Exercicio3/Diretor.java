package Exercicio3;

public class Diretor extends Funcionario {
	private Departamento arrayDepartamento[];
	private int deptsIndex = 0 ;
	public Diretor(String nome, double salario, Departamento departamento , int quantidadeDepartamento) {
		super(nome, salario, departamento);
		this.arrayDepartamento = new Departamento[quantidadeDepartamento];
	}

	
	
	public int getDeptsIndex() {
		return deptsIndex;
	}



	public void setDeptsIndex(int deptsIndex) {
		this.deptsIndex = deptsIndex;
	}



	@Override
	public double getBonus() {
		double bonus = (getSalario() * 4) + (3000 * deptsIndex ) ;
		return bonus;
	}
	
	public void adicionarDepartamento(Departamento d) {
		if (deptsIndex < arrayDepartamento.length) {
			arrayDepartamento[deptsIndex] = d ;
			deptsIndex ++ ;
		} else {
			 System.out.println("Quantidade maxima de Departamentos alcaçada!");
		}
	}

}
