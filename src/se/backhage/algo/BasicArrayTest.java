package se.backhage.algo;

import org.junit.*;
import static org.junit.Assert.*;

public class BasicArrayTest {
	private final int ARRAY_SIZE = 100000;
	private BasicArray basicArray;
	
	@Before
	public void setUp() {
		basicArray = new BasicArrayImpl(ARRAY_SIZE);
	}

	@Test
	public void checkLength() {
		assertEquals(ARRAY_SIZE, basicArray.length());
	}
	
	@Test
	public void setAndGetFirstElement() {
		basicArray.set(0, 42);
		assertEquals(42, basicArray.get(0));
	}
	
	@Test
	public void setAndGetLastElement() {
		int lastIndex = ARRAY_SIZE - 1;
		basicArray.set(lastIndex, 42);
		assertEquals(42, basicArray.get(lastIndex));
	}
}
