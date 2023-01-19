package conway;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import conway.tests.AliveTestSuite;
import conway.tests.ClearTestSuite;
import conway.tests.CountTestSuite;
import conway.tests.StepTestSuite;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ AliveTestSuite.class, ClearTestSuite.class, CountTestSuite.class, StepTestSuite.class })
public class ConwayTestSuite {
}
