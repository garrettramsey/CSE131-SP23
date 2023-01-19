package conway.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import conway.Conway;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ClearPreliminaryTest {
	@Test
	public void test() {
		int rows = 3;
		int columns = 5;

		Conway conway = new Conway(rows, columns);
		assertEquals(rows, conway.getRows());
		assertEquals(columns, conway.getColumns());

		for (int r = 0; r < rows; ++r) {
			for (int c = 0; c < columns; ++c) {
				assertFalse(conway.isAlive(r, c));
			}
		}

		int rAlive = 1;
		int cAlive = 2;

		conway.setAlive(true, rAlive, cAlive);
		for (int r = 0; r < rows; ++r) {
			for (int c = 0; c < columns; ++c) {
				boolean expected = r == rAlive && c == cAlive;
				assertEquals(expected, conway.isAlive(r, c));
			}
		}

		conway.clear();
		for (int r = 0; r < rows; ++r) {
			for (int c = 0; c < columns; ++c) {
				assertFalse(conway.isAlive(r, c));
			}
		}
	}
}
