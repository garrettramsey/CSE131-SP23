package speedlimit.tests;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import support.cse131.LenientTextUtils;
import support.cse131.SystemOutputUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InComplianceWithTheLawTest {
	private static final List<String> EXPECTED_LINES = Arrays.asList("Have a nice day.");

	private final int limitMPH;

	public InComplianceWithTheLawTest(int limitMPH) {
		this.limitMPH = limitMPH;
	}

	@Test
	public void testBelowSpeedLimit() throws IOException {
		int reportedMPH = limitMPH - 1;
		String actualOutput = SystemOutputUtils.capture(() -> {
			SpeedLimitTestUtils.invokeMain(reportedMPH, limitMPH);
		});
		List<String> actualCleanedLines = LenientTextUtils.toLinesOfSpaceSeparatedTokens(actualOutput);
		SpeedLimitTestUtils.checkSize(actualOutput, EXPECTED_LINES, actualCleanedLines);
		SpeedLimitTestUtils.checkEqualsIgnoringCaseAndWhiteSpace(actualOutput, EXPECTED_LINES, actualCleanedLines);
	}

	@Test
	public void testExactlyAtSpeedLimit() throws IOException {
		int reportedMPH = limitMPH;
		String actualOutput = SystemOutputUtils.capture(() -> {
			SpeedLimitTestUtils.invokeMain(reportedMPH, limitMPH);
		});
		List<String> actualCleanedLines = LenientTextUtils.toLinesOfSpaceSeparatedTokens(actualOutput);
		SpeedLimitTestUtils.checkSize(actualOutput, EXPECTED_LINES, actualCleanedLines);
		SpeedLimitTestUtils.checkEqualsIgnoringCaseAndWhiteSpace(actualOutput, EXPECTED_LINES, actualCleanedLines);
	}

	@Parameterized.Parameters(name = "limitMPH: {0}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		for (int limit : Arrays.asList(25, 55, 70, 131, 231, 425)) {
			args.add(new Object[] { limit });
		}
		return args;
	}
}
