package linearregression;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Tom Larsen
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DebugAppInteractive {
	public static void main(String[] args) {
		double RADIUS = 0.02;
		Color POINT_COLOR = Color.BLACK;
		Color LINE_COLOR = Color.RED;
		StdDraw.enableDoubleBuffering();
		StdDraw.setPenRadius(0.007);
		List<XY> points = new LinkedList<>();
		while (true) {
			StdDraw.clear();
			while (!StdDraw.isMousePressed()) {
				StdDraw.pause(20);
			}
			while (StdDraw.isMousePressed()) {
				StdDraw.pause(20);
			}
			double x = StdDraw.mouseX();
			double y = StdDraw.mouseY();

			if (StdDraw.isKeyPressed(KeyEvent.VK_SHIFT)) {
				Iterator<XY> iterator = points.iterator();
				while (iterator.hasNext()) {
					XY point = iterator.next();
					if (Math.hypot(x - point.getX(), y - point.getY()) < RADIUS) {
						iterator.remove();
					}
				}
			} else {
				points.add(new XY(x, y));
			}
			StdDraw.setPenColor(POINT_COLOR);
			for (XY xy : points) {
				StdDraw.filledCircle(xy.getX(), xy.getY(), RADIUS);
			}
			StdDraw.setPenColor(LINE_COLOR);
			if (points.size() > 1) {
				PredictorBasedOnX predictor = PredictorUtils.learnPredictor(points);
				double y0 = predictor.predict(0);
				double y1 = predictor.predict(1);
				StdDraw.line(0, y0, 1, y1);
			}
			StdDraw.show();
			StdDraw.pause(10);
		}
	}
}