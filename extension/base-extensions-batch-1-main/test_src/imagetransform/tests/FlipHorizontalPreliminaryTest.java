package imagetransform.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.awt.Color;

import org.junit.Test;

import imagetransform.ImageTransforms;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class FlipHorizontalPreliminaryTest {
	@Test
	public void test1x2() {
		Color[][] source = new Color[1][2];
		source[0][0] = Color.BLACK;
		source[0][1] = Color.WHITE;

		Color[][] actual = ImageTransforms.flipHorizontal(source);

		assertArrayEquals("Do NOT mutate (change) the contents of the source parameter.",
				new Color[] { Color.BLACK, Color.WHITE }, source[0]);

		assertNotSame(source, actual);
		assertNotNull(actual);
		assertEquals(1, actual.length);
		assertNotNull(actual[0]);
		assertEquals(2, actual[0].length);
		assertEquals(Color.WHITE, actual[0][0]);
		assertEquals(Color.BLACK, actual[0][1]);
	}
}
