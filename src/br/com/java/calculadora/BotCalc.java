package br.com.java.calculadora;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BotCalc extends JButton {
	
	public BotCalc(String texto) {
		super(texto);
		setFocusPainted(false);
		setBorderPainted(false);
		setBackground(new Color(30, 30, 30));
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.BOLD, 20));
		
		addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(200, 3, 11));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(30, 30, 30));
			}
			
			
		});
		
	}
	
	

}
