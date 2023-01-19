package mosaics;

import static edu.wustl.cse.mosaic.Mosaics.*;

import edu.wustl.cse.mosaic.Mosaic;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class OverlayDemo {
	private static Mosaic overlaidEllipses() {
		return overlay(
				filledEllipse(0.1, 0.2, HONOLULU_BLUE), 
				filledEllipse(0.2, 0.4, BAMBOO),
				filledEllipse(0.8, 0.6, BLACK)
		);
	}

	public static void main(String[] args) {
		showCentered(overlaidEllipses(), 0.9);
	}
}
