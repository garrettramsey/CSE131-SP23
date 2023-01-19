package speedlimit.tests;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import support.cse131.LenientTextUtils;
import support.cse131.SystemOutputUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public abstract class AbstractInfractionTest {
	protected static enum TestExtent {
		VALUE_ORDER_ONLY,
		VALUE_ORDER_AND_TEXT_CONTENTS;
	}

	private final int reportedOverMPH;
	private final int limitMPH;
	private final List<String> expectedLines;
	private final TestExtent testExtent;

	public AbstractInfractionTest(int reportedOverMPH, int limitMPH, List<String> expectedLines,
			TestExtent testExtent) {
		this.reportedOverMPH = reportedOverMPH;
		this.limitMPH = limitMPH;
		this.expectedLines = expectedLines;
		this.testExtent = testExtent;
	}

	@Test
	public void test() throws IOException {
		String actualOutput = SystemOutputUtils.capture(() -> {
			SpeedLimitTestUtils.invokeMain(reportedOverMPH + limitMPH, limitMPH);
		});
		List<String> actualCleanedLines = LenientTextUtils.toLinesOfSpaceSeparatedTokens(actualOutput);
		SpeedLimitTestUtils.checkSize(actualOutput, expectedLines, actualCleanedLines);
		SpeedLimitTestUtils.checkIntegersList(actualOutput, expectedLines, actualCleanedLines);
		if (testExtent == TestExtent.VALUE_ORDER_AND_TEXT_CONTENTS) {
			SpeedLimitTestUtils.checkEqualsIgnoringCaseAndWhiteSpace(actualOutput, expectedLines, actualCleanedLines);
		}
	}

	@Parameterized.Parameters(name = "reportedOverMPH: {0}; limitMPH: {1}; expected: {2}")
	public static Collection<Object[]> getConstructorArguments() {
		return Arrays.asList(
				new Object[] { 1, 25, Arrays.asList("You reported a speed of 26 MPH for a speed limit of 25 MPH.",
						"You went 1 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 2, 25, Arrays.asList("You reported a speed of 27 MPH for a speed limit of 25 MPH.",
						"You went 2 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 3, 25, Arrays.asList("You reported a speed of 28 MPH for a speed limit of 25 MPH.",
						"You went 3 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 4, 25, Arrays.asList("You reported a speed of 29 MPH for a speed limit of 25 MPH.",
						"You went 4 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 5, 25, Arrays.asList("You reported a speed of 30 MPH for a speed limit of 25 MPH.",
						"You went 5 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 6, 25, Arrays.asList("You reported a speed of 31 MPH for a speed limit of 25 MPH.",
						"You went 6 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 7, 25, Arrays.asList("You reported a speed of 32 MPH for a speed limit of 25 MPH.",
						"You went 7 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 8, 25, Arrays.asList("You reported a speed of 33 MPH for a speed limit of 25 MPH.",
						"You went 8 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 9, 25, Arrays.asList("You reported a speed of 34 MPH for a speed limit of 25 MPH.",
						"You went 9 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 10, 25, Arrays.asList("You reported a speed of 35 MPH for a speed limit of 25 MPH.",
						"You went 10 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 11, 25, Arrays.asList("You reported a speed of 36 MPH for a speed limit of 25 MPH.",
						"You went 11 MPH over the speed limit.", "Your fine is $110.") },

				new Object[] { 12, 25, Arrays.asList("You reported a speed of 37 MPH for a speed limit of 25 MPH.",
						"You went 12 MPH over the speed limit.", "Your fine is $120.") },

				new Object[] { 43, 25, Arrays.asList("You reported a speed of 68 MPH for a speed limit of 25 MPH.",
						"You went 43 MPH over the speed limit.", "Your fine is $430.") },

				new Object[] { 99, 25, Arrays.asList("You reported a speed of 124 MPH for a speed limit of 25 MPH.",
						"You went 99 MPH over the speed limit.", "Your fine is $990.") },

				new Object[] { 131, 25, Arrays.asList("You reported a speed of 156 MPH for a speed limit of 25 MPH.",
						"You went 131 MPH over the speed limit.", "Your fine is $1310.") },

				new Object[] { 231, 25, Arrays.asList("You reported a speed of 256 MPH for a speed limit of 25 MPH.",
						"You went 231 MPH over the speed limit.", "Your fine is $2310.") },

				new Object[] { 425, 25, Arrays.asList("You reported a speed of 450 MPH for a speed limit of 25 MPH.",
						"You went 425 MPH over the speed limit.", "Your fine is $4250.") },

				new Object[] { 1, 42, Arrays.asList("You reported a speed of 43 MPH for a speed limit of 42 MPH.",
						"You went 1 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 2, 42, Arrays.asList("You reported a speed of 44 MPH for a speed limit of 42 MPH.",
						"You went 2 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 3, 42, Arrays.asList("You reported a speed of 45 MPH for a speed limit of 42 MPH.",
						"You went 3 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 4, 42, Arrays.asList("You reported a speed of 46 MPH for a speed limit of 42 MPH.",
						"You went 4 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 5, 42, Arrays.asList("You reported a speed of 47 MPH for a speed limit of 42 MPH.",
						"You went 5 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 6, 42, Arrays.asList("You reported a speed of 48 MPH for a speed limit of 42 MPH.",
						"You went 6 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 7, 42, Arrays.asList("You reported a speed of 49 MPH for a speed limit of 42 MPH.",
						"You went 7 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 8, 42, Arrays.asList("You reported a speed of 50 MPH for a speed limit of 42 MPH.",
						"You went 8 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 9, 42, Arrays.asList("You reported a speed of 51 MPH for a speed limit of 42 MPH.",
						"You went 9 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 10, 42, Arrays.asList("You reported a speed of 52 MPH for a speed limit of 42 MPH.",
						"You went 10 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 11, 42, Arrays.asList("You reported a speed of 53 MPH for a speed limit of 42 MPH.",
						"You went 11 MPH over the speed limit.", "Your fine is $110.") },

				new Object[] { 12, 42, Arrays.asList("You reported a speed of 54 MPH for a speed limit of 42 MPH.",
						"You went 12 MPH over the speed limit.", "Your fine is $120.") },

				new Object[] { 43, 42, Arrays.asList("You reported a speed of 85 MPH for a speed limit of 42 MPH.",
						"You went 43 MPH over the speed limit.", "Your fine is $430.") },

				new Object[] { 99, 42, Arrays.asList("You reported a speed of 141 MPH for a speed limit of 42 MPH.",
						"You went 99 MPH over the speed limit.", "Your fine is $990.") },

				new Object[] { 131, 42, Arrays.asList("You reported a speed of 173 MPH for a speed limit of 42 MPH.",
						"You went 131 MPH over the speed limit.", "Your fine is $1310.") },

				new Object[] { 231, 42, Arrays.asList("You reported a speed of 273 MPH for a speed limit of 42 MPH.",
						"You went 231 MPH over the speed limit.", "Your fine is $2310.") },

				new Object[] { 425, 42, Arrays.asList("You reported a speed of 467 MPH for a speed limit of 42 MPH.",
						"You went 425 MPH over the speed limit.", "Your fine is $4250.") },

				new Object[] { 1, 55, Arrays.asList("You reported a speed of 56 MPH for a speed limit of 55 MPH.",
						"You went 1 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 2, 55, Arrays.asList("You reported a speed of 57 MPH for a speed limit of 55 MPH.",
						"You went 2 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 3, 55, Arrays.asList("You reported a speed of 58 MPH for a speed limit of 55 MPH.",
						"You went 3 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 4, 55, Arrays.asList("You reported a speed of 59 MPH for a speed limit of 55 MPH.",
						"You went 4 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 5, 55, Arrays.asList("You reported a speed of 60 MPH for a speed limit of 55 MPH.",
						"You went 5 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 6, 55, Arrays.asList("You reported a speed of 61 MPH for a speed limit of 55 MPH.",
						"You went 6 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 7, 55, Arrays.asList("You reported a speed of 62 MPH for a speed limit of 55 MPH.",
						"You went 7 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 8, 55, Arrays.asList("You reported a speed of 63 MPH for a speed limit of 55 MPH.",
						"You went 8 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 9, 55, Arrays.asList("You reported a speed of 64 MPH for a speed limit of 55 MPH.",
						"You went 9 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 10, 55, Arrays.asList("You reported a speed of 65 MPH for a speed limit of 55 MPH.",
						"You went 10 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 11, 55, Arrays.asList("You reported a speed of 66 MPH for a speed limit of 55 MPH.",
						"You went 11 MPH over the speed limit.", "Your fine is $110.") },

				new Object[] { 12, 55, Arrays.asList("You reported a speed of 67 MPH for a speed limit of 55 MPH.",
						"You went 12 MPH over the speed limit.", "Your fine is $120.") },

				new Object[] { 43, 55, Arrays.asList("You reported a speed of 98 MPH for a speed limit of 55 MPH.",
						"You went 43 MPH over the speed limit.", "Your fine is $430.") },

				new Object[] { 99, 55, Arrays.asList("You reported a speed of 154 MPH for a speed limit of 55 MPH.",
						"You went 99 MPH over the speed limit.", "Your fine is $990.") },

				new Object[] { 131, 55, Arrays.asList("You reported a speed of 186 MPH for a speed limit of 55 MPH.",
						"You went 131 MPH over the speed limit.", "Your fine is $1310.") },

				new Object[] { 231, 55, Arrays.asList("You reported a speed of 286 MPH for a speed limit of 55 MPH.",
						"You went 231 MPH over the speed limit.", "Your fine is $2310.") },

				new Object[] { 425, 55, Arrays.asList("You reported a speed of 480 MPH for a speed limit of 55 MPH.",
						"You went 425 MPH over the speed limit.", "Your fine is $4250.") },

				new Object[] { 1, 71, Arrays.asList("You reported a speed of 72 MPH for a speed limit of 71 MPH.",
						"You went 1 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 2, 71, Arrays.asList("You reported a speed of 73 MPH for a speed limit of 71 MPH.",
						"You went 2 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 3, 71, Arrays.asList("You reported a speed of 74 MPH for a speed limit of 71 MPH.",
						"You went 3 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 4, 71, Arrays.asList("You reported a speed of 75 MPH for a speed limit of 71 MPH.",
						"You went 4 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 5, 71, Arrays.asList("You reported a speed of 76 MPH for a speed limit of 71 MPH.",
						"You went 5 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 6, 71, Arrays.asList("You reported a speed of 77 MPH for a speed limit of 71 MPH.",
						"You went 6 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 7, 71, Arrays.asList("You reported a speed of 78 MPH for a speed limit of 71 MPH.",
						"You went 7 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 8, 71, Arrays.asList("You reported a speed of 79 MPH for a speed limit of 71 MPH.",
						"You went 8 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 9, 71, Arrays.asList("You reported a speed of 80 MPH for a speed limit of 71 MPH.",
						"You went 9 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 10, 71, Arrays.asList("You reported a speed of 81 MPH for a speed limit of 71 MPH.",
						"You went 10 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 11, 71, Arrays.asList("You reported a speed of 82 MPH for a speed limit of 71 MPH.",
						"You went 11 MPH over the speed limit.", "Your fine is $110.") },

				new Object[] { 12, 71, Arrays.asList("You reported a speed of 83 MPH for a speed limit of 71 MPH.",
						"You went 12 MPH over the speed limit.", "Your fine is $120.") },

				new Object[] { 43, 71, Arrays.asList("You reported a speed of 114 MPH for a speed limit of 71 MPH.",
						"You went 43 MPH over the speed limit.", "Your fine is $430.") },

				new Object[] { 99, 71, Arrays.asList("You reported a speed of 170 MPH for a speed limit of 71 MPH.",
						"You went 99 MPH over the speed limit.", "Your fine is $990.") },

				new Object[] { 131, 71, Arrays.asList("You reported a speed of 202 MPH for a speed limit of 71 MPH.",
						"You went 131 MPH over the speed limit.", "Your fine is $1310.") },

				new Object[] { 231, 71, Arrays.asList("You reported a speed of 302 MPH for a speed limit of 71 MPH.",
						"You went 231 MPH over the speed limit.", "Your fine is $2310.") },

				new Object[] { 425, 71, Arrays.asList("You reported a speed of 496 MPH for a speed limit of 71 MPH.",
						"You went 425 MPH over the speed limit.", "Your fine is $4250.") },

				new Object[] { 1, 87, Arrays.asList("You reported a speed of 88 MPH for a speed limit of 87 MPH.",
						"You went 1 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 2, 87, Arrays.asList("You reported a speed of 89 MPH for a speed limit of 87 MPH.",
						"You went 2 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 3, 87, Arrays.asList("You reported a speed of 90 MPH for a speed limit of 87 MPH.",
						"You went 3 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 4, 87, Arrays.asList("You reported a speed of 91 MPH for a speed limit of 87 MPH.",
						"You went 4 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 5, 87, Arrays.asList("You reported a speed of 92 MPH for a speed limit of 87 MPH.",
						"You went 5 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 6, 87, Arrays.asList("You reported a speed of 93 MPH for a speed limit of 87 MPH.",
						"You went 6 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 7, 87, Arrays.asList("You reported a speed of 94 MPH for a speed limit of 87 MPH.",
						"You went 7 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 8, 87, Arrays.asList("You reported a speed of 95 MPH for a speed limit of 87 MPH.",
						"You went 8 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 9, 87, Arrays.asList("You reported a speed of 96 MPH for a speed limit of 87 MPH.",
						"You went 9 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 10, 87, Arrays.asList("You reported a speed of 97 MPH for a speed limit of 87 MPH.",
						"You went 10 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 11, 87, Arrays.asList("You reported a speed of 98 MPH for a speed limit of 87 MPH.",
						"You went 11 MPH over the speed limit.", "Your fine is $110.") },

				new Object[] { 12, 87, Arrays.asList("You reported a speed of 99 MPH for a speed limit of 87 MPH.",
						"You went 12 MPH over the speed limit.", "Your fine is $120.") },

				new Object[] { 43, 87, Arrays.asList("You reported a speed of 130 MPH for a speed limit of 87 MPH.",
						"You went 43 MPH over the speed limit.", "Your fine is $430.") },

				new Object[] { 99, 87, Arrays.asList("You reported a speed of 186 MPH for a speed limit of 87 MPH.",
						"You went 99 MPH over the speed limit.", "Your fine is $990.") },

				new Object[] { 131, 87, Arrays.asList("You reported a speed of 218 MPH for a speed limit of 87 MPH.",
						"You went 131 MPH over the speed limit.", "Your fine is $1310.") },

				new Object[] { 231, 87, Arrays.asList("You reported a speed of 318 MPH for a speed limit of 87 MPH.",
						"You went 231 MPH over the speed limit.", "Your fine is $2310.") },

				new Object[] { 425, 87, Arrays.asList("You reported a speed of 512 MPH for a speed limit of 87 MPH.",
						"You went 425 MPH over the speed limit.", "Your fine is $4250.") },

				new Object[] { 1, 131, Arrays.asList("You reported a speed of 132 MPH for a speed limit of 131 MPH.",
						"You went 1 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 2, 131, Arrays.asList("You reported a speed of 133 MPH for a speed limit of 131 MPH.",
						"You went 2 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 3, 131, Arrays.asList("You reported a speed of 134 MPH for a speed limit of 131 MPH.",
						"You went 3 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 4, 131, Arrays.asList("You reported a speed of 135 MPH for a speed limit of 131 MPH.",
						"You went 4 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 5, 131, Arrays.asList("You reported a speed of 136 MPH for a speed limit of 131 MPH.",
						"You went 5 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 6, 131, Arrays.asList("You reported a speed of 137 MPH for a speed limit of 131 MPH.",
						"You went 6 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 7, 131, Arrays.asList("You reported a speed of 138 MPH for a speed limit of 131 MPH.",
						"You went 7 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 8, 131, Arrays.asList("You reported a speed of 139 MPH for a speed limit of 131 MPH.",
						"You went 8 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 9, 131, Arrays.asList("You reported a speed of 140 MPH for a speed limit of 131 MPH.",
						"You went 9 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 10, 131, Arrays.asList("You reported a speed of 141 MPH for a speed limit of 131 MPH.",
						"You went 10 MPH over the speed limit.", "Your fine is $100.") },

				new Object[] { 11, 131, Arrays.asList("You reported a speed of 142 MPH for a speed limit of 131 MPH.",
						"You went 11 MPH over the speed limit.", "Your fine is $110.") },

				new Object[] { 12, 131, Arrays.asList("You reported a speed of 143 MPH for a speed limit of 131 MPH.",
						"You went 12 MPH over the speed limit.", "Your fine is $120.") },

				new Object[] { 43, 131, Arrays.asList("You reported a speed of 174 MPH for a speed limit of 131 MPH.",
						"You went 43 MPH over the speed limit.", "Your fine is $430.") },

				new Object[] { 99, 131, Arrays.asList("You reported a speed of 230 MPH for a speed limit of 131 MPH.",
						"You went 99 MPH over the speed limit.", "Your fine is $990.") },

				new Object[] { 131, 131, Arrays.asList("You reported a speed of 262 MPH for a speed limit of 131 MPH.",
						"You went 131 MPH over the speed limit.", "Your fine is $1310.") },

				new Object[] { 231, 131, Arrays.asList("You reported a speed of 362 MPH for a speed limit of 131 MPH.",
						"You went 231 MPH over the speed limit.", "Your fine is $2310.") },

				new Object[] { 425, 131, Arrays.asList("You reported a speed of 556 MPH for a speed limit of 131 MPH.",
						"You went 425 MPH over the speed limit.", "Your fine is $4250.") }
		);
	}
}
