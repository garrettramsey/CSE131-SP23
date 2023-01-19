package sortanalysis.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
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
public class EchoInputComprehensiveTest {
	private final List<Integer> originalValues;
	private final String expectedOutput;

	public EchoInputComprehensiveTest(List<Integer> originalValues, String expectedOutput) {
		this.originalValues = originalValues;
		this.expectedOutput = expectedOutput;
	}

	@Test
	public void test() throws Exception {
		PrefixedLineTester tester = new DsaPrefixedLineTester(originalValues, expectedOutput, DsaPrefixedLine.INPUT);
		List<String> actualTokens = tester.toOneAndOnlyOnePrefixedTokens();

		//actualTokens = actualTokens.subList(originalValues.size() + 1, actualTokens.size());
		int skipPrefixFromIndex = 1;
		List<Integer> actualValues = LenientTextUtils.toIntegers(actualTokens, skipPrefixFromIndex);

		List<Integer> unexpected = new ArrayList<>(originalValues.size() + 1);
		unexpected.add(originalValues.size());
		unexpected.addAll(originalValues);

		String sizeIncludedAsContentsMessage = tester
				.toMessage("Unexpected size printed with expected array contents.");
		assertNotEquals(sizeIncludedAsContentsMessage, unexpected, actualValues);

		String sizeMessage = tester.toMessage("Unexpected number of items printed.");
		assertEquals(sizeMessage, originalValues.size(), actualValues.size());

		String independentOfOrderMessage = tester
				.toMessage("Does not contain the correct items (even independent of order).");
		Tests.assertEqualsIndependentOfOrder(independentOfOrderMessage, originalValues, actualValues);

		String equalsMessage = tester.toMessage("Contains the correct items but not in the correct order.");
		assertEquals(equalsMessage, originalValues, actualValues);
	}

	@Parameterized.Parameters(name = "original: {0}; expectedOutput: {1}")
	public static Collection<Object[]> getConstructorArguments() throws Exception {
		return TestCases.getConstructorArguments();
	}
}
