package Exercico4;

import java.util.Arrays;

public class Professor extends Pessoa {
	private Disciplina DisciplinasLecionadas[];
	private int quantDisciplinas = 0,contadorDisciplinas = 0;
	public Professor(String nome, String endereco, int idade , int quantDisciplinas) {
		super(nome, endereco, idade);
		this.quantDisciplinas = quantDisciplinas;
		this.DisciplinasLecionadas = new Disciplina [quantDisciplinas];
		
	}
	public Disciplina[] getDisciplinasLecionadas() {
		return DisciplinasLecionadas;
	}
	public void setDisciplinasLecionadas(Disciplina[] disciplinasLecionadas) {
		DisciplinasLecionadas = disciplinasLecionadas;
	}
	public int getQuantDisciplinas() {
		return quantDisciplinas;
	}
	public void setQuantDisciplinas(int quantDisciplinas) {
		this.quantDisciplinas = quantDisciplinas;
	}
	public int getContadorDisciplinas() {
		return contadorDisciplinas;
	}
	public void setContadorDisciplinas(int contadorDisciplinas) {
		this.contadorDisciplinas = contadorDisciplinas;
	}
	
	public void incrementaContador () {
		this.contadorDisciplinas ++ ;
	}
	
	public void addDisciplina(Disciplina d) {
		boolean add = false ;
		
		for (int i = 0; i < DisciplinasLecionadas.length && !add; i++) {
			if (DisciplinasLecionadas[i] == null) {
				DisciplinasLecionadas[i] = d ;
				contadorDisciplinas ++;
				add = true;
			}
		}
	}
	@Override
	public String toString() {
	    // Usamos o getNome() e getIdade() que vêm de Pessoa
	    // %-15s alinha o nome e %02d garante dois dígitos no contador
	    return String.format("Prof(a): %-15s | Idade: %d | Disciplinas: %d/%d", 
	                         getNome(), getIdade(), contadorDisciplinas, quantDisciplinas);
	}
	
	
}
