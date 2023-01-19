package test;

import java.util.List;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class TokensIndexPair {
	private final List<String> tokens;
	private final int index;

	public TokensIndexPair(List<String> tokens, int index) {
		this.tokens = tokens;
		this.index = index;
	}

	public List<String> getTokens() {
		return tokens;
	}

	public int getIndex() {
		return index;
	}
}
