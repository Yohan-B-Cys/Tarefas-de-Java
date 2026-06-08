package Exercicio6;

public class Gerente extends Funcionario {
	private Funcionario[] arraysFuncionario ;
	private int vagasOcupadas = 0 ;
	public Gerente(String nome, double salario, Departamento departamento , int tamanhoEquipe) throws RegraNegocioRHException {
		super(nome, salario, departamento);
		if (tamanhoEquipe < 5) {
			throw new RegraNegocioRHException("Um gerente não pode ter uma equipe menor que 5 funcionarios");
		}
		this.arraysFuncionario = new Funcionario[tamanhoEquipe];
	}
	
	
	
	public int getVagasOcupadas() {
		return vagasOcupadas;
	}



	public void setVagasOcupadas(int vagasOcupadas) {
		this.vagasOcupadas = vagasOcupadas;
	}



	@Override
	public double getBonus() {
		double bonus = (getSalario() * 2) + ( 100 * vagasOcupadas) ;
		return bonus;
	}
	
	public void adicionarFuncionario (Funcionario f) {

		
		for (int i = 0; i < arraysFuncionario.length; i++) {
	        if (arraysFuncionario[i] == null) { 
	            arraysFuncionario[i] = f;
	            vagasOcupadas++;
	            return;
	        }
	    }
	    System.out.println("Equipe cheia!");
	}
	
	public void retirarFuncionario(Funcionario f){
		if (vagasOcupadas == 0) {
			System.out.println("Equipe vazia!");
			return;
		}
		for (int i = 0; i < arraysFuncionario.length; i++) {
			if (f == arraysFuncionario[i]) {
				arraysFuncionario[i] = null ;
				vagasOcupadas -- ;
				return ;
			}
		}
	}

	public void setArraysFuncionario(int novoTamanhoEquipe) throws RegraNegocioRHException {
		if (novoTamanhoEquipe < 5) {
			throw new RegraNegocioRHException("Um gerente não pode ter uma equipe menor que 5 funcionarios");
		}
		// Se passou na validação, cria um novo array com o novo tamanho
		this.arraysFuncionario = new Funcionario[novoTamanhoEquipe];
		this.vagasOcupadas = 0; // Zera as vagas pois o array é novo
	}
	
}
