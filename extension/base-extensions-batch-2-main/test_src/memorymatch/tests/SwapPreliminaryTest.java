package memorymatch.tests;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

import memorymatch.MemoryMatchBoard;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class SwapPreliminaryTest {
	@Test
	public void test1x2() {
		Color[][] board = new Color[1][2];
		board[0][0] = Color.BLACK;
		board[0][1] = Color.WHITE;

		// swap
		MemoryMatchBoard.swapCells(board, 0, 0, 0, 1);
		assertEquals(board[0][0], Color.WHITE);
		assertEquals(board[0][1], Color.BLACK);

		// swap back
		MemoryMatchBoard.swapCells(board, 0, 0, 0, 1);
		assertEquals(board[0][0], Color.BLACK);
		assertEquals(board[0][1], Color.WHITE);

		// swap
		MemoryMatchBoard.swapCells(board, 0, 1, 0, 0);
		assertEquals(board[0][0], Color.WHITE);
		assertEquals(board[0][1], Color.BLACK);

		// swap back
		MemoryMatchBoard.swapCells(board, 0, 1, 0, 0);
		assertEquals(board[0][0], Color.BLACK);
		assertEquals(board[0][1], Color.WHITE);
	}
}
