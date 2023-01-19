package mousechaser.tests;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import mousechaser.ChaseTheMouse;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class SquareTest {
	private final double expected;
	private final double v;

	public SquareTest(double expected, double v) {
		this.expected = expected;
		this.v = v;
	}

	@Test
	public void test() {
		double delta = 0.0001;
		double actual = ChaseTheMouse.square(v);
		assertEquals(expected, actual, delta);
	}

	@Parameterized.Parameters(name = "{0} = {1}^2")
	public static Collection<Object[]> getConstructorArguments() {
		Collection<Object[]> args = new LinkedList<>();
		
		// specific cases
		args.add(new Object[] { 0.0, 0.0 });
		args.add(new Object[] { 1.0, 1.0 });
		args.add(new Object[] { 4.0, 2.0 });
		args.add(new Object[] { 100.0, 10.0 });
		args.add(new Object[] { 17161.0, 131.0 });
		args.add(new Object[] { 53361.0, 231.0 });
		args.add(new Object[] { 180625.0, 425.0 });

		// random cases
		args.add(new Object[] { 172.29187599999997, -13.126 });
		args.add(new Object[] { 3041.412201, 55.149 });
		args.add(new Object[] { 22.155849, 4.707 });
		args.add(new Object[] { 2475.759049, 49.757 });
		args.add(new Object[] { 76.003524, -8.718 });
		args.add(new Object[] { 36.711481, -6.059 });
		args.add(new Object[] { 1419.556329, 37.677 });
		args.add(new Object[] { 2038.7934089999999, -45.153 });
		args.add(new Object[] { 4777.850884, 69.122 });
		args.add(new Object[] { 1126.340721, 33.561 });
		args.add(new Object[] { 9301.059363999999, 96.442 });
		args.add(new Object[] { 115.86369599999999, -10.764 });
		args.add(new Object[] { 4975.468369000001, 70.537 });
		args.add(new Object[] { 192.43238399999998, -13.872 });
		args.add(new Object[] { 6100.234816, 78.104 });
		args.add(new Object[] { 7762.667235999999, -88.106 });
		args.add(new Object[] { 2887.127824, 53.732 });
		args.add(new Object[] { 2794.0738810000003, 52.859 });
		args.add(new Object[] { 67.65062499999999, 8.225 });
		args.add(new Object[] { 6436.531983999999, 80.228 });
		args.add(new Object[] { 0.46785600000000005, 0.684 });
		args.add(new Object[] { 420.94728899999996, -20.517 });
		args.add(new Object[] { 6714.819136, -81.944 });

		return args;
	}
}
