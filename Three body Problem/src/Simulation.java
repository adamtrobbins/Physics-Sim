
public class Simulation {
	public static final double GRAV_CONST = 30;
	public static double time = 0;
	public final double DT;
	private final double TIME_LIMIT;
	private int PRINT_PERIOD;
	private int printCounter;
	private Body[] bodies;
	
	public Simulation(double timeInc, double TIME_LIMIT, Body[] bodies) {
		DT = timeInc;
		this.TIME_LIMIT = TIME_LIMIT;
		this.bodies = bodies;
		PRINT_PERIOD = 1;
		
	}
	
	public void run() {
		while (time < TIME_LIMIT) {
			incTime();
			if (checkCollisions()) {
				break;
			}
		}
	}
	
	private void incTime() {
		computeGravities();
		
		boolean stopPrint = false;
		
		for (Body b : bodies) {
			b.accelerate(DT);
			if (printCounter == PRINT_PERIOD) {
				System.out.print(b + " ");
				stopPrint = true;
			}
		}
		System.out.print(String.format("Time: %.2f", time));
		System.out.println();
		
		if (stopPrint) {
			printCounter = 0;
		}
		
		time += DT;
		printCounter++;
	}
	
	private void computeGravities() {
		for (Body b : bodies) {
			for (Body bx : bodies) {
				if (b != bx) {
					b.addForce(calcGravity(b, bx));
				}
			}
		}
	}
	
	//Force on B1
	private Vector calcGravity(Body b1, Body b2) {
		double r = Vector.distance(b1.getPos(), b2.getPos());
		double magnitude =  GRAV_CONST * b1.getMass() * b2.getMass() / (r * r);
		
		return Vector.scale(magnitude, Vector.unit(Vector.subtract(b2.getPos(), b1.getPos())));
	}
	
	private boolean checkCollisions() {
		for (Body b : bodies) {
			for (Body bx : bodies) {
				if (b != bx && Vector.distance(b.getPos(), bx.getPos()) < 0.5) {
					System.out.println(b + " and " + bx + " have collided!");
					return true;
				}
			}
		}
		return false;
	}
}
