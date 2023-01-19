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
public class ScalarMultiplyTest {
	private final double[] expected;
	private final double[] xyOriginal;
	private final double scalar;

	public ScalarMultiplyTest(List<Double> expected, List<Double> xy, double scalar) {
		this.expected = PrimitiveArrays.toDoubleArray(expected);
		this.xyOriginal = PrimitiveArrays.toDoubleArray(xy);
		this.scalar = scalar;
	}

	@Test
	public void test() {
		double[] xyCopyToPass = Arrays.copyOf(xyOriginal, xyOriginal.length);

		double[] actual = ChaseTheMouse.scalarMultiply(xyCopyToPass, scalar);

		String nullMessage = ChaseTheMouseTestMessages.toNullMessage(actual);
		assertNotNull(nullMessage, actual);

		String sameMessage = ChaseTheMouseTestMessages.toNotSameMessage("xy");
		assertNotSame(sameMessage, xyCopyToPass, actual);

		String mutatedMessage = ChaseTheMouseTestMessages.toMutatedParameterMessage("xy", xyOriginal,
				xyCopyToPass);
		assertArrayEquals(mutatedMessage, xyOriginal, xyCopyToPass, 0.0);

		String lengthMessage = ChaseTheMouseTestMessages.toLengthMessage(expected, actual);
		assertEquals(lengthMessage, expected.length, actual.length);

		String contentsMessage = ChaseTheMouseTestMessages.toArrayEqualityMessage(expected, actual);
		assertArrayEquals(contentsMessage, expected, actual, 0.0);
	}

	@Parameterized.Parameters(name = "{0} = {1} * {2}")
	public static Collection<Object[]> getConstructorArguments() {
		Collection<Object[]> args = new LinkedList<>();
		
		// specific cases
		args.add(new Object[] { Arrays.asList(0.0, 0.0), Arrays.asList(3.0, 5.0), 0.0 });
		args.add(new Object[] { Arrays.asList(3.0, 5.0), Arrays.asList(3.0, 5.0), 1.0 });
		args.add(new Object[] { Arrays.asList(6.0, 10.0), Arrays.asList(3.0, 5.0), 2.0 });
		args.add(new Object[] { Arrays.asList(30.0, 50.0), Arrays.asList(3.0, 5.0), 10.0 });
		args.add(new Object[] { Arrays.asList(-2.0, -3.0), Arrays.asList(-2.0, -3.0), 1.0 });
		args.add(new Object[] { Arrays.asList(2.0, 3.0), Arrays.asList(-2.0, -3.0), -1.0 });
		args.add(new Object[] { Arrays.asList(-4.0, -6.0), Arrays.asList(-2.0, -3.0), 2.0 });
		args.add(new Object[] { Arrays.asList(4.0, 6.0), Arrays.asList(-2.0, -3.0), -2.0 });
		args.add(new Object[] { Arrays.asList(-20.0, -30.0), Arrays.asList(-2.0, -3.0), 10.0 });
		args.add(new Object[] { Arrays.asList(20.0, 30.0), Arrays.asList(-2.0, -3.0), -10.0 });
		args.add(new Object[] { Arrays.asList(55675.0, 98175.0), Arrays.asList(131.0, 231.0), 425.0 });

		// random cases
		args.add(new Object[] { Arrays.asList(-3972.4308679999995, -6436.095042), Arrays.asList(55.412, 89.778), -71.689 });
		args.add(new Object[] { Arrays.asList(4931.999279999999, 2649.2728319999997), Arrays.asList(89.895, 48.288), 54.864 });
		args.add(new Object[] { Arrays.asList(-0.6000840000000001, 5.489868), Arrays.asList(1.899, -17.373), -0.316 });
		args.add(new Object[] { Arrays.asList(-275.98381400000005, 449.074224), Arrays.asList(49.691, -80.856), -5.554 });
		args.add(new Object[] { Arrays.asList(-2900.401358, 4401.339580000001), Arrays.asList(33.127, -50.27), -87.554 });
		args.add(new Object[] { Arrays.asList(4354.21272, -4797.87396), Arrays.asList(57.07, -62.885), 76.296 });
		args.add(new Object[] { Arrays.asList(-2200.545016, 4095.4827179999997), Arrays.asList(40.856, -76.038), -53.861 });
		args.add(new Object[] { Arrays.asList(2348.923104, 1617.6745079999998), Arrays.asList(-93.456, -64.362), -25.134 });
		args.add(new Object[] { Arrays.asList(-247.13443800000002, -168.87547800000002), Arrays.asList(29.558, 20.198), -8.361 });
		args.add(new Object[] { Arrays.asList(7223.697557999999, -2323.49271), Arrays.asList(-93.627, 30.115), -77.154 });
		args.add(new Object[] { Arrays.asList(5930.395173, -6105.504762), Arrays.asList(69.393, -71.442), 85.461 });
		args.add(new Object[] { Arrays.asList(-4471.558145, 3726.911007), Arrays.asList(-96.115, 80.109), 46.523 });
		args.add(new Object[] { Arrays.asList(5241.283235999999, 5447.182209), Arrays.asList(-61.068, -63.467), -85.827 });
		args.add(new Object[] { Arrays.asList(-34.278296, -0.795861), Arrays.asList(-4.264, -0.099), 8.039 });
		args.add(new Object[] { Arrays.asList(-2201.476416, -1079.180904), Arrays.asList(43.504, 21.326), -50.604 });
		args.add(new Object[] { Arrays.asList(1112.1689139999999, 1168.969329), Arrays.asList(-19.874, -20.889), -55.961 });
		args.add(new Object[] { Arrays.asList(252.56203000000002, 201.44387200000003), Arrays.asList(-96.73, -77.152), -2.611 });
		args.add(new Object[] { Arrays.asList(1553.813982, 1700.1774629999998), Arrays.asList(39.354, 43.061), 39.483 });
		args.add(new Object[] { Arrays.asList(-142.676125, -108.376475), Arrays.asList(-37.795, -28.709), 3.775 });
		args.add(new Object[] { Arrays.asList(-179.043201, -2017.0262340000002), Arrays.asList(5.727, 64.518), -31.263 });
		args.add(new Object[] { Arrays.asList(-2457.4950799999997, -1284.38194), Arrays.asList(-31.804, -16.622), 77.27 });
		args.add(new Object[] { Arrays.asList(-609.3203000000001, 2595.073058), Arrays.asList(9.65, -41.099), -63.142 });
		args.add(new Object[] { Arrays.asList(3385.067912, -534.0927899999999), Arrays.asList(80.524, -12.705), 42.038 });

		return args;
	}
}
