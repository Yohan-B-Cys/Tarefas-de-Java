import java.util.Scanner;

public class SistemaAcademico {

	private static Aluno[] alunos;
	
	public static void cadastrarAluno(Aluno aluno) {
		for (int i = 0; i < alunos.length; i++) {
			if (alunos[i] ==null) {
				alunos[i] = aluno ;
				System.out.println("Aluno cadastrado com sucesso !");
				return;
			}
		}
		System.out.println("Falha de cadastro! Quantidade maxima de alunos atingida");
	}
	
	public static void excluirAluno(String nomeAluno) {
		for (int i = 0; i < alunos.length; i++) {
			if (alunos[i] !=null && alunos[i].getNome().equalsIgnoreCase(nomeAluno)) {
				alunos[i] = null ;
				System.out.printf("Aluno removido com sucesso ! vaga %d liberada \n" , i);
				return ;
			}
		}
		System.out.println("Aluno não encontrado logo não pode ser removido ");
	}
	
	public static Aluno[] listarAlunos() {
		for (int i = 0; i < alunos.length; i++) {
			if (alunos[i] != null) {
				System.out.println(alunos[i].getNome());
			}
			
		}
		return alunos ;
	}
	
	public static String matricularAlunoEmDisciplina(Aluno aluno , String disciplina) {
		return aluno.fazMatricula(disciplina); 
	}
	
	public static String cancelarMatricula(Aluno aluno , String disciplina){
		return aluno.cancelarMatricula(disciplina) ;
	}
	public static String ListaDeAlunoseDisciplinas() {
		String lista = "";
		for (int i = 0; i < alunos.length; i++) {
			if(alunos[i] !=null) {
				 lista +=alunos[i].imprime() ;
			}
			
		}
		return lista ;
	}
	

	public static void main(String[] arg) {

		String nome , matricula , curso , disciplina  ;
		int qtdAlunos,qtdDisciplinas, idade , periodo; 
		int opcao = -1;

		Scanner leitor = new Scanner(System.in);

		System.out.print("Informe a quantidade de alunos cadastrados =>");
		qtdAlunos = leitor.nextInt();

		alunos = new Aluno[qtdAlunos];

		while (opcao != 0) {

			System.out.println("-------SISTEMA ACADEMICO -------");
			System.out.println("escolha a opção desejada abaixo");
			System.out.println("1 - Cadastrar aluno");
			System.out.println("2 - Excluir aluno por nome");
			System.out.println("3 - Listar alunos");
			System.out.println("4 - Matricular aluno em Disciplina");
			System.out.println("5 - Cancelar Matricula");
			System.out.println("6 - Imprimir alunos e Disciplinas Matriculadas");
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
				
				System.out.println("Digite o numero de Matricula do aluno");
				matricula = leitor.nextLine();
				
				System.out.println("Digite o curso do aluno");
				curso = leitor.nextLine();
				
				System.out.println("Digite o periodo do aluno");
				periodo = leitor.nextInt();
				leitor.nextLine();
				
				System.out.println("Digite a idade do aluno");
				idade = leitor.nextInt();
				leitor.nextLine();
				
				Aluno novoAluno = new Aluno(nome,matricula,curso,periodo,idade,0);
				
				cadastrarAluno(novoAluno);
				
				
				break;
			case 2:
				System.out.println("-------EXCLUSÃO DE ALUNO -------");
				System.out.println("Digite o nome do aluno que deseja excluir");
				nome = leitor.nextLine();
				
				excluirAluno(nome);
				
				break;
				
			case 3:
				System.out.println("-------LISTANDO ALUNOS -------");
				listarAlunos();
				break;
				
			case 4:
				System.out.println("-------MATRICULANDO ALUNO -------");
				System.out.println("Digite o nome do aluno que deseja matricular");
				nome = leitor.nextLine();
				int achou = 0, posicao = 0 ;
				for (int i = 0; i < alunos.length; i++) {
					if(alunos[i]!=null && alunos[i].getNome().equalsIgnoreCase(nome)) {
						posicao = i;
						achou = 1 ;
					}
				}
				if (achou == 0) {
					System.out.println("Aluno não encontrado");
					break ;
				} else {
					if (alunos[posicao].getDisciplinasMatriculadas().length==0) {
						System.out.println("Digite a quantidade de Disciplinas permitidas do aluno");
						qtdDisciplinas = leitor.nextInt();
						leitor.nextLine();
						
						String[] arrayDisciplinas = new String[qtdDisciplinas];
						alunos[posicao].setDisciplinasMatriculadas(arrayDisciplinas);
					}
					
					System.out.println("Digite o nome da Disciplina que o aluno será matriculado");
					disciplina = leitor.nextLine();
				}
				System.out.println(matricularAlunoEmDisciplina(alunos[posicao], disciplina));
				break;
				
			case 5:
				System.out.println("-------CANCELANDO MATRICULA -------");
				System.out.println("Digite o nome do aluno que deseja cancelar a matricula");
				nome = leitor.nextLine();
				 achou = 0; posicao = 0 ;
				for (int i = 0; i < alunos.length; i++) {
					if(alunos[i]!=null && alunos[i].getNome().equalsIgnoreCase(nome)) {
						posicao = i;
						achou = 1 ;
					}
				} if (achou == 0) {
					System.out.println("Aluno não encontrado");
					break ;
				}
				System.out.println("Digite o nome da Disciplina que será cancelada a matricula");
				disciplina = leitor.nextLine();
				
				System.out.println(cancelarMatricula(alunos[posicao], disciplina));
				break;

			case 6:
				System.out.println("-------Listando Alunos e Disciplinas -------");
				System.out.println(ListaDeAlunoseDisciplinas());
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
