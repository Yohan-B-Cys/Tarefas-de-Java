package Exercicio3;

public abstract class Funcionario {
	private String nome ;
	private double salario ;
	private Departamento departamento ;
	
	
	
	public Funcionario(String nome, double salario, Departamento departamento) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.departamento = departamento;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public double getSalario() {
		return salario;
	}



	public void setSalario(double salario) {
		this.salario = salario;
	}



	public Departamento getDepartamento() {
		return departamento;
	}



	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public abstract double getBonus ();
	
	
	
}
