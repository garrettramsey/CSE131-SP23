package support.cse131.image.gui;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ImageOperatorsResultsPane<K> extends JPanel {
	private static final long serialVersionUID = 1L;

	private final Map<K, ImageOperatorResultsPane<K>> mapKeyToPane = new HashMap<>();

	public ImageOperatorsResultsPane(List<K> items, List<Supplier<BufferedImage>> originalSuppliers,
			BiFunction<K, List<Supplier<BufferedImage>>, ImageOperatorResultsPane<K>> imageOperatorPaneCreator) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setBorder(BorderFactory.createEmptyBorder(0, 0, 24, 0));
		for (K item : items) {
			ImageOperatorResultsPane<K> pane = imageOperatorPaneCreator.apply(item, originalSuppliers);
			mapKeyToPane.put(item, pane);
			add(pane);
		}
	}

	public void filterVisible(boolean isCorrectShowing, Map<K, Boolean> mapK,
			Map<Supplier<BufferedImage>, Boolean> mapSupplier) {
		for (Entry<K, ImageOperatorResultsPane<K>> entry : mapKeyToPane.entrySet()) {
			entry.getValue().setVisible(mapK.get(entry.getKey()));
			entry.getValue().filterVisible(isCorrectShowing, mapSupplier);
		}
	}
}
