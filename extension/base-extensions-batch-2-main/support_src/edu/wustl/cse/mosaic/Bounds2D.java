package edu.wustl.cse.mosaic;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class Bounds2D {
	private final double xMin;
	private final double yMin;
	private final double xMax;
	private final double yMax;

	public Bounds2D(double xMin, double yMin, double xMax, double yMax) {
		super();
		this.xMin = xMin;
		this.yMin = yMin;
		this.xMax = xMax;
		this.yMax = yMax;
	}

	public double width() {
		return xMax - xMin;
	}

	public double height() {
		return yMax - yMin;
	}

	public double xMin() {
		return xMin;
	}

	public double yMin() {
		return yMin;
	}

	public double xMax() {
		return xMax;
	}

	public double yMax() {
		return yMax;
	}

	public Bounds2D translate(double x, double y) {
		return new Bounds2D(xMin + x, yMin + y, xMax + x, yMax + y);
	}

	public Bounds2D union(Bounds2D other) {
		return new Bounds2D(Math.min(xMin, other.xMin), Math.min(yMin, other.yMin), Math.max(xMax, other.xMax),
				Math.max(yMax, other.yMax));
	}
}
