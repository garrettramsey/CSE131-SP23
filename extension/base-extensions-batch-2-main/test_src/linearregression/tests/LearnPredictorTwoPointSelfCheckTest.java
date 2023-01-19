package linearregression.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import linearregression.PredictorUtils;
import linearregression.PredictorBasedOnX;
import linearregression.XY;
import test.cse131.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class LearnPredictorTwoPointSelfCheckTest {
	private final XY a;
	private final XY b;

	public LearnPredictorTwoPointSelfCheckTest(XY a, XY b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Test
	public void test() {
		PredictorBasedOnX predictor = PredictorUtils.learnPredictor(Arrays.asList(a, b));
		assertEquals(a.getY(), predictor.predict(a.getX()), UnitTestUtils.reasonableDelta());
		assertEquals(b.getY(), predictor.predict(b.getX()), UnitTestUtils.reasonableDelta());
	}

	@Parameterized.Parameters(name = "a: {0}; b: {1}")
	public static Collection<Object[]> getConstructorArguments() {
		Collection<Object[]> args = new LinkedList<>();

		// specific point on y axis cases
		args.add(new Object[] { new XY(0.0, 0.0), new XY(1.0, 0.0) });
		args.add(new Object[] { new XY(0.0, 0.0), new XY(1.0, 1.0) });
		args.add(new Object[] { new XY(0.0, 0.0), new XY(1.0, 2.0) });
		args.add(new Object[] { new XY(0.0, 0.0), new XY(2.0, 1.0) });
		args.add(new Object[] { new XY(0.0, 1.0), new XY(1.0, 1.0) });
		args.add(new Object[] { new XY(0.0, 1.0), new XY(2.0, 1.0) });
		args.add(new Object[] { new XY(0.0, 1.0), new XY(2.0, -1.0) });

		// random cases
		for (int i = 0; i < 16; ++i) {
			args.add(new Object[] { new XY(nextRandomValue(), nextRandomValue()),
					new XY(nextRandomValue(), nextRandomValue()) });
		}

		return args;
	}

	private static double nextRandomValue() {
		return -10.0 + 20.0 * Math.random();
	}
}
