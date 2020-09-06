package zadatak3;

public class Vektor {
	private double x, y;
	
	
	public Vektor(double x, double y) {
		this.x=x; 
		this.y=y;
	}
	
	public double x() {return x;}
	public double y() {return y;}
	
	public Vektor pomnozi(double y) {
		return new Vektor(this.x*y, this.y*y);
	}
	public Vektor saberi(Vektor v) {
		return new Vektor(this.x+v.x, this.y+v.y);
	}
	public Vektor clone() {
		return new Vektor(this.x, this.y);
	}
}
