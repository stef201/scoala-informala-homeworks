/**
 * 
 */
package siit.homework7;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Comparator;


/**
 * The Class BirthDateCompare.
 */
public class BirthDateCompare implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		OperationStudent op = new OperationStudent();
		Calendar date1, date2;
		int i = 0;
		try {
			date1 = op.parseStringToCalendar(s1.getDateBirth());
			date2 = op.parseStringToCalendar(s2.getDateBirth());
			int d1 = (date1.get(date1.YEAR) * 10000 + date1.get(date1.MONTH) * 100 + date1.get(date1.DAY_OF_MONTH));
			int d2 = (date2.get(date2.YEAR) * 10000 + date2.get(date2.MONTH) * 100 + date2.get(date2.DAY_OF_MONTH));
			if (d1 < d2) {
				i = -1;
			} else if (d1 == d2) {
				i = s1.getCnp().compareTo(s2.getCnp());
			} else {
				i = 1;
			}
		} catch (ParseException e) {
			System.out.println("Date of birth should be like: dd MM YYYY");
			e.printStackTrace();
			// At this stage, Object is already checked for this exception
		}
		return i;
	}

}
