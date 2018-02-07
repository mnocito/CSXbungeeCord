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




	protected void doStep() {
//		if (positionY <=-40) {
//			boy.color = Color.green;
//
//		} else {
			for (int i = 0; i < bungee.masses.length; i++) {
				bungee.updateVelocities(timestep);
				bungee.updatePositions(timestep);
				bungee.updateAccelerations();
			}
		//	boy.setY(positionY);
			positionY += g*time;
			bungeetrail.addPoint(0, positionY);
//		}

		time+=timestep;

	}
	public void initialize() {
		frame.setVisible(true);
		frame.addDrawable(bungeetrail);
		frame.addDrawable(boy);
		bungeetrail.addPoint(0, 0);
		bungee.setN((int) control.getDouble("n"));
		frame.setPreferredMinMax(-100, 100, -100, 100);
		bungee.setLength(5);

//		Mass m = new Mass ( 4, 0 ,g);
//		frame.addDrawable(m);
//		m.setXY(0, 0);
		for (int i = 0; i < bungee.getN(); i++) {
			bungee.masses[i] = new Mass(bungee.getMass()/bungee.getN(), 0, g);
			frame.addDrawable(bungee.masses[i]);
			bungee.masses[i].setXY(0,-(bungee.getLength()/bungee.getN())*i);
		}

	}
	public void reset() {
		control.setAdjustableValue("n", 0);
	}
	public static void main (String[] args) {
		SimulationControl.createApp(new BungeeSimulation());
	}

}
