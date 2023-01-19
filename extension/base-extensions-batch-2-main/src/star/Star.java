package star;

import javax.swing.JOptionPane;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.DialogBoxes;
import support.cse131.NotYetImplementedException;
import support.cse131.Timing;

public class Star {
	/**
	 * @param numPoints number of points on star
	 * @returns revolutions required to complete a star with specified numPoints
	 */
	private static double calculateRevolutionsForPoints(int numPoints) {
		
			// Delete the line below and implement this method
			throw new NotYetImplementedException();
		
	}

	private static final double RADIANS_PER_REVOLUTION = 2.0 * Math.PI;

	/**
	 * @param numPoints number of points on star
	 * @returns radians required to complete a star with specified numPoints
	 */
	private static double calculateTotalThetaInRadians(int numPoints) {
		return calculateRevolutionsForPoints(numPoints) * RADIANS_PER_REVOLUTION;
	}

	/**
	 * Fills a star with an odd number of points.
	 * 
	 * @param xCenter         x-coordinate of the center of the star
	 * @param yCenter         y-coordinate of the center of the star
	 * @param radius          radius of the star
	 * @param numPoints       number of points on the star
	 * @param theta0InRadians start angle of the star in radians
	 * 
	 * @throws IllegalArgumentException if numPoints is even or less than 3.
	 */
	public static void filledOddPointedStar(double xCenter, double yCenter, double radius, int numPoints,
			double theta0InRadians) {
		if (numPoints % 2 == 0) {
			throw new IllegalArgumentException(String.format("numPoints must be odd; was: %d", numPoints));
		}
		if (numPoints < 3) {
			throw new IllegalArgumentException(String.format("numPoints must be >= 3; was: %d", numPoints));
		}

		
			//
			// FIXME Your code goes here
			//
		
	}

	public static void main(String args[]) {
		double revolutionsPerSecond = 0.5;
		Object[] options = { "Continue", "Exit" };
		StdDraw.enableDoubleBuffering();
		int nDelta = 2;

		outer: for (int n = 3; n < 12; n += nDelta) {
			for (double[] params : new double[][] { { 0.4, 0.3, 0.2 }, { 0.6, 0.7, 0.05 } }) {
				double time0 = Timing.getCurrentTimeInSeconds();
				double theta = 0.0;
				double x = params[0];
				double y = params[1];
				double radius = params[2];
				while (theta < RADIANS_PER_REVOLUTION) {
					StdDraw.clear();
					StdDraw.setPenColor(0, 0, 0); // BLACK
					StdDraw.circle(x, y, radius);
					StdDraw.setPenColor(36, 255, 36); // GREEN
					filledOddPointedStar(x, y, radius, n, theta);
					StdDraw.show();
					StdDraw.pause(10);
					double timeCurrent = Timing.getCurrentTimeInSeconds();
					double timeSinceStart = timeCurrent - time0;
					double revolutions = timeSinceStart * revolutionsPerSecond;
					theta = RADIANS_PER_REVOLUTION * revolutions;
				}

				String message = String.format(
						"<html>You should have seen a spinning green<br/><br/><pre>    oddPointedStar(%s, %s, %s, %d, theta)</pre><br/>perfectly fit inside a black circle</html>",
						x, y, radius, n);
				if (DialogBoxes.askUser(message, "Odd Pointed Star", JOptionPane.QUESTION_MESSAGE, options)) {
					// pass
				} else {
					break outer;
				}
			}
		}
		System.exit(0);
	}
}
