package zadatak3;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends KruznaFigura {

	public Igrac(Vektor v,  double r, Vektor brzina, Scena s) {
		super(v, Color.GREEN, r, brzina, s);		
	}
	public void pomeri(double pom) {
		Vektor pomjeraj=new Vektor(pom, 0);
		Vektor privremeni=centar.saberi(pomjeraj);
		if((privremeni.x()+precnik/2)<scena.getWidth()&& (privremeni.x()-precnik/2)>=0) centar=privremeni;
	}
	@Override
	public void sudarilaSe() {
		scena.zaustavi();
	}
	@Override
	public void Crtaj(Scena s) {
		super.Crtaj(s);
		Graphics g=s.getGraphics();
		g.setColor(Color.BLUE);
		g.fillOval((int)(centar.x()-precnik/4), (int)(centar.y()-precnik/4), (int)precnik/2, (int)(precnik/2));
	}
}
