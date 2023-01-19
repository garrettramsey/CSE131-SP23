package support.cse131.image.transform.gui;

import java.awt.Dimension;

import javax.swing.JLabel;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class BigPixelView extends JLabel {
	private static final long serialVersionUID = 1L;

	public BigPixelView() {
		setOpaque(true);
	}

	@Override
	public Dimension getMinimumSize() {
		return new Dimension(32, 32);
	}

	@Override
	public Dimension getPreferredSize() {
		return getMinimumSize();
	}

	@Override
	public Dimension getMaximumSize() {
		return getMinimumSize();
	}
}
