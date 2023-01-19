package mousechaser.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
public class MagnitudeTest {
	private final double expected;
	private final double[] vOriginal;

	public MagnitudeTest(double expected, List<Double> v) {
		this.expected = expected;
		this.vOriginal = PrimitiveArrays.toDoubleArray(v);
	}

	@Test
	public void test() {
		double[] vCopyToPass = Arrays.copyOf(vOriginal, vOriginal.length);

		double actual = ChaseTheMouse.calculateMagnitude(vCopyToPass);

		String vMutatedMessage = ChaseTheMouseTestMessages.toMutatedParameterMessage("v", vOriginal, vCopyToPass);
		assertArrayEquals(vMutatedMessage, vOriginal, vCopyToPass, 0.0);

		double delta = 0.0001;
		assertEquals(expected, actual, delta);
	}

	@Parameterized.Parameters(name = "{0} = calculateMagnitude({1})")
	public static Collection<Object[]> getConstructorArguments() {
		Collection<Object[]> args = new LinkedList<>();
		
		// specific cases
		args.add(new Object[] { 0.0, Arrays.asList(0.0, 0.0) });
		args.add(new Object[] { 1.0, Arrays.asList(1.0, 0.0) });
		args.add(new Object[] { 1.0, Arrays.asList(0.0, 1.0) });
		args.add(new Object[] { 2.0, Arrays.asList(2.0, 0.0) });
		args.add(new Object[] { 2.0, Arrays.asList(0.0, 2.0) });
		args.add(new Object[] { 5.0, Arrays.asList(3.0, 4.0) });

		// random cases
		args.add(new Object[] { 41.84867984775625, Arrays.asList(38.273, 16.926) });
		args.add(new Object[] { 86.04531109247034, Arrays.asList(56.219, 65.14) });
		args.add(new Object[] { 78.59393903476273, Arrays.asList(29.278, 72.937) });
		args.add(new Object[] { 114.39219832226323, Arrays.asList(-66.811, 92.854) });
		args.add(new Object[] { 112.40140416382707, Arrays.asList(-57.647, -96.493) });
		args.add(new Object[] { 26.662171329432265, Arrays.asList(-5.006, -26.188) });
		args.add(new Object[] { 115.92070325010972, Arrays.asList(91.299, 71.429) });
		args.add(new Object[] { 99.52046847257101, Arrays.asList(92.298, -37.221) });
		args.add(new Object[] { 96.30206702869881, Arrays.asList(93.467, 23.195) });
		args.add(new Object[] { 103.22212218802711, Arrays.asList(-36.403, 96.59) });
		args.add(new Object[] { 36.644325317844235, Arrays.asList(-32.513, 16.903) });
		args.add(new Object[] { 99.38180535691632, Arrays.asList(96.96, 21.806) });
		args.add(new Object[] { 86.37883578747747, Arrays.asList(0.914, 86.374) });
		args.add(new Object[] { 123.65743508984811, Arrays.asList(79.377, -94.818) });
		args.add(new Object[] { 92.698245360956, Arrays.asList(-47.678, -79.497) });
		args.add(new Object[] { 106.56495919391139, Arrays.asList(60.468, 87.748) });
		args.add(new Object[] { 98.56122177103934, Arrays.asList(-52.881, 83.174) });
		args.add(new Object[] { 26.53452709207383, Arrays.asList(17.622, -19.838) });
		args.add(new Object[] { 23.507982240081773, Arrays.asList(2.302, -23.395) });
		args.add(new Object[] { 82.95872306153223, Arrays.asList(51.274, 65.216) });
		args.add(new Object[] { 83.01838665018732, Arrays.asList(72.619, -40.231) });
		args.add(new Object[] { 46.87872628389129, Arrays.asList(-38.133, -27.267) });
		args.add(new Object[] { 88.44833801717249, Arrays.asList(49.087, 73.577) });

		return args;
	}
}
