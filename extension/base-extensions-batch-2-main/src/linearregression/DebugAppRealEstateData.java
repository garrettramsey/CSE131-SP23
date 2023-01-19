package linearregression;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;
import linearregression.io.AreaPriceFiles;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DebugAppRealEstateData {
	public static void main(String[] args) {
		Color POINT_COLOR = Color.BLACK;
		Color LINE_COLOR = Color.RED;
		StdDraw.enableDoubleBuffering();
		List<XY> xys = AreaPriceFiles.createXYsForBroward();
		StdDraw.clear();
		StdDraw.setPenColor(POINT_COLOR);
		double xMax = -Double.MAX_VALUE;
		double yMax = -Double.MAX_VALUE;
		for (XY xy : xys) {
			xMax = Math.max(xMax, xy.getX());
			yMax = Math.max(yMax, xy.getY());
		}
		StdDraw.setPenRadius(0.004);
		for (XY xy : xys) {
			StdDraw.point(xy.getX() / xMax, xy.getY() / yMax);
		}
		StdDraw.setPenRadius(0.007);
		StdDraw.setPenColor(LINE_COLOR);
		PredictorBasedOnX predictor = PredictorUtils.learnPredictor(xys);
		StdDraw.line(0, predictor.predict(0) / yMax, 1, predictor.predict(xMax) / yMax);
		StdDraw.show();

		while (true) {
			while (!StdDraw.isMousePressed()) {
				if (StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)) {
					System.exit(0);
				} else {
					// wait, do nothing
					StdDraw.pause(10);
				}
			}
			while (StdDraw.isMousePressed()) {
				// wait, do nothing
				StdDraw.pause(10);
			}
			double sqFeet = StdDraw.mouseX() * xMax;
			double price = predictor.predict(sqFeet);

			System.out.println(String.format("Real estate with %5d sq. feet in Broward has a predicted price of $%7d",
					Math.round(sqFeet), Math.round(price)));
		}
	}
}
