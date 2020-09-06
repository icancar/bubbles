package zadatak3;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.*;

public class Igra extends Frame {
	private Scena scena;
	private Label poeni;
	
	public Igra() {
		super("Igra");
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
			}	
		});
		setBounds(700, 0, 750, 750);
		scena=new Scena(this);
		scena.addKeyListener(new KeyAdapter() {
		
			@Override
			public void keyPressed(KeyEvent arg0) {
				scena.pomeriIgraca(arg0);
			}
			
			
		});
		setFocusable(true);
		scena.requestFocus();
		scena.setBounds(700, 0, 750, 750);
		scena.dodajIgraca();
		scena.pokreni();
		
		add(scena, BorderLayout.CENTER);
		add(dodajNivoe(),BorderLayout.EAST);
		
		
		setVisible(true);
	}
	private Panel dodajNivoe() {
		Panel istok = new Panel(new GridLayout(8, 1, 10, 10));
		Label nivoi = new Label("Tezina: ");
		nivoi.setFont(new Font(null, Font.BOLD, 20));
		nivoi.setAlignment(Label.CENTER);
		istok.add(nivoi);
		poeni=new Label("Poeni: 0");
		poeni.setFont(new Font(null, Font.BOLD, 20));
		CheckboxGroup tezina = new CheckboxGroup();
		Checkbox easy = new Checkbox("Lako", tezina, true);
		Checkbox middle = new Checkbox("Srednje", tezina, false);
		Checkbox hard = new Checkbox("Tesko", tezina, false);
		istok.add(easy);
		istok.add(middle);
		istok.add(hard);
		istok.setBackground(Color.LIGHT_GRAY);
		istok.add(poeni);
		return istok;
	}
	public Label poeni() {return poeni;}
	public static void main(String[] arg) {
		new Igra();
	}
}
