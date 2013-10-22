package se.backhage.algo;

public final class QuickSort implements SortingAlgorithm {
    public void sort(int[] toSort) {
        quickSort(toSort, 0, toSort.length-1);
    }

    private void quickSort(int[] toSort, int minIndex, int maxIndex) {
        int incIndex = minIndex;
        int decIndex = maxIndex;
        int pivotValue = toSort[(minIndex + maxIndex) / 2];
        while (incIndex < decIndex) {
            while (toSort[incIndex] < pivotValue) {
                incIndex++;
            }
            while (toSort[decIndex] > pivotValue) {
                decIndex--;
            }
            if (incIndex <= decIndex) {
                swap(toSort, incIndex, decIndex);
                incIndex++;
                decIndex--;
            }
        }
        if (incIndex < maxIndex) {
            quickSort(toSort, incIndex, maxIndex);
        }
        if (decIndex > minIndex) {
            quickSort(toSort, minIndex, decIndex);
        }
    }

    private void swap(int[] array, int firstIndex, int secondIndex) {
        int tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
    }
}
