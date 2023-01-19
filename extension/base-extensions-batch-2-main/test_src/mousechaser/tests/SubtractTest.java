package mousechaser.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import mousechaser.ChaseTheMouse;
import support.cse131.PrimitiveArrays;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class SubtractTest {
	private final double[] expected;
	private final double[] aOriginal;
	private final double[] bOriginal;

	public SubtractTest(List<Double> expected, List<Double> a, List<Double> b) {
		this.expected = PrimitiveArrays.toDoubleArray(expected);
		this.aOriginal = PrimitiveArrays.toDoubleArray(a);
		this.bOriginal = PrimitiveArrays.toDoubleArray(b);
	}

	@Test
	public void test() {
		double[] aCopyToPass = Arrays.copyOf(aOriginal, aOriginal.length);
		double[] bCopyToPass = Arrays.copyOf(bOriginal, bOriginal.length);

		double[] actual = ChaseTheMouse.subtract(aCopyToPass, bCopyToPass);

		String nullMessage = ChaseTheMouseTestMessages.toNullMessage(actual);
		assertNotNull(nullMessage, actual);

		String aNotSameMessage = ChaseTheMouseTestMessages.toNotSameMessage("a");
		assertNotSame(aNotSameMessage, aCopyToPass, actual);
		String bNotSameMessage = ChaseTheMouseTestMessages.toNotSameMessage("b");
		assertNotSame(bNotSameMessage, bCopyToPass, actual);

		String aMutatedMessage = ChaseTheMouseTestMessages.toMutatedParameterMessage("a", aOriginal, aCopyToPass);
		assertArrayEquals(aMutatedMessage, aOriginal, aCopyToPass, 0.0);
		String bMutatedMessage = ChaseTheMouseTestMessages.toMutatedParameterMessage("b", bOriginal, bCopyToPass);
		assertArrayEquals(bMutatedMessage, bOriginal, bCopyToPass, 0.0);

		String lengthMessage = ChaseTheMouseTestMessages.toLengthMessage(expected, actual);
		assertEquals(lengthMessage, expected.length, actual.length);

		String contentsMessage = ChaseTheMouseTestMessages.toArrayEqualityMessage(expected, actual);
		assertArrayEquals(contentsMessage, expected, actual, 0.0);
	}

	@Parameterized.Parameters(name = "{0} = {1} - {2}")
	public static Collection<Object[]> getConstructorArguments() {
		Collection<Object[]> args = new LinkedList<>();
		
		// specific cases
		args.add(new Object[] { Arrays.asList(-2.0, -2.0), Arrays.asList(1.0, 2.0), Arrays.asList(3.0, 4.0) });
		args.add(new Object[] { Arrays.asList(-20.0, -20.0), Arrays.asList(10.0, 20.0), Arrays.asList(30.0, 40.0) });

		// random cases
		args.add(new Object[] { Arrays.asList(132.0, -67.655), Arrays.asList(63.288, -48.095), Arrays.asList(-68.712, 19.56) });
		args.add(new Object[] { Arrays.asList(82.509, 104.57199999999999), Arrays.asList(41.057, 93.082), Arrays.asList(-41.452, -11.49) });
		args.add(new Object[] { Arrays.asList(-61.643, -45.539), Arrays.asList(-17.564, -31.127), Arrays.asList(44.079, 14.412) });
		args.add(new Object[] { Arrays.asList(-11.866999999999997, 14.039000000000001), Arrays.asList(-70.225, -23.025), Arrays.asList(-58.358, -37.064) });
		args.add(new Object[] { Arrays.asList(106.298, 65.549), Arrays.asList(35.367, -6.35), Arrays.asList(-70.931, -71.899) });
		args.add(new Object[] { Arrays.asList(-88.791, 89.959), Arrays.asList(-3.437, 54.735), Arrays.asList(85.354, -35.224) });
		args.add(new Object[] { Arrays.asList(-94.977, 97.717), Arrays.asList(-55.127, 94.538), Arrays.asList(39.85, -3.179) });
		args.add(new Object[] { Arrays.asList(31.694999999999997, -4.068000000000012), Arrays.asList(48.992, 89.728), Arrays.asList(17.297, 93.796) });
		args.add(new Object[] { Arrays.asList(-26.316999999999993, 105.566), Arrays.asList(-85.463, 54.722), Arrays.asList(-59.146, -50.844) });
		args.add(new Object[] { Arrays.asList(-107.66499999999999, -98.41300000000001), Arrays.asList(-32.597, -34.24), Arrays.asList(75.068, 64.173) });
		args.add(new Object[] { Arrays.asList(1.3229999999999995, 8.405000000000001), Arrays.asList(-7.027, 52.754), Arrays.asList(-8.35, 44.349) });
		args.add(new Object[] { Arrays.asList(146.851, 42.284), Arrays.asList(70.047, -8.83), Arrays.asList(-76.804, -51.114) });
		args.add(new Object[] { Arrays.asList(52.723, -48.183), Arrays.asList(86.166, -49.385), Arrays.asList(33.443, -1.202) });
		args.add(new Object[] { Arrays.asList(72.798, 66.9), Arrays.asList(50.164, 12.462), Arrays.asList(-22.634, -54.438) });
		args.add(new Object[] { Arrays.asList(-22.372, -73.958), Arrays.asList(-71.928, -44.236), Arrays.asList(-49.556, 29.722) });
		args.add(new Object[] { Arrays.asList(-113.437, 111.199), Arrays.asList(-79.848, 28.872), Arrays.asList(33.589, -82.327) });
		args.add(new Object[] { Arrays.asList(-59.108999999999995, -21.286), Arrays.asList(-30.351, 73.58), Arrays.asList(28.758, 94.866) });
		args.add(new Object[] { Arrays.asList(98.013, 134.301), Arrays.asList(47.988, 49.29), Arrays.asList(-50.025, -85.011) });
		args.add(new Object[] { Arrays.asList(-88.99499999999999, -40.57899999999999), Arrays.asList(-3.544, 16.605), Arrays.asList(85.451, 57.184) });
		args.add(new Object[] { Arrays.asList(-57.708, 55.716), Arrays.asList(21.051, -17.079), Arrays.asList(78.759, -72.795) });
		args.add(new Object[] { Arrays.asList(-55.459, 133.607), Arrays.asList(-65.01, 86.99), Arrays.asList(-9.551, -46.617) });
		args.add(new Object[] { Arrays.asList(-73.738, 30.483), Arrays.asList(-77.493, 5.12), Arrays.asList(-3.755, -25.363) });
		args.add(new Object[] { Arrays.asList(-96.03399999999999, 3.3119999999999994), Arrays.asList(-42.095, -1.445), Arrays.asList(53.939, -4.757) });

		return args;
	}
}
