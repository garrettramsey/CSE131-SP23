package support.cse131.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import support.cse131.color.resources.Colors;
import support.cse131.image.resources.ImageResource;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class BufferedImageSuppliers {
	private static enum BufferedImageSupplier implements Supplier<BufferedImage> {
		GRADIENT_5X7(Colors.get5x7ColorBlindFriendlyGradient()), CHIPS_5X3(Colors.get5x3ColorBlindFriendlyPalette()),
		CHIPS_3X5(Colors.get3x5ColorBlindFriendlyPalette());

		private final BufferedImage bufferedImage;

		private BufferedImageSupplier(Color[][] colors) {
			bufferedImage = BufferedImages.toBufferedImage(colors, BufferedImage.TYPE_INT_BGR);
		}

		@Override
		public BufferedImage get() {
			return bufferedImage;
		}
	}

	public static List<Supplier<BufferedImage>> asList() {
		List<Supplier<BufferedImage>> suppliers = new ArrayList<>(
				BufferedImageSupplier.values().length + ImageResource.values().length);
		suppliers.addAll(Arrays.asList(BufferedImageSupplier.values()));
		suppliers.addAll(Arrays.asList(ImageResource.values()));
		return suppliers;
	}
}
