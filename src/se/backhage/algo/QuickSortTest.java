package se.backhage.algo;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Random;

public class QuickSortTest {
  @Test
  public void sortArrayWithEvenNumberOfElements() {
    randomizeSortAndCheckArrayWithLength(2);
  }

  @Test
  public void sortArrayWithUnevenNumberOfElements() {
    randomizeSortAndCheckArrayWithLength(3);
  }

  @Test
  public void sortOneMillionElements() {
    randomizeSortAndCheckArrayWithLength(1000000);
  }

  private void randomizeSortAndCheckArrayWithLength(int length) {
    int[] testArray = createRandomizedArray(length);
    QuickSort.sort(testArray, 0, length - 1);
    assertTestArrayIsSorted(testArray); 
  }

  private int[] createRandomizedArray(final int size) {
    int[] randomizedArray = new int[size];
    Random random = new Random();
    for (int i = 0; i < size; i++) {
      randomizedArray[i] = random.nextInt();
    }
    return randomizedArray;
  }

  private void assertTestArrayIsSorted(int[] arrayToTest) {
    for (int i = 1; i < arrayToTest.length; ++i) {
      assertTrue(arrayToTest[i - 1] <= arrayToTest[i]);
    }
  }
}
