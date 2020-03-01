
public class Vector {
	final double x;
	final double y;
	final double z;
	final double len;

	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		len = Math.sqrt(x * x + y * y + z * z);
	}
	
	public Vector() {
		this(0, 0, 0);
	}

	public static Vector scale(double scalar, Vector v) {
		return new Vector(scalar * v.x, scalar * v.y , scalar * v.z);
	}

	public static Vector unit(Vector v) {
		return new Vector(v.x / v.len, v.y / v.len, v.z / v.len);
	}

	public static Vector add(Vector v1, Vector v2) {
		return new Vector(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
	}

	public static Vector subtract(Vector v1, Vector v2) {
		return add(v1, scale(-1, v2));
	}
	
	public static double distance(Vector v1, Vector v2) {
		return subtract(v1, v2).len;
	}

	public static Vector dot(Vector v1, Vector v2) {
		return new Vector(v1.x * v2.x, v1.y * v2.y, v1.z * v2.z);
	}

	public static Vector cross(Vector v1, Vector v2) {
		return new Vector(v1.y * v2.z - v1.z * v2.y, 
				v1.z * v2.x - v1.x * v2.z, 
				v1.x * v2.y - v1.y * v2.x);
	}
}
