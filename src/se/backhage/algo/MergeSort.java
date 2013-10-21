package se.backhage.algo;

public class MergeSort implements SortingAlgorithm {
    private int[] mergeSortArray;

    public void sort(int[] toSort, int minIndex, int maxIndex) {
        mergeSortArray = new int[toSort.length];
        mergeSort(toSort, 0, toSort.length - 1);
    }

    private void mergeSort(int[] toSort, int minIndex, int maxIndex) {
        if (minIndex < maxIndex) {
            int middleIndex = (minIndex + maxIndex) / 2;
            mergeSort(toSort, minIndex, middleIndex);
            mergeSort(toSort, middleIndex+1, maxIndex);
            merge(toSort, minIndex, maxIndex);
        }
    }

    private void merge(int[] toSort, int minIndex, int maxIndex) {
        for (int i = minIndex; i <= maxIndex; ++i) {
            mergeSortArray[i] = toSort[i];
        }

        int leftIndex = minIndex;
        int middleIndex = (minIndex + maxIndex) / 2;
        int rightIndex = middleIndex + 1;
        int targetIndex = minIndex;

        while (leftIndex <= middleIndex && rightIndex <= maxIndex) {
            if (mergeSortArray[leftIndex] <= mergeSortArray[rightIndex]) {
                toSort[targetIndex] = mergeSortArray[leftIndex];
                ++leftIndex;
            }
            else {
                toSort[targetIndex] = mergeSortArray[rightIndex];
                ++rightIndex;
            }
            ++targetIndex;
        }
        while (leftIndex <= middleIndex) {
            toSort[targetIndex] = mergeSortArray[leftIndex];
            ++targetIndex;
            ++leftIndex;
        }
    }
}
