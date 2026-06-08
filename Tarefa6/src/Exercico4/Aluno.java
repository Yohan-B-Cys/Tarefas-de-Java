package Exercico4;

import java.util.Arrays;

public class Aluno extends Pessoa {
	private String  matricula, curso;
	private int periodo, quantidadeDisciplinasPermitidadas;
	private int contadorDisciplinas = 0;
	private Disciplina disciplinasMatriculadas[];

	public Aluno(String nome, String endereco, int idade, String matricula, String curso, int periodo,
			int quantidadeDisciplinasPermitidadas) {
		super(nome, endereco, idade);
		this.matricula = matricula;
		this.curso = curso;
		this.periodo = periodo;
		this.quantidadeDisciplinasPermitidadas = quantidadeDisciplinasPermitidadas;
		this.disciplinasMatriculadas = new Disciplina[quantidadeDisciplinasPermitidadas];
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	

	public int getQuantidadeDisciplinasPermitidadas() {
		return quantidadeDisciplinasPermitidadas;
	}

	public void setQuantidadeDisciplinasPermitidadas(int quantidadeDisciplinasPermitidadas) {
		this.quantidadeDisciplinasPermitidadas = quantidadeDisciplinasPermitidadas;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	public Disciplina[] getDisciplinasMatriculadas() {
		return disciplinasMatriculadas;
	}

	public void setDisciplinasMatriculadas(Disciplina[] disciplinasMatriculadas) {
		this.disciplinasMatriculadas = disciplinasMatriculadas;
	}
	
	public int getContadorDisciplinas() {
		return contadorDisciplinas;
	}

	public void setContadorDisciplinas(int contadorDisciplinas) {
		this.contadorDisciplinas = contadorDisciplinas;
	}
	
	public void incrementaContador() {
		this.contadorDisciplinas ++ ;
	}
	
	public void decrementaContador() {
		this.contadorDisciplinas -- ;
	}

	
	
	@Override
	public String toString() {
		return String.format("Nome: %-15s | Matrícula: %-10s | Curso: %-10s | Período: %dº", 
                getNome(), matricula, curso, periodo);
	}
	
	

	public String imprime() {

		String saida = "-----------------------------------------------------------------\n";
		saida += "Nome do Aluno: " + getNome() + "\n";
		saida += "Matricula: " + this.matricula + "\n";
		saida += "Curso: " + this.curso + "\n";
		saida += "Periodo: " + this.periodo + "\n";

		String listaMaterias = "";
		for (int i = 0; i < disciplinasMatriculadas.length; i++) {
			if (disciplinasMatriculadas[i] != null) {

				if (!listaMaterias.equals("")) {
					listaMaterias += "; ";
				}
				listaMaterias += disciplinasMatriculadas[i];
			}
		}

		saida += "Disciplinas Matriculadas: " + listaMaterias + "\n";
		saida += "-----------------------------------------------------------------";

		return saida;
	}

}

