package memorymatch;

import java.awt.Color;

import support.cse131.NotYetImplementedException;

public class MemoryMatchBoard {
	/**
	 * @return an array of 8 discernible colors
	 */
	public static Color[] getPalette() {
		// http://mkweb.bcgsc.ca/colorblind/img/colorblindness.palettes.v11.pdf
		Color[] palette = new Color[] {
				new Color(0, 0, 0),
				new Color(34, 113, 178),
				new Color(61, 183, 233),
				new Color(247, 72, 165),
				new Color(53, 155, 115),
				new Color(213, 94, 0),
				new Color(230, 159, 0),
				new Color(240, 228, 66)
		};
		return palette;
	}

	/**
	 * Swaps the colors located at board[aRow][aCol] and board[bRow][bCol].
	 * 
	 * Note: this mutates (changes) the contents of the specified board.
	 * 
	 * @param board the 2D array of colors
	 */
	public static void swapCells(Color[][] board, int aRow, int aCol, int bRow, int bCol) {
		
			// TODO
		
	}

	

	/**
	 * Rearranges the colors in the specified board until they are in a reasonably
	 * random arrangement.
	 * 
	 * Note: this mutates (changes) the contents of the specified board.
	 * 
	 * @param board the 2D array of colors to shuffle
	 */
	public static void shuffle(Color[][] board) {
		
			// TODO
		
	}

	/**
	 * @param palette an array of 8 Colors
	 * @return shuffled 4x4 2D array of Colors suitable for a memory match game
	 */
	public static Color[][] generateShuffled4x4Board(Color[] palette) {
		
			// Delete the line below and implement this method
			throw new NotYetImplementedException();
		
	}
}
