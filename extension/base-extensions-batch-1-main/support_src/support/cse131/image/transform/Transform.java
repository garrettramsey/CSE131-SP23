package support.cse131.image.transform;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.function.UnaryOperator;

import imagetransform.ImageTransforms;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public enum Transform {
	COPY {
		@Override
		public UnaryOperator<Color[][]> actual() {
			return ImageTransforms::copy;
		}

		@Override
		public int expectedRGB(BufferedImage originalImage, int expectedRow, int expectedCol) {
			return originalImage.getRGB(expectedCol, expectedRow);
		}

		@Override
		public String toString() {
			return "copy";
		}
	},

	FLIP_HORIZONTAL {
		@Override
		public UnaryOperator<Color[][]> actual() {
			return ImageTransforms::flipHorizontal;
		}

		@Override
		public int expectedRGB(BufferedImage originalImage, int expectedRow, int expectedCol) {
			int lastCol = originalImage.getWidth() - 1;
			return originalImage.getRGB(lastCol - expectedCol, expectedRow);
		}

		@Override
		public String toString() {
			return "flipHorizontal";
		}
	},
	FLIP_VERTICAL {
		@Override
		public UnaryOperator<Color[][]> actual() {
			return ImageTransforms::flipVertical;
		}

		@Override
		public int expectedRGB(BufferedImage originalImage, int expectedRow, int expectedCol) {
			int lastRow = originalImage.getHeight() - 1;
			return originalImage.getRGB(expectedCol, lastRow - expectedRow);
		}

		@Override
		public String toString() {
			return "flipVertical";
		}
	},
	MIRROR_LEFT_ONTO_RIGHT {
		@Override
		public UnaryOperator<Color[][]> actual() {
			return ImageTransforms::mirrorLeftOntoRight;
		}

		@Override
		public int expectedRGB(BufferedImage originalImage, int expectedRow, int expectedCol) {
			int lastCol = originalImage.getWidth() - 1;
			int originalCol = expectedCol < originalImage.getWidth() / 2 ? expectedCol : lastCol - expectedCol;
			return originalImage.getRGB(originalCol, expectedRow);
		}

		@Override
		public String toString() {
			return "mirrorLeftOntoRight";
		}
	},
	ROTATE_RIGHT {
		@Override
		public UnaryOperator<Color[][]> actual() {
			return ImageTransforms::rotateRight;
		}

		@Override
		public int expectedRGB(BufferedImage originalImage, int expectedRow, int expectedCol) {
			int originalCol = expectedRow;
			int originalRow = (originalImage.getHeight() - 1) - expectedCol;
			return originalImage.getRGB(originalCol, originalRow);
		}

		@Override
		public int expectedWidth(BufferedImage originalImage) {
			return originalImage.getHeight();
		}

		@Override
		public int expectedHeight(BufferedImage originalImage) {
			return originalImage.getWidth();
		}

		@Override
		public String toString() {
			return "rotateRight";
		}
	};

	public abstract UnaryOperator<Color[][]> actual();

	public abstract int expectedRGB(BufferedImage originalImage, int expectedRow, int expectedCol);

	public int expectedWidth(BufferedImage originalImage) {
		return originalImage.getWidth();
	}

	public int expectedHeight(BufferedImage originalImage) {
		return originalImage.getHeight();
	}

}
