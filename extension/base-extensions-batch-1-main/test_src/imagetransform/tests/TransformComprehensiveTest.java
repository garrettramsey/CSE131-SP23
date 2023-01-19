package imagetransform.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import support.cse131.image.BufferedImageSuppliers;
import support.cse131.image.BufferedImages;
import support.cse131.image.transform.Transform;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public abstract class TransformComprehensiveTest {
	private final Transform transform;
	private final BufferedImage originalImage;
	private final int[][] expectedRGBs;

	public TransformComprehensiveTest(Transform transform, Supplier<BufferedImage> supplier) {
		this.transform = transform;
		this.originalImage = supplier.get();
		this.expectedRGBs = toExpectedRgbs(transform, originalImage);
	}

	@Test
	public void test() throws IOException {
		Color[][] original = BufferedImages.toColorMatrix(originalImage);
		Color[][] source = BufferedImages.toColorMatrix(originalImage);

		Color[][] actual = transform.actual().apply(source);
		assertArrayEquals(original, source);
		for (int r = 0; r < original.length; ++r) {
			assertArrayEquals(original[r], source[r]);
		}

		assertNotSame(source, actual);
		assertNotNull(actual);

		int expectedHeight = expectedRGBs.length;
		int expectedWidth = expectedRGBs[0].length;

		int actualHeight = actual.length;
		assertNotEquals(expectedWidth, actualHeight);
		assertEquals(expectedHeight, actualHeight);

		for (int r = 0; r < actual.length; ++r) {
			assertNotNull(toRowMessage(r), actual[r]);
			int actualWidth = actual[r].length;
			assertNotEquals(toRowMessage(r), expectedHeight, actualWidth);
			assertEquals(toRowMessage(r), expectedWidth, actualWidth);
		}

		for (int r = 0; r < expectedHeight; ++r) {
			for (int c = 0; c < expectedWidth; ++c) {
				assertNotNull(toPixelMessage(r,c), actual[r][c]);
				assertEquals(toPixelMessage(r,c), new Color(expectedRGBs[r][c]), actual[r][c]);
			}
		}
	}

	private static String toRowMessage(int r) {
		return String.format("row: %d\n", r);
	}

	private static String toPixelMessage(int r, int c) {
		return String.format("row: %d; column: %d\n", r, c);
	}

	private static int[][] toExpectedRgbs(Transform transform, BufferedImage originalImage) {
		int expectedWidth = transform.expectedWidth(originalImage);
		int expectedHeight = transform.expectedHeight(originalImage);
		int[][] matrix = new int[expectedHeight][expectedWidth];
		for (int r = 0; r < matrix.length; ++r) {
			for (int c = 0; c < matrix[r].length; ++c) {
				matrix[r][c] = transform.expectedRGB(originalImage, r, c);
			}
		}
		return matrix;
	}

	@Parameterized.Parameters(name = "{0}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		for (Supplier<BufferedImage> supplier : BufferedImageSuppliers.asList()) {
			args.add(new Object[] { supplier });
		}
		return args;
	}
}
