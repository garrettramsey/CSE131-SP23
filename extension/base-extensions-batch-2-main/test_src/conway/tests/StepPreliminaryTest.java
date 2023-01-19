package conway.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import conway.Conway;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class StepPreliminaryTest {
	@Test
	public void testAliveCellWith0LivingNeighborsDies() {
		Conway conway = new Conway(3, 3);
		conway.setAlive(true, 1, 1);

		assertTrue(conway.isAlive(1, 1));
		assertEquals(0, conway.countLivingNeighbors(1, 1));
		conway.step();
		assertFalse(conway.isAlive(1, 1));
	}

	@Test
	public void testAliveCellWith1LivingNeighborsDies() {
		Conway conway = new Conway(3, 3);
		conway.setAlive(true, 1, 1);
		conway.setAlive(true, 1, 2);

		assertTrue(conway.isAlive(1, 1));
		assertEquals(1, conway.countLivingNeighbors(1, 1));
		conway.step();
		assertFalse(conway.isAlive(1, 1));
	}

	@Test
	public void testAliveCellWith2LivingNeighborsStaysAlive() {
		Conway conway = new Conway(3, 3);
		conway.setAlive(true, 1, 1);
		conway.setAlive(true, 1, 2);
		conway.setAlive(true, 2, 1);

		assertTrue(conway.isAlive(1, 1));
		assertEquals(2, conway.countLivingNeighbors(1, 1));
		conway.step();
		assertTrue(conway.isAlive(1, 1));
	}

	@Test
	public void testAliveCellWith3LivingNeighborsStaysAlive() {
		Conway conway = new Conway(3, 3);
		conway.setAlive(true, 1, 1);
		conway.setAlive(true, 1, 2);
		conway.setAlive(true, 2, 1);
		conway.setAlive(true, 1, 0);

		assertTrue(conway.isAlive(1, 1));
		assertEquals(3, conway.countLivingNeighbors(1, 1));
		conway.step();
		assertTrue(conway.isAlive(1, 1));
	}

	@Test
	public void testAliveCellWith4LivingNeighborsDies() {
		Conway conway = new Conway(3, 3);
		conway.setAlive(true, 1, 1);
		conway.setAlive(true, 1, 2);
		conway.setAlive(true, 2, 1);
		conway.setAlive(true, 1, 0);
		conway.setAlive(true, 0, 1);

		assertTrue(conway.isAlive(1, 1));
		assertEquals(4, conway.countLivingNeighbors(1, 1));
		conway.step();
		assertFalse(conway.isAlive(1, 1));
	}

	@Test
	public void testAliveCellWith5LivingNeighborsDies() {
		Conway conway = new Conway(3, 3);
		conway.setAlive(true, 1, 1);
		conway.setAlive(true, 1, 2);
		conway.setAlive(true, 2, 1);
		conway.setAlive(true, 1, 0);
		conway.setAlive(true, 0, 1);
		conway.setAlive(true, 0, 0);

		assertTrue(conway.isAlive(1, 1));
		assertEquals(5, conway.countLivingNeighbors(1, 1));
		conway.step();
		assertFalse(conway.isAlive(1, 1));
	}

	@Test
	public void testDeadCellWith3LivingNeighborsComesAlive() {
		Conway conway = new Conway(3, 3);
		conway.setAlive(true, 0, 1);
		conway.setAlive(true, 0, 2);
		conway.setAlive(true, 1, 2);

		assertFalse(conway.isAlive(1, 1));
		conway.step();
		assertTrue(conway.isAlive(1, 1));
	}

}
