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
public class AddTest {
	private final double[] expected;
	private final double[] aOriginal;
	private final double[] bOriginal;

	public AddTest(List<Double> expected, List<Double> a, List<Double> b) {
		this.expected = PrimitiveArrays.toDoubleArray(expected);
		this.aOriginal = PrimitiveArrays.toDoubleArray(a);
		this.bOriginal = PrimitiveArrays.toDoubleArray(b);
	}

	@Test
	public void test() {
		double[] aCopyToPass = Arrays.copyOf(aOriginal, aOriginal.length);
		double[] bCopyToPass = Arrays.copyOf(bOriginal, bOriginal.length);

		double[] actual = ChaseTheMouse.add(aCopyToPass, bCopyToPass);

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

	@Parameterized.Parameters(name = "{0} = {1} + {2}")
	public static Collection<Object[]> getConstructorArguments() {
		Collection<Object[]> args = new LinkedList<>();
		
		// specific cases
		args.add(new Object[] { Arrays.asList(4.0, 6.0), Arrays.asList(1.0, 2.0), Arrays.asList(3.0, 4.0) });
		args.add(new Object[] { Arrays.asList(40.0, 60.0), Arrays.asList(10.0, 20.0), Arrays.asList(30.0, 40.0) });

		// random cases
		args.add(new Object[] { Arrays.asList(124.63900000000001, 118.62), Arrays.asList(64.123, 22.799), Arrays.asList(60.516, 95.821) });
		args.add(new Object[] { Arrays.asList(-90.661, -53.457), Arrays.asList(-20.349, -4.828), Arrays.asList(-70.312, -48.629) });
		args.add(new Object[] { Arrays.asList(-66.46700000000001, 12.825999999999997), Arrays.asList(15.466, -24.132), Arrays.asList(-81.933, 36.958) });
		args.add(new Object[] { Arrays.asList(40.245, -58.78), Arrays.asList(83.88, -43.648), Arrays.asList(-43.635, -15.132) });
		args.add(new Object[] { Arrays.asList(-48.623, 2.6240000000000023), Arrays.asList(-51.683, 16.42), Arrays.asList(3.06, -13.796) });
		args.add(new Object[] { Arrays.asList(88.847, 30.625999999999998), Arrays.asList(89.954, 8.757), Arrays.asList(-1.107, 21.869) });
		args.add(new Object[] { Arrays.asList(174.325, 89.619), Arrays.asList(81.692, 81.36), Arrays.asList(92.633, 8.259) });
		args.add(new Object[] { Arrays.asList(30.668, -121.97900000000001), Arrays.asList(28.817, -76.623), Arrays.asList(1.851, -45.356) });
		args.add(new Object[] { Arrays.asList(-68.003, -148.828), Arrays.asList(-10.195, -99.375), Arrays.asList(-57.808, -49.453) });
		args.add(new Object[] { Arrays.asList(-164.329, 12.866), Arrays.asList(-73.916, 58.92), Arrays.asList(-90.413, -46.054) });
		args.add(new Object[] { Arrays.asList(78.256, -148.515), Arrays.asList(46.164, -83.434), Arrays.asList(32.092, -65.081) });
		args.add(new Object[] { Arrays.asList(28.913, -13.896), Arrays.asList(7.396, 41.711), Arrays.asList(21.517, -55.607) });
		args.add(new Object[] { Arrays.asList(-32.553000000000004, -60.074), Arrays.asList(-82.272, 15.985), Arrays.asList(49.719, -76.059) });
		args.add(new Object[] { Arrays.asList(90.59100000000001, -127.155), Arrays.asList(40.17, -77.28), Arrays.asList(50.421, -49.875) });
		args.add(new Object[] { Arrays.asList(-151.059, -118.11099999999999), Arrays.asList(-55.714, -33.761), Arrays.asList(-95.345, -84.35) });
		args.add(new Object[] { Arrays.asList(-21.735, 17.743), Arrays.asList(-28.11, 28.095), Arrays.asList(6.375, -10.352) });
		args.add(new Object[] { Arrays.asList(12.75500000000001, 67.52000000000001), Arrays.asList(88.203, 96.816), Arrays.asList(-75.448, -29.296) });
		args.add(new Object[] { Arrays.asList(154.099, 18.383), Arrays.asList(75.105, -30.374), Arrays.asList(78.994, 48.757) });
		args.add(new Object[] { Arrays.asList(-80.894, -56.40200000000001), Arrays.asList(-10.299, 17.781), Arrays.asList(-70.595, -74.183) });
		args.add(new Object[] { Arrays.asList(-0.08699999999999619, -157.99599999999998), Arrays.asList(59.277, -68.461), Arrays.asList(-59.364, -89.535) });
		args.add(new Object[] { Arrays.asList(-155.33100000000002, 113.918), Arrays.asList(-87.177, 16.519), Arrays.asList(-68.154, 97.399) });
		args.add(new Object[] { Arrays.asList(2.865000000000002, 70.848), Arrays.asList(59.65, 0.023), Arrays.asList(-56.785, 70.825) });
		args.add(new Object[] { Arrays.asList(78.382, -46.556000000000004), Arrays.asList(17.239, 24.156), Arrays.asList(61.143, -70.712) });

		return args;
	}
}
