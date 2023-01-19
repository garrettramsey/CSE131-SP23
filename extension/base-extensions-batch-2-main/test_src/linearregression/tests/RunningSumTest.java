package linearregression.tests;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import linearregression.RunningSum;

/**
 * 
 * @author roncytron
 *
 */
public class RunningSumTest {

	@Test
	public void test() {
		Random r = new Random();
		List<Double> vals = new LinkedList<Double>();
		RunningSum rs = new RunningSum();
		double sum = 0.0;
		for (int i = 0; i < 1000; ++i) {
			assertEquals(msg("Count wrong before add", vals), i, rs.getCount());
			double val = r.nextDouble() * Math.pow(10, r.nextInt(4));
			vals.add(val);
			rs.add(val);
			assertEquals(msg("Count wrong after add", vals), i + 1, rs.getCount());
			sum = sum + val;
			assertEquals(msg("Sum wrong after add", vals), sum, rs.getSum(), .01);
			if (i > 0) {
				assertEquals(msg("Average wrong after add", vals), sum / (i + 1), rs.getAverage(), .01);
			}
		}
	}

	private static String msg(String s, List<Double> list) {
		return "For list so far: " + list + " " + s;
	}

}
