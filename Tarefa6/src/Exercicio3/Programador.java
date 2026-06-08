package Exercicio3;

public class Programador extends Funcionario {

	public Programador(String nome, double salario, Departamento departamento) {
		super(nome, salario, departamento);
		
	}

	@Override
	public double getBonus() {
		double bonus = getSalario() * 0.8;
		return bonus;
	}
	
}
