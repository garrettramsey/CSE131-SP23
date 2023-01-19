package conway;

import support.cse131.NotYetImplementedException;

public class Conway {

	/**
	 * Constructs a new Conway board rows X columns in size with each cell's alive
	 * status false.
	 * 
	 * @param rows the number of rows
	 * @param cols the number of columns
	 */
	public Conway(int rows, int cols) {

		// FIXME
		throw new NotYetImplementedException();

	}

	/**
	 * @return the number of rows
	 */
	public int getRows() {

		// FIXME
		throw new NotYetImplementedException();

	}

	/**
	 * @return the number of columns
	 */
	public int getColumns() {

		// FIXME
		throw new NotYetImplementedException();

	}

	/**
	 * Sets the current status of the cell at (row, col)
	 * 
	 * @param isAlive if true, the cell is alive; if false, the cell is dead
	 * @param row
	 * @param col
	 */
	public void setAlive(boolean isAlive, int row, int col) {

		// FIXME
		throw new NotYetImplementedException();

	}

	/**
	 * @param row
	 * @param col
	 * @return whether or not a cell at a specific row and column is alive.
	 *         If row or col is out of bounds, you must return false.
	 */
	public boolean isAlive(int row, int col) {

		// FIXME
		throw new NotYetImplementedException();

	}

	/**
	 * Make every cell not alive
	 */
	public void clear() {

		// FIXME
		throw new NotYetImplementedException();

	}

	/**
	 * Consider the 3x3 cell array that has the cell at (row, col) at its center.
	 * Let's call all cells but that center cell the neighbors of that center cell.
	 * This method returns the number of neighbors that are alive.
	 * 
	 * n n n
	 * n c n
	 * n n n
	 * 
	 * Above, if c represents the cell at (row, col), each n is
	 * a neighbor of c, according to the above definition.
	 * The result is at most 8 and at least 0.
	 * 
	 * @param row
	 * @param col
	 * @return the number of living neighbors
	 */
	public int countLivingNeighbors(int row, int col) {

		// FIXME
		throw new NotYetImplementedException();

	}

	/**
	 * Executes a generation of life. Be sure to read the specification
	 * for this assignment, because it points out a common mistake students
	 * make when implementing this method.
	 * 
	 */
	public void step() {

		// FIXME
		throw new NotYetImplementedException();

	}
}