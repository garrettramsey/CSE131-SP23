package imagetransform.tests;

import java.awt.image.BufferedImage;
import java.util.function.Supplier;

import support.cse131.image.transform.Transform;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class RotateRightComprehensiveTest extends TransformComprehensiveTest {
	public RotateRightComprehensiveTest(Supplier<BufferedImage> supplier) {
		super(Transform.ROTATE_RIGHT, supplier);
	}
}
