package zadatak3;

import java.awt.Color;

public abstract class KruznaFigura extends Krug {
	protected Vektor brzina;
	protected Scena scena;
	
	public KruznaFigura(Vektor v, Color b, double r, Vektor brzina, Scena s) {
		super(v, b, r);
		this.brzina=brzina;
		scena=s;
		scena.dodajFiguru(this);
	}
	
	public void protekaoPeriod() {
		centar=centar.saberi(brzina	);
		if((centar.x()+precnik/2)>scena.getWidth() || (centar.y()+precnik/2)>scena.getHeight()) scena.izbaci(this);	
	}
	public abstract void sudarilaSe();
}
