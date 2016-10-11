/*
 * @author SN
 */
package siit.homework8;

import java.util.Comparator;

/**
 * The Class BubbleSort.
 */
public class BubbleSort implements SortAlg {

	/**
	 * Sort.
	 *
	 * @param <T> the generic type
	 * @param array 
	 * @param comparator: the comparator
	 * @return the array t[]
	 */
	public <T> T[] sort(T[] array, Comparator<T> comparator) {
		if ((null == array) || (array.length < 2)) {
			return array;
		}
		boolean ordered;

		do {
			ordered = false;
			for (int j = 1; j < array.length; j++) {
				if (comparator.compare(array[j-1], array[j]) > 0) {
					ordered = true;
					replace(array, j);
				}
			}
		} while (ordered);
		return array;

	}

	/**
	 * Sort Array
	 *
	 * @param <T> the generic type
	 * @param unsorted the array to be sorted
	 * @return the array t[]
	 */
	public <T extends Comparable<T>> T[] sort(T[] unsorted) {
		if ((null == unsorted) || (unsorted.length < 2)) {
			return unsorted;
		}
		int length = unsorted.length;
		boolean ordered;

		do {
			ordered = false;
			for (int j = 1; j < length; j++) {
				if (unsorted[j - 1].compareTo(unsorted[j]) > 0) {
					ordered = true;
					replace(unsorted, j);
				}
			}
		} while (ordered);
		return unsorted;
	}
	
	/**
	 * Replace.
	 *
	 * @param <T> the generic type
	 * @param array 
	 * @param j the index
	 */
	protected <T> void replace(T[] array, int j) {
		T temp = array[j - 1];
		array[j - 1] = array[j];
		array[j] = temp;
	}
	
	/**
	 * Replace.
	 *
	 * @param <T> the generic type
	 * @param unsorted the unsorted array
	 * @param j index
	 */
	protected <T extends Comparable<T>> void replace(T[] unsorted, int j) {
		T temp = unsorted[j - 1];
		unsorted[j - 1] = unsorted[j];
		unsorted[j] = temp;
	}
}
