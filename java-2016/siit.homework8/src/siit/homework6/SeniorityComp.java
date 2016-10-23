/**
 * 
 */
package siit.homework6;

import java.util.Comparator;

/**
 * @author SN
 * TreeSet comparator for LastName
 */
public class SeniorityComp implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.getYearsInTheCompany() < o2.getYearsInTheCompany()){
			return 1;
		}else {
			return -1;
		}
	}
}
