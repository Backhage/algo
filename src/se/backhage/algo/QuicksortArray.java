package se.backhage.algo;

public class QuicksortArray extends BasicArrayImpl implements SortableArray {

    public QuicksortArray(int size) {
        super(size);
    }

    public void sort() {
        QuickSort.sort(array, 0, array.length - 1);
    }
}
