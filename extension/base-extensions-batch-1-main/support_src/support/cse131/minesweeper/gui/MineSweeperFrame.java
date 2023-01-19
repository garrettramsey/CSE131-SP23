package support.cse131.minesweeper.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import support.cse131.LenientTextUtils;
import support.cse131.minesweeper.MineSweeperUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class MineSweeperFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private final JTextArea outputTextArea;
	private final JSlider rowSlider;
	private final JSlider colSlider;
	private final JSlider probSlider;

	private final JButton generateButton;

	private final CellMatrixPane<CellView, Optional<Integer>> matrixView;

	public MineSweeperFrame() {
		super("Mine Sweeper");

		final int ROW_MAX = 20;
		final int COL_MAX = 20;
		rowSlider = createSlider(JSlider.VERTICAL, 1, ROW_MAX, 5, 1, "rows: %d");
		rowSlider.setInverted(true);

		colSlider = createSlider(JSlider.HORIZONTAL, 1, COL_MAX, 9, 1, "cols: %d");

		probSlider = createSlider(JSlider.VERTICAL, 0, 100, 25, 10, "%d%% mines");

		generateButton = new JButton("invoke main(args)");
		generateButton.addActionListener((e) -> generate());

		matrixView = new CellMatrixPane<>(new CellView[ROW_MAX][COL_MAX], CellView::new);

		JPanel mainPane = new JPanel();
		mainPane.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		mainPane.add(new JLabel(), gbc);
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;
		mainPane.add(colSlider, gbc);
		gbc.weightx = 0.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		mainPane.add(new JLabel(), gbc);

		gbc.weightx = 0.0;
		gbc.weighty = 1.0;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.VERTICAL;
		mainPane.add(rowSlider, gbc);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		mainPane.add(matrixView, gbc);
		gbc.weightx = 0.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		mainPane.add(probSlider, gbc);

		outputTextArea = new JTextArea();
		outputTextArea.setFont(new Font("monospaced", Font.PLAIN, 18));
		JScrollPane scrollPane = new JScrollPane(outputTextArea);

		JLabel printLabel = new JLabel("MineSweeper print output >>> ");
		printLabel.setVerticalAlignment(JLabel.TOP);

		JPanel outputPane = new JPanel();
		outputPane.setLayout(new GridBagLayout());
		GridBagConstraints gbcOutput = new GridBagConstraints();
		gbcOutput.anchor = GridBagConstraints.PAGE_START;
		gbcOutput.fill = GridBagConstraints.BOTH;
		gbcOutput.gridx = 0;
		gbcOutput.gridy = 0;
		outputPane.add(printLabel, gbcOutput);

		gbcOutput.weightx = 1.0;
		gbcOutput.weighty = 1.0;
		gbcOutput.gridwidth = GridBagConstraints.REMAINDER;
		gbcOutput.gridheight = 2;
		gbcOutput.gridx = 1;
		gbcOutput.gridy = 0;
		outputPane.add(scrollPane, gbcOutput);

		gbcOutput.gridx = 0;
		gbcOutput.gridy = 1;
		gbcOutput.weightx = 0.0;
		gbcOutput.weighty = 0.0;
		gbcOutput.gridwidth = 1;
		gbcOutput.gridheight = 1;
		gbcOutput.anchor = GridBagConstraints.PAGE_END;
		gbcOutput.fill = GridBagConstraints.NONE;
		outputPane.add(generateButton, gbcOutput);

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, mainPane, outputPane);
		splitPane.setResizeWeight(0.9);

		this.getContentPane().add(splitPane, BorderLayout.CENTER);

		generateButton.doClick();

	}

	private JSlider createSlider(int orientation, int min, int max, int value, int minorTickSpacing, String format) {
		JSlider slider = new JSlider(orientation, min, max, value);
		slider.setMinorTickSpacing(minorTickSpacing);
		slider.setPaintTicks(true);
		slider.addChangeListener((e) -> generate());

		Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
		labelTable.put(min, new JLabel(String.format(format, min)));
		labelTable.put(max, new JLabel(String.format(format, max)));
		slider.setLabelTable(labelTable);
		slider.setPaintLabels(true);
		return slider;
	}

	private void generate() {
		try {
			int colCount = colSlider.getValue();
			int rowCount = rowSlider.getValue();
			double probability = probSlider.getValue() / 100.0;

			generateButton.setText(String.format("main(\"%d\", \"%d\", \"%.2f\")", colCount, rowCount, probability));
			String output = MineSweeperUtils.runMain(colCount, rowCount, probability);
			outputTextArea.setText(output);
			outputTextArea.setForeground(Color.BLACK);

			List<List<String>> linesOfTokenLists = LenientTextUtils.toLinesOfTokenLists(output);
			Optional<Integer>[][] optionalCounts = MineSweeperUtils.toOptionalCounts(output, linesOfTokenLists, colCount, rowCount);
			matrixView.updateCells(optionalCounts);
		} catch (Throwable t) {
			outputTextArea.setText(t.toString());
			outputTextArea.setForeground(Color.RED.darker());
		}
	}

	public static void createAndShowGUI() {
		JFrame frame = new MineSweeperFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
