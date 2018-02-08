package bungeeCordLKMN;

public class BungeeCord {
	int n; //number of sections of bungee cord
	double mass;//mass of the bungee cord
	double length; //length of the bungee cord
	double k; //k of the overall bungee cord
	Mass[] masses = new Mass[n]; //array of masses
	double g = -9.81;
	
	public double getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
		masses = new Mass[n];
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
	public double getSpringK() {
		return n*k;
	}
	public double getInitialSpringLength() {
		return length / n;
	}
	public void updateAccelerations() {
		for (int i = 1; i < n; i++) {
			masses[i].setA(((masses[i].getMass() * g) - (n * k * (Math.abs(masses[i].getY() - masses[i - 1].getY()) - getInitialSpringLength())) + (n * k * Math.abs(masses[i].getY() - masses[i - 1].getY()) - getInitialSpringLength())) / masses[i].getMass());
		}
	}
	public void updateVelocities(double timestep) {
		for (int i = 0; i < n; i++) {
			masses[i].setV(masses[i].getV() + masses[i].getA() * timestep);
		}
	}
	public void updatePositions(double timestep) {
		for (int i = 0; i < n; i++) {
			masses[i].setXY(0, masses[i].getY() + masses[i].getV() * timestep);
		}
	}
	
}
