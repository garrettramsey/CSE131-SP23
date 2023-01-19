package linearregression;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import linearregression.tests.LearnPredictorTestSuite;
import linearregression.tests.RegressionLineImplementsPredictorTestSuite;
import linearregression.tests.RegressionLineTestSuite;
import linearregression.tests.RunningSumTestSuite;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ RunningSumTestSuite.class, RegressionLineTestSuite.class,
		RegressionLineImplementsPredictorTestSuite.class, LearnPredictorTestSuite.class })
public class LinearRegressionTestSuite {

}
