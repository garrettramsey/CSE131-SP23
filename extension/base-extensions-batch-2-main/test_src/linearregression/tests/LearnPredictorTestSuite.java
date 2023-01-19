package linearregression.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ LearnPredictorTwoPointPreliminaryTest.class, LearnPredictorTwoPointSelfCheckTest.class,
		LearnPredictorMultiPointComprehensiveTest.class, LearnPredictorTest.class })
public class LearnPredictorTestSuite {

}
