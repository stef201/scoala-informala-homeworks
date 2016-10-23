/*
 * @author SN
 */
package siit.homework8;

import java.util.Comparator;

import siit.homework6.Employee;

/**
 * The Interface SortAlg. that requests a comparator
 */
public interface SortAlg {
	
	public <T extends Comparable<T>> T[] sort(T[] unsorted);

	
}
