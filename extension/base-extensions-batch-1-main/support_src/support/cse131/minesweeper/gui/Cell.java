package support.cse131.minesweeper.gui;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
interface Cell<T> {
	void update(int r, int c, T[][] t);
}
