package br.com.java.calculadora;

public class FormatadorResultado {

	public String formatar(double resultado) {

		if (resultado == (int) resultado) {

			return String.valueOf((int)resultado);
		}

		return String.valueOf(resultado);
	}

}
