package Exercicio13;

import java.util.Scanner;

public class Principal {
	public static void main (String[] args) {
		Scanner leitor = new Scanner(System.in);
		int tamanho , tipo, qtdPassageiros ,qtdTurbinas , qtdMotores , qtdRodas , qtdPortas, qtdMarchas , qtdVagoes ;
		String nome , marca , placa , tipoCombustivel,TipoCarroceria , categoria , registro , tipoAgua ;
		double quilometragem , altitudeMax , envergadura , autonomiaVoo , comprimento , calado ,deslocamento ;
		
		
		System.out.println("Quantos Veiculos deseja informar ?");
		tamanho = leitor.nextInt();leitor.nextLine();
		
		Veiculo[] frota = new Veiculo [tamanho];
		
		for (int i = 0; i < frota.length; i++) {
			System.out.println("\n--- Cadastro do Veículo " + (i + 1) + " ---");
			System.out.println("1- Carro | 2- Trem | 3- Avião | 4- Barco");
			tipo = leitor.nextInt(); leitor.nextLine();
			
			System.out.print("Nome: "); nome = leitor.nextLine();
			System.out.print("Marca: "); marca = leitor.nextLine();
			System.out.print("Quantidade de Passageiros: "); qtdPassageiros = leitor.nextInt() ;leitor.nextLine();
			
			if (tipo == 1) {
				System.out.print("Quilometragem: "); quilometragem = leitor.nextDouble();leitor.nextLine();
				System.out.print("Quantidade de Rodas: "); qtdRodas = leitor.nextInt() ;leitor.nextLine();
				System.out.print("Tipo Combustivel: "); tipoCombustivel = leitor.nextLine();
				System.out.print("Placa: "); placa = leitor.nextLine();
				System.out.print("Tipo Carroceria (Suv ,Sedan , Coupe etc.): "); TipoCarroceria = leitor.nextLine();
				System.out.print("Quantidade de Portas: "); qtdPortas = leitor.nextInt() ;leitor.nextLine();
				System.out.print("Quantidade de Marchas: "); qtdMarchas = leitor.nextInt() ;leitor.nextLine();
				System.out.print("Automático (s/n)? ");
				String resposta = leitor.nextLine();
				boolean automatico = resposta.equalsIgnoreCase("s");
				frota[i] = new Carro(nome, marca, qtdPassageiros, quilometragem, qtdRodas, tipoCombustivel, placa, TipoCarroceria, qtdPortas, qtdMarchas, 0, automatico);
			}
			else if (tipo == 2) {
				System.out.print("Quilometragem: "); quilometragem = leitor.nextDouble();leitor.nextLine();
				System.out.print("Quantidade de Rodas: "); qtdRodas = leitor.nextInt() ;leitor.nextLine();
				System.out.print("Tipo Combustivel: "); tipoCombustivel = leitor.nextLine();
				System.out.print("Quantidade de Vagões: "); qtdVagoes = leitor.nextInt() ;leitor.nextLine();
				System.out.print("Registro : "); registro = leitor.nextLine();
				System.out.print("Categoria (Carga , Transporte humano etc): "); categoria = leitor.nextLine();
				frota[i] = new Trem(nome, marca, qtdPassageiros, quilometragem, qtdRodas, tipoCombustivel, qtdVagoes, registro, categoria);
			}
			else if (tipo == 3) {
				System.out.print("Altitude Maxima: "); altitudeMax = leitor.nextDouble();
				System.out.print("Autonomia de Voo: "); autonomiaVoo = leitor.nextDouble();
				System.out.print("Envergadura da Asa: "); envergadura = leitor.nextDouble();
				System.out.print("Quantidade de Turbinas: "); qtdTurbinas = leitor.nextInt() ;leitor.nextLine();
				System.out.print("Categoria (Carga , Transporte humano etc): "); categoria = leitor.nextLine();
				frota[i] = new Aviao(nome, marca, qtdPassageiros, altitudeMax, autonomiaVoo, envergadura, qtdTurbinas, categoria);
			}
			else if (tipo == 4) {
				System.out.print("Calado (Distancia entre a linha Dagua e a quilha): "); calado = leitor.nextDouble();
				System.out.print("Deslocamento do barco: "); deslocamento = leitor.nextDouble();leitor.nextLine();
				System.out.print("Tipo de agua (doce , salgada , ambos): "); tipoAgua = leitor.nextLine();
				System.out.print("Comprimento do barco: "); comprimento = leitor.nextDouble();leitor.nextLine();
				System.out.print("Quantidade de Motores: "); qtdMotores = leitor.nextInt() ;leitor.nextLine();
				System.out.print("Tem Cabine (s/n)? ");
				String resposta = leitor.nextLine();
				boolean temCabine = resposta.equalsIgnoreCase("s");
				frota [i] = new Barco(nome, marca, qtdPassageiros, calado, deslocamento, tipoAgua, comprimento, qtdMotores, temCabine);
			}
		}
		
		System.out.println("\n\n======= EXECUTANDO MOVIMENTOS DA FROTA =======");
		for (Veiculo veiculo : frota) {
			if (veiculo != null) {
				veiculo.andar();
				System.out.println("----------------------------------------------");
			}
		}
		System.out.println("Programa finalizado");
		leitor.close();
	}
}
