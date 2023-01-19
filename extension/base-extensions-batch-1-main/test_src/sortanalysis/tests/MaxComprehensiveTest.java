package sortanalysis.tests;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import support.cse131.LenientTextUtils;
import test.PrefixedLineTester;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class MaxComprehensiveTest {
	private final List<Integer> originalValues;
	private final String expectedOutput;

	public MaxComprehensiveTest(List<Integer> originalValues, String expectedOutput) {
		this.originalValues = originalValues;
		this.expectedOutput = expectedOutput;
	}

	@Test
	public void test() throws Exception {
		PrefixedLineTester tester = new DsaPrefixedLineTester(originalValues, expectedOutput, DsaPrefixedLine.MAX);
		List<String> actualTokens = tester.toOneAndOnlyOnePrefixedTokens();
		List<String> expectedTokens = tester.getExpectedTokensAtDefaultLine();

		int skipPrefixFromIndex = 1;
		List<Integer> expectedValues = LenientTextUtils.toIntegers(expectedTokens, skipPrefixFromIndex);
		List<Integer> actualValues = LenientTextUtils.toIntegers(actualTokens, skipPrefixFromIndex);

		String sizeMessage = tester.toMessage("Unexpected number of items printed.");
		assertEquals(sizeMessage, expectedValues.size(), actualValues.size());

		int expectedValue = expectedValues.get(0);
		int actualValue = actualValues.get(0);

		String equalsMessage = tester.toMessage(String.format("expected: %d; actual: %d", expectedValue, actualValue));
		assertEquals(equalsMessage, expectedValue, actualValue);
	}

	@Parameterized.Parameters(name = "original: {0}; expectedOutput: {1}")
	public static Collection<Object[]> getConstructorArguments() throws Exception {
		return TestCases.getConstructorArguments();
	}
}
