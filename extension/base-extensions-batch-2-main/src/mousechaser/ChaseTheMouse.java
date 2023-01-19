package mousechaser;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.NotYetImplementedException;
import support.cse131.Timing;

public class ChaseTheMouse {
	private static final int X = 0;
	private static final int Y = 1;

	/**
	 * @return the current x and y coordinates of the mouse
	 */
	public static double[] getMousePosition() {
		
			// Delete the line below
			throw new NotYetImplementedException();
			// Return the current mouse position as specified in the write up
		
	}

	/**
	 * Draw a ball of radius r at the specified location
	 * 
	 * @param location the x and y coordinate for the ball
	 * @param radius   the radius of the ball
	 */
	public static void drawBall(double[] location, double radius) {
		
			// Delete the line below
			throw new NotYetImplementedException();
			// Draw the ball here as specified in the write up
		
	}

	/**
	 * @param v value
	 * @return v^2
	 */
	public static double square(double v) {
		
			// Delete the line below
			throw new NotYetImplementedException();
			// Return v squared
		
	}

	/**
	 * @param xy vector in 2D space
	 * @return magnitude of xy
	 */
	public static double calculateMagnitude(double[] xy) {
		
			// Delete the line below
			throw new NotYetImplementedException();
			// Return the magnitude of xy
		
	}

	/**
	 * @param a vector in 2D space
	 * @param b vector in 2D space
	 * @return a + b
	 */
	public static double[] add(double[] a, double[] b) {
		
			// Delete the line below
			throw new NotYetImplementedException();
			// Return a+b
		
	}

	/**
	 * @param a vector in 2D space
	 * @param b vector in 2D space
	 * @return a - b
	 */
	public static double[] subtract(double[] a, double[] b) {
		
			// Delete the line below
			throw new NotYetImplementedException();
			// Return a-b
		
	}

	/**
	 * @param xy     vector in 2D space
	 * @param scalar
	 * @return xy * scalar
	 */
	public static double[] scalarMultiply(double[] xy, double scalar) {
		
			// Delete the line below
			throw new NotYetImplementedException();
			// Return xy*scalar
		
	}

	/**
	 * 
	 * @param currentBallPosition the location of the ball currently
	 * @param mousePosition       the location of the mouse currently
	 * @param speed               the speed with which the ball should move toward
	 *                            the mouse
	 * @param deltaTime           the elapsed time
	 * @return the next location of the ball given its current position, the mouse's
	 *         position, the speed, and the time change
	 */
	public static double[] calculateNextPosition(double[] currentBallPosition, double[] mousePosition, double speed,
			double deltaTime) {
		
			// Delete the line below
			throw new NotYetImplementedException();
			// Return the next ball position as specified in the write up
		
	}

	/**
	 * Simulate a ball chasing the mouse.
	 */
	public static void chaseTheMouse() {
		
			// Delete the line below
			throw new NotYetImplementedException();
		
	}

	public static void main(String[] args) {
		chaseTheMouse();
	}
}
