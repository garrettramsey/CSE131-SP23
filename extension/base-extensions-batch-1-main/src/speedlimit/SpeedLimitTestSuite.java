package speedlimit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import speedlimit.tests.DeclarationsTest;
import speedlimit.tests.InComplianceWithTheLawTest;
import speedlimit.tests.InfractionAtLeastOrderedValuesTest;
import speedlimit.tests.InfractionOrderedValuesAndCorrectTextTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ DeclarationsTest.class, InComplianceWithTheLawTest.class,
		InfractionAtLeastOrderedValuesTest.class, InfractionOrderedValuesAndCorrectTextTest.class })
public class SpeedLimitTestSuite {
}
