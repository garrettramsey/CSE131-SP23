package linearregression;

import support.cse131.NotYetImplementedException;

public class RegressionLine {

	//
	// Declare instance variables here
	//

	public RegressionLine() {
		// Perform any remaining initialization here, if necessary
	}

	/**
	 * Adds a point to the developing model
	 * 
	 * @param x the x coordinate of the point
	 * @param x the y coordinate of the point
	 */
	public void accept(double x, double y) {

		// Delete the line below and implement this method
		throw new NotYetImplementedException();

	}

	/**
	 * Adds a point to the developing model
	 * 
	 * @param point the point
	 */
	public void accept(XY point) {
		accept(point.getX(), point.getY());
	}

	/**
	 * 
	 * @return the slope of the line that best fits the data so far
	 */
	public double getSlope() {

		// Delete the line below and implement this method
		throw new NotYetImplementedException();

	}

	/**
	 * 
	 * @return the y-intercept of the line that best fits the data so far
	 */
	public double getIntercept() {

		// Delete the line below and implement this method
		throw new NotYetImplementedException();

	}

}