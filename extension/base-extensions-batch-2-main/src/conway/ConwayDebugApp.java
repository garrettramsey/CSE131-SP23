package conway;

import javax.swing.SwingUtilities;

import conway.gui.ConwayController;

public class ConwayDebugApp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> ConwayController.createAndShowGUI());
	}
}
