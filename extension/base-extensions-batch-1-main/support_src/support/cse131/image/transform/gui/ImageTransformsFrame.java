package support.cse131.image.transform.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import support.cse131.gui.MultipleSelectPane;
import support.cse131.image.BufferedImageSuppliers;
import support.cse131.image.BufferedImages;
import support.cse131.image.gui.ImageOperatorResultsPane;
import support.cse131.image.gui.ImageOperatorsResultsPane;
import support.cse131.image.gui.ImageOperatorsResultsScrollPane;
import support.cse131.image.transform.Transform;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ImageTransformsFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private final JCheckBox displayCorrectResultsCheckBox;
	private final MultipleSelectPane<Transform> transformsPane;
	private final MultipleSelectPane<Supplier<BufferedImage>> suppliersPane;
	private final ImageOperatorsResultsPane<Transform> resultsPane;

	public ImageTransformsFrame() {
		super("Image Transforms");
		List<Supplier<BufferedImage>> suppliers = BufferedImageSuppliers.asList();
		resultsPane = new ImageOperatorsResultsPane<>(Arrays.asList(Transform.values()), suppliers,
				ImageTransformsFrame::createImageOperatorPane);

		displayCorrectResultsCheckBox = new JCheckBox("display correct results?", true);
		displayCorrectResultsCheckBox.addItemListener((e) -> updateResultsViews());
		transformsPane = new MultipleSelectPane<>("transforms: ", Arrays.asList(Transform.values()),
				(e) -> updateResultsViews());

		suppliersPane = new MultipleSelectPane<>("images: ", BufferedImageSuppliers.asList(),
				(e) -> updateResultsViews());
		JPanel controlPane = new JPanel();
		controlPane.setLayout(new BoxLayout(controlPane, BoxLayout.PAGE_AXIS));
		controlPane.add(displayCorrectResultsCheckBox);
		controlPane.add(Box.createRigidArea(new Dimension(0,8)));
		controlPane.add(transformsPane);
		controlPane.add(Box.createRigidArea(new Dimension(0,8)));
		controlPane.add(suppliersPane);
		JScrollPane scrollPane = new ImageOperatorsResultsScrollPane(resultsPane);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(controlPane, BorderLayout.LINE_START);
		this.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

	private void updateResultsViews() {
		Map<Transform, Boolean> mapTransform = transformsPane.getSelectedMap();
		Map<Supplier<BufferedImage>, Boolean> mapSupplier = suppliersPane.getSelectedMap();
		resultsPane.filterVisible(displayCorrectResultsCheckBox.isSelected(), mapTransform, mapSupplier);
	}

	private static ImageOperatorResultsPane<Transform> createImageOperatorPane(Transform transform,
			List<Supplier<BufferedImage>> suppliers) {
		return new ImageOperatorResultsPane<>(transform, suppliers, (originalImage) -> toExpected(transform, originalImage),
				(originalImage) -> toActual(transform, originalImage), (image) -> {
					int width = image.getWidth();
					if (width <= 32) {
						return new BigPixelImageView(image);
					} else {
						return new JLabel(new ImageIcon(image));
					}
				});
	}

	private static BufferedImage toActual(Transform transform, BufferedImage originalImage) {
		return BufferedImages.toBufferedImage(transform.actual().apply(BufferedImages.toColorMatrix(originalImage)),
				BufferedImage.TYPE_INT_BGR);
	}

	private static BufferedImage toExpected(Transform transform, BufferedImage originalImage) {
		int rowCount = transform.expectedHeight(originalImage);
		int colCount = transform.expectedWidth(originalImage);
		BufferedImage expectedImage = new BufferedImage(colCount, rowCount, BufferedImage.TYPE_INT_BGR);
		for (int r = 0; r < rowCount; ++r) {
			for (int c = 0; c < colCount; ++c) {
				expectedImage.setRGB(c, r, transform.expectedRGB(originalImage, r, c));
			}
		}
		return expectedImage;
	}

	public static void createAndShowGUI() {
		JFrame frame = new ImageTransformsFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
