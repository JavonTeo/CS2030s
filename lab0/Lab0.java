import java.util.Scanner;

/**
 * CS2030S Lab 0: Estimating Pi with Monte Carlo
 * Semester 2, 2021/22
 *
 * <p>This program takes in two command line arguments: the 
 * number of points and a random seed.  It runs the
 * Monte Carlo simulation with the given argument and print
 * out the estimated pi value.
 *
 * @author Javon Teo (Group 14J) 
 */

class Lab0 {

  // TODO 
  public static double estimatePi(int numOfPoints, int seed) {
	Circle c = new Circle(new Point(0.5, 0.5), 0.5);
	double n = 0.0;
	RandomPoint tmp = new RandomPoint(0.0, 1.0, 0.0, 1.0);
	RandomPoint.setSeed(seed);
	for (int i = 0; i < numOfPoints; i++) {
		RandomPoint RPoint = new RandomPoint(0.0, 1.0, 0.0, 1.0);
		boolean withinC = c.contains(RPoint);
		if (withinC) {
			n += 1.0;
		}
	}
	double k =  numOfPoints;
	return (4*n) / k;
   }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numOfPoints = sc.nextInt();
    int seed = sc.nextInt();

    double pi = estimatePi(numOfPoints, seed);

    System.out.println(pi);
    sc.close();
  }
}
