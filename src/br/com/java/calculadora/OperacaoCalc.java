package br.com.java.calculadora;

public class OperacaoCalc {
	
	public double somar(double numero1, double numero2) {
		return numero1 + numero2;
	
	}
	public double subtrair(double numero1, double numero2) {
		return numero1 - numero2;
	
	}
	public double multiplicar(double numero1, double numero2) {
		return numero1 * numero2;
	}
	public double dividir(double numero1, double numero2) {
		
		if(numero2 == 0) {
			return Double.NaN;
		}
		
		return numero1 / numero2;
	}
	
	public double porcentagem(double numero1, double numero2) {
		return numero1 * (numero2 / 100);
	}
	
	public double raiz(double numero) {
		if(numero < 0) {
			return Double.NaN;
		}
		if(numero == 0) {
			return 0;
		}
		
		double estimativa = numero;
		
		for(int r = 1; r  < 10; r++) {
			estimativa = (estimativa + numero / estimativa) / 2;
		}
		return estimativa;
	}
	

}
