package imagetransform;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import imagetransform.tests.CopyTestSuite;
import imagetransform.tests.FlipHorizontalTestSuite;
import imagetransform.tests.FlipVerticalTestSuite;
import imagetransform.tests.MirrorLeftOntoRightTestSuite;
import imagetransform.tests.RotateRightTestSuite;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ CopyTestSuite.class, FlipHorizontalTestSuite.class, FlipVerticalTestSuite.class,
		MirrorLeftOntoRightTestSuite.class, RotateRightTestSuite.class })
public class ImageTransformsTestSuite {
}
