package lsystem;

import static edu.wustl.cse.mosaic.Mosaics.*;
import static edu.wustl.cse.mosaic.Mosaics.beside;
import static edu.wustl.cse.mosaic.Mosaics.emptyRectangle;
import static edu.wustl.cse.mosaic.Mosaics.filledRectangle;
import static edu.wustl.cse.mosaic.Mosaics.outlinedRectangle;
import static edu.wustl.cse.mosaic.Mosaics.overlay;
import static edu.wustl.cse.mosaic.Mosaics.showCentered;

import java.awt.Color;

import edu.wustl.cse.mosaic.Mosaic;
import support.cse131.NotYetImplementedException;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class CantorStool {
	private static Mosaic block(double width, double height) {
		Color outlineColor = BLACK;
		Color fillColor = BAMBOO;
		return overlay(filledRectangle(width, height, fillColor), outlinedRectangle(width, height, outlineColor));
	}

	public static Mosaic stool(double width, double height) {
		
			// Delete the line below and implement this method
			throw new NotYetImplementedException();
		
	}

	public static void main(String[] args) {
		showCentered(stool(1.0, 1.0), 0.9);
	}
}
