/**
 * @author SN
 */
package siit.homework7;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * 
	 */
	public static void main(String[] args) {

		OperationStudent op = new OperationStudent();
		HashSet<Student> test = new HashSet<>();
		
		//ADD
		try {
			test = op.addStudent(test, "Ion", "Ana",  "01 01 1972", "f", "2891202087255");
			test = op.addStudent(test, "Dave", "Xxxx", "01 01 1972", "m", "1720101042301");
			test = op.addStudent(test, "Alex", "Marica", "05 07 1984", "M", "1840705344103");
			test = op.addStudent(test, "Alexandra", "Alexa", "05 11 1990", "F", "2901105216398");
			test = op.addStudent(test, "Alin", "Varza", "05 07 1991", "m", "1910705219239");
			test = op.addStudent(test, "Eugen", "Zagan", "01 01 1986", "m", "1860101046308");
			test = op.addStudent(test, "Ana", "Oanca", "05 07 1988", "f", "2880705349103");
			test = op.addStudent(test, "Any", "Umrea", "01 07 1981", "f", "2810701044532");
			test = op.addStudent(test, "Emil", "Aaron", "23 05 1983", "m", "1850523046305");
			test = op.addStudent(test, "Emilia", "Muron", "09 09 1986", "f", "2860909042308");
		} catch (IllegalArgumentException | StudentUnknownNameException | WrongBirthYearException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		printSet(test);
		System.out.println("------------------");
		
		//REMOVE
		try {
			test = op.deleteStudent(test, "2901105216398");
			test = op.deleteStudent(test, "2810701044532");
			test = op.deleteStudent(test, "2860909042308");
		} catch (IllegalArgumentException | StudentNonExistentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		printSet(test);
		System.out.println("------------------");
		
		//AGE
		System.out.println("Age = 30");
		HashSet<Student> ageSet = new HashSet<>();
		try {
			ageSet = op.retriveStudentsAgeX(test, 30);
			printSet(ageSet);
		} catch (ParseException e) {
			// The parsing was already done for the adding of the object in the Set. 
			// So here unless the object is modified, there should be no
			// exception thrown
		}
		System.out.println("------------------");

		//SORT NAME 
		TreeSet<Student> sort = new TreeSet<>();
		try {
			sort = op.orderStudentsBy(test, "name");
		} catch (IllegalArgumentException e) {
			System.out.printf(e.getMessage(), e);
			
		}
		for (Student student : sort) {
			System.out.println(student.toString());
		}
		System.out.println("------------------");
		//SORT DATE
		TreeSet<Student> sort2 = new TreeSet<>();
		try {
			sort2 = op.orderStudentsBy(test, "date");
		} catch (IllegalArgumentException e) {
			System.out.printf(e.getMessage(), e);
			
		}
		for (Student student : sort2) {
			System.out.println(student.toString());
		}
		System.out.println("------------------");
	}

	/**
	 * Prints the set.
	 *
	 * @param hashSet the hash set
	 */
	protected static void printSet(HashSet<Student> hashSet) {
		for (Student student : hashSet) {
			System.out.println(student.toString());
		}
	}

}
