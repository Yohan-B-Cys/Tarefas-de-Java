package Exercico4;


public class Disciplina {
	private String nome ;
	private Professor prof ;
	private Aluno  turma[] ;
	private int contaAluno , limite ;
	
	
	public Disciplina(String nome, Professor prof , int limite) {
		super();
		this.nome = nome;
		this.prof = prof;
		this.limite = limite ;
		
		this.turma = new Aluno[limite];
	}
	
	public void fazMatricula(Aluno a) {
		for (int i = 0; i < turma.length; i++) {
	        if (turma[i] == null) { 
	            turma[i] = a;
	            contaAluno++;
	            a.incrementaContador();
	            break;
	        }
	    }
		
		for (int j = 0; j < a.getDisciplinasMatriculadas().length; j++) {
			if (a.getDisciplinasMatriculadas()[j] == null) {
				a.getDisciplinasMatriculadas()[j] = this;
				return  ;
			}
			
			
		}

		
		
	}

	public int cancelarMatricula(Aluno a) {

		if (contaAluno == 0) {
			System.out.println("turma vazia!");
			return 0;
		}
		Disciplina[] turmasAluno = a.getDisciplinasMatriculadas();
		
		
		
		for (int i = 0; i < turmasAluno.length; i++) {
			if  ( turmasAluno[i] == this) {
				turmasAluno[i] =null;
				a.decrementaContador();
				break ;
			}
		}
		
		for (int i = 0; i < turma.length; i++) {
			if (a == turma[i]) {
				turma[i] = null ;
				contaAluno -- ;
				return 1 ;
			}
		}
		
		return 0 ;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public int getContaAluno() {
		return contaAluno;
	}

	public void setContaAluno(int contaAluno) {
		this.contaAluno = contaAluno;
	}
	
	
	
	
}
