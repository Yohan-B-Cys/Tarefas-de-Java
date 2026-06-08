package exercicio2;

public class Bicicleta {

	int cadencia = 0;
	int velocidade = 0;
	int marcha = 1;
	
	
	
	public Bicicleta(int cadencia, int velocidade, int marcha) throws RPMInvalidoException, VelocidadeInvalidaException, MarchaInvalidaException {
		super();
		
		mudarCadencia(cadencia);
		this.velocidade = 0; 
		aumentarVelocidade(velocidade); 
		mudarMarcha(marcha);
	}
	void mudarCadencia(int novoValor) throws RPMInvalidoException{
	if (novoValor < 0) {
		throw new RPMInvalidoException("RPM INVALIDO " + novoValor);
	}	
	cadencia = novoValor;
	}
	void mudarMarcha(int novoValor) throws MarchaInvalidaException{
	if (novoValor < 1 || novoValor > 24) {
		throw new MarchaInvalidaException(this, novoValor);
	}	
	marcha = novoValor;
	}
	
	
	void aumentarVelocidade(int incremento) throws VelocidadeInvalidaException {
		if (incremento < 0 || (this.velocidade + incremento) > 100) {
			throw new VelocidadeInvalidaException ("Velocidade Invalida! O limite é 100. Tentativa: " + (this.velocidade + incremento)) ;
		}
		velocidade = velocidade + incremento;
	}
	void aplicarFreios(int decremento) throws VelocidadeInvalidaException {
	
		if (this.velocidade - decremento < 0) {
			throw new VelocidadeInvalidaException ("A velocidade não pode ficar negativa ao frear!");
		}
		velocidade = velocidade - decremento;
	}
	void printStates(){
	System.out.println("cadencia="+cadencia+" velocidade="+velocidade+"marcha="+marcha);
	}
}
