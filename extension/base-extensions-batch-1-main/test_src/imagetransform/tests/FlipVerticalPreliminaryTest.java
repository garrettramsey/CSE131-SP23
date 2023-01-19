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
public class FlipVerticalPreliminaryTest {
	@Test
	public void test2x1() {
		Color[][] source = new Color[2][1];
		source[0][0] = Color.BLACK;
		source[1][0] = Color.WHITE;

		Color[][] actual = ImageTransforms.flipVertical(source);

		assertArrayEquals("Do NOT mutate (change) the contents of the source parameter.", new Color[] { Color.BLACK },
				source[0]);
		assertArrayEquals("Do NOT mutate (change) the contents of the source parameter.", new Color[] { Color.WHITE },
				source[1]);

		assertNotSame(source, actual);
		assertNotNull(actual);
		assertEquals(2, actual.length);
		assertNotNull(actual[0]);
		assertEquals(1, actual[0].length);
		assertEquals(Color.WHITE, actual[0][0]);
		assertNotNull(actual[1]);
		assertEquals(1, actual[1].length);
		assertEquals(Color.BLACK, actual[1][0]);
	}
}
