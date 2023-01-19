package linearregression.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import linearregression.PredictorBasedOnX;
import linearregression.RegressionLine;

public class RegressionLineImplementsPredictorTest {
	@Test
	public void test() {
		assertTrue(PredictorBasedOnX.class.isAssignableFrom(RegressionLine.class));
	}
}
