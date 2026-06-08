import java.util.Scanner;
public class CoversaoTemperatura {
	
	public static char pedeTipo(Scanner leitor){
		char tipo = ' ' ;
		boolean valido = false ;
		
		while (!valido) {
		System.out.println("Digite o caracter da escala de temperatura desejada C para Celsius, F de Fahrenheit e K de kelvin :");
		tipo = leitor.next().charAt(0);
		tipo = Character.toUpperCase(tipo);
		
			if (tipo =='K' || tipo =='F' || tipo == 'C') {
				valido = true ;			
			} else {
				System.out.println("O caracter digitado não é valido digite novamente.");
			}
			
		}
	
		return tipo;
		
	}
	
	public static double pedeTemp(char tipo , Scanner leitor) {
		double temp = 0 ;
		boolean valido = false ;
		
		while (!valido) {
			System.out.println("Digite a temperatura desejada: ");
			temp = leitor.nextDouble();
			
			if (tipo == 'K' && temp < 0){
				System.out.println("Temperatura invalida ! Não existe kelvin negativo digite novamente");
			} else if (tipo =='F' && temp < -459.67){
				System.out.println("Temperatura invalida ! Não existe temperatura menor que -459,67 °F digite novamente");
			} else if (tipo == 'C' && temp < -273.15) {
				System.out.println("Temperatura invalida ! Não existe temperatura menor que -273,15 °C negativo digite novamente");
			} else {
				valido = true ;
			}
		}
		return temp ;
	}
	
	public static void ConverteTemp(double temp , char tipo , char tipoDesejado){
		double tempConvertida = 0 ;
		if (tipo == tipoDesejado) {
			System.out.printf("Não há conversão pois as escalas são iguais logo %.2f continua igual \n" , temp);
			return ;
		}
		
		if (tipo == 'C' && tipoDesejado =='K') {
			tempConvertida = temp + 273.15;
			System.out.printf("%.2f °C convertido para Kelvin é %.2f K \n",temp,tempConvertida ) ;
			return;
		}else if (tipo == 'C' && tipoDesejado =='F'){
			tempConvertida =(temp * 1.8) + 32 ;
			System.out.printf("%.2f °C convertido para Fahrenheit é %.2f °F \n",temp,tempConvertida ) ;
			return ;
		}
		
		
		if (tipo=='F' && tipoDesejado =='C') {
			tempConvertida =(temp - 32) /1.8;
			System.out.printf("%.2f °F convertido para Celsius é %.2f °C \n",temp,tempConvertida ) ;
			return;
		} else if (tipo=='F' && tipoDesejado =='K'){
			tempConvertida = ((temp - 32) /1.8) + 273.15 ;
			System.out.printf("%.2f °F convertido para Kelvin é %.2f K \n",temp,tempConvertida ) ;
			return;
		}
		
		if (tipo == 'K' && tipoDesejado == 'C') {
			tempConvertida = temp - 273.15 ;
			System.out.printf("%.2f K convertido para Celsius é %.2f °C \n",temp,tempConvertida ) ;
			return;
		} else if (tipo == 'K' && tipoDesejado == 'F') {
			tempConvertida = ((temp - 273.15)* 1.8) + 32 ;
			System.out.printf("%.2f K convertido para Fahrenheit é %.2f °F \n",temp,tempConvertida ) ;
			return;
		}
		
	}
	
	public static void main (String[] args) {
		Scanner leitor = new Scanner(System.in);
		char tipo = ' ' , tipoDesejado = ' ';
		double temp = 0;
		int op = -1 ;
		
		tipo = pedeTipo(leitor) ;
		temp = pedeTemp(tipo, leitor);
		
		while (op!=0) {
			String s = (Character.toUpperCase(tipo) == 'K') ? "K" : "°" + Character.toUpperCase(tipo);
			
			System.out.println("------------------------------------------------------");
			System.out.println("--------------- Sistema de Conversor ---------------");
			
			System.out.printf("Temperatura atual: %.2f %s \n", temp, s);
			System.out.println("Selecione a opção desejada:");
			System.out.println("1 - Trocar escala e temperatura.");
			System.out.println("2 - Trocar temperatura na mesma escala.");

			
			System.out.printf("3 - Converter %.2f %s para Kelvin. \n", temp, s);
			System.out.printf("4 - Converter %.2f %s para Fahrenheit. \n", temp, s);
			System.out.printf("5 - Converter %.2f %s para Celsius. \n", temp, s);
			System.out.printf("0 - Para Sair\n");

			System.out.print("=> ");
			op = leitor.nextInt();
			System.out.println("------------------------------------------------------");
			
			switch (op) {
			case 0:
				System.out.println("Saindo ...");
				break;
			case 1:
				tipo = pedeTipo(leitor);
				temp = pedeTemp(tipo, leitor);
				break;
			case 2:
				temp = pedeTemp(tipo, leitor);
				break;	
			case 3:
				tipoDesejado ='K';
				ConverteTemp(temp, tipo, tipoDesejado);
				break;
			case 4:
				tipoDesejado ='F';
				ConverteTemp(temp, tipo, tipoDesejado);
				break;
			case 5:
				tipoDesejado ='C';
				ConverteTemp(temp, tipo, tipoDesejado);
				break;	
				
			default:
				System.out.println("Opção invalida!");
				break;
			}
		}
		
	}
}
