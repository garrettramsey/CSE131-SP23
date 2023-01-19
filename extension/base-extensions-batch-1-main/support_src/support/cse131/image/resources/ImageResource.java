package support.cse131.image.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.function.Supplier;

import javax.imageio.ImageIO;

import support.cse131.Lazy;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public enum ImageResource implements Supplier<BufferedImage> {
	WASHU_BEAR, YOU_BELONG_HERE, RON_CYTRON, MCKELVEY_HALL;

	private final Lazy<BufferedImage> lazy = new Lazy<>(() -> {
		return readImageResource(name().toLowerCase() + ".png");
	});

	@Override
	public BufferedImage get() {
		return lazy.get();
	}

	private static BufferedImage readImageResource(String resourceName) {
		try {
			return ImageIO.read(ImageResource.class.getResource(resourceName));
		} catch (IOException ioe) {
			throw new RuntimeException(resourceName, ioe);
		}
	}
}
