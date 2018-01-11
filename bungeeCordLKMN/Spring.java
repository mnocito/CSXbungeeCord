package bungeeCordLKMN;

import org.opensourcephysics.display.Trail;

public class Spring {
	private double k;
	private double mass;
	private double deltaX;
	private double length;
	private Trail trail;
	private double X;
	public double getX() {
		return X;
	}
	public void setX(double x) {
		X = x;
	}
	public double getY() {
		return Y;
	}
	public void setY(double y) {
		Y = y;
	}
	private double Y;
	
	public double getK() {
		return k;
	}
	public void setK(double k) {
		this.k = k;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	public double getDeltaX() {
		return deltaX;
	}
	public void setDeltaX(double deltaX) {
		this.deltaX = deltaX;
	}
	public double getCurrentLength() {
		return length + deltaX;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	
}
