package minesweeper.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import support.cse131.LenientTextUtils;
import support.cse131.minesweeper.MineSweeperUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class ProbabilityTest {
	private final double probability;

	public ProbabilityTest(double probability, int iteration) {
		this.probability = probability;
	}

	@Test
	public void test() throws IOException {
		Random random = new Random();
		int rowCount = 30 + random.nextInt(10);
		int colCount = 30 + random.nextInt(10);
		String output = MineSweeperUtils.runMain(colCount, rowCount, probability);
		List<List<String>> linesOfTokenLists = LenientTextUtils.toLinesOfTokenLists(output);
		linesOfTokenLists = linesOfTokenLists.subList(3, linesOfTokenLists.size());

		Optional<Integer>[][] optionalCounts = MineSweeperUtils.toOptionalCounts(output, linesOfTokenLists, colCount, rowCount);
		int bombCount = 0;
		for (int r = 0; r < rowCount; ++r) {
			for (int c = 0; c < colCount; ++c) {
				if (optionalCounts[r][c].isPresent()) {
					//pass
				} else {
					++bombCount;
				}
			}
		}
		double actual = bombCount / (double) (rowCount * colCount);
		double delta = 0.1;
		assertEquals(probability, actual, delta);
	}

	@Parameterized.Parameters(name = "probability: {0}; iteration: {1}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		for (double probability = 0.15; probability < 0.9; probability += 0.15) {
			for (int i = 0; i < 3; ++i) {
				args.add(new Object[] { probability, i });
			}
		}
		return args;
	}
}
