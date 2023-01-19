package minesweeper.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import support.cse131.LenientTextUtils;
import support.cse131.minesweeper.MineSweeperUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class CountTest {
	private final int colCount;
	private final int rowCount;
	private final double probability;

	public CountTest(int colCount, int rowCount, double probability) {
		this.colCount = colCount;
		this.rowCount = rowCount;
		this.probability = probability;
	}

	@Test
	public void test() throws IOException {
		String output = MineSweeperUtils.runMain(colCount, rowCount, probability);
		List<List<String>> linesOfTokenLists = LenientTextUtils.toLinesOfTokenLists(output);
		//remove first three lines as they are prompts
		linesOfTokenLists = linesOfTokenLists.subList(3, linesOfTokenLists.size());
		
		Optional<Integer>[][] optionalCounts = MineSweeperUtils.toOptionalCounts(output, linesOfTokenLists, colCount,
				rowCount);
		for (int r = 0; r < optionalCounts.length; ++r) {
			for (int c = 0; c < optionalCounts[r].length; ++c) {
				if (optionalCounts[r][c].isPresent()) {
					int expected = MineSweeperUtils.toCorrectCount(optionalCounts, r, c);
					int actual = optionalCounts[r][c].get();
					String equalityHeader = "\nAt row: " + r + ", column: " + c
							+ "\nLeft side . is accompanied by a number, however it is not correct.\nRight side expected: " + expected + "; Right side actual: " + actual + "\n";
					String equalityMessage = MineSweeperUtils.toMessage(equalityHeader, output, linesOfTokenLists);
					assertEquals(equalityMessage, expected, actual);
				}
			}
		}
	}

	@Parameterized.Parameters(name = "colCount: {0}; rowCount: {1}; probability: {2}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		List<Integer> colCounts = Arrays.asList(1, 2, 5, 9, 23);
		List<Integer> rowCounts = Arrays.asList(1, 2, 7, 42);
		List<Double> probabilies = Arrays.asList(0.0, 0.4, 0.75, 1.0);
		for (int colCount : colCounts) {
			for (int rowCount : rowCounts) {
				for (double probability : probabilies) {
					args.add(new Object[] { colCount, rowCount, probability });
				}
			}
		}
		return args;
	}
}
