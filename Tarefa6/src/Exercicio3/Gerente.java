package Exercicio3;

public class Gerente extends Funcionario {
	private Funcionario[] arraysFuncionario ;
	private int vagasOcupadas = 0 ;
	public Gerente(String nome, double salario, Departamento departamento , int tamanhoEquipe) {
		super(nome, salario, departamento);
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

}
