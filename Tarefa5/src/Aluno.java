
public class Aluno {
	private String nome, matricula, curso, endereco;
	private int periodo, idade, quantidadeDisciplinasPermitidadas;
	private int contadorDisciplinas = 0;
	private String[] disciplinasMatriculadas;

	public Aluno(String nome, String matricula, String curso, int periodo, int idade,
			int quantidadeDisciplinasPermitidadas) {
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
		this.periodo = periodo;
		this.idade = idade;
		this.quantidadeDisciplinasPermitidadas = quantidadeDisciplinasPermitidadas;

		this.disciplinasMatriculadas = new String[quantidadeDisciplinasPermitidadas];
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public String[] getDisciplinasMatriculadas() {
		return disciplinasMatriculadas;
	}

	public void setDisciplinasMatriculadas(String[] disciplinasMatriculadas) {
		this.disciplinasMatriculadas = disciplinasMatriculadas;
	}

	public String fazMatricula(String disciplina) {
		String erro, sucesso;

		if (disciplinasMatriculadas.length == 0) {
			erro = "Este aluno não pode ser matriculado em nenhuma disciplina, por favor, fale com a secretaria.";
			return erro;
		}
		if (contadorDisciplinas >= disciplinasMatriculadas.length) {
			erro = "Quantidade de disciplinas excedida. O limite de disciplinas para este aluno é de "
					+ disciplinasMatriculadas.length
					+ " disciplina(s). Se desejar, cancele a matrícula de uma das disciplinas e faça a nova matrícula.";
			return erro;
		}
		for (int i = 0; i < disciplinasMatriculadas.length; i++) {
			if (disciplinasMatriculadas[i]==null) {
				disciplinasMatriculadas[i] = disciplina;
				contadorDisciplinas++;
				sucesso = "Matrícula na disciplina  " + "“" + disciplina + "”" + " executada  ";
				return sucesso;

			}
		}
		return "Erro na Matricula";
		
		
	}

	public String cancelarMatricula(String disciplina) {

		for (int i = 0; i < disciplinasMatriculadas.length; i++) {
			if (disciplinasMatriculadas[i] != null && disciplinasMatriculadas[i].equals(disciplina)) {
				disciplinasMatriculadas[i] = null;
				contadorDisciplinas--;
				return "Cancelamento da matrícula da disciplina " + disciplina + " executado com sucesso.";

			}
		}

		return "Aluno não está matriculado na disciplina " + disciplina
				+ ", portanto não é possível cancelar esta matrícula";
	}

	public String imprime() {

		String saida = "-----------------------------------------------------------------\n";
		saida += "Nome do Aluno: " + this.nome + "\n";
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
