package mosaics;

import static edu.wustl.cse.mosaic.Mosaics.*;

import edu.wustl.cse.mosaic.Mosaic;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class BesideDemo {
	private static Mosaic sideBySideEllipses() {
		return beside(
				filledEllipse(0.1, 0.2, HONOLULU_BLUE), 
				filledEllipse(0.1, 0.3, BAMBOO), 
				filledEllipse(0.1, 0.4, BLACK)
		);
	}

	public static void main(String[] args) {
		showCentered(sideBySideEllipses(), 0.9);
	}
}
