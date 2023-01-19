package conway.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import conway.Conway;

public class ConwayGridPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private final Conway conway;
	private final CellViz[][] cells;

	public ConwayGridPanel(Conway conway, int cellWidth) {
		this.conway = conway;
		int rows;
		int cols;
		Throwable throwable;
		try {
			rows = conway.getRows();
			cols = conway.getColumns();
			throwable = null;
		} catch (Throwable t) {
			rows = 0;
			cols = 0;
			throwable = t;
		}
		cells = new CellViz[rows][cols];
		if (cells.length > 0) {
			setLayout(new GridLayout(rows, cols));
			for (int i = 0; i < cells.length; ++i) {
				for (int j = 0; j < cells[i].length; ++j) {
					Cell c = new Cell(conway, i, j);
					CellViz cell = new CellViz(c, cellWidth, i, j, conway);
					cells[i][j] = cell;
					this.add(cell);
				}
			}
		} else {
			setLayout(new BorderLayout());
			add(new JLabel(throwable.toString()));
		}
	}

	public void displayLiveness() {
		for (int r = 0; r < cells.length; ++r) {
			for (int c = 0; c < cells[r].length; ++c) {
				cells[r][c].displayLiveness(conway.isAlive(r, c));
			}
		}
	}

}
