package mousechaser;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import mousechaser.tests.AddTest;
import mousechaser.tests.CalculateNextPositionTest;
import mousechaser.tests.MagnitudeTest;
import mousechaser.tests.ScalarMultiplyTest;
import mousechaser.tests.SquareTest;
import mousechaser.tests.SubtractTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ SquareTest.class, MagnitudeTest.class, AddTest.class, SubtractTest.class,
		ScalarMultiplyTest.class, CalculateNextPositionTest.class })
public class ChaseTheMouseTestSuite {
}
