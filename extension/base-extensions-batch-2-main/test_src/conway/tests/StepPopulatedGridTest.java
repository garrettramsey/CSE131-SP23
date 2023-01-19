package conway.tests;

import conway.Conway;
import org.junit.Test;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class StepPopulatedGridTest {
	private static void test(boolean[][] liveMatrix, int[][] countMatrix, boolean[][] liveMatrixPrime,
			int[][] countMatrixPrime) {
		int rows = liveMatrix.length;
		int columns = liveMatrix[0].length;
		Conway conway = new Conway(rows, columns);

		ConwayTestUtils.testUnpopulated(conway, rows, columns);
		ConwayTestUtils.populate(conway, liveMatrix);
		ConwayTestUtils.testPopulated(conway, liveMatrix, countMatrix);

		conway.clear();

		ConwayTestUtils.testUnpopulated(conway, rows, columns);
		ConwayTestUtils.populate(conway, liveMatrix);
		ConwayTestUtils.testPopulated(conway, liveMatrix, countMatrix);

		conway.step();

		ConwayTestUtils.testPopulated(conway, liveMatrixPrime, countMatrixPrime);
	}

		@Test
	public void testUnpopulated2x4() {
		boolean[][] aliveMatrix = {
				{false, false, false, false}, 
				{false, false, false, false}
		};
		int[][] countMatrix = {
				{0, 0, 0, 0}, 
				{0, 0, 0, 0}
		};
		boolean[][] aliveMatrixPrime = {
				{false, false, false, false}, 
				{false, false, false, false}
		};
		int[][] countMatrixPrime = {
				{0, 0, 0, 0}, 
				{0, 0, 0, 0}
		};
		test(aliveMatrix, countMatrix, aliveMatrixPrime, countMatrixPrime);
	}

	@Test
	public void testBlinker() {
		boolean[][] aliveMatrix = {
				{false, false, false}, 
				{true, true, true}, 
				{false, false, false}
		};
		int[][] countMatrix = {
				{2, 3, 2}, 
				{1, 2, 1}, 
				{2, 3, 2}
		};
		boolean[][] aliveMatrixPrime = {
				{false, true, false}, 
				{false, true, false}, 
				{false, true, false}
		};
		int[][] countMatrixPrime = {
				{2, 1, 2}, 
				{3, 2, 3}, 
				{2, 1, 2}
		};
		test(aliveMatrix, countMatrix, aliveMatrixPrime, countMatrixPrime);
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
		int[][] countMatrix = {
				{0, 0, 0, 0, 0, 0}, 
				{0, 1, 2, 3, 2, 1}, 
				{1, 3, 4, 4, 2, 1}, 
				{1, 2, 4, 4, 3, 1}, 
				{1, 2, 3, 2, 1, 0}, 
				{0, 0, 0, 0, 0, 0}
		};
		boolean[][] aliveMatrixPrime = {
				{false, false, false, false, false, false}, 
				{false, false, false, true, false, false}, 
				{false, true, false, false, true, false}, 
				{false, true, false, false, true, false}, 
				{false, false, true, false, false, false}, 
				{false, false, false, false, false, false}
		};
		int[][] countMatrixPrime = {
				{0, 0, 1, 1, 1, 0}, 
				{1, 1, 2, 1, 2, 1}, 
				{2, 1, 3, 3, 2, 2}, 
				{2, 2, 3, 3, 1, 2}, 
				{1, 2, 1, 2, 1, 1}, 
				{0, 1, 1, 1, 0, 0}
		};
		test(aliveMatrix, countMatrix, aliveMatrixPrime, countMatrixPrime);
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
		int[][] countMatrix = {
				{1, 2, 2, 1, 0, 0}, 
				{2, 2, 2, 1, 0, 0}, 
				{2, 2, 3, 2, 1, 1}, 
				{1, 1, 2, 3, 2, 2}, 
				{0, 0, 1, 2, 2, 2}, 
				{0, 0, 1, 2, 2, 1}
		};
		boolean[][] aliveMatrixPrime = {
				{false, false, false, false, false, false}, 
				{false, true, true, false, false, false}, 
				{false, true, true, false, false, false}, 
				{false, false, false, true, true, false}, 
				{false, false, false, true, true, false}, 
				{false, false, false, false, false, false}
		};
		int[][] countMatrixPrime = {
				{1, 2, 2, 1, 0, 0}, 
				{2, 3, 3, 2, 0, 0}, 
				{2, 3, 4, 4, 2, 1}, 
				{1, 2, 4, 4, 3, 2}, 
				{0, 0, 2, 3, 3, 2}, 
				{0, 0, 1, 2, 2, 1}
		};
		test(aliveMatrix, countMatrix, aliveMatrixPrime, countMatrixPrime);
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
		int[][] countMatrix = {
				{0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 1, 2, 3, 2, 1, 0, 0}, 
				{0, 0, 2, 3, 5, 3, 2, 0, 0}, 
				{0, 0, 3, 5, 8, 5, 3, 0, 0}, 
				{0, 0, 2, 3, 5, 3, 2, 0, 0}, 
				{0, 0, 1, 2, 3, 2, 1, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		boolean[][] aliveMatrixPrime = {
				{false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, true, false, false, false, false}, 
				{false, false, false, true, false, true, false, false, false}, 
				{false, false, true, false, false, false, true, false, false}, 
				{false, false, false, true, false, true, false, false, false}, 
				{false, false, false, false, true, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false}
		};
		int[][] countMatrixPrime = {
				{0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 1, 1, 1, 0, 0, 0}, 
				{0, 0, 1, 2, 2, 2, 1, 0, 0}, 
				{0, 1, 2, 2, 3, 2, 2, 1, 0}, 
				{0, 1, 2, 3, 4, 3, 2, 1, 0}, 
				{0, 1, 2, 2, 3, 2, 2, 1, 0}, 
				{0, 0, 1, 2, 2, 2, 1, 0, 0}, 
				{0, 0, 0, 1, 1, 1, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		test(aliveMatrix, countMatrix, aliveMatrixPrime, countMatrixPrime);
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
		int[][] countMatrix = {
				{1, 1, 2, 1, 1, 0, 0, 0, 0, 0}, 
				{1, 1, 4, 2, 2, 0, 0, 0, 0, 0}, 
				{1, 3, 4, 3, 2, 0, 0, 0, 0, 0}, 
				{0, 2, 2, 3, 1, 0, 0, 0, 0, 0}, 
				{0, 1, 1, 1, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		boolean[][] aliveMatrixPrime = {
				{false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, true, false, false, false, false, false, false}, 
				{false, true, false, true, false, false, false, false, false, false}, 
				{false, false, true, true, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false}
		};
		int[][] countMatrixPrime = {
				{0, 0, 1, 1, 1, 0, 0, 0, 0, 0}, 
				{1, 1, 3, 1, 2, 0, 0, 0, 0, 0}, 
				{1, 1, 5, 3, 3, 0, 0, 0, 0, 0}, 
				{1, 2, 3, 2, 2, 0, 0, 0, 0, 0}, 
				{0, 1, 2, 2, 1, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		test(aliveMatrix, countMatrix, aliveMatrixPrime, countMatrixPrime);
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
		int[][] countMatrix = {
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 3, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 1, 0, 0, 0, 0, 1, 2, 3, 1, 3, 1, 2, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 1}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 1, 2, 1, 1, 0, 0, 2, 3, 4, 3, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 2, 3, 3, 2}, 
				{0, 0, 1, 2, 2, 1, 0, 0, 0, 0, 0, 0, 1, 2, 2, 3, 2, 2, 1, 2, 1, 0, 3, 5, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 3, 2}, 
				{0, 0, 2, 3, 3, 2, 0, 0, 0, 0, 0, 0, 2, 2, 3, 1, 1, 2, 4, 3, 3, 1, 2, 3, 4, 3, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 1}, 
				{0, 0, 2, 3, 3, 2, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 1, 0, 4, 3, 3, 1, 1, 2, 3, 1, 3, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 1, 2, 2, 1, 0, 0, 0, 0, 0, 0, 2, 2, 3, 1, 1, 2, 4, 3, 3, 1, 0, 0, 1, 1, 3, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 3, 2, 2, 1, 2, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		boolean[][] aliveMatrixPrime = {
				{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, true, true, false}, 
				{false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false, false, false, true, true, false}, 
				{false, false, false, true, true, false, false, false, false, false, false, false, false, true, true, false, false, false, false, true, true, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, true, true, false, false, false, false, false, false, false, true, true, true, false, false, false, false, true, true, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, true, true, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}
		};
		int[][] countMatrixPrime = {
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 3, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 2, 2, 4, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 1}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3, 2, 2, 0, 0, 0, 0, 1, 2, 2, 4, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 3, 2}, 
				{0, 0, 1, 2, 2, 1, 0, 0, 0, 0, 0, 0, 1, 3, 4, 3, 2, 0, 1, 2, 2, 2, 2, 3, 5, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 3, 2}, 
				{0, 0, 2, 3, 3, 2, 0, 0, 0, 0, 0, 1, 3, 5, 5, 4, 1, 0, 2, 3, 3, 3, 2, 2, 4, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 1}, 
				{0, 0, 2, 3, 3, 2, 0, 0, 0, 0, 0, 1, 3, 6, 5, 3, 0, 0, 3, 5, 5, 3, 1, 2, 2, 4, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 1, 2, 2, 1, 0, 0, 0, 0, 0, 1, 3, 5, 5, 4, 1, 0, 2, 3, 3, 2, 0, 1, 1, 3, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3, 4, 3, 2, 0, 1, 2, 2, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		test(aliveMatrix, countMatrix, aliveMatrixPrime, countMatrixPrime);
	}

	@Test
	public void testFull3x5() {
		boolean[][] aliveMatrix = {
				{true, true, true, true, true}, 
				{true, true, true, true, true}, 
				{true, true, true, true, true}
		};
		int[][] countMatrix = {
				{3, 5, 5, 5, 3}, 
				{5, 8, 8, 8, 5}, 
				{3, 5, 5, 5, 3}
		};
		boolean[][] aliveMatrixPrime = {
				{true, false, false, false, true}, 
				{false, false, false, false, false}, 
				{true, false, false, false, true}
		};
		int[][] countMatrixPrime = {
				{0, 1, 0, 1, 0}, 
				{2, 2, 0, 2, 2}, 
				{0, 1, 0, 1, 0}
		};
		test(aliveMatrix, countMatrix, aliveMatrixPrime, countMatrixPrime);
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
		int[][] countMatrix = {
				{3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3}, 
				{5, 8, 8, 8, 8, 8, 8, 8, 8, 8, 5}, 
				{5, 8, 8, 8, 8, 8, 8, 8, 8, 8, 5}, 
				{5, 8, 8, 8, 8, 8, 8, 8, 8, 8, 5}, 
				{5, 8, 8, 8, 8, 8, 8, 8, 8, 8, 5}, 
				{5, 8, 8, 8, 8, 8, 8, 8, 8, 8, 5}, 
				{3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3}
		};
		boolean[][] aliveMatrixPrime = {
				{true, false, false, false, false, false, false, false, false, false, true}, 
				{false, false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false, false}, 
				{false, false, false, false, false, false, false, false, false, false, false}, 
				{true, false, false, false, false, false, false, false, false, false, true}
		};
		int[][] countMatrixPrime = {
				{0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0}, 
				{1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1}, 
				{0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0}
		};
		test(aliveMatrix, countMatrix, aliveMatrixPrime, countMatrixPrime);
	}

	@Test
	public void testRandom5x8() {
		boolean[][] aliveMatrix = {
				{false, true, true, true, true, true, false, true}, 
				{true, false, true, false, true, true, false, false}, 
				{true, false, false, false, false, true, false, true}, 
				{true, true, true, true, false, true, false, true}, 
				{false, false, false, false, false, false, false, true}
		};
		int[][] countMatrix = {
				{2, 3, 3, 4, 4, 3, 3, 0}, 
				{2, 5, 3, 5, 5, 4, 5, 2}, 
				{3, 6, 4, 4, 5, 3, 5, 1}, 
				{2, 3, 2, 1, 3, 1, 5, 2}, 
				{2, 3, 3, 2, 2, 1, 3, 1}
		};
		boolean[][] aliveMatrixPrime = {
				{false, true, true, false, false, true, true, false}, 
				{true, false, true, false, false, false, false, false}, 
				{true, false, false, false, false, true, false, false}, 
				{true, true, true, false, true, false, false, true}, 
				{false, true, true, false, false, false, true, false}
		};
		int[][] countMatrixPrime = {
				{2, 3, 2, 2, 1, 1, 1, 1}, 
				{2, 5, 2, 2, 2, 3, 3, 1}, 
				{3, 6, 3, 3, 2, 1, 2, 1}, 
				{3, 5, 3, 3, 1, 3, 3, 1}, 
				{3, 4, 3, 3, 1, 2, 1, 2}
		};
		test(aliveMatrix, countMatrix, aliveMatrixPrime, countMatrixPrime);
	}

	@Test
	public void testRandom7x9() {
		boolean[][] aliveMatrix = {
				{true, false, false, false, false, false, false, false, true}, 
				{false, true, true, false, true, false, true, true, false}, 
				{true, true, false, true, true, true, false, false, true}, 
				{false, true, true, true, false, false, false, false, false}, 
				{true, false, true, true, false, true, true, true, true}, 
				{true, true, false, false, true, true, true, true, false}, 
				{false, true, false, false, false, true, false, true, false}
		};
		int[][] countMatrix = {
				{1, 3, 2, 2, 1, 2, 2, 3, 1}, 
				{4, 4, 3, 4, 3, 4, 2, 3, 3}, 
				{3, 5, 7, 5, 4, 3, 3, 3, 1}, 
				{4, 5, 6, 5, 6, 4, 4, 4, 3}, 
				{3, 6, 5, 4, 5, 4, 5, 4, 2}, 
				{3, 4, 4, 3, 4, 5, 7, 5, 4}, 
				{3, 2, 2, 1, 3, 3, 5, 2, 2}
		};
		boolean[][] aliveMatrixPrime = {
				{false, true, false, false, false, false, false, true, false}, 
				{false, false, true, false, true, false, true, true, true}, 
				{true, false, false, false, false, true, true, true, false}, 
				{false, false, false, false, false, false, false, false, true}, 
				{true, false, false, false, false, false, false, false, true}, 
				{true, false, false, true, false, false, false, false, false}, 
				{true, true, false, false, true, true, false, true, false}
		};
		int[][] countMatrixPrime = {
				{1, 1, 2, 2, 1, 2, 3, 3, 3}, 
				{2, 3, 1, 2, 1, 4, 5, 5, 3}, 
				{0, 2, 1, 2, 2, 3, 4, 5, 4}, 
				{2, 2, 0, 0, 1, 2, 3, 4, 2}, 
				{1, 2, 1, 1, 1, 0, 0, 2, 1}, 
				{3, 4, 2, 1, 3, 2, 2, 2, 2}, 
				{2, 2, 2, 2, 2, 1, 2, 0, 1}
		};
		test(aliveMatrix, countMatrix, aliveMatrixPrime, countMatrixPrime);
	}

}
