package star;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class AustraliaFlagMinusUnionJack {
	// https://en.wikipedia.org/wiki/Flag_of_Australia#/media/File:Flag_of_Australia_template.svg

	private static void uprightStar(double x, double y, double radius, int numPoints) {
		Star.filledOddPointedStar(x, y, radius, numPoints, Math.PI / 2.0);
	}

	private static void crusis7(double x, double y) {
		uprightStar(x, y, 0.5 / 14.0, 7);
	}

	private static void commonwealthStar() {
		uprightStar(0.25, 0.125, 3.0/40.0, 7);
	}

	private static void alphaCrucis() {
		crusis7(0.75, 0.5 / 6.0);
	}

	private static void betaCrucis() {
		crusis7(5.0/8.0, 0.25);
	}

	private static void gammaCrucis() {
		crusis7(0.75, 2.5 / 6.0);
	}

	private static void deltaCrucis() {
		crusis7(31.0 / 36.0, 151.0 / 480.0);
	}

	private static void epsilonCrucis() {
		Star.filledOddPointedStar(0.8, 11.0 / 48.0, 1.0 / 48.0, 5, Math.PI / 2.0);
	}

	public static void main(String[] args) {
		StdDraw.setCanvasSize(600, 300);
		StdDraw.setXscale(0.0, 1.0);
		StdDraw.setYscale(0.0, 0.5);
		StdDraw.setPenColor(0, 0, 139);
		StdDraw.filledRectangle(0, 0, 1.5, 1.0);
		StdDraw.setPenColor(Color.WHITE);
		commonwealthStar();
		alphaCrucis();
		betaCrucis();
		gammaCrucis();
		deltaCrucis();
		epsilonCrucis();
	}
}
