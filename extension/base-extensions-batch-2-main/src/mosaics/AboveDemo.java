package mosaics;

import static edu.wustl.cse.mosaic.Mosaics.*;

import edu.wustl.cse.mosaic.Mosaic;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class AboveDemo {
	private static Mosaic stackedEllipses() {
		return above(
				filledEllipse(0.2, 0.1, HONOLULU_BLUE), 
				filledEllipse(0.3, 0.1, BAMBOO),
				filledEllipse(0.4, 0.1, BLACK)
		);
	}

	public static void main(String[] args) {
		showCentered(stackedEllipses(), 0.9);
	}
}
