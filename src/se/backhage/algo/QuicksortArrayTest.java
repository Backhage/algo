package se.backhage.algo;

import java.util.Random;

import static org.junit.Assert.*;
import org.junit.*;

public class QuicksortArrayTest {
	private final int ARRAY_SIZE = 100000;
	private SortableArray sortableArray;
	
	@Before
	public void setUp() {
		sortableArray = new QuicksortArray(ARRAY_SIZE);
	}
	
	@Test
	public void getLength() {
		assertEquals(ARRAY_SIZE, sortableArray.length());
	}
	
	@Test
	public void setAndGetFirstElement() {
		final int FIRST_INDEX = 0;
		assertSetAndGet(FIRST_INDEX);
	}

	@Test
	public void setAndGetLastElement() {
		final int LAST_INDEX = ARRAY_SIZE - 1;
		assertSetAndGet(LAST_INDEX);
	}
	
	private void assertSetAndGet(int index) {
		assertEquals(0, sortableArray.get(index));
		final int TEST_VALUE = 42;
		sortableArray.set(index, TEST_VALUE);
		assertEquals(TEST_VALUE, sortableArray.get(index));
	}
	
	@Test
	public void sort() {
		randomizeArray();
		sortableArray.sort();
		assertArrayIsSorted();
	}
	
	private void randomizeArray() {
		Random random = new Random();
		for (int i = 0; i < ARRAY_SIZE; ++i) {
			sortableArray.set(i, random.nextInt());
		}
	}
	
	private void assertArrayIsSorted() {
		for (int i = 1; i < ARRAY_SIZE; ++i) {
			assertTrue(sortableArray.get(i - 1) <= sortableArray.get(i));
		}
	}
}
