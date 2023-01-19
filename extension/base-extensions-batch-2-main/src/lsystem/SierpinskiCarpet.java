package lsystem;

import static edu.wustl.cse.mosaic.Mosaics.*;
import static edu.wustl.cse.mosaic.Mosaics.beside;
import static edu.wustl.cse.mosaic.Mosaics.filledSquare;
import static edu.wustl.cse.mosaic.Mosaics.showCentered;

import java.awt.Color;

import edu.wustl.cse.mosaic.Mosaic;
import support.cse131.NotYetImplementedException;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class SierpinskiCarpet {
	private static Color PRIMARY_COLOR = HONOLULU_BLUE;
	private static Color SECONDARY_COLOR = PARIS_DAISY;

	public static Mosaic carpet(double sideLength) {
		
			// Delete the line below and implement this method
			throw new NotYetImplementedException();
		
	}

	public static void main(String[] args) {
		showCentered(carpet(1.0), 0.9);
	}
}
