package Exercicio3;

public class AuxiliarLimpeza extends Funcionario {

	public AuxiliarLimpeza(String nome, double salario, Departamento departamento) {
		super(nome, salario, departamento);
	}
	
	@Override
	public double getBonus() {
		double bonus = getSalario() * 0.5;
		return bonus ;
	}
}
