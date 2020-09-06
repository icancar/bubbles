package zadatak3;

import java.awt.Color;

public class Balon extends KruznaFigura {

	public Balon(Vektor v, Color b, double r, Vektor brzina, Scena s) {
		super(v, b, r, brzina, s);
	}

	@Override
	public void sudarilaSe() {
		boja=Color.BLACK;
	}

}
