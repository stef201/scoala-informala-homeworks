/**
 * 
 */
package siit.homework6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author SN
 * Main method
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*EmployeesParkingSpace parking = new EmployeesParkingSpace();
		int parkingSpaces = 4;
		inputList();
		ArrayList initialList = (ArrayList) inputList();
		
		
		System.out.println("Employees with a parcking space:");
		parking.withParkingSpace(initialList, parkingSpaces);
		// the actual list can be obtain from the same method above as a TreeSet()
		
		
		System.out.println("\nEmployees without a parcking space:");
		parking.noParkingSpace(initialList, parkingSpaces);
		// the actual list can be obtain from the same method above as a TreeSet()
*/		Employee e1 = new Employee("Xxxx", "Dave", 6, "ProjectManager", "1720101042301");
		Employee e2 = new Employee("Marica", "Alex", 2, "SeniorEngineer", "1840705344103");
		Employee e3 = new Employee("Nan", "Mariu", 9, "Manager", "1780705216655");
		Employee e4 = new Employee("Alexa", "Alexandra", 1, "JuniorEngineer", "2901105216398");
		Employee e5 = new Employee("Varza", "Alin", 0, "JuniorEngineer", "1910705219239");
		Employee e6 = new Employee("Zagan", "Eugen", 3, "SeniorEngineer", "1860101046308");
		Employee e7 = new Employee("Oanca", "Ana", 3, "JuniorEngineer", "2880705349103");
		Employee e8 = new Employee("Umrea", "Any", 7, "ProjectManager", "2810701044532");
		Employee e9 = new Employee("Aaron", "Emil", 6, "SeniorEngineer", "1850523046305");
		Employee e10 = new Employee("Muron", "Emilia", 15, "JuniorEngineer", "2860909042308");
		
		TreeSet<Employee> sortedE = new TreeSet<>(new NameComp());
		sortedE.add(e1); sortedE.add(e2); sortedE.add(e3); sortedE.add(e4); sortedE.add(e5);
		sortedE.add(e6); sortedE.add(e7); sortedE.add(e8); sortedE.add(e9);
		
		Employee [] emps = new Employee [9];
		int i = 0;
		for (Employee employee : sortedE) {
			emps [i] = employee;
			i++;
		}
		System.out.println(Arrays.toString(emps));
	}

	/**
	 * @return
	 * 
	 */
	private static Collection inputList() {
		Collection initialList = new ArrayList();
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
