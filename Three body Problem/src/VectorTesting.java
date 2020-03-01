import org.junit.Test;
import static org.junit.Assert.*;

public class VectorTesting {
	@Test
	public void vectorAttsTest() {
		Vector v1 = new Vector(-1, 2, -2);

		assertEquals(-1, v1.x, 0.01);
		assertEquals(2, v1.y, 0.01);
		assertEquals(-2, v1.z, 0.01);
		assertEquals(3, v1.len, 0.01);
	}
	@Test
	public void addVectorsTest() {
		Vector v1 = new Vector(1, 2, 3);
		Vector v2 = new Vector(-3, 4, -4);

		Vector v3 = Vector.add(v1, v2);
		assertEquals(-2, v3.x, 0.01);
		assertEquals(6, v3.y, 0.01);
		assertEquals(-1, v3.z, 0.01);
	}
	@Test
	public void crossTest() {
		Vector v1 = new Vector(5, 4, -1);
		Vector v2 = new Vector(15, 12, -3);
		
		Vector v3 = Vector.cross(v1, v2);
		assertEquals(0, v3.len, 0.01);
		
	}
}
