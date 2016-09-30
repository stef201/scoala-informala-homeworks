/*
 * @author SN
 */
package siit.homework7;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class OperationStudent.
 */
public class OperationStudent {
	
	private Student student;

	/**
	 * Adds the student.
	 *
	 * @param students
	 *            the students
	 * @param firstName
	 *            the first name
	 * @param lastName
	 *            the last name
	 * @param dateBirth
	 *            the date birth
	 * @param gender
	 *            the gender
	 * @param cnp
	 *            the cnp
	 * @return the hash set
	 * @throws WrongBirthYearException
	 *             the wrong birth year exception
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 * @throws NullPointerException
	 *             the null pointer exception
	 * @throws StudentUnknownNameException
	 *             the student unknown name exception
	 */
	public HashSet<Student> addStudent(HashSet<Student> students, String firstName, String lastName, String dateBirth,
			String gender, String cnp)
					throws WrongBirthYearException, IllegalArgumentException, StudentUnknownNameException {
		
		// First and Last Name
		student = new Student(firstName, lastName, dateBirth, gender, cnp);
		if (firstName != "" && lastName != "") {
			student.setFirstName(firstName);
			student.setLastName(lastName);
		} else {
			throw new StudentUnknownNameException("First or Last name not filled!");
		}
		// Birth Date
		Calendar birth = null;
		try {
			birth = parseStringToCalendar(dateBirth);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Date format wrong (dd MM YYYY)" + e);
		}
		Calendar cal = Calendar.getInstance();
		if (1900 < birth.get(birth.YEAR) && birth.get(birth.YEAR) < (cal.get(Calendar.YEAR) - 18)) {
			student.setDateBirth(dateBirth);
		} else {
			throw new WrongBirthYearException("Year of birth should be less then current year - 18!");
		}
		// Gender
		if (gender == "m" || gender == "M" || gender == "f" || gender == "F") {
			student.setGender(gender);
		} else {
			throw new IllegalArgumentException("Gender should be M/m/F/f !! not: " + gender);
		}
		// CNP/ID
		boolean condition = (cnp.startsWith("1") && (gender == "m" || gender == "M"))
				|| (cnp.startsWith("2") && (gender == "f" || gender == "F")) && (cnp.length() == 13);
		if (condition) {
			student.setCnp(cnp);
		} else {
			throw new IllegalArgumentException("Wrong CNP(/size) or wrong gender!");
		}
		students.add(student);

		return students;
	}

	/**
	 * Delete student.
	 *
	 * @param students
	 *            the students
	 * @param cnp
	 *            the cnp
	 * @return the hash set
	 * @throws StudentNonExistentException
	 *             the student non existent exception
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 */
	public HashSet<Student> deleteStudent(HashSet<Student> students, String cnp)
			throws StudentNonExistentException, IllegalArgumentException {

		boolean x = false;
		if (cnp == "" || cnp.length() != 13) {
			throw new IllegalArgumentException(
					"To delete student by CNP, field must not be empty and must be composed of 13 digits");
		} else {
			for (Student s : students) {
				if (s.getCnp() == cnp) {
					x = true;
					student = s;
				}
			}

			if (x == true) {
				students.remove(student);
			} else {
				throw new StudentNonExistentException("The there is no student with the inputed CNP " + cnp + "\n");
			}
		}
		return students;
	}

	/**
	 * Retrieve students age X.
	 *
	 * @param students
	 *            the students
	 * @param age
	 *            the age
	 * @return the hash set
	 * @throws ParseException
	 *             the parse exception
	 */
	public HashSet<Student> retriveStudentsAgeX(HashSet<Student> students, int age) throws ParseException {
		HashSet<Student> result;
		if (age <= 0 || age>99) {
			throw new IllegalArgumentException("Age should not be negative: " + age);
		} else {
			result = new HashSet<Student>();
			Calendar cal = Calendar.getInstance();
			Calendar birth = null;
			for (Student s : students) {
				try {
					birth = parseStringToCalendar(s.getDateBirth());
				} catch (ParseException e) {
					//already checked in add method.
				}
				int x = 0;
				int month = cal.get(cal.MONTH) - birth.get(birth.MONTH);
				int day = cal.get(cal.DAY_OF_MONTH) - birth.get(birth.DAY_OF_MONTH);
				if (month < 0 || (month == 0 && day < 0)) {
					x = -1;
				}
				int age2 = cal.get(cal.YEAR) - birth.get(birth.YEAR) + x;
				if (age == age2) {
					result.add(s);
				}
			}
		}
		return result;

	}

	/**
	 * Order students by.
	 *
	 * @param students
	 *            the students
	 * @param nameOrBirth
	 *            the name or birth
	 * @return the tree set
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 */
	public TreeSet<Student> orderStudentsBy(HashSet<Student> students, String nameOrBirth)
			throws IllegalArgumentException {

		if (nameOrBirth == "Name" || nameOrBirth == "name") {
			TreeSet<Student> sortedStudents = new TreeSet<>(new LastNameCompare());
			for (Student s : students) {
				sortedStudents.add(s);
			}
			return sortedStudents;
		} else if (nameOrBirth == "date" || nameOrBirth == "Date") {
			TreeSet<Student> sortedStudents = new TreeSet<>(new BirthDateCompare());
			for (Student s : students) {
				sortedStudents.add(s);
			}
			return sortedStudents;
		} else {
			throw new IllegalArgumentException("The sorted list should be by -date- or -name-");
		}
	}

	/**
	 * Parses the string to calendar.
	 *
	 * @param dateBirth
	 *            the date birth
	 * @return the calendar
	 * @throws ParseException
	 *             the parse exception
	 */
	protected Calendar parseStringToCalendar(String dateBirth) throws ParseException {
		Calendar cal = Calendar.getInstance();
		DateFormat format = new SimpleDateFormat("dd MM yyyy");
		format.setLenient(false);
		Date date = format.parse(dateBirth);
		cal.setTime(date);
		return cal;
	}
}
