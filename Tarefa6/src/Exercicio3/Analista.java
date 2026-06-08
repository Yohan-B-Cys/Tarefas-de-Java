package Exercicio3;
public class Analista extends Funcionario {

	public Analista(String nome, double salario, Departamento departamento) {
		super(nome, salario, departamento);
	}

	@Override
	public double getBonus() {
		double bonus = getSalario() ;
		return bonus;
	}

	
}
