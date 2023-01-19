package linearregression.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import linearregression.PredictorUtils;
import linearregression.PredictorBasedOnX;
import linearregression.XY;
import test.cse131.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class LearnPredictorTwoPointPreliminaryTest {
	@Test
	public void test() {
		XY a = new XY(2, 5);
		XY b = new XY(12, 25);
		PredictorBasedOnX predictor = PredictorUtils.learnPredictor(Arrays.asList(a, b));
		assertEquals(a.getY(), predictor.predict(a.getX()), UnitTestUtils.reasonableDelta());
		assertEquals(b.getY(), predictor.predict(b.getX()), UnitTestUtils.reasonableDelta());

		assertEquals(1.0, predictor.predict(0), UnitTestUtils.reasonableDelta());
		assertEquals(45.0, predictor.predict(22.0), UnitTestUtils.reasonableDelta());
		assertEquals(65.0, predictor.predict(32.0), UnitTestUtils.reasonableDelta());

		assertEquals(-15.0, predictor.predict(-8.0), UnitTestUtils.reasonableDelta());
		assertEquals(-35.0, predictor.predict(-18.0), UnitTestUtils.reasonableDelta());
	}
}
