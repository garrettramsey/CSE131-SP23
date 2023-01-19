package mousechaser;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class MousePositionDebugApp {
	public static void main(String[] args) {
		StdDraw.enableDoubleBuffering();
		double xPrev = StdDraw.mouseX();
		double yPrev = StdDraw.mouseY();

		final int X = 0;
		final int Y = 1;
		final int EXPECTED = 0;
		final int ACTUAL = 1;
		final Color CORRECT_COLOR = Color.BLACK;
		final Color INCORRECT_COLOR = new Color(144, 0, 0);
		final double RADIUS = 0.01;
		List<double[][]> expectedAndActualMousePositions = new LinkedList<>();
		while (!StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)) {
			double xPreInvocation = StdDraw.mouseX();
			double yPreInvocation = StdDraw.mouseY();

			if (xPrev != xPreInvocation || yPrev != yPreInvocation) {
				double[] actual = ChaseTheMouse.getMousePosition();

				if (actual == null) {
					System.err.print("null");
					System.exit(-1);

				}
				if (actual.length != 2) {
					System.err.print("array.length: " + actual.length);
					System.exit(-1);
				}

				double xPostInvocation = StdDraw.mouseX();
				double yPostInvocation = StdDraw.mouseY();

				if (xPreInvocation == xPostInvocation && yPreInvocation == yPostInvocation) {
					double[][] positions = { { xPostInvocation, yPostInvocation }, actual };
					if (!isWithinReasonableDelta(positions)) {
						System.err.println(String.format("expected: (%f, %f); actual: (%f, %f)", positions[EXPECTED][X],
								positions[EXPECTED][Y], positions[ACTUAL][X], positions[ACTUAL][Y]));
					}
					expectedAndActualMousePositions.add(positions);
				}
				xPrev = xPostInvocation;
				yPrev = yPostInvocation;
			}

			StdDraw.clear();
			for (double[][] positions : expectedAndActualMousePositions) {
				if (isWithinReasonableDelta(positions)) {
					StdDraw.setPenColor(CORRECT_COLOR);
				} else {
					StdDraw.setPenColor(INCORRECT_COLOR);
					double x = positions[ACTUAL][X];
					double y = positions[ACTUAL][Y];
					double v = RADIUS * 2;
					StdDraw.line(x - v, y - v, x + v, y + v);
					StdDraw.line(x - v, y + v, x + v, y - v);
				}
				StdDraw.filledCircle(positions[ACTUAL][X], positions[ACTUAL][Y], RADIUS);
			}
			StdDraw.text(0.5, 0.95,
					String.format("Move mouse in window to test getMousePosition()"));
			StdDraw.text(0.5, 0.9, "Press Escape key to exit.");
			StdDraw.show();
			StdDraw.pause(10);
		}
		System.exit(0);
	}

	private static boolean isWithinReasonableDelta(double[][] positions) {
		return isWithinReasonableDelta(positions[0][0], positions[1][0])
				&& isWithinReasonableDelta(positions[0][1], positions[1][1]);
	}

	private static boolean isWithinReasonableDelta(double a, double b) {
		final double REASONABLE_DELTA = 0.0001;
		return Math.abs(a - b) < REASONABLE_DELTA;
	}
}
