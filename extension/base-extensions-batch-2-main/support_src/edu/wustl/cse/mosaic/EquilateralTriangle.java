package edu.wustl.cse.mosaic;

import java.awt.Color;
import java.util.Optional;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class EquilateralTriangle implements Mosaic {
	private final double sideLength;
	private final double height;
	private final Color color;
	private final Mode mode;

	public EquilateralTriangle(double halfSideLength, Color color, Mode mode) {
		this.sideLength = halfSideLength * 2;
		this.height = Math.sqrt(3) * sideLength / 2.0;
		this.color = color;
		this.mode = mode;
	}

	@Override
	public Bounds2D getBounds() {
		return new Bounds2D(0, 0, sideLength, height);
	}

	@Override
	public void draw(double x, double y) {
		double[] xs = { x, x + sideLength, x + sideLength / 2.0 };
		double[] ys = { y, y, y + height };
		Optional<Color> prevColor;
		if (this.color != null) {
			prevColor = Optional.of(StdDraw.getPenColor());
			StdDraw.setPenColor(color);
		} else {
			prevColor = Optional.empty();
		}
		if (mode == Mode.FILL) {
			StdDraw.filledPolygon(xs, ys);
		} else {
			StdDraw.polygon(xs, ys);
		}

		if (prevColor.isPresent()) {
			StdDraw.setPenColor(prevColor.get());
		}
	}
}
