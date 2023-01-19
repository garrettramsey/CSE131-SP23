package memorymatch.tests;

import java.awt.Color;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class BoardTestMessages {
	static String toMessage(String header, Color[][] board) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append(header);
		sb.append("\nboard:\n");
		for (Color[] row : board) {
			sb.append("\t");
			for (Color color : row) {
				sb.append(String.format("%-34s", color));
			}
			sb.append("\n");
		}
		sb.append("\n");
		return sb.toString();
	}

	static String toMessage(String header, int r, int c, Color[][] board) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append(header);
		sb.append("\nboard[").append(r).append("][").append(c).append("] = ").append(board[r][c]).append("\n");
		sb.append("\nboard:\n");
		for (Color[] row : board) {
			sb.append("\t");
			for (Color color : row) {
				sb.append(String.format("%-34s", color));
			}
			sb.append("\n");
		}
		sb.append("\n");
		return sb.toString();
	}

}
