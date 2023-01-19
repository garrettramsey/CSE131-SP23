package netpresentvalue.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import netpresentvalue.NPV;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ProductDevelopmentStoryTest {
	@Test
	public void test() {
		// modified from unknown author

		//
		// Story parameters from https://en.wikipedia.org/wiki/Net_present_value#Example
		//
		int investment = 100000;
		int payout = 10000;
		double r = 0.10;

		double[] expectedPVs = new double[] {
				-100000.0,
				9090.90909090909,
				8264.462809917353,
				7513.148009015776,
				6830.134553650705,
				6209.213230591549,
				5644.739300537772,
				5131.581182307064,
				4665.07380209733,
				4240.976183724846,
				3855.432894295314,
				3504.938994813922,
				3186.308177103565
		};

		double[] expectedNPVs = new double[] {
				-100000.0,
				-90909.09090909091,
				-82644.62809917355,
				-75131.48009015778,
				-68301.34553650708,
				-62092.13230591553,
				-56447.39300537776,
				-51315.8118230707,
				-46650.73802097337,
				-42409.76183724852,
				-38554.32894295321,
				-35049.38994813929,
				-31863.081771035722
		};

		double acceptableDelta = 0.00001;
		for (int year = 0; year <= 12; ++year) {
			double dollars = year == 0 ? -investment : payout;
			double pv = NPV.presentValue(dollars, year, r);
			assertEquals("pv in year: " + year, expectedPVs[year], pv, acceptableDelta);
			double npv = NPV.netPresentValue(investment, year, payout, r);
			assertEquals("npv in year: " + year, expectedNPVs[year], npv, acceptableDelta);
		}
	}
}
