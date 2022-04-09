/**
 * CS2030S Lab 0: Point.java
 * Semester 2, 2021/22
 *
 * <p>The Point class encapsulates a point on a 2D plane.
 *
 * @author Javon Teo (Group 14J)
 */
import java.lang.Math;
public class Point {
  // TODO

  private double x;
  private double y;

  public Point(double x, double y) {
	this.x = x;
	this.y = y;
  }

public double getx() {
	return this.x;
}
public double gety() {
	return this.y;
}

  @Override
  public String toString() {
	  return "(" + this.x + ", " + this.y + ")";
  }

  public double CalcDist(Point p) {
	double px = p.getx();
	double py = p.gety();
	double distSq = Math.pow(this.x-px, 2.0) +  Math.pow(this.y-py, 2.0);
	return Math.sqrt(distSq);
  }
}
