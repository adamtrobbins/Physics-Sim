
public class Client {
	
	public static void main(String[] args) {
		Body[] bodies = new Body[2];
		bodies[0] = new Body("Mercury", 1, new Vector(-10, 0, 0), new Vector(0, 1, 0));
		bodies[1] = new Body("Venus", 1, new Vector(10, 0, 0), new Vector(0, -1, 0));
		//bodies[2] = new Body("Earth", 1, new Vector(0, 7, 0));
		
		Simulation sim = new Simulation(0.10, 500, bodies);
		
		sim.run();
	}
}
