package br.com.java.calculadora;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Interfacee {

	public static void main(String[] args) {

		JFrame janela = new JFrame("Calculator By Me(Malens)");

		Calculadora calculadora = new Calculadora();
		OperacaoCalc operacao = new OperacaoCalc();
		FormatadorResultado formatador = new FormatadorResultado();

		janela.setSize(300, 300);
		janela.setResizable(false); 



		JPanel principal = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		principal.setBackground(new Color(30, 30, 30));
		janela.add(principal);

		JTextField visor = new JTextField(10);
		visor.setFont(new Font("Arial", Font.PLAIN, 32));
		visor.setForeground(Color.WHITE);
		visor.setBackground(new Color(20, 20, 20));
		visor.setHorizontalAlignment(SwingConstants.RIGHT);
		visor.setEditable(false);
		visor.setBorder(
				BorderFactory.createMatteBorder( 0, 0, 2, 0, new Color(200, 3, 11)));
		visor.setPreferredSize(new Dimension(450, 70));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.insets = new Insets(15, 15, 15, 15);
		principal.add(visor, gbc);

		//Botões 

		JPanel botoes = new JPanel(new GridLayout(0, 4, 5, 5));
		botoes.setOpaque(false);
		GridBagConstraints gbcBotoes = new GridBagConstraints();
		gbcBotoes.gridx = 0;
		gbcBotoes.gridy = 1;
		gbcBotoes.weightx = 1.0;
		gbcBotoes.weighty = 0;
		gbcBotoes.fill = GridBagConstraints.HORIZONTAL;
		gbcBotoes.anchor = GridBagConstraints.CENTER;
		gbcBotoes.insets = new Insets(5, 5, 5, 5);
		principal.add(botoes, gbcBotoes);

		BotCalc numero1 = new BotCalc("1");
		botoes.add(numero1);

		BotCalc numero2 = new BotCalc("2");
		botoes.add(numero2);

		BotCalc numero3 = new BotCalc("3");
		botoes.add(numero3);

		BotCalc soma = new BotCalc("+");

		soma.addActionListener( e ->{
			
			if(visor.getText().isEmpty() || visor.getText().equals("ERRO")) {
				return;
			}
			calculadora.setNumero1(Double.parseDouble(visor.getText()));
			calculadora.setOperador("+");
			visor.setText("");
		});

		botoes.add(soma);

		BotCalc numero4 = new BotCalc("4");
		botoes.add(numero4);

		BotCalc numero5 = new BotCalc ("5");
		botoes.add(numero5);

		BotCalc numero6 = new BotCalc ("6");
		botoes.add(numero6);

		BotCalc subt = new BotCalc ("-");
		subt.addActionListener(e ->{
			
			if(visor.getText().isEmpty() || visor.getText().equals("ERRO")) {
				return;
			}
			calculadora.setNumero1(Double.parseDouble(visor.getText()));
			calculadora.setOperador("-");
			visor.setText("");
		});
		botoes.add(subt);

		BotCalc numero7 = new BotCalc("7");
		botoes.add(numero7);

		BotCalc numero8 = new BotCalc ("8");
		botoes.add(numero8);

		BotCalc numero9 = new BotCalc ("9");
		botoes.add(numero9);

		BotCalc multip = new BotCalc ("X");

		multip.addActionListener(e ->{
			
			if(visor.getText().isEmpty() || visor.getText().equals("ERRO")) {
				return;
			}

			calculadora.setNumero1(Double.parseDouble(visor.getText()));
			calculadora.setOperador("X");
			visor.setText("");
		});
		botoes.add(multip);

		BotCalc ponto = new BotCalc(".");

		ponto.addActionListener(e -> {
			if (visor.getText().contains(".")) {
				if (visor.getText().isEmpty()) {
					visor.setText("0.");
				} else {
					visor.setText(visor.getText() + ".");
				}
			}
		});

		botoes.add(ponto);

		BotCalc numero0 = new BotCalc ("0");
		botoes.add(numero0);

		BotCalc two00 = new BotCalc("00");
		botoes.add(two00);

		BotCalc div = new BotCalc ("÷");

		div.addActionListener( e ->{
			
			if(visor.getText().isEmpty() || visor.getText().equals("ERRO")) {
				return;
			}

			calculadora.setNumero1(Double.parseDouble(visor.getText()));
			calculadora.setOperador("÷");
			visor.setText("");

		});
		botoes.add(div);
		
		BotCalc porc = new BotCalc("%");
		
			porc.addActionListener(e -> {
				
				if(visor.getText().isEmpty() || visor.getText().equals("ERRO")) {
					return;
				}
				double resultado = 0;
				
				if(calculadora.getOperador() != null) {
					
					double numero = Double.parseDouble(visor.getText());
					resultado = operacao.porcentagem(
							calculadora.getNumero1(), 
							numero
							);
					calculadora.setNumero2(resultado);
					visor.setText(String.valueOf(resultado));
					visor.setText(formatador.formatar(resultado));
				}});
			
		botoes.add(porc);
		
		BotCalc raiz = new BotCalc("√");
			raiz.addActionListener(e -> {
				
				if(visor.getText().isEmpty() || visor.getText().equals("ERRO")) {
					return;
				}
				
				double numero = Double.parseDouble(visor.getText());
				double resultado = operacao.raiz(numero);
				visor.setText(formatador.formatar(resultado));
			});
		botoes.add(raiz);

		BotCalc igual = new BotCalc ("=");
		igual.addActionListener(e ->{
			
			if(calculadora.getOperador() == null) {
				visor.setText("ERRO");
				return;
			}
			if(visor.getText().isEmpty()) {
				visor.setText("ERRO");	
				return;
			}

			calculadora.setNumero2(Double.parseDouble(visor.getText()));

			double resultado = 0;
			
			switch(calculadora.getOperador()) {
				case "+":
					resultado = operacao.somar(calculadora.getNumero1(), calculadora.getNumero2());
					break;
				
				case "-":
					resultado = operacao.subtrair(calculadora.getNumero1(), calculadora.getNumero2());
					break;
					
				case "X":
					resultado = operacao.multiplicar(calculadora.getNumero1(), calculadora.getNumero2());
					break;
					
				case "÷":
					resultado = operacao.dividir(calculadora.getNumero1(),calculadora.getNumero2());
					break;
			}
			if(Double.isNaN(resultado)) {
				visor.setText("ERRO");
			}else{visor.setText(formatador.formatar(resultado));}

		});
		botoes.add(igual);

		BotCalc limp = new BotCalc ("C");
		limp.addActionListener(e -> { 
			visor.setText("");
		});
		botoes.add(limp);
		
		numero1.addActionListener( e -> adicionarDigito(visor, "1"));
		numero2.addActionListener( e -> adicionarDigito(visor, "2"));
		numero3.addActionListener( e -> adicionarDigito(visor, "3"));
		numero4.addActionListener( e -> adicionarDigito(visor, "4"));
		numero5.addActionListener( e -> adicionarDigito(visor, "5"));
		numero6.addActionListener( e -> adicionarDigito(visor, "6"));
		numero7.addActionListener( e -> adicionarDigito(visor, "7"));
		numero8.addActionListener( e -> adicionarDigito(visor, "8"));
		numero9.addActionListener( e -> adicionarDigito(visor, "9"));
		numero0.addActionListener( e -> adicionarDigito(visor, "0"));
		two00.addActionListener( e -> adicionarDigito(visor, "00"));
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

	private static void adicionarDigito(JTextField visor, String digito) {
		if(visor.getText().equals("ERRO")) {
			visor.setText(digito);
		}else{ visor.setText(visor.getText() + digito );}		
		}

}
