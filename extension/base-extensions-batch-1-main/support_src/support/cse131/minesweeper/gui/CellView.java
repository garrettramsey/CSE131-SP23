package support.cse131.minesweeper.gui;

import java.awt.Font;
import java.util.Optional;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import support.cse131.minesweeper.MineSweeperUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class CellView extends JToggleButton implements Cell<Optional<Integer>> {
	private static final long serialVersionUID = 1L;

	private static final Icon X_ICON = new ImageIcon(CellView.class.getResource("images/x.png"));

	private Font baseFont;
	private Font mineFont;

	public CellView() {
		baseFont = getFont();
		mineFont = baseFont.deriveFont(baseFont.getSize2D() * 1.5f);
	}

	@Override
	public void update(int row, int col, Optional<Integer>[][] optionalCounts) {
		String text;
		String tooltip = null;
		Icon icon = null;
		Font font = baseFont;
		if (optionalCounts[row][col].isPresent()) {
			int actual = optionalCounts[row][col].get();
			int expected = MineSweeperUtils.toCorrectCount(optionalCounts, row, col);
			if (expected == actual) {
				text = Integer.toString(actual);
			} else {
				text = String.format("%d (%d)", actual, expected);
				tooltip = String.format(
						"<html><p>cell[row=%d][col=%d]</p><p style=\"margin-left: 12px\">printed: <strong>%d</strong></p><p style=\"margin-left: 12px\">expected: <strong>%d</strong></p></html>",
						row, col, actual, expected);
				icon = X_ICON;
			}
		} else {
			text = "*";
			font = mineFont;
		}
		setToolTipText(tooltip);
		setText(text);
		setIcon(icon);
		setFont(font);
	}
}