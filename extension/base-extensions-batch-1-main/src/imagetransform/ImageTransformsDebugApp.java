package imagetransform;

import support.cse131.image.transform.gui.ImageTransformsFrame;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ImageTransformsDebugApp {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> ImageTransformsFrame.createAndShowGUI());
	}
}
