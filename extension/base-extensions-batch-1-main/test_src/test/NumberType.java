package test;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public enum NumberType {
	INTEGER {
		@Override
		protected Number parse(String token) {
			return Integer.parseInt(token);
		}
	},
	DOUBLE {
		@Override
		protected Number parse(String token) {
			return Double.parseDouble(token);
		}
	};

	protected abstract Number parse(String token);

	public boolean isParsable(String token) {
		try {
			parse(token);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
}
