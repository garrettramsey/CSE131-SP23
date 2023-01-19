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
public class AllPairSumsTest {
	private final int[] weights;
	private final int[] expected;

	public AllPairSumsTest(List<Integer> weights, List<Integer> expected) {
		this.weights = PrimitiveArrays.toIntArray(weights);
		this.expected = PrimitiveArrays.toIntArray(expected);
		Arrays.sort(this.expected);
	}

	@Test
	public void test() {
		int[] copy = Arrays.copyOf(weights, weights.length);
		int[] actual = Watermelons.allPairSums(copy);
		assertEquals(expected.length, actual.length);
		Arrays.sort(actual);
		assertArrayEquals(expected, actual);
	}

	@Parameterized.Parameters(name = "weights: {0}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		
		// specific cases
		args.add(new Object[] {Arrays.asList(1, 2), Arrays.asList(3)});
		args.add(new Object[] {Arrays.asList(1, 1, 2, 3, 5, 8), Arrays.asList(2, 3, 4, 6, 9, 3, 4, 6, 9, 5, 7, 10, 8, 11, 13)});
		args.add(new Object[] {Arrays.asList(9, 11, 13, 14, 17), Arrays.asList(20, 22, 23, 26, 24, 25, 28, 27, 30, 31)});

		// random cases
		args.add(new Object[] {Arrays.asList(30, 34, 13, 28, 7, 7), Arrays.asList(64, 43, 58, 37, 37, 47, 62, 41, 41, 41, 20, 20, 35, 35, 14)});
		args.add(new Object[] {Arrays.asList(20, 34, 25), Arrays.asList(54, 45, 59)});
		args.add(new Object[] {Arrays.asList(1, 33), Arrays.asList(34)});
		args.add(new Object[] {Arrays.asList(31, 37, 1), Arrays.asList(68, 32, 38)});
		args.add(new Object[] {Arrays.asList(25, 33, 41, 30, 2, 3, 8, 21), Arrays.asList(58, 66, 55, 27, 28, 33, 46, 74, 63, 35, 36, 41, 54, 71, 43, 44, 49, 62, 32, 33, 38, 51, 5, 10, 23, 11, 24, 29)});
		args.add(new Object[] {Arrays.asList(19, 3, 27, 6, 11, 29, 39, 27, 22), Arrays.asList(22, 46, 25, 30, 48, 58, 46, 41, 30, 9, 14, 32, 42, 30, 25, 33, 38, 56, 66, 54, 49, 17, 35, 45, 33, 28, 40, 50, 38, 33, 68, 56, 51, 66, 61, 49)});
		args.add(new Object[] {Arrays.asList(12, 27, 35, 42), Arrays.asList(39, 47, 54, 62, 69, 77)});
		args.add(new Object[] {Arrays.asList(36, 13), Arrays.asList(49)});
		args.add(new Object[] {Arrays.asList(6, 38, 5, 14, 15, 39, 41, 18, 38), Arrays.asList(44, 11, 20, 21, 45, 47, 24, 44, 43, 52, 53, 77, 79, 56, 76, 19, 20, 44, 46, 23, 43, 29, 53, 55, 32, 52, 54, 56, 33, 53, 80, 57, 77, 59, 79, 56)});
		args.add(new Object[] {Arrays.asList(13, 12, 4, 39, 39, 23, 7, 13), Arrays.asList(25, 17, 52, 52, 36, 20, 26, 16, 51, 51, 35, 19, 25, 43, 43, 27, 11, 17, 78, 62, 46, 52, 62, 46, 52, 30, 36, 20)});
		args.add(new Object[] {Arrays.asList(27, 27, 25), Arrays.asList(54, 52, 52)});
		args.add(new Object[] {Arrays.asList(7, 41), Arrays.asList(48)});

		return args;
	}
}
