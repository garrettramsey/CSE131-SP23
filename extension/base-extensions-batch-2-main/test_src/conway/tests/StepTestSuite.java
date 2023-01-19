package conway.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ StepPreliminaryTest.class, StepUnpopulatedGridTest.class, StepPopulatedGridTest.class })
public class StepTestSuite {
}
