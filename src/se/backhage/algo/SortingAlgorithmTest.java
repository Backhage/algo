package se.backhage.algo;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SortingAlgorithmTest {
    private SortingAlgorithm sortingAlgorithm;

    public SortingAlgorithmTest(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

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
        sortingAlgorithm.sort(testArray);
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

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
                new Object[]{new QuickSort()},
                new Object[]{new MergeSort()});
    }
}
