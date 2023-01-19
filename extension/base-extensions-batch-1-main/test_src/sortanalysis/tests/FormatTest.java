package sortanalysis.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import test.NumberType;
import test.PrefixedLine;
import test.PrefixedLineOfNumbers;
import test.PrefixedLineTester;
import test.cse131.Messages;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class FormatTest {
	@Test
	public void test() throws Exception {
		List<Integer> originalValues = Arrays.asList(9, 42, 12);
		String expectedOutput = "Input: 9 42 12\n"
				+ "Sorted: 9 12 42\n"
				+ "Mean: 21.0\n"
				+ "Median: 12.0\n"
				+ "Min: 9\n"
				+ "Max: 42\n"
				+ "Range: 33";
		PrefixedLineTester tester = new DsaPrefixedLineTester(originalValues, Optional.of(expectedOutput),
				Optional.empty());

		List<List<String>> actualTokensLists = tester.getActualTokensLists();
		actualTokensLists = actualTokensLists.subList(originalValues.size() + 1, actualTokensLists.size());
		
		List<List<String>> expectedTokensLists = tester.getExpectedTokensLists();
		StringBuilder sb = new StringBuilder();
		sb.append("\n\nToo many lines.\n\n");
		sb.append("Expected line count: (at most) ").append(expectedTokensLists.size()).append(" lines.\n");
		sb.append("Actual line count: ").append(actualTokensLists.size()).append(" lines.\n");
		sb.append("\n");
		sb.append(Messages.toComplete(tester.getActualOutput(), expectedTokensLists, actualTokensLists,
				DsaPrefixedLineTester::toLine));
		String tooManyLinesMessage = sb.toString();
		assertThat(tooManyLinesMessage, actualTokensLists.size(), lessThanOrEqualTo(expectedTokensLists.size()));

		for (PrefixedLine line : DsaPrefixedLine.values()) {
			//if (line.getExpectedIndex() < actualTokensLists.size()) {
			//	tester.toOneAndOnlyOnePrefixedTokensAtLine(line);
			//}
		}

		int lineIndex = 0;
		for (List<String> actualTokens : actualTokensLists) {
			PrefixedLineOfNumbers lineOfNumbers = DsaPrefixedLine.values()[lineIndex];
			NumberType numberType = lineOfNumbers.getNumberType();
			List<String> actualTokensWhichShouldBeNumbers = actualTokens.subList(1, actualTokens.size());

			String emptyMessage = tester.toMessageAtLine("Unexpected line with no numbers after the prefix.",
					lineOfNumbers);
			assertFalse(emptyMessage, actualTokensWhichShouldBeNumbers.isEmpty());

			for (String token : actualTokensWhichShouldBeNumbers) {
				String header = token + " is not an integer or a double.  Expected: " + numberType.name().toLowerCase()
						+ ".";
				assertTrue(tester.toMessageAtLine(header, lineOfNumbers), NumberType.DOUBLE.isParsable(token));
			}

			if (numberType == NumberType.INTEGER) {
				for (String token : actualTokensWhichShouldBeNumbers) {
					String header = token + " is a double.  However, an integer is expected.";
					assertTrue(tester.toMessageAtLine(header, lineOfNumbers), NumberType.INTEGER.isParsable(token));
				}
			}
			++lineIndex;
		}
	}
}
