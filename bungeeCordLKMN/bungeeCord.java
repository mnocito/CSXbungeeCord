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
	public void update(double timestep) {
		masses[0].setV(masses[0].getV() + masses[0].getA() * timestep);
		masses[0].setXY(0, masses[0].getY() + masses[0].getV() * timestep);
		masses[0].setA(((masses[0].getMass() * g) + (n * k * (Math.abs(masses[1].getY() - masses[0].getY()) - getInitialSpringLength()))) / masses[0].getMass());
		for (int i = 1; i < n - 1; i++) {
			masses[i].setV(masses[i].getV() + masses[i].getA() * timestep);
			masses[i].setXY(0, masses[i].getY() + masses[i].getV() * timestep);
			masses[i].setA(((masses[i].getMass() * g) - (n * k * (Math.abs(masses[i].getY() - masses[i - 1].getY()) - getInitialSpringLength())) + (n * k * (Math.abs(masses[i + 1].getY() - masses[i].getY()) - getInitialSpringLength()))) / masses[i].getMass());
		}
		masses[n - 1].setV(masses[n - 1].getV() + masses[n - 1].getA() * timestep);
		masses[n - 1].setXY(0, masses[n - 1].getY() + masses[n - 1].getV() * timestep);
		masses[n - 1].setA(((masses[n - 1].getMass() * g) - (n * k * (Math.abs(masses[n - 1].getY() - masses[n - 2].getY()) - getInitialSpringLength()))) / masses[n - 1].getMass());
		
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
