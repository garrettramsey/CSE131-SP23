package mousechaser.tests;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class ChaseTheMouseTestMessages {
	static String toNullMessage(double[] expected) {
		return "\nThe return value is null.\n";
	}

	static String toNotSameMessage(String parameterName) {
		return "\nThe return value is the same array instance as the " + parameterName + " parameter.\n";
	}

	static String toMutatedParameterMessage(String parameterName, double[] original, double[] mutated) {
		return "\nThe " + parameterName + " parameter was mutated (changed).\n";
	}

	static String toLengthMessage(double[] expected, double[] actual) {
		return "\nThe return value array is not the correct length.\n";
	}

	static String toArrayEqualityMessage(double[] expected, double[] actual) {
		return "\nThe return value array contents are not correct.\n";
	}
}
