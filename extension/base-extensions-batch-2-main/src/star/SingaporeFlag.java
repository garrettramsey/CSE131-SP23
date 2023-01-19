package star;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class SingaporeFlag {
	private static void mother() {
		StdDraw.clear();
		StdDraw.setPenColor(255, 0, 0);
		StdDraw.filledRectangle(3, 3, 3, 3);
		StdDraw.filledRectangle(3, 13, 3, 3);
		StdDraw.filledRectangle(16, 3, 6, 3);
		StdDraw.filledRectangle(16, 13, 6, 3);
		StdDraw.setPenColor(0, 0, 127);
		StdDraw.filledRectangle(11, 8, 11, 1);
		StdDraw.filledRectangle(8, 8, 1, 8);
	}

	public static void indonesia() {
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(9, 11);
		mother();
	}

	public static void main(String[] args) {
		StdDraw.setCanvasSize(600, 400);

		indonesia();

		StdDraw.setXscale(-1.5, 1.5);
		StdDraw.setYscale(-1.0, 1.0);

		double xCrescent = -0.75;
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.filledCircle(xCrescent, 0.5, 0.3);
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledCircle(xCrescent + 0.1, 0.5, 0.28);

		StdDraw.setPenColor(Color.WHITE);
		double xCenterOfStars = xCrescent + 0.2;
		double yCenterOfStars = 0.5;

		double starRadius = 0.07;
		double starDistance = 0.15;
		double theta = Math.PI / 2.0;
		for (int i = 0; i < 5; ++i) {
			double x = xCenterOfStars + Math.cos(theta) * starDistance;
			double y = yCenterOfStars + Math.sin(theta) * starDistance;
			Star.filledOddPointedStar(x, y, starRadius, 5, Math.PI / 2);
			theta += Math.PI * 2.0 / 5;
		}
	}
}
