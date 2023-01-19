package speedlimit.tests;

import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class InfractionAtLeastOrderedValuesTest extends AbstractInfractionTest {
	public InfractionAtLeastOrderedValuesTest(int reportedOverMPH, int limitMPH, List<String> expectedLines) {
		super(reportedOverMPH, limitMPH, expectedLines, TestExtent.VALUE_ORDER_ONLY);
	}
}
