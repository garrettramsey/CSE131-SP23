package minesweeper;

import support.cse131.minesweeper.gui.MineSweeperFrame;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class MineSweeperDebugApp {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(()->MineSweeperFrame.createAndShowGUI());
	}
}
