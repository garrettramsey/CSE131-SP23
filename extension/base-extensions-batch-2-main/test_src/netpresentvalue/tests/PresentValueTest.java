package netpresentvalue.tests;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import netpresentvalue.NPV;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class PresentValueTest {
	private final double dollars;
	private final int years;
	private final double r;
	private final double expected;

	public PresentValueTest(double dollars, int years, double r, double expected) {
		this.dollars = dollars;
		this.years = years;
		this.r = r;
		this.expected = expected;
	}

	@Test
	public void test() {
		double actual = NPV.presentValue(dollars, years, r);
		assertEquals(expected, actual, 0.0001);
	}

	@Parameterized.Parameters(name = "dollars: {0}; years: {1}; r: {2}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		
		// specific cases
		args.add(new Object[] {1.0, 50, 0.1, 0.008518551279500606});

		// random cases
		args.add(new Object[] {3283.991445880652, 7, 0.7080353711157102, 77.43262753337476});
		args.add(new Object[] {4161.68195804381, 12, 0.27925875292123437, 216.6547033689376});
		args.add(new Object[] {4592.621797359746, 7, 0.0382059428047683, 3532.450698465696});
		args.add(new Object[] {842.7875438876853, 10, 0.918030153440318, 1.250730681922486});
		args.add(new Object[] {3828.7414896129535, 6, 0.7794417708525633, 120.6016801712607});
		args.add(new Object[] {8576.21161129864, 27, 0.21651294223175788, 43.166186174648885});
		args.add(new Object[] {2173.1997212310052, 16, 0.4753474779723459, 4.313110083799932});
		args.add(new Object[] {2581.1813296995333, 21, 0.3377140940871346, 5.730455658123333});
		args.add(new Object[] {2156.077038819535, 3, 0.31513412878546, 947.8816807856497});
		args.add(new Object[] {6465.242578799207, 9, 0.781916459093805, 35.69429187622936});
		args.add(new Object[] {9610.504174081641, 88, 0.07155692874746655, 21.948471250703808});
		args.add(new Object[] {3324.5844736900076, 10, 0.25898850668202034, 332.2918715951091});
		args.add(new Object[] {7093.0944551052135, 56, 0.07643362612904159, 114.69629981367196});
		args.add(new Object[] {8304.409277336126, 41, 0.13555208460388835, 45.27092106124539});
		args.add(new Object[] {3381.970891262608, 40, 0.03232561971701797, 947.3307674940972});
		args.add(new Object[] {9081.433637966027, 98, 0.04966373349508013, 78.56616693131264});

		return args;
	}
}
