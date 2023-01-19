package conway.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import conway.Conway;
import org.junit.Test;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class AlivePopulatedGridTest {
	private void test(boolean[][] liveMatrix) {
		int rows = liveMatrix.length;
		int columns = liveMatrix[0].length;
		Conway conway = new Conway(rows, columns);
		assertEquals(rows, conway.getRows());
		assertEquals(columns, conway.getColumns());
		for (int r = 0; r < rows; ++r) {
			for (int c = 0; c < columns; ++c) {
				assertFalse(conway.isAlive(r, c));
			}
		}

		for (int r = 0; r < rows; ++r) {
			for (int c = 0; c < columns; ++c) {
				conway.setAlive(liveMatrix[r][c], r, c);
			}
		}

		for (int r = 0; r < rows; ++r) {
			for (int c = 0; c < columns; ++c) {
				assertEquals(liveMatrix[r][c], conway.isAlive(r, c));
			}
		}
	}

		@Test
	public void testUnpopulated2x4() {
		boolean[][] aliveMatrix = {
				{false, false, false, false}, 
				{false, false, false, false}
		};
		test(aliveMatrix);
	}

	@Test
	public void testBlinker() {
		boolean[][] aliveMatrix = {
				{false, false, false}, 
				{true, true, true}, 
				{false, false, false}
		};
		test(aliveMatrix);
	}

	@Test
	public void testToad() {
		boolean[][] aliveMatrix = {
				{false, false, false, false, false, false}, 
				{false, false, false, false, false, false}, 
				{false, false, true, true, true, false}, 
				{false, true, true, true, false, false}, 
				{false, false, false, false, false, false}, 
				{false, false, false, false, false, false}
		};
		test(aliveMatrix);
	}

	@Test
	public void testBeacon() {
		boolean[][] aliveMatrix = {
				{false, false, false, false, false, false}, 
				{false, true, true, false, false, false}, 
				{false, true, false, false, false, false}, 
				{false, false, false, false, true, false}, 
				{false, false, false, true, true, false}, 
				{false, false, false, false, false, false}
		};
		test(aliveMatrix);
	}

	@Test
	public void testFourBlinkers() {
		boolean[][] aliveMatrix = {
				{false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false}, 
				{false, false, false, true, true, true, false, false, false}, 
				{false, false, false, true, true, true, false, false, false}, 
				{false, false, false, true, true, true, false, false, false}, 
				{false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false}
		};
		test(aliveMatrix);
	}

	@Test
	public void testGlider() {
		boolean[][] aliveMatrix = {
				{false, false, false, false, false, false, false, false, false, false}, 
				{false, true, false, true, false, false, false, false, false, false}, 
				{false, false, true, true, false, false, false, false, false, false}, 
				{false, false, true, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false}
		};
		test(aliveMatrix);
	}

	@Test
	public void testGosperGliderGun() {
		boolean[][] aliveMatrix = {
				{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false}, 
				{false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, true, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false}, 
				{false, false, false, true, true, false, false, false, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, true, true, false, false, false, false, false, false, false, false, true, false, false, false, true, false, true, true, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}
		};
		test(aliveMatrix);
	}

	@Test
	public void testFull3x5() {
		boolean[][] aliveMatrix = {
				{true, true, true, true, true}, 
				{true, true, true, true, true}, 
				{true, true, true, true, true}
		};
		test(aliveMatrix);
	}

	@Test
	public void testFull7x11() {
		boolean[][] aliveMatrix = {
				{true, true, true, true, true, true, true, true, true, true, true}, 
				{true, true, true, true, true, true, true, true, true, true, true}, 
				{true, true, true, true, true, true, true, true, true, true, true}, 
				{true, true, true, true, true, true, true, true, true, true, true}, 
				{true, true, true, true, true, true, true, true, true, true, true}, 
				{true, true, true, true, true, true, true, true, true, true, true}, 
				{true, true, true, true, true, true, true, true, true, true, true}
		};
		test(aliveMatrix);
	}

	@Test
	public void testRandom5x8() {
		boolean[][] aliveMatrix = {
				{true, false, false, false, false, true, true, false}, 
				{true, true, true, false, true, false, true, false}, 
				{false, false, false, false, true, true, true, false}, 
				{false, false, true, true, false, true, true, true}, 
				{false, false, false, true, true, false, true, true}
		};
		test(aliveMatrix);
	}

	@Test
	public void testRandom7x9() {
		boolean[][] aliveMatrix = {
				{false, false, false, false, false, true, true, false, false}, 
				{true, true, false, false, true, true, false, true, true}, 
				{false, true, true, false, false, false, true, false, true}, 
				{true, false, true, true, false, true, true, true, false}, 
				{false, true, true, true, true, false, false, false, true}, 
				{true, false, false, true, true, true, false, true, true}, 
				{true, false, false, false, true, false, false, false, false}
		};
		test(aliveMatrix);
	}

}
