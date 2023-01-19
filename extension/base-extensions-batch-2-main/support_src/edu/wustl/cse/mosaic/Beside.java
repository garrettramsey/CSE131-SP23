package edu.wustl.cse.mosaic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class Beside implements Mosaic {
	private final List<Mosaic> pictures;

	public Beside(Mosaic left, Mosaic next, Mosaic[] other) {
		this.pictures = new ArrayList<>(2 + other.length);
		this.pictures.add(left);
		this.pictures.add(next);
		this.pictures.addAll(Arrays.asList(other));
	}

	@Override
	public Bounds2D getBounds() {
		Bounds2D bounds = pictures.get(0).getBounds();
		for (Mosaic picture : pictures.subList(1, pictures.size())) {
			bounds = bounds.union(picture.getBounds().translate(bounds.width(), 0));
		}
		return bounds;
	}

	@Override
	public void draw(double x, double y) {
		Bounds2D bounds = getBounds();
		for (Mosaic picture : pictures) {
			Bounds2D pictureBounds = picture.getBounds();
			double yOffset = (bounds.height() - pictureBounds.height()) / 2.0;
			picture.draw(x, y + yOffset);
			x += pictureBounds.width();
		}
	}
}
