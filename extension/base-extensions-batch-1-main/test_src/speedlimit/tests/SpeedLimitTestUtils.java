package speedlimit.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import test.cse131.Messages;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class SpeedLimitTestUtils {
	public static void invokeMain(int reportedMPH, int limitMPH) {
		try {
			Class<?> cls = Class.forName("speedlimit.SpeedLimit");
			Method method = cls.getMethod("main", String[].class);
			String input = Integer.toString(reportedMPH) + "\n" + Integer.toString(limitMPH) + "\n";
			InputStream sysInBackup = System.in; // backup System.in to restore it later
			ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);
			Object arg = new String[] { };
			method.invoke(null, arg);
			System.setIn(sysInBackup);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static void checkSize(String actualOutput, List<String> expectedLines, List<String> actualCleanedLines) {
		String sizeMessage = toSizeMessage(actualOutput, expectedLines, actualCleanedLines);
		assertEquals(sizeMessage, expectedLines.size(), actualCleanedLines.size());
	}

	private static String toSizeMessage(String actualOutput, List<String> expectedLines,
			List<String> actualCleanedLines) {
		StringBuilder sb = new StringBuilder();
		sb.append("\nIncorrect number of (cleaned) lines printed.\n");
		sb.append("\texpected line count: ").append(expectedLines.size()).append(".\n");
		sb.append("\tactual (cleaned) printed line count: ").append(actualCleanedLines.size()).append(".\n");
		sb.append("\n");
		sb.append(Messages.toCompleteFromListOfStrings(actualOutput, expectedLines, actualCleanedLines));
		return sb.toString();
	}

	private static List<List<Integer>> toIntegersList(List<String> lines) {
		List<List<Integer>> result = new ArrayList<>(lines.size());

		// https://stackoverflow.com/a/3681347
		String regex = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?";
		Pattern pattern = Pattern.compile(regex);
		for (String expectedLine : lines) {
			Matcher matcher = pattern.matcher(expectedLine);
			List<Integer> requiredIntegersForLine = new LinkedList<>();
			while (matcher.find()) {
				String substring = matcher.group();
				Double realNumber = Double.parseDouble(substring);
				requiredIntegersForLine.add(realNumber.intValue());
			}
			result.add(requiredIntegersForLine);
		}
		return result;
	}

	public static void checkIntegersList(String actualOutput, List<String> expectedLines,
			List<String> actualCleanedLines) {
		final int N = expectedLines.size();
		if (actualCleanedLines.size() != N) {
			throw new Error("expected sizes already checked");
		}
		List<List<Integer>> expectedIntegersList = SpeedLimitTestUtils.toIntegersList(expectedLines);
		List<List<Integer>> actualIntegersList = toIntegersList(actualCleanedLines);

		int index = 0;
		for (List<Integer> expectedIntegersAtI : expectedIntegersList) {
			List<Integer> actualIntegersAtI = actualIntegersList.get(index);
			String integersSizeMessage = toIntegersAtLineIndexSizeMessage(actualOutput, expectedLines,
					actualCleanedLines, expectedIntegersList, actualIntegersList, index);
			assertEquals(integersSizeMessage, expectedIntegersAtI.size(), actualIntegersAtI.size());
			String integersEqualsMessage = toIntegersAtLineIndexEqualsMessage(actualOutput, expectedLines,
					actualCleanedLines, expectedIntegersList, actualIntegersList, index);
			assertEquals(integersEqualsMessage, expectedIntegersAtI, actualIntegersAtI);
			++index;
		}
	}

	private static String toIntegersAtLineIndexSizeMessage(String actualOutput, List<String> expectedLines,
			List<String> actualCleanedLines, List<List<Integer>> expectedIntegersList,
			List<List<Integer>> actualIntegersList, int lineIndex) {
		StringBuilder sb = new StringBuilder();
		sb.append("\nIncorrect number of integers found on line ").append(lineIndex).append(".\n");
		sb.append("\texpected integer count: ").append(expectedIntegersList.get(lineIndex).size()).append(".\n");
		sb.append("\tactual integer count: ").append(actualIntegersList.get(lineIndex).size()).append(".\n");
		String header = sb.toString();
		return toIntegersAtLineIndexMessage(actualOutput, expectedLines,
				actualCleanedLines, header, expectedIntegersList, actualIntegersList, lineIndex);
	}

	private static String toIntegersAtLineIndexEqualsMessage(String actualOutput, List<String> expectedLines,
			List<String> actualCleanedLines, List<List<Integer>> expectedIntegersList,
			List<List<Integer>> actualIntegersList, int lineIndex) {
		final int N = expectedIntegersList.get(lineIndex).size();
		if (actualIntegersList.get(lineIndex).size() != N) {
			throw new Error("expected sizes already checked");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("\nCorrect number of integers (").append(expectedIntegersList.get(lineIndex).size())
				.append(") found on line[").append(lineIndex).append("] (counting from 0).\n");
		sb.append("However, the contents are different.\n");
		String header = sb.toString();
		return toIntegersAtLineIndexMessage(actualOutput, expectedLines,
				actualCleanedLines, header, expectedIntegersList, actualIntegersList, lineIndex);
	}

	private static String toIntegersAtLineIndexMessage(String actualOutput, List<String> expectedLines,
			List<String> actualCleanedLines, String header, List<List<Integer>> expectedIntegersList,
			List<List<Integer>> actualIntegersList, int lineIndex) {
		StringBuilder sb = new StringBuilder();
		sb.append(header);
		sb.append("\n=== expected integers on line[").append(lineIndex).append("] (counting from 0) ===\n");
		sb.append(expectedIntegersList.get(lineIndex));
		sb.append("\n=== actual integers on line[").append(lineIndex).append("] (counting from 0) ===\n");
		sb.append(actualIntegersList.get(lineIndex));
		sb.append("\n");
		sb.append(Messages.toLineFromListOfStrings(actualOutput, expectedLines, actualCleanedLines, lineIndex));
		sb.append("\n");
		sb.append(Messages.toCompleteFromListOfStrings(actualOutput, expectedLines, actualCleanedLines));
		return sb.toString();
	}

	public static void checkEqualsIgnoringCaseAndWhiteSpace(String actualOutput, List<String> expectedLines,
			List<String> actualCleanedLines) {
		final int N = expectedLines.size();
		if (actualCleanedLines.size() != N) {
			throw new Error("expected sizes already checked");
		}
		StringBuilder sbContents = new StringBuilder();
		int i = 0;
		List<Integer> incorrectLineIndices = new ArrayList<>(N);
		for (String expectedLine : expectedLines) {
			String actualCleanedLine = actualCleanedLines.get(i);
			sbContents.append("[").append(i);

			String expectedWhiteSpaceFree = expectedLine.replaceAll("\\s", "");
			String actualWhiteSpaceFree = actualCleanedLine.replaceAll("\\s", "");

			String actualWithoutPointZeroes = actualWhiteSpaceFree.replaceAll("\\.0", "");

			if (expectedWhiteSpaceFree.equalsIgnoreCase(actualWithoutPointZeroes)) {
				sbContents.append("] match\n");
			} else {
				sbContents.append("] *** DIFFERENCE *** \n");
				incorrectLineIndices.add(i);
			}
			sbContents.append("    expected[").append(i).append("]: ").append(expectedLine).append("\n");
			sbContents.append("      actual[").append(i).append("]: ").append(actualCleanedLine).append("\n");
			sbContents.append("\n");
			++i;
		}
		StringBuilder sbMacro = new StringBuilder();
		sbMacro.append("\nThe correct number of lines (").append(N).append(") were printed.\n");
		sbMacro.append("However, the contents differ on ").append(toLineIndicesText(incorrectLineIndices, N))
				.append(".\n\n");
		sbMacro.append(sbContents);
		String message = sbMacro.toString();
		assertTrue(message, incorrectLineIndices.size() == 0);
	}

	private static String toLineIndicesText(List<Integer> incorrectLineIndices, int N) {
		StringBuilder sb = new StringBuilder();
		if (incorrectLineIndices.size() == N) {
			sb.append("all lines");
		} else {
			if (incorrectLineIndices.size() == 1) {
				sb.append("line ");
				sb.append(incorrectLineIndices.get(0));
			} else {
				sb.append("lines ");
				sb.append(incorrectLineIndices);
			}
			sb.append(" (counting from 0)");
		}
		return sb.toString();
	}
}
