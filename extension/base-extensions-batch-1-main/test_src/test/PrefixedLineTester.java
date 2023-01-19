package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

import support.cse131.LenientTextUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class PrefixedLineTester {
	private final PrefixedLine defaultLine;
	private final String actualOutput;
	private final List<List<String>> actualTokensLists;
	private final Optional<List<List<String>>> expectedTokensListsOpt;
	private final Optional<String> expectedSubMessageOpt;

	public PrefixedLineTester(Callable<String> toActualOutput, Optional<String> expectedOutputOpt,
			Optional<PrefixedLine> defaultLineOpt)
			throws Exception {
		defaultLine = defaultLineOpt.isPresent() ? defaultLineOpt.get() : null;
		actualOutput = toActualOutput.call();
		actualTokensLists = LenientTextUtils.toLinesOfTokenLists(actualOutput);
		expectedTokensListsOpt = expectedOutputOpt.isPresent()
				? Optional.of(LenientTextUtils.toLinesOfTokenLists(expectedOutputOpt.get()))
				: Optional.empty();
//		expectedSubMessage = toPotentiallyFewerExpectedLines(expectedTokensLists, actualTokensLists.size());
		expectedSubMessageOpt = expectedTokensListsOpt.isPresent()
				? Optional.of(toExpectedLines(expectedTokensListsOpt.get()))
				: Optional.empty();
	}

//	private static String toPotentiallyFewerExpectedLines(List<List<String>> tokensLists, int lineCount) {
//		if (lineCount == tokensLists.size()) {
//			return toExpectedLines(tokensLists);
//		} else {
//			StringBuilder sb = new StringBuilder();
//			sb.append("\n");
//			sb.append(String.format("=== expected (first %d of %d) lines ===\n", lineCount, tokensLists.size()));
//			sb.append(toTextFromLinesOfTokens(tokensLists.subList(0, lineCount)));
//			return sb.toString();
//		}
//	}

	public String getActualOutput() {
		return actualOutput;
	}

	public List<List<String>> getExpectedTokensLists() {
		if (expectedSubMessageOpt.isPresent()) {
			return expectedTokensListsOpt.get();
		} else {
			return null;
		}
	}

	public List<String> getExpectedTokensAtDefaultLine() {
		if(expectedTokensListsOpt.isPresent()) {
			return expectedTokensListsOpt.get().get(defaultLine.getExpectedIndex());
		} else {
			return null;
		}
	}

	public List<List<String>> getActualTokensLists() {
		return actualTokensLists;
	}

	private List<TokensIndexPair> toTokensIndexPairsOfPrefixedTokensAtLine(PrefixedLine line) {
		List<TokensIndexPair> result = new LinkedList<>();
		int index = 0;
		for (List<String> tokens : actualTokensLists) {
			if (tokens.size() > 0) {
				String first = tokens.get(0);
				for (String prefix : line.getAcceptablePrefixes()) {
					if (first.equalsIgnoreCase(prefix)) {
						result.add(new TokensIndexPair(tokens, index));
						break;
					}
				}
			}
			++index;
		}
		return result;
	}

	public TokensIndexPair toOneAndOnlyOnePrefixedTokensIndexPairAtLine(PrefixedLine line) {
		List<TokensIndexPair> tokensIndexPairs = toTokensIndexPairsOfPrefixedTokensAtLine(line);

		String prefixedLineNotFoundMessage = toPrefixedLineNotFoundMessage(line);
		assertNotEquals(prefixedLineNotFoundMessage, 0, tokensIndexPairs.size());

		String prefixedLineMultipleFoundMessage = toPrefixedLineMultipleFoundMessage(tokensIndexPairs, line);
		assertEquals(prefixedLineMultipleFoundMessage, 1, tokensIndexPairs.size());

		return tokensIndexPairs.get(0);
	}

	public TokensIndexPair toOneAndOnlyOnePrefixedTokensIndexPair() {
		return toOneAndOnlyOnePrefixedTokensIndexPairAtLine(defaultLine);
	}

	public List<String> toOneAndOnlyOnePrefixedTokensAtLine(PrefixedLine line) {
		TokensIndexPair tokenIndexPair = toOneAndOnlyOnePrefixedTokensIndexPairAtLine(line);
		
		StringBuilder sb = new StringBuilder();
		sb.append("Found line with acceptable prefix but on unexpected line number.\n\n");

		sb.append(String.format("=== actual (cleaned) line[%d] (was expecting to find at index %d)\n",
				tokenIndexPair.getIndex(), line.getExpectedIndex()));
		sb.append(LenientTextUtils.toLine(tokenIndexPair.getTokens()));

		String incorrectLineMessage = toMessageAtLine(sb.toString(), line);
		//assertEquals(incorrectLineMessage, line.getExpectedIndex(), tokenIndexPair.getIndex());
		return tokenIndexPair.getTokens();
	}

	public List<String> toOneAndOnlyOnePrefixedTokens() {
		return toOneAndOnlyOnePrefixedTokensAtLine(defaultLine);
	}

	public String toMessageAtLine(String header, PrefixedLine line) {
		int expectedIndex = line.getExpectedIndex();
		String actualSubMessage = toCleanedActualLinesPrinted(actualTokensLists);
		StringBuilder sb = new StringBuilder();
		sb.append("\n").append(header).append("\n");
		if (expectedTokensListsOpt.isPresent()) {
			sb.append("\n=== expected line[").append(expectedIndex).append("] ===\n");
			sb.append(LenientTextUtils.toLine(expectedTokensListsOpt.get().get(expectedIndex)));
		}
		sb.append("\n=== actual (cleaned) line[").append(expectedIndex).append("] ===\n");
		sb.append(LenientTextUtils.toLine(actualTokensLists.get(expectedIndex)));
		if (expectedSubMessageOpt.isPresent()) {
			sb.append("\n\n");
			sb.append(expectedSubMessageOpt.get());
		}
		sb.append(actualSubMessage);
		sb.append("\n");
		return sb.toString();
	}

	public String toMessage(String header) {
		return toMessageAtLine(header, defaultLine);
	}

	private String toAcceptablePrefixesText(PrefixedLine line) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		String p = "";
		for (String acceptablePrefix : line.getAcceptablePrefixes()) {
			sb.append(p);
			sb.append("\"");
			sb.append(acceptablePrefix);
			sb.append("\"");
			p = " OR ";
		}
		sb.append("]");
		return sb.toString();
	}

	private String toPrefixedLineNotFoundMessage(PrefixedLine line) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\nUnable to find line with a required (case-insensitive) acceptable prefix:\n    ")
				.append(toAcceptablePrefixesText(line)).append("\n");
		if (expectedSubMessageOpt.isPresent()) {
			sb.append(expectedSubMessageOpt.get());
			sb.append("\n");
		}
		sb.append(toCleanedActualLinesPrinted(actualTokensLists));
		sb.append("\n");
		return sb.toString();
	}

	private String toPrefixedLineMultipleFoundMessage(List<TokensIndexPair> tokensIndexPairs, PrefixedLine line) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\nFound multiple (").append(tokensIndexPairs.size())
				.append(") lines with a required (case-insensitive) acceptable prefix:\n    ")
				.append(toAcceptablePrefixesText(line)).append(").\nShould only find 1.\n");
		if (expectedSubMessageOpt.isPresent()) {
			sb.append(expectedSubMessageOpt.get());
		}
		sb.append(toCleanedActualLinesPrinted(actualTokensLists));
		sb.append("\n");
		sb.append("=== multiple (cleaned) lines found ===\n");
		sb.append(toTextFromTokensIndexPairs(tokensIndexPairs));
		sb.append("\n");
		return sb.toString();
	}

	private static String toTextFromLinesOfTokens(List<List<String>> actualLinesOfTokenLists) {
		StringBuilder sb = new StringBuilder();
		for (List<String> tokenList : actualLinesOfTokenLists) {
			sb.append(LenientTextUtils.toLine(tokenList));
		}
		return sb.toString();
	}

	private static String toTextFromTokensIndexPairs(List<TokensIndexPair> tokenIndexPairs) {
		StringBuilder sb = new StringBuilder();
		for (TokensIndexPair tokenIndexPair : tokenIndexPairs) {
			sb.append("(counting from 0) line[");
			sb.append(tokenIndexPair.getIndex());
			sb.append("]: ");
			sb.append(LenientTextUtils.toLine(tokenIndexPair.getTokens()));
		}
		return sb.toString();
	}

	private static String toExpectedLines(List<List<String>> tokensLists) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("=== expected lines ===\n");
		sb.append(toTextFromLinesOfTokens(tokensLists));
		return sb.toString();
	}

	private static String toCleanedActualLinesPrinted(List<List<String>> tokensLists) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("=== actual (cleaned) lines ===\n");
		sb.append(toTextFromLinesOfTokens(tokensLists));
		return sb.toString();
	}
}
