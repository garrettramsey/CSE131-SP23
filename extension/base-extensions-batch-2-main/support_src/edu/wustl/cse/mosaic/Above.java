package edu.wustl.cse.mosaic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class Above implements Mosaic {
	private final List<Mosaic> reversedPictures;

	public Above(Mosaic top, Mosaic next, Mosaic[] other) {
		reversedPictures = new ArrayList<>(2 + other.length);
		reversedPictures.add(top);
		reversedPictures.add(next);
		reversedPictures.addAll(Arrays.asList(other));
		Collections.reverse(reversedPictures);
	}

	@Override
	public Bounds2D getBounds() {
		Bounds2D bounds = reversedPictures.get(0).getBounds();
		for (Mosaic picture : reversedPictures.subList(1, reversedPictures.size())) {
			bounds = bounds.union(picture.getBounds().translate(0, bounds.height()));
		}
		return bounds;
	}

	@Override
	public void draw(double x, double y) {
		Bounds2D bounds = getBounds();
		for (Mosaic picture : reversedPictures) {
			Bounds2D pictureBounds = picture.getBounds();
			double xOffset = (bounds.width() - pictureBounds.width()) / 2.0;
			picture.draw(x + xOffset, y);
			y += pictureBounds.height();
		}
	}
}
