package linearregression.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import linearregression.RunningSum;
import test.cse131.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class RunningSumPreliminaryTest {
	@Test
	public void test() {
		RunningSum runningSum = new RunningSum();
		assertEquals(0, runningSum.getCount());
		assertEquals(0.0, runningSum.getSum(), UnitTestUtils.zeroDelta());

		runningSum.add(23.0);
		assertEquals(1, runningSum.getCount());
		assertEquals(23.0, runningSum.getSum(), UnitTestUtils.zeroDelta());
		assertEquals(23.0, runningSum.getAverage(), UnitTestUtils.reasonableDelta());

		runningSum.add(10.0);
		assertEquals(2, runningSum.getCount());
		assertEquals(33.0, runningSum.getSum(), UnitTestUtils.zeroDelta());
		assertEquals(16.5, runningSum.getAverage(), UnitTestUtils.reasonableDelta());

		runningSum.add(93.0);
		assertEquals(3, runningSum.getCount());
		assertEquals(126.0, runningSum.getSum(), UnitTestUtils.zeroDelta());
		assertEquals(42.0, runningSum.getAverage(), UnitTestUtils.reasonableDelta());
	}
}
