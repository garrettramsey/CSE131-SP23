package sortanalysis.tests;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import support.cse131.LenientTextUtils;
import test.PrefixedLineTester;
import test.cse131.Tests;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class SortedComprehensiveTest {
	private final List<Integer> originalValues;
	private final String expectedOutput;

	public SortedComprehensiveTest(List<Integer> originalValues, String expectedOutput) {
		this.originalValues = originalValues;
		this.expectedOutput = expectedOutput;
	}

	@Test
	public void test() throws Exception {
		PrefixedLineTester tester = new DsaPrefixedLineTester(originalValues, expectedOutput, DsaPrefixedLine.SORTED);
		List<String> actualTokens = tester.toOneAndOnlyOnePrefixedTokens();
		List<String> expectedTokens = tester.getExpectedTokensAtDefaultLine();

		//actualTokens = actualTokens.subList(originalValues.size() + 1, actualTokens.size());
		int skipPrefixFromIndex = 1;
		List<Integer> expectedValues = LenientTextUtils.toIntegers(expectedTokens, skipPrefixFromIndex);
		List<Integer> actualValues = LenientTextUtils.toIntegers(actualTokens, skipPrefixFromIndex);

		String isSortedSubMessage = "\n" + (isSorted(actualValues) ? "The contents are sorted, however."
				: "Further, the contents are NOT sorted.") + "\n";
		String sizeMessage = tester.toMessage("Unexpected number of items printed." + isSortedSubMessage);
		assertEquals(sizeMessage, originalValues.size(), actualValues.size());

		String independentOfOrderMessage = tester
				.toMessage("Does not contain the correct items (even independent of order)." + isSortedSubMessage);
		Tests.assertEqualsIndependentOfOrder(independentOfOrderMessage, originalValues, actualValues);

		String equalsMessage = tester
				.toMessage("Contains the correct items but not in the correct order." + isSortedSubMessage);
		assertEquals(equalsMessage, expectedValues, actualValues);
	}

	@Parameterized.Parameters(name = "original: {0}; expectedOutput: {1}")
	public static Collection<Object[]> getConstructorArguments() throws Exception {
		return TestCases.getConstructorArguments();
	}

	private static boolean isSorted(List<Integer> xs) {
		int prev = Integer.MIN_VALUE;
		for (int x : xs) {
			if (x < prev) {
				return false;
			}
			prev = x;
		}
		return true;
	}
}
