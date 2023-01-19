package memorymatch.tests;

import java.awt.Color;
import java.util.Arrays;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class BoardTestUtils {
	public static Color[][] deepCopy(Color[][] matrix) {
		Color[][] copy = new Color[matrix.length][];
		for (int r = 0; r < matrix.length; ++r) {
			copy[r] = Arrays.copyOf(matrix[r], matrix[r].length);
		}
		return copy;
	}
}
