package edu.wustl.cse.mosaic;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

/**
 * Inspired by the Racket Image Library:
 * https://docs.racket-lang.org/teachpack/2htdpimage.html
 * 
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class Mosaics {
	public static Color BLACK = Color.BLACK;
	public static Color HONOLULU_BLUE = new Color(34, 113, 178);
	public static Color SUMMER_SKY = new Color(61, 183, 233);
	public static Color BARBIE_PINK = new Color(247, 90, 175);
	public static Color OCEAN_GREEN = new Color(53, 155, 115);
	public static Color BAMBOO = new Color(213, 94, 0);
	public static Color GAMBAGE = new Color(230, 159, 0);
	public static Color PARIS_DAISY = new Color(240, 228, 66);
	
	
	public static Mosaic above(Mosaic top, Mosaic next, Mosaic... other) {
		return new Above(top, next, other);
	}

	public static Mosaic beside(Mosaic left, Mosaic next, Mosaic... other) {
		return new Beside(left, next, other);
	}

	public static Mosaic overlay(Mosaic front, Mosaic next, Mosaic... other) {
		return new Overlay(front, next, other);
	}

	public static Mosaic emptyRectangle(double halfWidth, double halfHeight) {
		return new Rectangle(halfWidth, halfHeight, null, null);
	}

	public static Mosaic filledEquilateralTriangle(double halfSideLength, Color color) {
		return new EquilateralTriangle(halfSideLength, color, Mode.FILL);
	}

	public static Mosaic filledEquilateralTriangle(double halfSideLength) {
		return filledEquilateralTriangle(halfSideLength, null);
	}

	public static Mosaic outlinedEquilateralTriangle(double halfSideLength, Color color) {
		return new EquilateralTriangle(halfSideLength, color, Mode.OUTLINE);
	}

	public static Mosaic outlinedEquilateralTriangle(double halfSideLength) {
		return outlinedEquilateralTriangle(halfSideLength, null);
	}

	public static Mosaic filledRectangle(double halfWidth, double halfHeight, Color color) {
		return new Rectangle(halfWidth, halfHeight, color, Mode.FILL);
	}

	public static Mosaic filledRectangle(double halfWidth, double halfHeight) {
		return filledRectangle(halfWidth, halfHeight, null);
	}

	public static Mosaic outlinedRectangle(double halfWidth, double halfHeight, Color color) {
		return new Rectangle(halfWidth, halfHeight, color, Mode.OUTLINE);
	}

	public static Mosaic outlinedRectangle(double halfWidth, double halfHeight) {
		return outlinedRectangle(halfWidth, halfHeight, null);
	}

	public static Mosaic filledSquare(double halfSideLength, Color color) {
		return filledRectangle(halfSideLength, halfSideLength, color);
	}

	public static Mosaic filledSquare(double halfSideLength) {
		return filledRectangle(halfSideLength, halfSideLength);
	}

	public static Mosaic outlinedSquare(double halfSideLength, Color color) {
		return outlinedRectangle(halfSideLength, halfSideLength, color);
	}

	public static Mosaic outlinedSquare(double halfSideLength) {
		return outlinedRectangle(halfSideLength, halfSideLength);
	}

	public static Mosaic filledEllipse(double halfWidth, double halfHeight, Color color) {
		return new Ellipse(halfWidth, halfHeight, color, Mode.FILL);
	}

	public static Mosaic filledEllipse(double halfWidth, double halfHeight) {
		return filledEllipse(halfWidth, halfHeight, null);
	}

	public static Mosaic outlinedEllipse(double halfWidth, double halfHeight, Color color) {
		return new Ellipse(halfWidth, halfHeight, color, Mode.OUTLINE);
	}

	public static Mosaic outlinedEllipse(double halfWidth, double halfHeight) {
		return outlinedEllipse(halfWidth, halfHeight, null);
	}

	public static Mosaic filledCircle(double radius, Color color) {
		return filledEllipse(radius, radius, color);
	}

	public static Mosaic filledCircle(double radius) {
		return filledEllipse(radius, radius);
	}

	public static Mosaic outlinedCircle(double radius, Color color) {
		return outlinedEllipse(radius, radius, color);
	}

	public static Mosaic outlinedCircle(double radius) {
		return outlinedEllipse(radius, radius);
	}

	public static void showCentered(Mosaic picture, double portion) {
		StdDraw.enableDoubleBuffering();

		// TODO: account for canvas size

		Bounds2D bounds = picture.getBounds();
		double size = Math.max(bounds.width(), bounds.height());
		double amount = size * 1.0 / portion;
		double pad = (amount - size) / 2.0;

		double x0 = bounds.xMin() - pad;
		double y0 = bounds.yMin() - pad;
		StdDraw.setXscale(x0, x0 + amount);
		StdDraw.setYscale(y0, y0 + amount);

		Bounds2D translatedBounds = bounds.translate((size - bounds.width()) / 2.0, (size - bounds.height()) / 2.0);
		picture.draw(translatedBounds.xMin(), translatedBounds.yMin());
		StdDraw.show();
	}
}
