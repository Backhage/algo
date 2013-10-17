package se.backhage.algo;

public class QuicksortArray extends BasicArrayImpl implements SortableArray {
		
	public QuicksortArray(int size) {
		super(size);
	}

	public void sort() {
		quickSort(0, length() - 1);
	}
		
	private void quickSort(int minIndex, int maxIndex) {
		int incIndex = minIndex;
		int decIndex = maxIndex;
		int pivotVal = array[(minIndex + maxIndex) / 2];
			
		while (incIndex < decIndex) {
			while (array[incIndex] < pivotVal) {
				incIndex++;
			}
			while (array[decIndex] > pivotVal) {
				decIndex--;
			}
			if (incIndex <= decIndex) {
				int tmp = array[incIndex];
				array[incIndex] = array[decIndex];
				array[decIndex] = tmp;
				incIndex++;
				decIndex--;
			}
		}
		if (incIndex < maxIndex) {
			quickSort(incIndex, maxIndex);
		}
		if (decIndex > minIndex) {
			quickSort(minIndex, decIndex);
		}
	}
}

