package support.cse131.image;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class BufferedImages {
	public static Color[][] toColorMatrix(BufferedImage bufferedImage) {
		Color[][] colors = new Color[bufferedImage.getHeight()][bufferedImage.getWidth()];
		int height = colors.length;
		int width = colors[0].length;
		for (int r = 0; r < height; ++r) {
			for (int c = 0; c < width; ++c) {
				colors[r][c] = new Color(bufferedImage.getRGB(c, r));
			}
		}
		return colors;
	}

	public static BufferedImage toBufferedImage(Color[][] colors, int imageType) {
		int height = colors.length;
		int width = colors[0].length;
		BufferedImage bufferedImage = new BufferedImage(width, height, imageType);
		for (int r = 0; r < height; ++r) {
			for (int c = 0; c < width; ++c) {
				bufferedImage.setRGB(c, r, colors[r][c].getRGB());
			}
		}
		return bufferedImage;
	}

	public static boolean rgbsEquivalent(BufferedImage a, BufferedImage b) {
		int width = a.getWidth();
		if (width != b.getWidth()) {
			return false;
		}
		int height = a.getHeight();
		if (height != b.getHeight()) {
			return false;
		}
		for (int r = 0; r < height; ++r) {
			for (int c = 0; c < width; ++c) {
				if (a.getRGB(c, r) != b.getRGB(c, r)) {
					return false;
				}
			}
		}
		return true;
	}

}
