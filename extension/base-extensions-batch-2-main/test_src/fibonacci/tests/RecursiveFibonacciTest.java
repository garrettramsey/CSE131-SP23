package fibonacci.tests;

import fibonacci.Fibonacci;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class RecursiveFibonacciTest extends AbstractFibonacciTest {
	public RecursiveFibonacciTest(int n, int expected) {
		super(n, expected);
	}

	@Override
	protected int fibonacci(int n) {
		return Fibonacci.recursive(n);
	}
}
