package watermelons;

import java.util.Arrays;

import support.cse131.NotYetImplementedException;

public class Watermelons {
	/**
	 * @param array an array of integers
	 * @return the number of pairs of elements in the specified array
	 */
	public static int pairCount(int[] array) {
		
			// TODO: Delete the line below and implement this method
			throw new NotYetImplementedException();
		
	}

	/**
	 * Computes the sum of each distinct pair of entries in the incoming array.
	 * A given pair of entries has its sum computed only once. So if you
	 * compute the sum for entries 2 and 4, and that sum appears in your answer
	 * array, then you do not also compute the sum of entries 4 and 2.
	 * Depending on the input, the same sum value may appear multiple times in the
	 * result.
	 * For example, if all of the incoming values are 0, then so are all of the
	 * returned values.
	 * 
	 * @param weights an array of integers, possibly containing duplicates
	 * @return an array containing the sums of pairs as described above
	 */
	public static int[] allPairSums(int[] weights) {
		
			// TODO: Delete the line below and implement this method
			throw new NotYetImplementedException();
		
	}

	

	/**
	 * @param array: an array, not to be mutated
	 * @return a sorted copy of the specified array
	 * 
	 */
	public static int[] toSortedCopy(int[] array) {
		int[] aCopy = Arrays.copyOf(array, array.length);
		Arrays.sort(aCopy);
		return aCopy;
	}

	/**
	 * @param a: an array, not to be mutated
	 * @param b: another array, not to be mutated
	 * @return true if the arrays' contents are the same, otherwise false
	 */
	public static boolean equalsIgnoringOrder(int[] a, int[] b) {
		if (a.length == b.length) {
			// They must first be sorted, so Arrays.equals can compare element by element.
			// The caller may not want the arrays to be disturbed?
			// We therefore copy the arrays before we perform the sort and compare.
			int[] aCopy = toSortedCopy(a);
			int[] bCopy = toSortedCopy(b);
			return Arrays.equals(aCopy, bCopy);
		} else {
			return false;
		}
	}

	/**
	 * The method below must COMPUTE and return a solution as described
	 * on the web page for this extension.
	 * 
	 * You must compute the solution by trying lots of possibilities, and finding
	 * the one that yields the right answer.
	 * 
	 * @param pairSums is array of watermelon pairwise sums. In other words,
	 *                 each element of pairSums represents the sum of one pair of
	 *                 watermelons in our puzzle.
	 * @return the weights of the watermelons
	 */
	public static int[] findWeightsOf5Watermelons(int[] pairSums) {
		int expectedLength = 10;
		if (pairSums.length != expectedLength) {
			throw new IllegalArgumentException(
					"pairSums must be an array of length " + expectedLength + " " + Arrays.toString(pairSums));
		}
		
			// TODO: Delete the line below and implement this method
			throw new NotYetImplementedException();
		
	}
}
