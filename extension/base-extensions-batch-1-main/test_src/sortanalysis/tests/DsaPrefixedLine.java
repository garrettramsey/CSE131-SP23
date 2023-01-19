package sortanalysis.tests;

import java.util.Arrays;
import java.util.List;

import test.NumberType;
import test.PrefixedLineOfNumbers;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public enum DsaPrefixedLine implements PrefixedLineOfNumbers {
	INPUT(NumberType.INTEGER), SORTED(NumberType.INTEGER), MEAN(NumberType.DOUBLE), MEDIAN(NumberType.DOUBLE),
	MIN(NumberType.INTEGER), MAX(NumberType.INTEGER), RANGE(NumberType.INTEGER);

	private String expectedPrefix = name().substring(0, 1) + name().substring(1).toLowerCase() + ":";

	private final NumberType numberType;

	private DsaPrefixedLine(NumberType numberType) {
		this.numberType = numberType;
	}

	@Override
	public NumberType getNumberType() {
		return numberType;
	}

	@Override
	public List<String> getAcceptablePrefixes() {
		return Arrays.asList(expectedPrefix, expectedPrefix.replaceAll(":", "="), expectedPrefix.replaceAll(":", ""));
	}

	@Override
	public int getExpectedIndex() {
		return ordinal();
	}
}
