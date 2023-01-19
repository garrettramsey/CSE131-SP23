package support.cse131.minesweeper.gui;

import java.awt.GridLayout;
import java.util.function.Supplier;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class CellMatrixPane<C extends AbstractButton & Cell<K>, K> extends JPanel {
	private static final long serialVersionUID = 1L;
	private final C[][] cells;
	private final GridLayout gridLayout;

	public CellMatrixPane(C[][] cells, Supplier<C> cellSupplier) {
		this.cells = cells;
		ButtonGroup buttonGroup = new ButtonGroup() {
			private static final long serialVersionUID = 1L;

			@Override
			public void setSelected(ButtonModel m, boolean b) {
				if (b) {
					super.setSelected(m, b);
				} else {
					clearSelection();
				}
			}
		};
		for (int r = 0; r < this.cells.length; ++r) {
			for (int c = 0; c < this.cells[r].length; ++c) {
				this.cells[r][c] = cellSupplier.get();
				buttonGroup.add(this.cells[r][c]);
			}
		}
		gridLayout = new GridLayout(1, 0, 2, 2);
		setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		setLayout(gridLayout);
	}

	public void updateCells(K[][] keys) {
		if (keys.length > 0) {
			int prevRows = gridLayout.getRows();
			int prevCols = gridLayout.getColumns();
			int nextRows = keys.length;
			int nextCols = keys[0].length;
			if (nextRows > cells.length) {
				throw new IllegalArgumentException();
			}
			if (nextCols > cells[0].length) {
				throw new IllegalArgumentException();
			}
			if (prevRows != nextRows || prevCols != nextCols) {
				removeAll();
				gridLayout.setRows(nextRows);
				gridLayout.setColumns(nextCols);
				for (int r = 0; r < nextRows; ++r) {
					for (int c = 0; c < nextCols; ++c) {
						add(cells[r][c]);
					}
				}
			}
			for (int r = 0; r < nextRows; ++r) {
				for (int c = 0; c < nextCols; ++c) {
					cells[r][c].update(r, c, keys);
				}
			}
		} else {
			throw new IllegalArgumentException();
		}
	}
}
