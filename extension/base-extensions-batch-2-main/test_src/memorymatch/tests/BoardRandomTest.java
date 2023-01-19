package memorymatch.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import memorymatch.MemoryMatchBoard;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class BoardRandomTest {
	@Test
	public void test() {
		int expectedUniqueCount = 10;
		int actualUniqueCount = 0;
		List<Color[][]> boards = new ArrayList<>(expectedUniqueCount);
		Color[] palette = MemoryMatchBoard.getPalette();
		for (int i = 0; i < expectedUniqueCount; ++i) {
			Color[][] board = MemoryMatchBoard.generateShuffled4x4Board(palette);
			if (deepContains(boards, board)) {
				// pass
			} else {
				++actualUniqueCount;
				boards.add(board);
			}
		}

		int checkCount = expectedUniqueCount - 2;
		assertThat("\nExpected to find: " + expectedUniqueCount + " unique boards.\nFound only: " + actualUniqueCount
				+ " unique board(s).\nTo allow for random chance of duplicates we only that assert greater than "
				+ checkCount + " unique boards are found.",
				actualUniqueCount,
				greaterThan(checkCount));
	}

	private static boolean deepContains(List<Color[][]> boards, Color[][] target) {
		for (Color[][] board : boards) {
			if (Arrays.deepEquals(board, target)) {
				return true;
			}
		}
		return false;
	}
}
