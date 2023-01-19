package mousechaser;

import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;
import mousechaser.debug.DrawBallCase;
import mousechaser.debug.DrawBallCases;
import support.cse131.DialogBoxes;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DrawBallDebugApp {
	private static void drawCrosshair(double x, double y, double halfRadius) {
		StdDraw.line(x, y - halfRadius, x, y + halfRadius);
		StdDraw.line(x - halfRadius, y, x + halfRadius, y);
	}

	private static void draw(DrawBallCase drawBallCase) {
		double prevPenRadius = StdDraw.getPenRadius();
		StdDraw.setPenRadius();
		double defaultPenRadius = StdDraw.getPenRadius();
		StdDraw.setPenColor(144, 0, 0);
		StdDraw.setPenRadius(defaultPenRadius * 4);
		StdDraw.circle(drawBallCase.x(), drawBallCase.y(), drawBallCase.radius());
		StdDraw.setPenColor(0, 0, 0);
		drawBallCase.draw();
		StdDraw.setPenColor(255, 255, 0);
		StdDraw.setPenRadius();
		StdDraw.circle(drawBallCase.x(), drawBallCase.y(), drawBallCase.radius());
		StdDraw.setPenColor(144, 0, 0);
		drawCrosshair(drawBallCase.x(), drawBallCase.y(), drawBallCase.radius() * 2);
		StdDraw.show();
		StdDraw.setPenRadius(prevPenRadius);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			for (DrawBallCase drawCase : DrawBallCases.getCases()) {
				StdDraw.clear();
				draw(drawCase);
				if (!DialogBoxes.askUser(drawCase.getText())) {
					break;
				}
			}
			System.exit(0);
		});
	}
}
