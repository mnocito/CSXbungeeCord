package bungeeCordLKMN;

import java.awt.Color;

import org.opensourcephysics.controls.*;
import org.opensourcephysics.display.*;
import org.opensourcephysics.frames.*;

public class BungeeSimulation extends AbstractSimulation {
	BungeeCord bungee = new BungeeCord();
	Trail bungeetrail = new Trail();
	DisplayFrame frame = new DisplayFrame( "X", "Height","Bungee Jump");
	Circle boy  = new Circle();
	double positionY = 0;
	double time = 0;
	double timestep  = 0.01;
	double g = -9.81;
	double n; //number of segments




	protected void doStep() {
		if (positionY <=-40) {
			boy.color = Color.green;

		} else {
			for (int i = 0; i < bungee.masses.length; i++) {
				bungee.masses[i].setY(bungee.masses[i].getY()+time*bungee.masses[i].getA());
			}
			boy.setY(positionY);
			positionY += g*time;
			bungeetrail.addPoint(0, positionY);
		}

		time+=timestep;

	}
	public void initialize() {
		frame.setVisible(true);
		frame.addDrawable(bungeetrail);
		frame.addDrawable(boy);
		bungeetrail.addPoint(0, 0);
		frame.setPreferredMinMax(-100, 100, -100, 100);

		for (int i = 0; i < n; i++) {
			bungee.masses[i] = new Mass(bungee.getMass()/n, 0, g, (bungee.getLength()/n)*i);
			frame.addDrawable(bungee.masses[i]);
		}

	}
	public static void main (String[] args) {
		SimulationControl.createApp(new BungeeSimulation());
	}

}
