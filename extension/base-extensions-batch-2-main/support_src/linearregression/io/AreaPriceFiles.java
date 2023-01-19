package linearregression.io;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import linearregression.XY;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class AreaPriceFiles {
	public static Scanner createArgsProcessorForBroward() {
		InputStream is = AreaPriceFiles.class.getResourceAsStream("resources/BrowardAreaPrice.txt");
		Scanner scanner = new Scanner(is);
		return scanner;
	}

	public static List<XY> createXYsForBroward() {
		Scanner ap = createArgsProcessorForBroward();
		int n = ap.nextInt();
		List<XY> xys = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			xys.add(new XY(ap.nextDouble(), ap.nextDouble()));
		}
		return xys;
	}
}
