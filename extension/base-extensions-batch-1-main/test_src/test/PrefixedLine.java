package test;

import java.util.List;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public interface PrefixedLine {
	List<String> getAcceptablePrefixes();

	int getExpectedIndex();
}
