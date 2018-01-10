package bungeeCordLKMN;

public class BungeeCord {
	double n; //number of sections of bungee cord
	double mass;//mass of the bungee cord
	double length; //length of the bungee cord
	double k; //k of the overall bungee cord
	public double getN() {
		return n;
	}
	public void setN(double n) {
		this.n = n;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getK() {
		return k;
	}
	public void setK(double k) {
		this.k = k;
	}
	
	private double getIndividualK() {
		return 0;
	}
	
	
}
