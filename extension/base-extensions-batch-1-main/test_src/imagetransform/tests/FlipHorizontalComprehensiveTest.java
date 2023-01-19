package imagetransform.tests;

import java.awt.image.BufferedImage;
import java.util.function.Supplier;

import support.cse131.image.transform.Transform;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class FlipHorizontalComprehensiveTest extends TransformComprehensiveTest {
	public FlipHorizontalComprehensiveTest(Supplier<BufferedImage> supplier) {
		super(Transform.FLIP_HORIZONTAL, supplier);
	}
}
