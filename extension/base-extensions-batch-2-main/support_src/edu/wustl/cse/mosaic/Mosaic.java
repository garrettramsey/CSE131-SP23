package edu.wustl.cse.mosaic;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public interface Mosaic {
	void draw(double x, double y);

	Bounds2D getBounds();
}
