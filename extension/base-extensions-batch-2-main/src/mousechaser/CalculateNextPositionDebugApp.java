package mousechaser;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.Timing;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class CalculateNextPositionDebugApp {
	public static void main(String[] args) {
		StdDraw.enableDoubleBuffering();
		double[] p0 = { 0.5, 0.5 };
		double radius = 0.01;
		double desiredMaxVectorLength = 0.25;
		Color BALL_COLOR = Color.BLACK;
		Color BOUNDARY_COLOR = new Color(146, 0, 0);
		Color VECTOR_COLOR = new Color(0, 73, 73);
		double tPrev = Timing.getCurrentTimeInSeconds();
		while (!StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)) {
			double tCurr = Timing.getCurrentTimeInSeconds();
			double tDelta = tCurr - tPrev;
			if(tDelta > 0.0) {
				StdDraw.clear();
				StdDraw.setPenColor(BALL_COLOR);
				ChaseTheMouse.drawBall(p0, radius);
				StdDraw.setPenColor(BOUNDARY_COLOR);
				StdDraw.circle(p0[0], p0[1], desiredMaxVectorLength);
				double[] mousePosition = ChaseTheMouse.getMousePosition();
				double speedNecessaryToAchieveDesiredMaxVectorLength = desiredMaxVectorLength / tDelta;
				double[] p1 = ChaseTheMouse.calculateNextPosition(p0, mousePosition,
						speedNecessaryToAchieveDesiredMaxVectorLength, tDelta);
				StdDraw.setPenColor(VECTOR_COLOR);
				StdDraw.line(p0[0], p0[1], p1[0], p1[1]);
				StdDraw.show();
				tPrev = tCurr;
			}
			StdDraw.pause(10);
		}
		System.exit(0);
	}
}
