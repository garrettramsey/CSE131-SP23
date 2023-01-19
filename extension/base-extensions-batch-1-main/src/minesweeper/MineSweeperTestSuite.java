package minesweeper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import minesweeper.tests.CountTest;
import minesweeper.tests.ProbabilityTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ CountTest.class, ProbabilityTest.class })
public class MineSweeperTestSuite {
}
