package support.cse131.color.resources;

import java.awt.Color;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class Colors {
	public static Color[][] get3x5ColorBlindFriendlyPalette() {
		// https://jacksonlab.agronomy.wisc.edu/2016/05/23/15-level-colorblind-friendly-palette/
		// http://mkweb.bcgsc.ca/biovis2012/krzywinski-visualizing-biological-data.pdf
		// http://mkweb.bcgsc.ca/biovis2012/color-blindness-palette.png
		Color[] colors = { new Color(0x000000), new Color(0x004949), new Color(0x009292), new Color(0xff6db6),
				new Color(0xffb16db), new Color(0x490092), new Color(0x006ddb), new Color(0xb66dff),
				new Color(0x6db6ff), new Color(0xb6dbff), new Color(0x920000), new Color(0x924900), new Color(0xdb6d00),
				new Color(0x24ff24), new Color(0xffff6d) };
		int rowCount = 3;
		int colCount = 5;
		Color[][] result = new Color[rowCount][colCount];
		for (int r = 0; r < rowCount; ++r) {
			for (int c = 0; c < colCount; ++c) {
				result[r][c] = colors[r * colCount + c];
			}
		}
		return result;
	}

	public static Color[][] get5x3ColorBlindFriendlyPalette() {
		Color[][] a = get3x5ColorBlindFriendlyPalette();
		int rowCount = a[0].length;
		int colCount = a.length;
		Color[][] result = new Color[rowCount][colCount];
		for (int r = 0; r < rowCount; ++r) {
			for (int c = 0; c < colCount; ++c) {
				result[r][c] = a[c][r];
			}
		}
		return result;
	}

	public static Color[][] get5x7ColorBlindFriendlyGradient() {
		Color[][] gradient = {
				{ new Color(73, 0, 146), new Color(63, 21, 146), new Color(52, 42, 146), new Color(42, 63, 146),
						new Color(31, 83, 146), new Color(21, 104, 146), new Color(0, 146, 146), },
				{ new Color(88, 0, 117), new Color(83, 24, 120), new Color(77, 48, 123), new Color(72, 72, 126),
						new Color(66, 96, 129), new Color(62, 120, 132), new Color(51, 168, 139), },
				{ new Color(102, 0, 88), new Color(103, 27, 94), new Color(102, 54, 100), new Color(102, 81, 106),
						new Color(102, 108, 112), new Color(102, 135, 119), new Color(102, 190, 131), },
				{ new Color(117, 0, 58), new Color(122, 30, 68), new Color(127, 61, 77), new Color(133, 91, 87),
						new Color(137, 121, 96), new Color(143, 151, 105), new Color(153, 211, 124), },
				{ new Color(146, 0, 0), new Color(162, 36, 16), new Color(177, 73, 31), new Color(193, 109, 47),
						new Color(208, 146, 62), new Color(224, 182, 78), new Color(255, 255, 109), }, };
		return gradient;
	}
}
