/*
 * @author SN
 */
package siit.homework8;

import java.util.Arrays;

import siit.homework6.*;

public class Main {

	public static void main(String[] args) {
		
		SortAlg sortAlg = new BubbleSort();
		Integer [] unsorted = new Integer [] {10, 5, 10, 2 , 2, 6, 13};
		Integer [] sorted = sortAlg.sort(unsorted);
		System.out.println(Arrays.toString(sorted));
		
		Integer [] expected = new Integer [] {1, 2, 5, 6, 10, 13, 15};
		System.out.println(Arrays.toString(expected));
		String [] names = new String [] {"John", "Amber", "Michael", "Carl", "Bill", "Razvan"};
		String [] sortedNames = sortAlg.sort(names);
		System.out.println(Arrays.toString(sortedNames));
		
		Employee[] emps = addObjectToArray();
		Employee [] emps2 = (new BubbleSort()).sort(emps, Employee.NAME_COMP); 
		for (int i = 0; i < emps2.length; i++) {
			System.out.println(emps2[i].toString());
		}
	}

	protected static Employee[] addObjectToArray() {
		Employee e1 = new Employee("Xxxx", "Dave", 6, "ProjectManager", "1720101042301");
		Employee e2 = new Employee("Marica", "Alex", 2, "SeniorEngineer", "1840705344103");
		Employee e3 = new Employee("Nan", "Mariu", 9, "Manager", "1780705216655");
		Employee e4 = new Employee("Alexa", "Alexandra", 1, "JuniorEngineer", "2901105216398");
		Employee e5 = new Employee("Varza", "Alin", 0, "JuniorEngineer", "1910705219239");
		Employee e6 = new Employee("Zagan", "Eugen", 3, "SeniorEngineer", "1860101046308");
		Employee e7 = new Employee("Oanca", "Ana", 3, "JuniorEngineer", "2880705349103");
		Employee e8 = new Employee("Umrea", "Any", 7, "ProjectManager", "2810701044532");
		Employee e9 = new Employee("Aaron", "Emil", 6, "SeniorEngineer", "1850523046305");
		Employee [] emps = new Employee [] { e1, e2, e3, e4, e5, e6, e7, e8, e9};
		return emps;
	}

}
