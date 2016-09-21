/**
 * 
 */
package siit.homework6;

import java.util.Comparator;

/**
 * @author SN
 * TreeSet comparator for LastName
 */
public class NameComp implements Comparator<Employee>{
	
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getLastName().compareTo(o2.getLastName());
	}



}
