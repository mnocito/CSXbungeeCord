package bungeeCordLKMN;

import org.opensourcephysics.display.Circle;

public class Mass extends Circle {
	private double mass;
	private double v;
	private double a;
	private double y;


	public Mass (double mass, double v, double a, double y) {
		this.mass = mass;
		this.v = v;
		this.a = a;
		this.y = y;
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
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
}
