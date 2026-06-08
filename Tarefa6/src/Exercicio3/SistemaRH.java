package Exercicio3;

import java.util.ArrayList;
import java.util.List;

public class SistemaRH {

	
	public static String imprimeRelatorio(List<Funcionario> lista) {
	    if (lista.isEmpty()) return "Nenhum funcionário encontrado.";

	    // Definindo larguras padrão para facilitar a manutenção
	    String formato = "| %-20s | %-15s | %-12s | %-12s | %-35s |\n";
	    
	    // O cabeçalho usa as mesmas larguras
	    String topo = String.format(formato, "Nome", "Cargo", "Salário", "Bônus", "Info Extra");
	    
	    // Gerando a divisória automaticamente com base no tamanho do topo
	    String divisoria = "-".repeat(topo.length() - 1) + "\n";
	    
	    StringBuilder relatorio = new StringBuilder();
	    relatorio.append(divisoria).append(topo).append(divisoria);

	    for (Funcionario f : lista) {
	        String infoExtra = "";
	        if (f instanceof Gerente) {
	            infoExtra = "Funcionarios Gerenciados: " + ((Gerente) f).getVagasOcupadas();
	        } else if (f instanceof Diretor) {
	            infoExtra = "Departamentos Dirigidos: " + ((Diretor) f).getDeptsIndex();
	        }
	        else if (f.getSalario() == 1) {
	            infoExtra = "Não de nem agua " ;
	        }
	        
	        // Usei %-9d porque 3 espaços são do "R$ " e 9 do número = 12 total
	        String linha = String.format("| %-20s | %-15s | R$ %-9d | R$ %-9d | %-35s |\n",
	                formatarNome(f.getNome(), 20), // Ajustei o formatarNome para aceitar o limite
	                f.getClass().getSimpleName(),
	                (int) f.getSalario(),
	                (int) f.getBonus(),
	                infoExtra);
	        
	        relatorio.append(linha);
	    }
	    relatorio.append(divisoria);
	    return relatorio.toString();
	}
	
	private static String formatarNome(String nome, int limite) {
	    if (nome.length() > limite) {
	        return nome.substring(0, limite - 3) + "...";
	    }
	    return nome;
	}
	
	public static void main(String[] args) {
  
        Departamento ti = new Departamento("Tecnologia da Informação");
        Departamento rh = new Departamento("Recursos Humanos");
        Departamento vendas = new Departamento("Vendas");
        Departamento zeladoria = new Departamento("Zeladoria");

        Diretor d1 = new Diretor("Yohan Cys", 12000.0, rh , 3);
        Gerente g1 = new Gerente("Thiago", 5000.0, ti , 3);
        Gerente g2 = new Gerente("Lucas", 5000.0, ti , 3);
        Analista a1 = new Analista("Sabrina", 3000.0, ti);
        Analista a2 = new Analista("Pedro", 3200.0, ti);
        Programador p1 = new Programador("Leticia", 2000, ti);
        Programador p2 = new Programador("Vinicius", 2000, ti);
        AuxiliarLimpeza al1 = new AuxiliarLimpeza("Danclebe", 1200, zeladoria) ;
        AuxiliarLimpeza al2 = new AuxiliarLimpeza("Jose Eduardo dos Santos Geremias Junior", 1, zeladoria) ;
        
        g1.adicionarFuncionario(a1);
        g1.adicionarFuncionario(a2);
        g2.adicionarFuncionario(p1);
        g2.adicionarFuncionario(p2);

   
        d1.adicionarDepartamento(ti);
        d1.adicionarDepartamento(rh);
        d1.adicionarDepartamento(vendas);
        
        List<Funcionario> listaEmpresa = new ArrayList<>();
        listaEmpresa.add(d1);
        listaEmpresa.add(g1);
        listaEmpresa.add(g2);
        listaEmpresa.add(a1);
        listaEmpresa.add(a2);
        listaEmpresa.add(p1);
        listaEmpresa.add(p2);
        listaEmpresa.add(al1);
        listaEmpresa.add(al2);

        System.out.println("Gerando Relatório CSV...");
        String resultado = imprimeRelatorio(listaEmpresa);
        
        System.out.println(resultado);
        
    }
}
