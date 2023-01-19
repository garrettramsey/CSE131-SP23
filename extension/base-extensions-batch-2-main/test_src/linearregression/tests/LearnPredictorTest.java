package linearregression.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import linearregression.PredictorUtils;
import linearregression.PredictorBasedOnX;
import linearregression.RegressionLine;
import linearregression.XY;

public class LearnPredictorTest {
	@Test
	public void testPredictions() {
		for (int i = 1; i < 100; i++) {
			double slope = i / 10d * Math.random();
			double intercept = i + 1;
			double[] xs = new double[100];
			for (int j = 0; j < xs.length; j++)
				xs[j] = j;
			double[] ys = new double[xs.length];
			for (int j = 0; j < xs.length; j++)
				ys[j] = slope * xs[j] + intercept;
			RegressionLine rl = new RegressionLine();
			List<XY> xys = new ArrayList<>(xs.length);
			for (int j = 0; j < xs.length; ++j) {
				xys.add(new XY(xs[j], ys[j]));
				rl.accept(xs[j], ys[j]);
			}

			PredictorBasedOnX predictor = PredictorUtils.learnPredictor(xys);
			for (int j = 0; j < 100; j++) {
				double x = j;
				double ans = j;
				ans = ans * rl.getSlope();
				ans = ans + rl.getIntercept();
				Assert.assertEquals(ans, predictor.predict(x), 0.1);
			}
		}
	}

}
