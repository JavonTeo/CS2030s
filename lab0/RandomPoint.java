import java.util.Random;
/** @author Javon Teo (Group 14J)
 */

// TODO
public class RandomPoint extends Point {
	private static Random rng = new Random(1);

	public RandomPoint(double minX, double maxX, double minY, double maxY) {
		super(rng.nextDouble()*(maxX - minX) + minX, rng.nextDouble()*(maxY - minY) + minY);
	}

	public static void setSeed(int s) {
		rng.setSeed(s);
	}
}
