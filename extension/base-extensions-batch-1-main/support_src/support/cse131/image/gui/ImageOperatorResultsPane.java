package support.cse131.image.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import support.cse131.image.BufferedImages;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ImageOperatorResultsPane<K> extends JPanel {
	private static final long serialVersionUID = 1L;

	private static final class BufferedImageOrRuntimeException {
		private final Optional<BufferedImage> bufferedImageOpt;
		private final Optional<RuntimeException> runtimeExceptionOpt;

		private BufferedImageOrRuntimeException(BufferedImage bufferedImage) {
			bufferedImageOpt = Optional.of(bufferedImage);
			runtimeExceptionOpt = Optional.empty();
		}

		private BufferedImageOrRuntimeException(RuntimeException runtimeException) {
			bufferedImageOpt = Optional.empty();
			runtimeExceptionOpt = Optional.of(runtimeException);
		}

		public static BufferedImageOrRuntimeException of(BufferedImage bufferedImage) {
			return new BufferedImageOrRuntimeException(bufferedImage);
		}

		public static BufferedImageOrRuntimeException of(RuntimeException runtimeException) {
			return new BufferedImageOrRuntimeException(runtimeException);
		}

		public Optional<BufferedImage> toExpectedImageOpt(BufferedImage expectedImage) {
			if (bufferedImageOpt.isPresent()) {
				return BufferedImages.rgbsEquivalent(expectedImage, bufferedImageOpt.get()) ? Optional.empty()
						: Optional.of(expectedImage);
			} else {
				return Optional.of(expectedImage);
			}
		}

		public JComponent toResultView(Function<BufferedImage, JComponent> imageViewCreator, Dimension stackTracePreferredSize) {
			if (bufferedImageOpt.isPresent()) {
				return imageViewCreator.apply(bufferedImageOpt.get());
			} else {
				StringWriter stringWriter = new StringWriter();
				PrintWriter printWriter = new PrintWriter(stringWriter);
				runtimeExceptionOpt.get().printStackTrace(printWriter);
				JTextArea textArea = new JTextArea(stringWriter.toString());
				JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setPreferredSize(stackTracePreferredSize);
				return scrollPane;
			}
		}
	}

	private static class IndividualResultPane extends JPanel {
		private static final long serialVersionUID = 1L;

		private final boolean isCorrect;

		public IndividualResultPane(BufferedImage originalImage, String name, BufferedImage expectedImage,
				BufferedImageOrRuntimeException actualImageOrRuntimeException,
				Function<BufferedImage, JComponent> imageViewCreator) {

			Optional<BufferedImage> expectedImageOpt = actualImageOrRuntimeException.toExpectedImageOpt(expectedImage);

			isCorrect = !expectedImageOpt.isPresent();
			GridBagLayout layout = new GridBagLayout();
			GridBagConstraints gbc = new GridBagConstraints();

			JLabel aTextLabel = new JLabel("original");
			JComponent aIconLabel = imageViewCreator.apply(originalImage);
			JLabel filterTextLabel = new JLabel(" == " + name + " ==> ");
			JLabel filterEmptyLabel = new JLabel("");

			String resultText = expectedImageOpt.isPresent() ? "*** INCORRECT RESULT ***" : "correct result";

			JLabel resultTextLabel = new JLabel(resultText);

			if (expectedImageOpt.isPresent()) {
				resultTextLabel.setFont(resultTextLabel.getFont().deriveFont(16.0f));
				resultTextLabel.setForeground(Color.RED.darker().darker());
			}

			Dimension stackTracePreferredSize = aIconLabel.getPreferredSize();
			stackTracePreferredSize.width *= 3;
			stackTracePreferredSize.width /= 2;
			JComponent resultIconLabel = actualImageOrRuntimeException.toResultView(imageViewCreator, stackTracePreferredSize);

			JLabel expectedTextLabel = new JLabel(expectedImageOpt.isPresent() ? "expected" : "");
			JComponent expectedIconLabel = expectedImageOpt.isPresent() ? imageViewCreator.apply(expectedImageOpt.get())
					: new JLabel("");

			setLayout(layout);
			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.fill = GridBagConstraints.NONE;
			gbc.insets = new Insets(4, 4, 4, 4);
			gbc.weightx = 0.0;
			gbc.gridwidth = 1;
			add(aTextLabel, gbc);
			add(filterEmptyLabel, gbc);
			add(resultTextLabel, gbc);
			gbc.insets = new Insets(4, 32, 4, 4);
			add(expectedTextLabel, gbc);
			gbc.insets = new Insets(4, 4, 4, 4);
			gbc.weightx = 1.0;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			add(new JLabel(), gbc);

			gbc.weightx = 0.0;
			gbc.gridwidth = 1;
			add(aIconLabel, gbc);
			gbc.fill = GridBagConstraints.VERTICAL;
			add(filterTextLabel, gbc);
			gbc.fill = GridBagConstraints.NONE;
			add(resultIconLabel, gbc);
			gbc.insets = new Insets(4, 32, 4, 4);
			add(expectedIconLabel, gbc);
			gbc.weightx = 1.0;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			add(new JLabel(), gbc);

			setBorder(BorderFactory.createEmptyBorder(0, 32, 0, 0));
			setAlignmentX(Component.LEFT_ALIGNMENT);
		}

		public boolean isCorrect() {
			return isCorrect;
		}
	}

	private final K key;

	private final Map<Supplier<BufferedImage>, IndividualResultPane> mapSupplierToPane = new HashMap<>();

	private static BufferedImageOrRuntimeException applyActualOperator(UnaryOperator<BufferedImage> actualOperator,
			BufferedImage originalImage) {
		try {
			return BufferedImageOrRuntimeException.of(actualOperator.apply(originalImage));
		} catch (RuntimeException re) {
			return BufferedImageOrRuntimeException.of(re);
		}
	}

	public ImageOperatorResultsPane(K key, List<Supplier<BufferedImage>> suppliers,
			UnaryOperator<BufferedImage> expectedOperator, UnaryOperator<BufferedImage> actualOperator,
			Function<BufferedImage, JComponent> imageViewCreator) {
		this.key = key;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		String name = this.key.toString();
		JLabel header = new JLabel();
		header.setFont(header.getFont().deriveFont(24.0f));
		add(header);
		int correctCount = 0;
		for (Supplier<BufferedImage> supplier : suppliers) {
			BufferedImage originalImage = supplier.get();
			BufferedImage expectedImage = expectedOperator.apply(originalImage);

			BufferedImageOrRuntimeException actualImageOrRuntimeException = applyActualOperator(actualOperator,
					originalImage);
			IndividualResultPane pane = new IndividualResultPane(originalImage, name, expectedImage,
					actualImageOrRuntimeException, imageViewCreator);
			if (pane.isCorrect()) {
				correctCount++;
			}
			mapSupplierToPane.put(supplier, pane);
			add(pane);

		}
		header.setText(String.format("%s (%d/%d correct)", name, correctCount, suppliers.size()));
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setBorder(BorderFactory.createEmptyBorder(0, 0, 48, 0));
	}

	public K getKey() {
		return key;
	}

	public void filterVisible(boolean isCorrectShowing, Map<Supplier<BufferedImage>, Boolean> mapSupplier) {
		for (Entry<Supplier<BufferedImage>, IndividualResultPane> entry : mapSupplierToPane.entrySet()) {
			boolean isVisible;
			if (mapSupplier.get(entry.getKey())) {
				if (entry.getValue().isCorrect()) {
					isVisible = isCorrectShowing;
				} else {
					isVisible = true;
				}
			} else {
				isVisible = false;
			}
			entry.getValue().setVisible(isVisible);
		}
	}
}
