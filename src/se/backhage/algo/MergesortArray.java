package se.backhage.algo;

public class MergesortArray extends BasicArrayImpl implements SortableArray {
    private int[] mergeSortArray;

    public MergesortArray(int size) {
        super(size);
    }

    public void sort() {
        mergeSortArray = new int[length()];
        mergeSort(0, length() - 1);
    }

    private void mergeSort(int minIndex, int maxIndex) {
        if (minIndex < maxIndex) {
            int middleIndex = (minIndex + maxIndex) / 2;
            mergeSort(minIndex, middleIndex);
            mergeSort(middleIndex+1, maxIndex);
            merge(minIndex, maxIndex);
        }
    }

    private void merge(int minIndex, int maxIndex) {
        for (int i = minIndex; i <= maxIndex; ++i) {
            mergeSortArray[i] = array[i];
        }

        int leftIndex = minIndex;
        int middleIndex = (minIndex + maxIndex) / 2;
        int rightIndex = middleIndex + 1;
        int targetIndex = minIndex;

        while (leftIndex <= middleIndex && rightIndex <= maxIndex) {
            if (mergeSortArray[leftIndex] <= mergeSortArray[rightIndex]) {
                array[targetIndex] = mergeSortArray[leftIndex];
                ++leftIndex;
            }
            else {
                array[targetIndex] = mergeSortArray[rightIndex];
                ++rightIndex;
            }
            ++targetIndex;
        }
        while (leftIndex <= middleIndex) {
            array[targetIndex] = mergeSortArray[leftIndex];
            ++targetIndex;
            ++leftIndex;
        }
    }
}
