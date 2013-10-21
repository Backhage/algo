package se.backhage.algo;

public final class QuickSort {
    public static void sort(int[] toSort, int minIndex, int maxIndex) {
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
            sort(toSort, incIndex, maxIndex);
        }
        if (decIndex > minIndex) {
            sort(toSort, minIndex, decIndex);
        }
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
    }
}
