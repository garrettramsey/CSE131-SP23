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
public class CalculateNextPositionTest {
	private final double[] expected;
	private final double[] currentBallPositionOriginal;
	private final double[] mousePositionOriginal;
	private final double speed;
	private final double deltaTime;

	public CalculateNextPositionTest(List<Double> expected, List<Double> currentBallPosition,
			List<Double> mousePosition, double speed, double deltaTime) {
		this.expected = PrimitiveArrays.toDoubleArray(expected);
		this.currentBallPositionOriginal = PrimitiveArrays.toDoubleArray(currentBallPosition);
		this.mousePositionOriginal = PrimitiveArrays.toDoubleArray(mousePosition);
		this.speed = speed;
		this.deltaTime = deltaTime;
	}

	@Test
	public void test() {
		double[] currentBallPositionCopyToPass = Arrays.copyOf(currentBallPositionOriginal,
				currentBallPositionOriginal.length);
		double[] mousePositionCopyToPass = Arrays.copyOf(mousePositionOriginal, mousePositionOriginal.length);

		double[] actual = ChaseTheMouse.calculateNextPosition(currentBallPositionCopyToPass, mousePositionCopyToPass,
				speed, deltaTime);

		String nullMessage = ChaseTheMouseTestMessages.toNullMessage(actual);
		assertNotNull(nullMessage, actual);

		String currentBallPositionNotSameMessage = ChaseTheMouseTestMessages.toNotSameMessage("currentBallPosition");
		assertNotSame(currentBallPositionNotSameMessage, currentBallPositionCopyToPass, actual);
		// Note: it is acceptable to return mousePosition in certain circumstances

		String currentBallPositionMutatedMessage = ChaseTheMouseTestMessages.toMutatedParameterMessage(
				"currentBallPosition", currentBallPositionOriginal, currentBallPositionCopyToPass);
		assertArrayEquals(currentBallPositionMutatedMessage, currentBallPositionOriginal, currentBallPositionCopyToPass,
				0.0);
		String mousePositionMutatedMessage = ChaseTheMouseTestMessages.toMutatedParameterMessage("mousePosition",
				mousePositionOriginal, mousePositionCopyToPass);
		assertArrayEquals(mousePositionMutatedMessage, mousePositionOriginal, mousePositionCopyToPass, 0.0);

		String lengthMessage = ChaseTheMouseTestMessages.toLengthMessage(expected, actual);
		assertEquals(lengthMessage, expected.length, actual.length);

		String contentsMessage = ChaseTheMouseTestMessages.toArrayEqualityMessage(expected, actual);
		assertArrayEquals(contentsMessage, expected, actual, 0.0001);
	}

