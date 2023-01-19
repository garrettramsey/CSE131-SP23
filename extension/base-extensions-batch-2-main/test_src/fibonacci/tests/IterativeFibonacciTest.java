package fibonacci.tests;

import fibonacci.Fibonacci;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class IterativeFibonacciTest extends AbstractFibonacciTest {
	public IterativeFibonacciTest(int n, int expected) {
		super(n, expected);
	}

	@Override
	protected int fibonacci(int n) {
		return Fibonacci.iterative(n);
	}
}
