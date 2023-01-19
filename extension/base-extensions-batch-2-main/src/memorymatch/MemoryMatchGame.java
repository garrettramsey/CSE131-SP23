package memorymatch;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.NotYetImplementedException;

public class MemoryMatchGame {
	private static final int X = 0;
	private static final int Y = 1;

	private static void defineWorldBoundaries() {
		// TODO: change values to a more convenient space if you so desire
		double xMin = 0.0;
		double xMax = 1.0;
		double yMin = 0.0;
		double yMax = 1.0;

		

		StdDraw.setXscale(xMin, xMax);
		StdDraw.setYscale(yMin, yMax);
	}

	private static double[] waitForMouseClick() {
		// wait for the mouse to be pressed
		while (!StdDraw.isMousePressed()) {
			StdDraw.pause(10);
		}
		// wait for the mouse to be released
		while (StdDraw.isMousePressed()) {
			StdDraw.pause(10);
		}
		// TODO: return the current mouse position
		
			// Delete the line below and implement this method
			throw new NotYetImplementedException();
		
	}

	private static int toRow(double[] xy) {
		double y = xy[Y];
		
			// Delete the line below and implement this method
			throw new NotYetImplementedException();
		
	}

	private static int toColumn(double[] xy) {
		double x = xy[X];
		
			// Delete the line below and implement this method
			throw new NotYetImplementedException();
		
	}

	private static int[] waitForClickOnRowColumn() {
		double[] xy = waitForMouseClick();
		int r = toRow(xy);
		int c = toColumn(xy);
		return new int[] { r, c };
	}

	// private static void drawBoard(Color[][] board, TODO) {
	// TODO
	// }

	

	// private static boolean isGameStillAlive(TODO) {
	// TODO
	// }

	

	public static void playGame() {
		defineWorldBoundaries();
		Color[] palette = MemoryMatchBoard.getPalette();
		Color[][] board = MemoryMatchBoard.generateShuffled4x4Board(palette);
		
			// Delete the line below and implement this method
			throw new NotYetImplementedException();
		
	}

	public static void main(String[] args) {
		playGame();
	}

}