	@Parameterized.Parameters(name = "{0} = calculateNextPosition({1}, {2}, {3}, {4})")
	public static Collection<Object[]> getConstructorArguments() {
		Collection<Object[]> args = new LinkedList<>();
		
		// specific cases
		args.add(new Object[] { Arrays.asList(0.3089442719099991, 0.41788854381999835), Arrays.asList(0.3, 0.4), Arrays.asList(0.5, 0.8), 0.1, 0.2 });
		args.add(new Object[] { Arrays.asList(0.5, 0.8), Arrays.asList(0.3, 0.4), Arrays.asList(0.5, 0.8), 0.5, 1.0 });

		// random cases
		args.add(new Object[] { Arrays.asList(72.697, 61.001), Arrays.asList(-19.653, -49.729), Arrays.asList(72.697, 61.001), 86.056, 24.077 });
		args.add(new Object[] { Arrays.asList(69.211, 57.72), Arrays.asList(-41.195, -96.494), Arrays.asList(69.211, 57.72), 25.638, 27.834 });
		args.add(new Object[] { Arrays.asList(54.99566586011032, 71.05100546626505), Arrays.asList(77.599, 69.171), Arrays.asList(-10.686, 76.514), 0.323, 70.221 });
		args.add(new Object[] { Arrays.asList(8.763, 7.212), Arrays.asList(-1.411, -6.473), Arrays.asList(8.763, 7.212), 67.389, 54.056 });
		args.add(new Object[] { Arrays.asList(-51.337, -95.842), Arrays.asList(-90.574, -9.271), Arrays.asList(-51.337, -95.842), 10.436, 36.53 });
		args.add(new Object[] { Arrays.asList(54.093, -40.541), Arrays.asList(-57.766, 63.206), Arrays.asList(54.093, -40.541), 55.08, 54.713 });
		args.add(new Object[] { Arrays.asList(43.556, -78.804), Arrays.asList(-30.978, -32.988), Arrays.asList(43.556, -78.804), 56.549, 17.363 });
		args.add(new Object[] { Arrays.asList(25.007, -62.527), Arrays.asList(70.895, 50.984), Arrays.asList(25.007, -62.527), 97.107, 42.73 });
		args.add(new Object[] { Arrays.asList(-66.571, 12.508), Arrays.asList(-8.111, -76.788), Arrays.asList(-66.571, 12.508), 36.144, 6.548 });
		args.add(new Object[] { Arrays.asList(74.528, 76.91), Arrays.asList(-60.211, -91.318), Arrays.asList(74.528, 76.91), 21.254, 41.398 });
		args.add(new Object[] { Arrays.asList(88.249, -43.658), Arrays.asList(-50.949, -76.926), Arrays.asList(88.249, -43.658), 36.185, 39.372 });
		args.add(new Object[] { Arrays.asList(-99.621, -1.369), Arrays.asList(85.365, -13.453), Arrays.asList(-99.621, -1.369), 64.849, 98.633 });
		args.add(new Object[] { Arrays.asList(-16.566, 38.353), Arrays.asList(-45.42, 96.603), Arrays.asList(-16.566, 38.353), 54.953, 78.447 });
		args.add(new Object[] { Arrays.asList(-31.001, -38.63), Arrays.asList(-65.067, -48.418), Arrays.asList(-31.001, -38.63), 3.934, 60.854 });
		args.add(new Object[] { Arrays.asList(-40.707, 22.803), Arrays.asList(-68.468, -81.59), Arrays.asList(-40.707, 22.803), 83.795, 71.772 });
		args.add(new Object[] { Arrays.asList(-10.477, -14.386), Arrays.asList(-46.056, 44.443), Arrays.asList(-10.477, -14.386), 84.266, 83.174 });
		args.add(new Object[] { Arrays.asList(54.797, -79.793), Arrays.asList(36.037, -30.195), Arrays.asList(54.797, -79.793), 75.92, 69.536 });
		args.add(new Object[] { Arrays.asList(93.342, -52.973), Arrays.asList(93.653, 71.744), Arrays.asList(93.342, -52.973), 99.065, 11.264 });
		args.add(new Object[] { Arrays.asList(15.532, -55.254), Arrays.asList(-11.293, -93.797), Arrays.asList(15.532, -55.254), 60.769, 44.079 });
		args.add(new Object[] { Arrays.asList(-13.232, -11.266), Arrays.asList(-76.801, -33.975), Arrays.asList(-13.232, -11.266), 10.74, 62.444 });
		args.add(new Object[] { Arrays.asList(59.473, 52.678), Arrays.asList(5.694, 83.658), Arrays.asList(59.473, 52.678), 23.315, 7.34 });
		args.add(new Object[] { Arrays.asList(-50.01, 96.495), Arrays.asList(45.172, 24.671), Arrays.asList(-50.01, 96.495), 98.761, 47.994 });
		args.add(new Object[] { Arrays.asList(61.738, 94.539), Arrays.asList(-41.367, -25.711), Arrays.asList(61.738, 94.539), 84.799, 32.274 });

		return args;
	}
}
