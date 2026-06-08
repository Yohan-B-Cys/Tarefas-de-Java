package Exercicio6;

public class Diretor extends Funcionario {
	private Departamento arrayDepartamento[];
	private int deptsIndex = 0 ;
	public Diretor(String nome, double salario, Departamento departamento , int quantidadeDepartamento) throws RegraNegocioRHException {
		super(nome, salario, departamento);
		
		if (quantidadeDepartamento < 2) {
			throw new RegraNegocioRHException("Um diretor deve dirigir ao menos 2 Departamentos");
		}
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

	// Método SET com validação exigida pela regra de negócio
		public void setArrayDepartamento(int quantidadeDepartamento) throws RegraNegocioRHException {
			if (quantidadeDepartamento < 2) {
				throw new RegraNegocioRHException("Um diretor deve dirigir ao menos 2 Departamentos");
			}
			// Se passou na validação, cria um novo array com o novo tamanho
			this.arrayDepartamento = new Departamento[quantidadeDepartamento];
			this.deptsIndex = 0; // Zera o contador de departamentos inseridos, pois o array é novo
		}
	
}
