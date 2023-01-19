package conway.gui;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import conway.Conway;
import conway.JavaCodeUtils;
import conway.Patterns;
import support.cse131.NotYetImplementedException;

public class ConwayController extends JFrame {
	private static final long serialVersionUID = 1L;

	private static final int slow = 600;
	private static final int medium = 300;
	private static final int fast = 75;

	private final Timer timer;
	private final Conway conway;
	private final JPanel contentPane;
	private final ConwayGridPanel conwayPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> createAndShowGUI());

	}

	public static void createAndShowGUI() {
		ConwayController frame = new ConwayController();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public ConwayController() {
		setTitle("Conway's Game of Life");
		setResizable(false);
		setBounds(100, 100, 905, 748);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		conway = new Conway(50, 50);
		conwayPanel = new ConwayGridPanel(conway, 20);
		conwayPanel.setBounds(10, 10, 700, 700);
		contentPane.add(conwayPanel);

		// create an instance of Conway and set up the timer
		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				conway.step(); // run a single step each delay/1000.0 seconds
				displayLiveness();
			}
		};
		timer = new Timer(medium, taskPerformer); // FIXME redundant

		JPanel pnlButtons = new JPanel();
		pnlButtons.setBounds(726, 59, 163, 341);
		contentPane.add(pnlButtons);
		pnlButtons.setLayout(null);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.start();
				System.out
						.println("Simulation running at "
								+ (timer.getDelay() / 1000.0)
								+ " seconds for each step.");
			}
		});
		btnStart.setBounds(37, 16, 89, 23);
		pnlButtons.add(btnStart);

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				System.out.println("Simulation has been stopped.");
			}
		});
		btnStop.setBounds(37, 55, 89, 23);
		pnlButtons.add(btnStop);

		JButton btnStep = new JButton("Step");
		btnStep.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				conway.step();
				displayLiveness();
			}
		});
		btnStep.setBounds(37, 94, 89, 23);
		pnlButtons.add(btnStep);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				conway.clear();
				displayLiveness();
			}
		});
		btnClear.setBounds(37, 133, 89, 23);
		pnlButtons.add(btnClear);

		String[] s = { "<html><i>(none)</i></html>", "Blinker", "Toad", "Beacon",
				"Four Blinkers", "Glider", "Gosper Glider Gun",
				"Your Design One", "Your Design Two" };
		JComboBox<String> cmbPatterns = new JComboBox<>(s);
		cmbPatterns.setMaximumRowCount(s.length);
		cmbPatterns.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("rawtypes")
				String selected = (String) ((JComboBox) e.getSource())
						.getSelectedItem();
				if (selected == "Blinker")
					Patterns.blinker(conway);
				else if (selected == "Toad")
					Patterns.toad(conway);
				else if (selected == "Beacon")
					Patterns.beacon(conway);
				else if (selected == "Four Blinkers")
					Patterns.fourBlinkers(conway);
				else if (selected == "Glider")
					Patterns.glider(conway);
				else if (selected == "Gosper Glider Gun")
					Patterns.gosperGliderGun(conway);
				else if (selected == "Your Design One")
					Patterns.yourDesignOne(conway);
				else if (selected == "Your Design Two")
					Patterns.yourDesignTwo(conway);
				displayLiveness();
			}
		});
		cmbPatterns.setBounds(16, 211, 130, 20);
		pnlButtons.add(cmbPatterns);

		JButton btnLogAndCapture = new JButton("To Java Code");
		btnLogAndCapture.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = JavaCodeUtils.toJavaCode(conway);
				System.out.println(text);
				StringSelection stringSelection = new StringSelection(text);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
				displayLiveness();
			}
		});
		btnLogAndCapture.setBounds(16, 172, 130, 23);
		pnlButtons.add(btnLogAndCapture);

		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				JSlider s = (JSlider) arg0.getSource();
				switch (s.getValue()) {
				case 1:
					timer.setDelay(slow);
					break;
				case 2:
					timer.setDelay(medium);
					break;
				case 3:
					timer.setDelay(fast);
					break;
				default:
					break;
				}
			}
		});
		slider.setSnapToTicks(true);
		slider.setMinimum(1);
		slider.setMaximum(3);
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing(0);
		slider.setValue(2);
		slider.setPaintLabels(true);
		slider.setBounds(16, 286, 130, 39);
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(1, new JLabel("Slow"));
		labelTable.put(2, new JLabel("Medium"));
		labelTable.put(3, new JLabel("Fast"));
		slider.setLabelTable(labelTable);
		pnlButtons.add(slider);

		JLabel lblSimulationSpeed = new JLabel("Simulation Speed:");
		lblSimulationSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		lblSimulationSpeed.setBounds(16, 247, 130, 23);
		pnlButtons.add(lblSimulationSpeed);
		try {
			displayLiveness();
		} catch (NotYetImplementedException nyie) {
			nyie.printStackTrace();
		}
	}

	public void displayLiveness() {
		conwayPanel.displayLiveness();
	}
}
