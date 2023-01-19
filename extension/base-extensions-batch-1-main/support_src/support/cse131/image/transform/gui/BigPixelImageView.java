package support.cse131.image.transform.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class BigPixelImageView extends JPanel {
	private static final long serialVersionUID = 1L;

	public BigPixelImageView(BufferedImage image) {
		int rowCount = image.getHeight();
		int colCount = image.getWidth();
		setLayout(new GridLayout(rowCount, colCount, 2, 2));
		for (int r = 0; r < rowCount; ++r) {
			for (int c = 0; c < colCount; ++c) {
				BigPixelView view = new BigPixelView();
				view.setBackground(new Color(image.getRGB(c, r)));
				add(view);
			}
		}
		
		setBackground(Color.BLACK);
	}
}
