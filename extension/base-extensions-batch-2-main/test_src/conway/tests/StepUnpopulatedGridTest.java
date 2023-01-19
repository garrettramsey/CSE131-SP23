package conway.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import conway.Conway;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class StepUnpopulatedGridTest {
	private final int rows;
	private final int columns;

	public StepUnpopulatedGridTest(int rows, int columns) {
		super();
		this.rows = rows;
		this.columns = columns;
	}

	private static void testUnpopulated(Conway conway, int rows, int columns) {
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

	@Test
	public void test() {
		Conway conway = new Conway(rows, columns);

		testUnpopulated(conway, rows, columns);
		for (int i = 0; i < 4; ++i) {
			conway.step();
			testUnpopulated(conway, rows, columns);
		}
	}

	@Parameterized.Parameters(name = "rows: {0}, cols: {1}")
	public static Collection<Object[]> getConstructorArguments() {
		Collection<Object[]> args = new LinkedList<>();

		args.add(new Object[] { 1, 1 });
		args.add(new Object[] { 1, 2 });
		args.add(new Object[] { 2, 1 });
		args.add(new Object[] { 2, 4 });
		args.add(new Object[] { 3, 5 });
		args.add(new Object[] { 7, 11 });

		Random random = new Random();
		for (int i = 0; i < 16; ++i) {
			args.add(new Object[] { 1 + random.nextInt(19), 1 + random.nextInt(19) });
		}

		return args;
	}

}
