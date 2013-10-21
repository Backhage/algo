package se.backhage.algo;

public class BasicArrayImpl implements BasicArray {
    protected int[] array;

    BasicArrayImpl(int size) {
        array = new int[size];
    }
    public void set(int index, int value) {
        array[index] = value;
    }
    public int get(int index) {
        return array[index];
    }
    public int length() {
        return array.length;
    }
}
