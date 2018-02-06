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
		if (positionY <=-40) {
			boy.color = Color.green;
			
		} else {
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
	}
	public static void main (String[] args) {
		SimulationControl.createApp(new BungeeSimulation());
	}

}
