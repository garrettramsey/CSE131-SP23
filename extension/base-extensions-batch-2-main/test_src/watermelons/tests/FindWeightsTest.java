package watermelons.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import support.cse131.PrimitiveArrays;
import watermelons.Watermelons;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class FindWeightsTest {
	private final int[] pairSums;
	private final int[] expected;

	public FindWeightsTest(List<Integer> pairSums, List<Integer> expected) {
		this.pairSums = PrimitiveArrays.toIntArray(pairSums);
		this.expected = PrimitiveArrays.toIntArray(expected);
		Arrays.sort(this.expected);
	}

	@Test
	public void test() {
		int[] copy = Arrays.copyOf(pairSums, pairSums.length);
		int[] actual = Watermelons.findWeightsOf5Watermelons(copy);
		assertEquals(expected.length, actual.length);
		Arrays.sort(actual);
		assertArrayEquals(expected, actual);
	}

	@Parameterized.Parameters(name = "pairSums: {0}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		
		// specific cases
		args.add(new Object[] {Arrays.asList(20, 22, 23, 26, 24, 25, 28, 27, 30, 31), Arrays.asList(9, 11, 13, 14, 17)});
		args.add(new Object[] {Arrays.asList(5, 7, 10, 15, 8, 11, 16, 13, 18, 21), Arrays.asList(2, 3, 5, 8, 13)});
		args.add(new Object[] {Arrays.asList(2, 3, 4, 6, 3, 4, 6, 5, 7, 8), Arrays.asList(1, 1, 2, 3, 5)});
		args.add(new Object[] {Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2, 2, 2), Arrays.asList(1, 1, 1, 1, 1)});

		// random cases
		args.add(new Object[] {Arrays.asList(26, 22, 31, 29, 18, 27, 25, 23, 21, 30), Arrays.asList(15, 11, 7, 16, 14)});
		args.add(new Object[] {Arrays.asList(33, 20, 26, 21, 21, 27, 22, 14, 9, 15), Arrays.asList(16, 17, 4, 10, 5)});
		args.add(new Object[] {Arrays.asList(19, 21, 15, 16, 16, 10, 11, 12, 13, 7), Arrays.asList(12, 7, 9, 3, 4)});
		args.add(new Object[] {Arrays.asList(25, 24, 16, 16, 25, 17, 17, 16, 16, 8), Arrays.asList(12, 13, 12, 4, 4)});
		args.add(new Object[] {Arrays.asList(21, 22, 19, 25, 17, 14, 20, 15, 21, 18), Arrays.asList(13, 8, 9, 6, 12)});
		args.add(new Object[] {Arrays.asList(24, 16, 20, 11, 24, 28, 19, 20, 11, 15), Arrays.asList(8, 16, 8, 12, 3)});
		args.add(new Object[] {Arrays.asList(12, 10, 19, 8, 10, 19, 8, 17, 6, 15), Arrays.asList(6, 6, 4, 13, 2)});
		args.add(new Object[] {Arrays.asList(18, 17, 22, 29, 5, 10, 17, 9, 16, 21), Arrays.asList(15, 3, 2, 7, 14)});
		args.add(new Object[] {Arrays.asList(22, 21, 28, 15, 19, 26, 13, 25, 12, 19), Arrays.asList(12, 10, 9, 16, 3)});
		args.add(new Object[] {Arrays.asList(7, 12, 11, 6, 13, 12, 7, 17, 12, 11), Arrays.asList(3, 4, 9, 8, 3)});
		args.add(new Object[] {Arrays.asList(34, 23, 21, 28, 23, 21, 28, 10, 17, 15), Arrays.asList(17, 17, 6, 4, 11)});
		args.add(new Object[] {Arrays.asList(8, 8, 12, 17, 6, 10, 15, 10, 15, 19), Arrays.asList(5, 3, 3, 7, 12)});

		return args;
	}
}
