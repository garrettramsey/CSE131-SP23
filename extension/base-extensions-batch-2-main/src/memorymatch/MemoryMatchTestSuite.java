package memorymatch;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import memorymatch.tests.GenerateBoardTestSuite;
import memorymatch.tests.ShuffleTestSuite;
import memorymatch.tests.SwapTestSuite;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ SwapTestSuite.class, ShuffleTestSuite.class, GenerateBoardTestSuite.class })
public class MemoryMatchTestSuite {
}
