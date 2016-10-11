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
		if(o1.getLastName().compareTo(o2.getLastName()) != 0){
		return o1.getLastName().compareTo(o2.getLastName());
		}else{
			return o1.getCnp().compareTo(o2.getCnp());
		}
	}
}
