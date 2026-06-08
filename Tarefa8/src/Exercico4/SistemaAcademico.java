package Exercico4;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SistemaAcademico {

	private static SistemaAcademico instanciaUnica;
	
	private List<Aluno> alunos = new ArrayList<Aluno>();
	private List<Professor> professores = new ArrayList<Professor>();
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public List<Aluno> getAluno(){
		return this.alunos;
	}
	
	
	public String[] nomeDosProf () {
	String [] nomes = new String[professores.size()];
		for (int i = 0; i < nomes.length; i++) {
			nomes[i] = professores.get(i).getNome();
		}
		return nomes;
	}
	
	public String[] nomeDosAluno () {
		String [] nomes = new String[alunos.size()];
			for (int i = 0; i < nomes.length; i++) {
				nomes[i] = alunos.get(i).getNome();
			}
			return nomes;
		}
	
	public String[] nomeDasDisciplinas () {
		String [] nomes = new String[disciplinas.size()];
			for (int i = 0; i < nomes.length; i++) {
				nomes[i] = disciplinas.get(i).getNome();
			}
			return nomes;
		}
	
	// O jeito de pegar o sistema é através deste método
    public static SistemaAcademico getInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new SistemaAcademico();
        }
        return instanciaUnica;
    }
    
    public Aluno buscarAlunoPorNome(String nomeBusca) {
        for (Aluno a : this.alunos) {
            // Usamos equalsIgnoreCase para não dar erro se digitar maiúscula/minúscula
            if (a.getNome().equalsIgnoreCase(nomeBusca)) {
                return a; // Encontrou! Devolve o objeto Aluno
            }
        }
        return null; // Percorreu tudo e não achou nada
    }
    
    public Professor buscarProfessorPorNome(String nomeBusca) {
        for (Professor p : this.professores) {
            // Usamos equalsIgnoreCase para não dar erro se digitar maiúscula/minúscula
            if (p.getNome().equalsIgnoreCase(nomeBusca)) {
                return p; // Encontrou! Devolve o objeto Aluno
            }
        }
        return null; // Percorreu tudo e não achou nada
    }
    
    public Disciplina buscarDisciplinaPorNome(String nomeBusca) {
        for (Disciplina d : this.disciplinas) {
            // Usamos equalsIgnoreCase para não dar erro se digitar maiúscula/minúscula
            if (d.getNome().equalsIgnoreCase(nomeBusca)) {
                return d; // Encontrou! Devolve o objeto Aluno
            }
        }
        return null; // Percorreu tudo e não achou nada
    }
	
	
	public  void cadastrarAluno(Aluno aluno) {
		if (aluno != null) {
			alunos.add(aluno);
			System.out.printf("Aluno %s cadastrado no sistema \n", aluno.getNome() );
		}else {
			System.out.println("Falha no cadastro");
		}
		
	}
	
	public void excluirAluno(Aluno aluno) {
		if (alunos.remove(aluno)) {
	        System.out.println("Aluno removido com sucesso!");
	    } else {
	        System.out.println("Aluno não encontrado.");
	        
	    }
	}
	
	public void listarAlunos() {
		alunos.forEach(System.out::println);
	}
	
	public  void matricularAlunoEmDisciplina(Aluno aluno , Disciplina disciplina) {
		
		
		if (aluno.getQuantidadeDisciplinasPermitidadas() <= aluno.getContadorDisciplinas()) {
			System.out.println("Numero maximo de Disciplinas disponiveis para esse aluno alcançada falha na matricula");
			throw new IllegalArgumentException("Numero maximo de Disciplinas disponiveis para esse aluno alcançada falha na matricula");
		}
		if (disciplina.getContaAluno() >= disciplina.getLimite()) {
			System.out.println("Turma cheia falha na matricula");
			throw new IllegalArgumentException("Turma cheia");
		}
		
		disciplina.fazMatricula(aluno);
		System.out.printf("Aluno %s matriculado na Disciplina %s com sucesso \n" , aluno.getNome(), disciplina.getNome());
		return;  
	}
	
	public void cancelarMatricula(Aluno aluno , Disciplina disciplina){
		
		if (disciplina.cancelarMatricula(aluno) ==1) {
			System.out.printf("Aluno %s foi desmatriculado na Disciplina %s com sucesso \n" , aluno.getNome(), disciplina.getNome());
		} else {
			System.out.println("Aluno não está nessa turma");
			throw new IllegalArgumentException("Aluno não está nessa turma");
		
			}
		return;  
	}
	
	public String ListaDeAlunoseDisciplinas() {
	   
	    if (alunos.isEmpty()) {
			return "Nenhum aluno cadastrado no momento";
		}
		
	    StringBuilder relatorio = new StringBuilder();
	    for (Aluno a : alunos) {
	       
	        // Aqui usamos o toString limpinho que fizemos acima
	        relatorio.append(a.toString()).append("\n"); 
	        
	        relatorio.append("Disciplinas: ");
	        boolean temMatricula = false;
	        
	        // Percorre o array fixo do aluno e só imprime o que não for null
	        for (Disciplina d : a.getDisciplinasMatriculadas()) {
	            if (d != null) {
	                // Imprime o nome da disciplina e uma vírgula
	                relatorio.append("[" + d.getNome() + "] ");
	                temMatricula = true;
	            }
	        }
	        
	        if (!temMatricula) {
	            relatorio.append("Nenhuma disciplina vinculada.");
	        }
	        relatorio.append("\n"); // Pula linha para o próximo aluno
	    }
	 
	    return relatorio.toString();
	}
	
	public void cadastrarProfessor(Professor novoProfessor) {
		if (novoProfessor != null) {
			professores.add(novoProfessor);
			System.out.printf("Professor/a %s cadastrado no sistema \n", novoProfessor.getNome() );
		}else {
			System.out.println("Falha no cadastro");
		}
	}
	
	public void cadastrarDisciplina(Disciplina novaDisciplina) {
		if (novaDisciplina != null) {
			if (novaDisciplina.getProf().getContadorDisciplinas() >= novaDisciplina.getProf().getQuantDisciplinas()) {
				System.out.println("Esse Professor não pode assumir mais Disciplinas");
				throw new IllegalArgumentException("Esse Professor não pode assumir mais Disciplinas");
			} else {
				disciplinas.add(novaDisciplina);
				novaDisciplina.getProf().addDisciplina(novaDisciplina);
				System.out.printf("Disciplina %s cadastrada no sistema \n", novaDisciplina.getNome() );}
		}else {
			System.out.println("Falha no cadastro");
		}
	}
	
	public String imprimeProfessoresDisciplinas() {
		if (professores.isEmpty()) {
			return "Nenhum Professor cadastrado";
		}
		StringBuilder listaProf = new StringBuilder();
		for (Professor p : professores ) {
			
			  listaProf.append(p.toString()).append("\n");
			  listaProf.append("Disciplinas: ");
			  boolean temDisciplina = false ;
			  
			  for (Disciplina d : p.getDisciplinasLecionadas()) {
				if (d != null) {
					listaProf.append("[").append(d.getNome()).append("] ");
					temDisciplina = true ;
				}
			}
		if (!temDisciplina) {
			listaProf.append("Nenhuma Disciplina lecionada");
		}	
		listaProf.append("\n");
		}
		
		
		return listaProf.toString();
	}
	

	public static void main(String[] arg) {

		String nome ,nomeProfessor , endereco, matricula , curso , disciplina  ;
		int qtdAlunos,qtdDisciplinas, idade , periodo; 
		int opcao = -1;
		
		SistemaAcademico sistema = SistemaAcademico.getInstancia();

		Scanner leitor = new Scanner(System.in);

		while (opcao != 0) {

			System.out.println("-------SISTEMA ACADEMICO -------");
			System.out.println("escolha a opção desejada abaixo");
			System.out.println("1 - Cadastrar aluno");
			System.out.println("2 - Excluir aluno por nome");
			System.out.println("3 - Listar alunos");
			System.out.println("4 - Matricular aluno em Disciplina");
			System.out.println("5 - Cancelar Matricula");
			System.out.println("6 - Imprimir alunos e Disciplinas Matriculadas");
			System.out.println("7 - Cadastrar Professor/a");
			System.out.println("8 - Cadastrar Disciplina");
			System.out.println("9 - Imprimir Professores e suas Disciplinas");
			System.out.println("0 - Sair");
			System.out.print("=>");
			
			opcao = leitor.nextInt();
			leitor.nextLine();
			System.out.println("-----------------------------------------------------------------") ;

			switch (opcao) {
			case 1:
				System.out.println("-------CADASTRO DE ALUNO -------");
				System.out.println("Digite o nome do aluno");
				nome = leitor.nextLine();
				
				System.out.println("Digite o endereço do aluno");
				endereco = leitor.nextLine();
				
				System.out.println("Digite a idade do aluno");
				idade = leitor.nextInt(); leitor.nextLine();
				
				System.out.println("Digite o numero de Matricula do aluno");
				matricula = leitor.nextLine();
				
				System.out.println("Digite o curso do aluno");
				curso = leitor.nextLine();
				
				System.out.println("Digite o periodo do aluno");
				periodo = leitor.nextInt();
				leitor.nextLine();
				
				System.out.println("Digite a quantidade de Disciplinas permitidas do aluno");
				qtdDisciplinas = leitor.nextInt();
				leitor.nextLine();
				//new Aluno(nome,matricula,curso,periodo,idade,0)
				Aluno novoAluno = new Aluno(nome, endereco, idade, matricula, curso, periodo, qtdDisciplinas);
				
				sistema.cadastrarAluno(novoAluno);
				
				
				break;
			case 2:
				System.out.println("-------EXCLUSÃO DE ALUNO -------");
				System.out.println("Digite o nome do aluno que deseja excluir");
				nome = leitor.nextLine();
				
				Aluno alunoExcluir = sistema.buscarAlunoPorNome(nome);
				if (alunoExcluir == null) {
					System.err.printf("Erro aluno %s nao encontrado" , nome);
				}else {
					sistema.excluirAluno(alunoExcluir);
				}
				
				
				break;
				
			case 3:
				System.out.println("-------LISTANDO ALUNOS -------");
				sistema.listarAlunos();
				break;
				
			case 4:
				System.out.println("-------MATRICULANDO ALUNO -------");
				System.out.println("Digite o nome do aluno que deseja matricular");
				nome = leitor.nextLine();
				
				System.out.println("Digite o nome da Disciplinha que deseja matricular");
				disciplina = leitor.nextLine();
				
				
				Aluno alunoMatricula = sistema.buscarAlunoPorNome(nome);
				Disciplina disciplinaMatricula = sistema.buscarDisciplinaPorNome(disciplina);
				
				if (alunoMatricula == null) {
					System.out.printf("Erro aluno %s não encontrado \n" , nome);
					
				} else if (disciplinaMatricula ==null) {
					System.out.printf("Erro Disciplina %s não encontrada \n" , disciplina);
				
					
				} else {sistema.matricularAlunoEmDisciplina(alunoMatricula, disciplinaMatricula);}
				
				break;
				
			case 5:
				System.out.println("-------CANCELANDO MATRICULA -------");
				System.out.println("Digite o nome do aluno que deseja cancelar a matricula");
				nome = leitor.nextLine();
				
				
				System.out.println("Digite o nome da Disciplina que será cancelada a matricula");
				disciplina = leitor.nextLine();
				
				Aluno alunoCancela =sistema.buscarAlunoPorNome(nome);
				Disciplina disciplinaCancela = sistema.buscarDisciplinaPorNome(disciplina);
				if (alunoCancela==null) {
					System.out.printf("Erro aluno %s não encontrado \n" , nome);
				
				} else if(disciplinaCancela == null) {
					System.out.printf("Erro Disciplina %s não encontrada \n" , disciplina);
			
				} else {
					sistema.cancelarMatricula(alunoCancela, disciplinaCancela);
				}
			
				
				break;

			case 6:
				System.out.println("-------Listando Alunos e Disciplinas -------");
				sistema.ListaDeAlunoseDisciplinas();
				break;
			case 7:
				System.out.println("-------CADASTRO DE PROFESSOR/A -------");
				System.out.println("Digite o nome do Professor/a");
				nome = leitor.nextLine();
				
				System.out.println("Digite o endereço do Professor/a");
				endereco = leitor.nextLine();
				
				System.out.println("Digite a idade do Professor/a");
				idade = leitor.nextInt(); leitor.nextLine();
				
				System.out.println("Digite a quantidade de Disciplinas que o Professor/a lecionará");
				qtdDisciplinas = leitor.nextInt();
				leitor.nextLine();
				
				Professor novoProfessor = new Professor(nome, endereco, idade, qtdDisciplinas);
				sistema.cadastrarProfessor(novoProfessor);
				break;
			case 8:
				System.out.println("-------CADASTRO DE DISCIPLINA -------");
				System.out.println("Digite o nome da Disciplina");
				nome = leitor.nextLine();
				
				System.out.println("Digite o nome do Professor/a que lecionará essa Disciplina");
				nomeProfessor = leitor.nextLine();
				
				Professor professorDisciplina = sistema.buscarProfessorPorNome(nomeProfessor) ;
				
				if (professorDisciplina == null) {
					System.out.println("Professor não encontrado");
					break;
				}
				
				System.out.println("Digite a quantidade de Alunos nessa Disciplina");
				qtdAlunos = leitor.nextInt(); leitor.nextLine();
				
				
				Disciplina novaDisciplina = new Disciplina(nome, professorDisciplina, qtdAlunos);
				sistema.cadastrarDisciplina(novaDisciplina);
				break;
			case 9 :
				System.out.println("-------Listando Professores e suas Disciplinas -------");
				sistema.imprimeProfessoresDisciplinas();
				break;
			case 0:
				System.out.println("-------SAINDO-------");
				break ;
			default:
				System.out.println("-------OPÇAO INVALIDA ! -------");
				break;
			}
			
		}
		leitor.close();
	}
}

