package imagetransform.tests;

import java.awt.image.BufferedImage;
import java.util.function.Supplier;

import support.cse131.image.transform.Transform;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class MirrorLeftOntoRightComprehensiveTest extends TransformComprehensiveTest {
	public MirrorLeftOntoRightComprehensiveTest(Supplier<BufferedImage> supplier) {
		super(Transform.MIRROR_LEFT_ONTO_RIGHT, supplier);
	}
}
