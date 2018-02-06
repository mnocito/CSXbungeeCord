package bungeeCordLKMN;

public class BungeeCord {
	int n; //number of sections of bungee cord
	double mass;//mass of the bungee cord
	double length; //length of the bungee cord
	double k; //k of the overall bungee cord
	Mass[] masses = new Mass[n]; //array of springs
	
	public double getN() {
		return n;
	}
	public void setN(int n) {
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
	
	private double getSpringK(double k, double n) {
		return n*k;
	}
	
}
