package fibonacci.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import fibonacci.ExpectedFibonaccis;
import fibonacci.Fibonacci;
import fibonacci.Graph;
import support.cse131.Timing;
import support.cse131.gui.LookAndFeels;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class FibonacciDebugAppFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private static class FibonacciTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;

		private final Optional<Integer>[] recursiveValues;
		private final Optional<Integer>[] recursiveTimes;
		private final Optional<Integer>[] iterativeValues;
		private final Optional<Integer>[] iterativeTimes;

		@SuppressWarnings("unchecked")
		public FibonacciTableModel(int rowCount) {
			recursiveValues = new Optional[rowCount];
			recursiveTimes = new Optional[rowCount];
			iterativeValues = new Optional[rowCount];
			iterativeTimes = new Optional[rowCount];
			Arrays.fill(recursiveValues, Optional.empty());
			Arrays.fill(recursiveTimes, Optional.empty());
			Arrays.fill(iterativeValues, Optional.empty());
			Arrays.fill(iterativeTimes, Optional.empty());
		}

		private static int[] toIntArray(Optional<Integer>[] opts) {
			int n = 0;
			for (int i = 0; i < opts.length; ++i) {
				if (opts[i].isPresent()) {
					n++;
				} else {
					break;
				}
			}
			int[] result = new int[n];
			for (int i = 0; i < n; ++i) {
				result[i] = opts[i].get();
			}
			return result;
		}

		public int[] recursiveTimes() {
			return toIntArray(recursiveTimes);
		}

		public int[] iterativeTimes() {
			return toIntArray(iterativeTimes);
		}

		@Override
		public String getColumnName(int columnIndex) {
			switch (columnIndex) {
			case 0:
				return "n";
			case 1:
				return "recursive(n)";
			case 2:
				return "recursive msec";
			case 3:
				return "iterative(n)";
			case 4:
				return "iterative msec";
			default:
				throw new Error(Integer.toString(columnIndex));
			}
		}

		@Override
		public java.lang.Class<?> getColumnClass(int columnIndex) {
			return Optional.class;
		}

		@Override
		public int getColumnCount() {
			return 5;
		}

		@Override
		public int getRowCount() {
			return iterativeTimes.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch (columnIndex) {
			case 0:
				return Optional.of(rowIndex);
			case 1:
				return recursiveValues[rowIndex];
			case 2:
				return recursiveTimes[rowIndex];
			case 3:
				return iterativeValues[rowIndex];
			case 4:
				return iterativeTimes[rowIndex];
			default:
				throw new Error(Integer.toString(columnIndex));
			}
		}

		public void updateRecursive(int rowIndex, int value, int time) {
			recursiveValues[rowIndex] = Optional.of(value);
			recursiveTimes[rowIndex] = Optional.of(time);
			fireTableCellUpdated(rowIndex, 1);
			fireTableCellUpdated(rowIndex, 2);
		}

		public void updateIterative(int rowIndex, int value, int time) {
			iterativeValues[rowIndex] = Optional.of(value);
			iterativeTimes[rowIndex] = Optional.of(time);
			fireTableCellUpdated(rowIndex, 3);
			fireTableCellUpdated(rowIndex, 4);
		}

		private static int correctCount(int[] actuals) {
			int correct = 0;
			int n = 0;
			for (int actual : actuals) {
				if (actual == ExpectedFibonaccis.expected(n)) {
					++correct;
				}
				++n;
			}
			return correct;

		}

		public void updateLabel(JLabel label) {
			int[] recursiveActuals = toIntArray(recursiveValues);
			int[] iterativeActuals = toIntArray(iterativeValues);
			int recursiveCorrect = correctCount(recursiveActuals);
			int iterativeCorrect = correctCount(iterativeActuals);
			label.setText(String.format("recursive: %d/%d; iterative: %d/%d", recursiveCorrect, recursiveActuals.length,
					iterativeCorrect, iterativeActuals.length));

			boolean isComplete = getRowCount() == recursiveActuals.length && getRowCount() == iterativeActuals.length;
			boolean isCorrect = recursiveCorrect == recursiveActuals.length
					&& iterativeCorrect == iterativeActuals.length;
			label.setIcon(
					isCorrect ? (isComplete ? EMPTY_ICON : INCOMPLETE_ICON) : ERROR_ICON);
		}
	}

	private static Icon INCOMPLETE_ICON;
	private static Icon ERROR_ICON;
	private static Icon EMPTY_ICON;

	private static class FibonacciTableCellRenderer extends DefaultTableCellRenderer {
		private static final long serialVersionUID = 1L;
		private static final Color ERROR_COLOR = new Color(144, 0, 0);

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
					column);
			@SuppressWarnings("unchecked")
			Optional<Integer> opt = (Optional<Integer>) value;
			setHorizontalAlignment(opt.isPresent() ? SwingConstants.RIGHT : SwingConstants.CENTER);
			String text;
			Color foreground = isSelected ? Color.WHITE : Color.BLACK;
			if (opt.isPresent()) {
				int actual = opt.get();
				text = Integer.toString(actual);
				if (column == 1 || column == 3) {
					int expected = ExpectedFibonaccis.expected(row);
					if (expected != actual) {
						text += "(" + expected + ")";
						foreground = ERROR_COLOR;
					}
				}
			} else {
				text = "?";
			}
			label.setForeground(foreground);
			label.setText(text);
			return label;
		}
	}

	private final JLabel label = new JLabel();
	private final FibonacciTableModel model = new FibonacciTableModel(43);

	public FibonacciDebugAppFrame() {
		super("Fibonacci Debug App");

		INCOMPLETE_ICON = LookAndFeels.getQuestionIcon();
		ERROR_ICON = LookAndFeels.getErrorIcon();
		EMPTY_ICON = new Icon() {
			@Override
			public void paintIcon(Component c, Graphics g, int x, int y) {
			}

			@Override
			public int getIconWidth() {
				return 0;
			}

			@Override
			public int getIconHeight() {
				return INCOMPLETE_ICON.getIconHeight();
			}
		};

		JTable table = new JTable(model);
		for (TableColumn column : Collections.list(table.getColumnModel().getColumns())) {
			column.setPreferredWidth(column.getPreferredWidth() * 2);
		}
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFillsViewportHeight(true);
		((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Optional.class, new FibonacciTableCellRenderer());
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		JButton graphButton = new JButton("Graph Timing");
		URL url = FibonacciDebugAppFrame.class.getResource("graph.png");
		if (url != null) {
			graphButton.setIcon(new ImageIcon(url));
		}

		graphButton.addActionListener((e) -> {
			Graph.graphLines(model.getRowCount(), new Color(144, 0, 0), "recursive", model.recursiveTimes(),
					new Color(0, 109, 219), "iterative", model.iterativeTimes());
		});
		graphButton.setFont(graphButton.getFont().deriveFont(Font.BOLD));

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(() -> {
			for (int i = 0; i < model.getRowCount(); ++i) {
				int _i = i;
				int t0 = Timing.getCurrentTimeInMilliseconds();
				int actualIterative = Fibonacci.iterative(i);
				int t1 = Timing.getCurrentTimeInMilliseconds();
				SwingUtilities.invokeLater(() -> {
					model.updateIterative(_i, actualIterative, t1 - t0);
					model.updateLabel(label);
				});
			}
		});
		executorService.submit(() -> {
			for (int i = 0; i < model.getRowCount(); ++i) {
				int _i = i;
				int t0 = Timing.getCurrentTimeInMilliseconds();
				int actualRecursive = Fibonacci.recursive(i);
				int t1 = Timing.getCurrentTimeInMilliseconds();
				SwingUtilities.invokeLater(() -> {
					model.updateRecursive(_i, actualRecursive, t1 - t0);
					model.updateLabel(label);
				});
			}
		});

		label.setFont(label.getFont().deriveFont(Font.BOLD, 18.0f));
		label.setIcon(INCOMPLETE_ICON);

		JPanel headerPane = new JPanel();
		headerPane.setLayout(new BorderLayout());
		headerPane.add(label, BorderLayout.LINE_START);
		headerPane.add(graphButton, BorderLayout.LINE_END);
		getContentPane().add(headerPane, BorderLayout.PAGE_START);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

	public static void createAndShowGUI() {
		try {
			LookAndFeels.setNimbusLookAndFeel();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// it is almost never the correct solution to only printing a stack trace.
			// i believe it is correct here.
			// -- dennis
			e.printStackTrace();
		}

		JFrame frame = new FibonacciDebugAppFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
