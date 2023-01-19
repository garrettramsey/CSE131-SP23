package watermelons;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import watermelons.tests.AllPairSumsTestSuite;
import watermelons.tests.FindWeightsTestSuite;
import watermelons.tests.PairCountTestSuite;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ PairCountTestSuite.class, AllPairSumsTestSuite.class, FindWeightsTestSuite.class })
public class WatermelonsTestSuite {
}
