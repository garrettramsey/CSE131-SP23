package speedlimit.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DeclarationsTest {
	@Test
	public void testClass() throws ClassNotFoundException {
		Class.forName("speedlimit.SpeedLimit");
	}

	@Test
	public void testMainMethod() throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		Class<?> cls = Class.forName("speedlimit.SpeedLimit");
		Method method = cls.getMethod("main", String[].class);
		assertTrue(Modifier.isPublic(method.getModifiers()));
		assertTrue(Modifier.isStatic(method.getModifiers()));
		assertEquals(Void.TYPE, method.getReturnType());
	}
}
