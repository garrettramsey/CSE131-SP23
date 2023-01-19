package memorymatch.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import memorymatch.MemoryMatchBoard;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class SwapComprehensiveTest {
	private final int aRow;
	private final int aCol;
	private final int bRow;
	private final int bCol;

	public SwapComprehensiveTest(int aRow, int aCol, int bRow, int bCol) {
		super();
		this.aRow = aRow;
		this.aCol = aCol;
		this.bRow = bRow;
		this.bCol = bCol;
	}

	@Test
	public void test3x5() {
		Color[][] original = {
				{ new Color(0x000000), new Color(0x004949), new Color(0x009292), new Color(0xff6db6),
						new Color(0xffb16db) },
				{ new Color(0x490092), new Color(0x006ddb), new Color(0xb66dff), new Color(0x6db6ff),
						new Color(0xb6dbff) },
				{ new Color(0x920000), new Color(0x924900), new Color(0xdb6d00), new Color(0x24ff24),
						new Color(0xffff6d) } };

		Color[][] copy = BoardTestUtils.deepCopy(original);
		assertArrayEquals(original, copy);

		MemoryMatchBoard.swapCells(copy, aRow, aCol, bRow, bCol);

		for (int r = 0; r < original.length; ++r) {
			for (int c = 0; c < original[r].length; ++c) {
				int oRow;
				int oCol;
				if (r == aRow && c == aCol) {
					oRow = bRow;
					oCol = bCol;
				} else if (r == bRow && c == bCol) {
					oRow = aRow;
					oCol = aCol;
				} else {
					oRow = r;
					oCol = c;
				}
				String message = toMessage(oRow, oCol, original, r, c, copy);
				assertEquals(message, original[oRow][oCol], copy[r][c]);
			}
		}
	}

	private static String toMessage(int oRow, int oCol, Color[][] original, int r, int c, Color[][] copy) {
		StringBuilder sb = new StringBuilder();
		if (oRow == r && oCol == c) {
			sb.append(String.format("\nswap expected\n"));
		} else {
			sb.append(String.format("\nswap NOT expected\n"));
		}
		sb.append("\noriginal\n");
		sb.append("========\n");
		append(sb, original);
		sb.append("\ncopy\n");
		sb.append("====\n");
		append(sb, copy);
		sb.append("\n");
		return sb.toString();
	}

	private static void append(StringBuilder sb, Color[][] matrix) {
		for (int r = 0; r < matrix.length; ++r) {
			for (int c = 0; c < matrix[r].length; ++c) {
				Color color = matrix[r][c];
				sb.append(String.format("0x%06x", color.getRGB() & 0xFFFFFF));
				sb.append(" ");
			}
			sb.append("\n");
		}
	}

	@Parameterized.Parameters(name = "[{0},{1}], [{2},{3}]")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();

		int rowCount = 3;
		int colCount = 5;
		Random random = new Random(131_231_425L);

		for (int i = 0; i < 131; ++i) {
			args.add(new Object[] { random.nextInt(rowCount), random.nextInt(colCount), random.nextInt(rowCount),
					random.nextInt(colCount) });
		}
		return args;
	}
}
