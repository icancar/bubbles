package zadatak3;

import java.awt.Color;
import java.awt.Graphics;

public class Krug {
	protected Vektor centar;
	protected Color boja;
	protected double precnik;
	
	public Krug (Vektor v, Color b, double r) {
		centar=v;
		boja=b;
		precnik=r;
	}
	public boolean preklapajuSe(Krug k) {
		Vektor c1=k.centar;
		double razdaljina=Math.sqrt(Math.pow((centar.x()-c1.x()), 2)+ Math.pow((centar.y()-c1.y()), 2));
		return razdaljina<(this.precnik+k.precnik);
	}
	
	public void Crtaj(Scena s) {
		Graphics g=s.getGraphics();
		g.setColor(boja);
		g.fillOval((int)(centar.x()-precnik/2), (int)(centar.y()-precnik/2),(int)precnik ,(int) precnik);
	}
	
	
}
