package watermelons.tests;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import watermelons.Watermelons;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class PairCountTest {
	private final int length;
	private final int expected;

	public PairCountTest(int length, int expected) {
		this.length = length;
		this.expected = expected;
	}

	@Test
	public void test() {
		int[] array = new int[length];
		int actual = Watermelons.pairCount(array);
		assertEquals(expected, actual);
	}

	@Parameterized.Parameters(name = "length: {0}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		
		args.add(new Object[] {2, 1});
		args.add(new Object[] {3, 3});
		args.add(new Object[] {4, 6});
		args.add(new Object[] {5, 10});
		args.add(new Object[] {6, 15});
		args.add(new Object[] {7, 21});
		args.add(new Object[] {8, 28});
		args.add(new Object[] {9, 36});
		args.add(new Object[] {10, 45});
		args.add(new Object[] {11, 55});
		args.add(new Object[] {12, 66});
		args.add(new Object[] {13, 78});
		args.add(new Object[] {14, 91});
		args.add(new Object[] {15, 105});
		args.add(new Object[] {16, 120});
		args.add(new Object[] {17, 136});
		args.add(new Object[] {18, 153});
		args.add(new Object[] {19, 171});
		args.add(new Object[] {20, 190});
		args.add(new Object[] {21, 210});
		args.add(new Object[] {22, 231});
		args.add(new Object[] {23, 253});
		args.add(new Object[] {24, 276});
		args.add(new Object[] {25, 300});
		args.add(new Object[] {26, 325});
		args.add(new Object[] {27, 351});
		args.add(new Object[] {28, 378});
		args.add(new Object[] {29, 406});
		args.add(new Object[] {30, 435});
		args.add(new Object[] {31, 465});
		args.add(new Object[] {32, 496});
		args.add(new Object[] {33, 528});
		args.add(new Object[] {34, 561});
		args.add(new Object[] {35, 595});
		args.add(new Object[] {36, 630});
		args.add(new Object[] {37, 666});
		args.add(new Object[] {38, 703});
		args.add(new Object[] {39, 741});
		args.add(new Object[] {40, 780});
		args.add(new Object[] {41, 820});
		args.add(new Object[] {42, 861});

		return args;
	}
}
