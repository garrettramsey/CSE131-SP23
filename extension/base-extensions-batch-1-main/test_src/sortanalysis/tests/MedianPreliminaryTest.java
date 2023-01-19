package sortanalysis.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import support.cse131.LenientTextUtils;
import test.PrefixedLineTester;
import test.cse131.Messages;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class MedianPreliminaryTest {
	@Test
	public void testOddNumberOfElements() throws Exception {
		List<Integer> originalValues = Arrays.asList(4, 10, 42);
		double expectedValue = originalValues.get(1);

		PrefixedLineTester tester = new DsaPrefixedLineTester(originalValues, Optional.empty(),
				Optional.of(DsaPrefixedLine.MEDIAN));
		List<String> actualTokens = tester.toOneAndOnlyOnePrefixedTokens();

		int skipPrefixFromIndex = 1;
		List<Double> actualValues = LenientTextUtils.toDoubles(actualTokens, skipPrefixFromIndex);

		String sizeMessage = tester.toMessage("Line prefixed by Median: should only print one number.");
		assertEquals(sizeMessage, 1, actualValues.size());
		double actualValue = actualValues.get(0);

		double delta = 0.0001;
		StringBuilder sb = new StringBuilder();
		sb.append("\nMedian value of an odd number of values is the middle value.\n");
		sb.append("\nexpected: ").append(expectedValue).append("; actual: ").append(actualValue).append("\n");
		sb.append(Messages.toLine(tester.getActualOutput(), Optional.empty(),
				tester.getActualTokensLists(), DsaPrefixedLine.MEDIAN.getExpectedIndex(),
				DsaPrefixedLineTester::toLine));
		sb.append("\n");
		sb.append(Messages.toComplete(tester.getActualOutput(), Optional.empty(), tester.getActualTokensLists(),
				DsaPrefixedLineTester::toLine));
		String equalityMessage = sb.toString();

		assertEquals(equalityMessage, expectedValue, actualValue, delta);
	}

	@Test
	public void testEvenNumberOfElements() throws Exception {
		List<Integer> originalValues = Arrays.asList(20, 30);
		double expectedValue = 25.0;

		PrefixedLineTester tester = new DsaPrefixedLineTester(originalValues, Optional.empty(),
				Optional.of(DsaPrefixedLine.MEDIAN));
		List<String> actualTokens = tester.toOneAndOnlyOnePrefixedTokens();

		int skipPrefixFromIndex = 1;
		List<Double> actualValues = LenientTextUtils.toDoubles(actualTokens, skipPrefixFromIndex);

		String sizeMessage = tester.toMessage("Line prefixed by Median: should only print one number.");
		assertEquals(sizeMessage, 1, actualValues.size());
		double actualValue = actualValues.get(0);

		double delta = 0.0001;

		StringBuilder sb = new StringBuilder();
		sb.append(
				"\nMedian value of an even number of values is the average of the two closest to the middle values.\n");
		sb.append("\nexpected: ").append(expectedValue).append("; actual: ").append(actualValue).append("\n");
		sb.append(Messages.toLine(tester.getActualOutput(), Optional.empty(),
				tester.getActualTokensLists(), DsaPrefixedLine.MEDIAN.getExpectedIndex(),
				DsaPrefixedLineTester::toLine));
		sb.append("\n");
		sb.append(Messages.toComplete(tester.getActualOutput(), Optional.empty(), tester.getActualTokensLists(),
				DsaPrefixedLineTester::toLine));
		String equalityMessage = sb.toString();
		assertNotEquals(equalityMessage, originalValues.get(0), actualValue, delta);
		assertNotEquals(equalityMessage, originalValues.get(1), actualValue, delta);
		assertEquals(equalityMessage, expectedValue, actualValue, delta);
	}
}
