package bungeeCordLKMN;

import org.opensourcephysics.display.Circle;

public class Mass extends Circle {
	private double mass;
	private double v;
	private double a;
	private double l;


	public Mass (double mass, double v, double a, double y, double l) {
		this.mass = mass;
		this.v = v;
		this.a = a;
		this.l = l;
	}
	public double getLength() {
		return l;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	public double getV() {
		return v;
	}
	public void setV(double v) {
		this.v = v;
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}

	
}
