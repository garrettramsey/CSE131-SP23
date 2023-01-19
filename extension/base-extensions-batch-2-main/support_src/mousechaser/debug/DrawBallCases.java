package mousechaser.debug;

import java.util.Arrays;
import java.util.List;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DrawBallCases {
	public static List<DrawBallCase> getCases() {
		return Arrays.asList(new DrawBallCase(0.3, 0.4, 0.1), new DrawBallCase(0.7, 0.2, 0.025), new DrawBallCase(0.6, 0.5, 0.15));
	}
}
