package linearregression;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdDraw;

public class DebugAppRandomData {
	public static void main(String[] args) {
		double RADIUS = 0.02;
		Color POINT_COLOR = Color.BLACK;
		Color LINE_COLOR = Color.RED;
		StdDraw.enableDoubleBuffering();
		StdDraw.setPenRadius(0.007);
		Scanner in = new Scanner(System.in);
		int n = 2;
		try {
			while (true) {
				List<XY> xys = new ArrayList<>(n);
				for (int i = 0; i < n; ++i) {
					xys.add(new XY(Math.random(), Math.random()));
				}

				StdDraw.clear();
				StdDraw.setPenColor(POINT_COLOR);
				for (XY xy : xys) {
					StdDraw.filledCircle(xy.getX(), xy.getY(), RADIUS);
				}
				StdDraw.setPenColor(LINE_COLOR);
				if (n > 1) {
					PredictorBasedOnX predictor = PredictorUtils.learnPredictor(xys);
					StdDraw.line(0, predictor.predict(0), 1, predictor.predict(1));
				}
				StdDraw.show();
				System.out.println("How many points?");
				n = in.nextInt();
			}
		} catch (NumberFormatException nfe) {
			System.exit(0);
		}
	}
}
