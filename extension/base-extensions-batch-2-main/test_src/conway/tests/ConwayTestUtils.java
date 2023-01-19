package conway.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import conway.Conway;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ConwayTestUtils {
	static void testUnpopulated(Conway conway, int rows, int columns) {
		assertEquals(rows, conway.getRows());
		assertEquals(columns, conway.getColumns());
		for (int r = 0; r < rows; ++r) {
			for (int c = 0; c < columns; ++c) {
				assertFalse(conway.isAlive(r, c));
			}
		}

		for (int r = 0; r < rows; ++r) {
			for (int c = 0; c < columns; ++c) {
				assertEquals(0, conway.countLivingNeighbors(r, c));
			}
		}
	}

	static void populate(Conway conway, boolean[][] liveMatrix) {
		int rows = liveMatrix.length;
		int columns = liveMatrix[0].length;
		for (int r = 0; r < rows; ++r) {
			for (int c = 0; c < columns; ++c) {
				conway.setAlive(liveMatrix[r][c], r, c);
			}
		}
	}

	static void testPopulated(Conway conway, boolean[][] liveMatrix, int[][] countMatrix) {
		int rows = liveMatrix.length;
		int columns = liveMatrix[0].length;
		assertEquals(rows, conway.getRows());
		assertEquals(columns, conway.getColumns());
		for (int r = 0; r < rows; ++r) {
			for (int c = 0; c < columns; ++c) {
				assertEquals(liveMatrix[r][c], conway.isAlive(r, c));
			}
		}

		for (int r = 0; r < rows; ++r) {
			for (int c = 0; c < columns; ++c) {
				assertEquals(countMatrix[r][c], conway.countLivingNeighbors(r, c));
			}
		}
	}
}
