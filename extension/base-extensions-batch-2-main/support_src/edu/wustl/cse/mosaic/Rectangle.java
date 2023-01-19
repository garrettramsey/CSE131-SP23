package edu.wustl.cse.mosaic;

import java.awt.Color;
import java.util.Optional;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class Rectangle implements Mosaic {
	private final double halfWidth;
	private final double halfHeight;
	private final Color color;
	private final Mode mode;

	public Rectangle(double halfWidth, double halfHeight, Color color, Mode mode) {
		this.halfWidth = halfWidth;
		this.halfHeight = halfHeight;
		this.color = color;
		this.mode = mode;
	}

	@Override
	public Bounds2D getBounds() {
		return new Bounds2D(0, 0, halfWidth * 2, halfHeight * 2);
	}

	@Override
	public void draw(double x, double y) {
		if(this.mode != null) {
			Optional<Color> prevColor;
			if (this.color != null) {
				prevColor = Optional.of(StdDraw.getPenColor());
				StdDraw.setPenColor(color);
			} else {
				prevColor = Optional.empty();
			}
			if (mode == Mode.FILL) {
				StdDraw.filledRectangle(x + halfWidth, y + halfHeight, halfWidth, halfHeight);
			} else {
				StdDraw.rectangle(x + halfWidth, y + halfHeight, halfWidth, halfHeight);
			}

			if (prevColor.isPresent()) {
				StdDraw.setPenColor(prevColor.get());
			}
		}
	}
}
