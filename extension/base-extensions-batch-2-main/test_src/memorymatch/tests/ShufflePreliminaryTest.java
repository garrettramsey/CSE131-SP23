package memorymatch.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

import java.awt.Color;
import java.util.Arrays;

import org.junit.Test;

import memorymatch.MemoryMatchBoard;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ShufflePreliminaryTest {
	@Test
	public void test() {
		Color[][] original = new Color[2][2];
		original[0][0] = Color.BLACK;
		original[0][1] = Color.RED;
		original[1][0] = Color.BLUE;
		original[1][1] = Color.MAGENTA;

		Color[][] copy = BoardTestUtils.deepCopy(original);

		assertArrayEquals(original, copy);
		final int N = 100;
		int i;
		for (i = 0; i < N; ++i) {
			MemoryMatchBoard.shuffle(copy);
			if (!Arrays.deepEquals(original, copy)) {
				break;
			}
		}

		String neverChangedMessage = String.format("shuffled %d times and board never changed", N);
		assertNotEquals(neverChangedMessage, N, i);
	}
}
