package zadatak3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Scena extends Canvas implements Runnable {

	private Igra igra;
	private boolean radi = false;
	private Thread nit;
	private Igrac igrac;
	private boolean dozvoljenIgrac = true;
	private int poeni = 0;
	private List<KruznaFigura> figure;

	public Scena(Igra i) {
		igra = i;
		nit = new Thread(this);
		figure = new ArrayList<>();
		// dodajIgraca();
		nit.start();
	}

	public void dodajIgraca() {
		Vektor polozaj = new Vektor(this.getWidth() / 2, this.getHeight() - 0.1 * this.getHeight());
		Vektor brzina = new Vektor(1, 1);
		igrac = new Igrac(polozaj, 30, brzina, this);
		// figure.add(igrac);
	}

	public synchronized void pokreni() {
		radi = true;
		notify();
	}

	@Override
	public void run() {
		try {
			synchronized (this) {
				while (!radi)
					wait();
			}
			boolean poklopljena = false;
			while (!poklopljena) {

				Thread.sleep(60);
				double rand = Math.random();
				if (rand < 0.1) { // generisanje balona
					int x = (int) (Math.random() * this.getWidth());
					Vektor polozaj = new Vektor(x, 10);
					Vektor brzina = new Vektor(0, 2);
					Balon b = new Balon(polozaj, Color.RED, 20, brzina, this);
				}
				for (int i1 = 1; i1 < figure.size(); i1++) {
					figure.get(i1).protekaoPeriod();
				}
				double rand2=Math.random();
				if (rand2 < 0.05) { // generisanje balona
					int x = (int) (Math.random() * this.getWidth());
					Vektor polozaj = new Vektor(x, 10);
					Vektor brzina = new Vektor(0, 2);
					Lopta b = new Lopta(polozaj, Color.BLUE, 20, brzina, this);
				}
				provjeriPoklapanje();
				azurirajLabelu();
				repaint();
			}
		} catch (InterruptedException g) {
		}

	}

	private void azurirajLabelu() {
		igra.poeni().setText("Poeni: " + poeni);

	}

	private void provjeriPoklapanje() {
		for (int i = 1; i < figure.size(); i++) {
			if (figure.get(i).preklapajuSe(figure.get(0))) {
				if (figure.get(i) instanceof Balon) {
					figure.remove(figure.get(i));
					nit.interrupt();
					dozvoljenIgrac = false;
				}
				else if(figure.get(i) instanceof Lopta) {
					figure.remove(figure.get(i));
					dodajPoene();
				}
			}
		}

	}

	private synchronized void dodajPoene() {
		poeni++;	
	}

	public synchronized void izbaci(KruznaFigura kruznaFigura) {
		for (int i = 0; i < figure.size(); i++) {
			if (figure.get(i).equals(kruznaFigura))
				figure.remove(kruznaFigura);
		}
		repaint();
	}

	public synchronized void dodajFiguru(KruznaFigura kr) {
		figure.add(kr);
		repaint();
	}

	public void zaustavi() {
		nit.interrupt();
	}

	public void pomeriIgraca(KeyEvent dog) {
		if (dozvoljenIgrac) {
			switch (dog.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				igrac.pomeri(-5);
				break;
			case KeyEvent.VK_RIGHT:
				igrac.pomeri(5);
				break;
			}
			repaint();
		}
	}

	@Override
	public void paint(Graphics g) {
		for (int i = 0; i < figure.size(); i++) {
			figure.get(i).Crtaj(this);
		}
	}

}
