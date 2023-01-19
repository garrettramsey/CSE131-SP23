package linearregression.tests;

import org.junit.Assert;
import org.junit.Test;

import linearregression.RegressionLine;

public class RegressionLineTest {
	@Test
	public void testSlopeIntercept() {
		for (int i = 0; i < 100; i++) {
			double slope = i / 10d * Math.random();
			double intercept = i + 1;
			double[] xs = new double[100];
			for (int j = 0; j < xs.length; j++)
				xs[j] = j;
			double[] ys = new double[xs.length];
			for (int j = 0; j < xs.length; j++)
				ys[j] = slope * xs[j] + intercept;
			RegressionLine rl = new RegressionLine();
			for (int j = 0; j < xs.length; ++j) {
				rl.accept(xs[j], ys[j]);
			}
			Assert.assertEquals(slope, rl.getSlope(), 0.1);
			Assert.assertEquals(intercept, rl.getIntercept(), 0.1);
		}

		for (int i = 0; i < 100; i++) {
			double slope = i / 10d * Math.random();
			double intercept = i + 1;
			double[] xs = new double[100];
			for (int j = 0; j < xs.length; j++)
				xs[j] = j;
			double[] ys = new double[xs.length];
			for (int j = 0; j < xs.length; j++)
				ys[j] = slope * xs[j] + intercept + (j % 2 == 0 ? 2 : -2);
			RegressionLine rl = new RegressionLine();
			for (int j = 0; j < xs.length; ++j) {
				rl.accept(xs[j], ys[j]);
			}
			Assert.assertEquals(slope, rl.getSlope(), 0.1);
			Assert.assertEquals(intercept, rl.getIntercept(), 0.1);
		}
	}
}
