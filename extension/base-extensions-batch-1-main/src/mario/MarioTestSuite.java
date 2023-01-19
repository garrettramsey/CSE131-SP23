package mario;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import mario.tests.MarioTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ MarioTest.class })
public class MarioTestSuite {
}
