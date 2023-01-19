package support.cse131.image.gui;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ImageOperatorsResultsScrollPane extends JScrollPane {
	private static final long serialVersionUID = 1L;

	public ImageOperatorsResultsScrollPane(JComponent component) {
		super(VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_ALWAYS);
		JPanel view = new JPanel();
		view.setLayout(new BorderLayout());
		view.add(component, BorderLayout.PAGE_START);
		setViewportView(view);
		getVerticalScrollBar().setUnitIncrement(24);
	}
}
