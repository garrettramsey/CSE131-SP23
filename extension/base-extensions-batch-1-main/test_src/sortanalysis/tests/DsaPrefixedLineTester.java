package sortanalysis.tests;

import java.util.List;
import java.util.Optional;

import sortanalysis.DataSortingAndAnalysisTestSuite;
import support.cse131.LenientTextUtils;
import test.PrefixedLine;
import test.PrefixedLineTester;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DsaPrefixedLineTester extends PrefixedLineTester {
	public DsaPrefixedLineTester(List<Integer> input, Optional<String> expectedOutputOpt,
			Optional<PrefixedLine> defaultLineOpt)
			throws Exception {
		super(() -> DataSortingAndAnalysisTestSuite.invokeMainWithSizeAndContents(input), expectedOutputOpt,
				defaultLineOpt);
	}

	public DsaPrefixedLineTester(List<Integer> input, String expectedOutput, PrefixedLine defaultLine)
			throws Exception {
		super(() -> DataSortingAndAnalysisTestSuite.invokeMainWithSizeAndContents(input), Optional.of(expectedOutput),
				Optional.of(defaultLine));
	}

	static String toLine(List<List<String>> lists, Integer index) {
		return LenientTextUtils.toLine(lists.get(index));
	}
}
