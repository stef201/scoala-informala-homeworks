/**
 * 
 */
package siit.homework6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author stef
 *
 */
public class EmployeeParkingSpaceIntegrationTest {

	@Test
	public void testParkingSpaces() {
		// given
		ArrayList initialList = originalListTest();
		TreeSet test1 = new TreeSet(new SeniorityComp());
		TreeSet test2 = new TreeSet(new SeniorityComp());
		EmployeesParkingSpace parking = new EmployeesParkingSpace();
		int parkingSpaces = 5;
		// when
		test1 = parking.withParkingSpace(initialList, parkingSpaces);
		test2 = parking.noParkingSpace(initialList, parkingSpaces);
		// then
		Assert.assertTrue(test1.size() == test2.size());
	}

	@Test
	public void testParkingSpaces2() {
		// given
		Employee e10 = new Employee("Muron", "Emilia", 15, "JuniorEngineer", "2860909042308");
		ArrayList initialList = originalListTest();
		TreeSet test1 = new TreeSet(new SeniorityComp());
		TreeSet test2 = new TreeSet(new SeniorityComp());
		EmployeesParkingSpace parking = new EmployeesParkingSpace();
		int parkingSpaces = 10;
		// when
		test2 = parking.noParkingSpace(initialList, parkingSpaces);
		// then
		Assert.assertTrue(test2.isEmpty());
	}
	
	@Test
	public void testParkingSpaces3() {
		// given
		Employee e10 = new Employee("Muron", "Emilia", 15, "JuniorEngineer", "2860909042308");
		ArrayList initialList = originalListTest();
		TreeSet test1 = new TreeSet(new SeniorityComp());
		TreeSet test2 = new TreeSet(new SeniorityComp());
		EmployeesParkingSpace parking = new EmployeesParkingSpace();
		int parkingSpaces = 3;
		// when
		test2 = parking.noParkingSpace(initialList, parkingSpaces);
		// then
		Assert.assertFalse(test2.isEmpty());
	}

	/**
	 * @return
	 */
	protected ArrayList originalListTest() {
		ArrayList initialList = new ArrayList();
		Employee e1 = new Employee("Xxxx", "Dave", 6, "ProjectManager", "1720101042301");
		Employee e2 = new Employee("Marica", "Alex", 2, "SeniorEngineer", "1840705344103");
		Employee e3 = new Employee("Nan", "Mariu", 9, "Manager", "1780705216655");
		Employee e4 = new Employee("Alexa", "Alexandra", 1, "JuniorEngineer", "2901105216398");
		Employee e5 = new Employee("Varza", "Alin", 0, "JuniorEngineer", "1910705219239");
		Employee e6 = new Employee("Zagan", "Eugen", 3, "SeniorEngineer", "1860101046308");
		Employee e7 = new Employee("Oanca", "Ana", 3, "JuniorEngineer", "2880705349103");
		Employee e8 = new Employee("Umrea", "Any", 7, "ProjectManager", "2810701044532");
		Employee e9 = new Employee("Aaron", "Emil", 6, "SeniorEngineer", "1850523046305");
		Employee e10 = new Employee("Muron", "Emilia", 15, "JuniorEngineer", "2860909042308");
		initialList.add(e1);
		initialList.add(e2);
		initialList.add(e3);
		initialList.add(e4);
		initialList.add(e5);
		initialList.add(e6);
		initialList.add(e7);
		initialList.add(e8);
		initialList.add(e9);
		initialList.add(e10);
		return initialList;
	}
}
