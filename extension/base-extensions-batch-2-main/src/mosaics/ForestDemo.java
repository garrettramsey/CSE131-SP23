package mosaics;

import static edu.wustl.cse.mosaic.Mosaics.*;

import edu.wustl.cse.mosaic.Mosaic;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ForestDemo {
	private static Mosaic tree() {
		return above(
				filledEquilateralTriangle(1, OCEAN_GREEN), 
				filledRectangle(0.1, 0.2, BAMBOO)
		);
	}
	
	private static Mosaic rowOfTrees() {
		Mosaic tree = tree();
		return beside(tree, tree, tree);
	}

	private static Mosaic forest() {
		Mosaic row = rowOfTrees();
		return above(row, row, row);
	}

	public static void main(String[] args) {
		showCentered(forest(), 0.9);
	}
}
