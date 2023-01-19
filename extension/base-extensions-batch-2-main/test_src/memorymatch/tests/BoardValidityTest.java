package memorymatch.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import memorymatch.MemoryMatchBoard;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class BoardValidityTest {
	@Test
	public void test() {
		Color[] palette = MemoryMatchBoard.getPalette();
		Color[][] board = MemoryMatchBoard.generateShuffled4x4Board(palette);
		assertNotNull(board);
		assertEquals(4, board.length);

		// use sorted sets in an attempt to improve messages
		Comparator<Color> colorComparator = (a, b) -> Integer.compare(a.getRGB(), b.getRGB());
		Set<Color> firstFounds = new TreeSet<>(colorComparator);
		Set<Color> secondFounds = new TreeSet<>(colorComparator);

		for (int r = 0; r < board.length; ++r) {
			assertNotNull(board[r]);
			assertEquals(4, board[r].length);
			for (int c = 0; c < board[r].length; ++c) {
				Color color = board[r][c];
				String nullMessage = BoardTestMessages.toMessage("", r, c, board);
				assertNotNull(nullMessage, color);

				if (firstFounds.add(color)) {
					// pass
				} else {
					boolean success = secondFounds.add(color);
					String foundTwiceAlreadyMessage = BoardTestMessages.toMessage("Color found twice already.\n", r, c,
							board);
					assertTrue(foundTwiceAlreadyMessage, success);
				}
			}
		}

		String firstMessage = BoardTestMessages
				.toMessage("Expected to find 8 unique colors.\nfirstFounds: " + firstFounds + "\n", board);
		assertEquals(firstMessage, 8, firstFounds.size());

		String secondMessage = BoardTestMessages.toMessage(
				"Expected to find 8 matches of the 8 unique colors.\nfirstFounds: " + firstFounds + "\nsecondFounds: "
						+ secondFounds + "\n",
				board);
		assertEquals(secondMessage, 8, secondFounds.size());

		// this case should already be taken care of by the tests above
		String equalityMessage = BoardTestMessages
				.toMessage("Expected equivalent Sets of Colors for first found and second found.\n", board);
		assertEquals(equalityMessage, firstFounds, secondFounds);
	}
}
