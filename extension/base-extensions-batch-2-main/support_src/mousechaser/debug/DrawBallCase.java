package mousechaser.debug;

import javax.swing.Icon;

import edu.princeton.cs.introcs.StdDraw;
import mousechaser.ChaseTheMouse;
import support.cse131.DrawCase;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DrawBallCase implements DrawCase {
	private final double x;
	private final double y;
	private final double radius;

	public DrawBallCase(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public double x() {
		return x;
	}

	public double y() {
		return y;
	}

	public double radius() {
		return radius;
	}

	@Override
	public String getText() {
		return String.format(
				"<html>Does the screen show a single black circle at (%s, %s) of radius: %s?<br/><br/>Note: we have outlined where the circle should be in yellow and red<br/>and added crosshairs at this location.</html>",
				x, y, radius);
	}

	@Override
	public void draw() {
		StdDraw.setPenColor(0, 0, 0);
		ChaseTheMouse.drawBall(new double[] { x, y }, radius);
	}

	@Override
	public Icon getIcon() {
		return null;
	}
}
