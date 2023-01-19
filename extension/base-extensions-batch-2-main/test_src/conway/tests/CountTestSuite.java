package conway.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ CountUnpopulatedGridTest.class, CountPopulatedGridTest.class })
public class CountTestSuite {
}
