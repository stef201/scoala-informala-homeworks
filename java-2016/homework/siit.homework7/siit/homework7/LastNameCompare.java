/**
 * 
 */
package siit.homework7;

import java.util.Comparator;



/**
 * The Class LastNameCompare.
 */
public class LastNameCompare implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		return s1.getLastName().compareTo(s2.getLastName());
	}

}
