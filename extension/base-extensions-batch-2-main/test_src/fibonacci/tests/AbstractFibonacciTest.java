package fibonacci.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import fibonacci.ExpectedFibonaccis;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public abstract class AbstractFibonacciTest {
	private final int n;
	private final int expected;

	public AbstractFibonacciTest(int n, int expected) {
		super();
		this.n = n;
		this.expected = expected;
	}

	protected abstract int fibonacci(int n);

	@Test
	public void test() {
		int actual = fibonacci(n);
		assertEquals(expected, actual);
	}

	@Parameterized.Parameters(name = "{0}")
	public static Collection<Object[]> getConstructorArguments() {
		int n = 33;
		List<Object[]> args = new ArrayList<>(n);
		for (int i = 0; i < n; ++i) {
			args.add(new Object[] { i, ExpectedFibonaccis.expected(i) });
		}
		return args;
	}

}
