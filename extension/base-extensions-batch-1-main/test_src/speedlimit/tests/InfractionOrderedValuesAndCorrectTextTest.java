package speedlimit.tests;

import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class InfractionOrderedValuesAndCorrectTextTest extends AbstractInfractionTest {
	public InfractionOrderedValuesAndCorrectTextTest(int reportedOverMPH, int limitMPH, List<String> expectedLines) {
		super(reportedOverMPH, limitMPH, expectedLines, TestExtent.VALUE_ORDER_AND_TEXT_CONTENTS);
	}
}
