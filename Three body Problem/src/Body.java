public class Body {
	private double mass;
	private Vector pos;
	private Vector velocity;
	private Vector netForce;
	private final String name;
	
	public Body(String name, double mass, Vector initPos, Vector initVelocity) {
		this.name = name;
		this.mass = mass;
		if (mass <= 0) {
			throw new IllegalArgumentException("Mass must be positive");
		}
		pos = initPos;
		velocity = initVelocity;
		netForce = new Vector();
	}
	
	public double getMass() {
		return mass;
	}
	
	public Vector getPos() {
		return pos;
	}
	
	public String toString() {
		return String.format("%s (Position: (%.3f, %.3f, %.3f) Mass: %.3f)", name,
				pos.x, pos.y, pos.z, mass);
	}
	
	public void addForce(Vector force) {
		netForce = Vector.add(netForce, force);
	}
	
	public void accelerate(double dt) {
		Vector acc = Vector.scale(1 / mass, netForce);
		velocity = Vector.add(velocity, Vector.scale(dt, acc));
		pos = Vector.add(pos, Vector.scale(dt, velocity));
		netForce = new Vector();
	}

}
