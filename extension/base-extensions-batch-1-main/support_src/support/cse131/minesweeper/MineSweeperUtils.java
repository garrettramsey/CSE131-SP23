package support.cse131.minesweeper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import minesweeper.MineSweeper;
import support.cse131.LenientTextUtils;
import support.cse131.SystemOutputUtils;
import test.cse131.Messages;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class MineSweeperUtils {
	public static String runMain(int colCount, int rowCount, double probability) throws IOException {
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		String input = Integer.toString(colCount) + "\n" + Integer.toString(rowCount) + "\n" + Double.toString(probability) + "\n";
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		return SystemOutputUtils.capture(() -> {
			MineSweeper.main(new String[] { });
			System.setIn(sysInBackup);

		});
		
	}

	public static Optional<Integer>[][] toOptionalCounts(String output, List<List<String>> linesOfTokenLists, int colCount, int rowCount) {

		String rowHeader = "\nPrinted row count does not match specified row count.\nexpected row count: " + rowCount
				+ "; actual printed row count: " + linesOfTokenLists.size() + "\n";
		String rowMessage = toMessage(rowHeader, output, linesOfTokenLists);
		assertEquals(rowMessage, rowCount, linesOfTokenLists.size());
		for (List<String> line : linesOfTokenLists) {
			String colHeader = "\nPrinted column count is not twice (as expected) the column count specified by the user.\nexpected column count: "
					+ (colCount * 2)
					+ "; actual printed column count: " + line.size() + "\n";
			String colMessage = toMessage(colHeader, output, linesOfTokenLists);
			assertEquals(colMessage, colCount * 2, line.size());
		}

		@SuppressWarnings("unchecked")
		Optional<Integer>[][] counts = new Optional[rowCount][colCount];

		int r = 0;
		for (List<String> line : linesOfTokenLists) {
			for (int c = 0; c < colCount; ++c) {
				int countIndex = c + colCount;
				String a = line.get(c);
				String b = line.get(countIndex);
				if (Objects.equals("*", a)) {
					String mineEqualityHeader = "\nAt row: " + r + ", column: " + c + "\nLeft and right sides do not match\nThe * on the left side not accompanied by * on the right side\nExpected: *; Actual: " + b + "\n";
					String mineEqualityMessage = toMessage(mineEqualityHeader, output, linesOfTokenLists);
					assertEquals(mineEqualityMessage, "*", b);
					counts[r][c] = Optional.empty();
				} else {
					String validLeftSideHeader = "\nAt row: " + r + ", column: " + c + "\nLeft side must be * or .\nActual: " + a + "\n";
					String validLeftSideMessage = toMessage(validLeftSideHeader, output, linesOfTokenLists);
					assertEquals(validLeftSideMessage, ".", a);

					String notMineHeader = "\nAt row: " + r + ", column: " + c + "\nLeft side . incorrectly accompanied * on the right.\nThe right side for this row and column should be the number of adjacent mines.\nActual: " + b + "\n";
					String notMineMessage = toMessage(notMineHeader, output, linesOfTokenLists);
					assertNotEquals(notMineMessage, "*", b);
					
					counts[r][c] = toIntegerOpt(b);

					String notNumberHeader = "\nAt row: " + r + ", column: " + c + "\nLeft side . not accompanied by number on the right\nActual: " + b + "\n";
					String notNumberMessage = toMessage(notNumberHeader, output, linesOfTokenLists);
					assertTrue(notNumberMessage, counts[r][c].isPresent());
				}
			}
			++r;
		}

		return counts;
	}

	public static int toCorrectCount(Optional<Integer>[][] optionalCounts, int row, int col) {
		int count = 0;
		for (int r = row - 1; r <= row + 1; ++r) {
			for (int c = col - 1; c <= col + 1; ++c) {
				if (r != row || c != col) {
					if (isMine(optionalCounts, r, c)) {
						++count;
					}
				}
			}
		}
		return count;
	}

	private static boolean isMine(Optional<Integer>[][] optionalCounts, int row, int col) {
		if (row < 0) {
			return false;
		}
		if (row >= optionalCounts.length) {
			return false;
		}
		if (col < 0) {
			return false;
		}
		if (col >= optionalCounts[row].length) {
			return false;
		}
		return !optionalCounts[row][col].isPresent();
	}

	public static String toMessage(String header, String actualOutput, List<List<String>> linesOfTokenLists) {
		StringBuilder sb = new StringBuilder();
		sb.append(header);
		sb.append("\n");
		sb.append(Messages.toComplete(actualOutput, Optional.empty(), linesOfTokenLists,
				(list, i) -> LenientTextUtils.toLine(list.get(i))));
		return sb.toString();
	}
	
	private static Optional<Integer> toIntegerOpt(String token) {
		try {
			return Optional.of(Integer.parseInt(token));
		} catch(NumberFormatException nfe) {
			return Optional.empty();
		}
	}

}
