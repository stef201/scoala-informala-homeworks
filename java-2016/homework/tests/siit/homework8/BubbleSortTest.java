package siit.homework8;

import org.junit.Test;

import siit.homework6.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Before;

public class BubbleSortTest {

	private Employee [] emps = new Employee[9];
	private Employee [] empsSorted = new Employee[9];
	@Before
	public void addObjectToArray() {
		
		//array to be sorted
		Employee e1 = new Employee("Aaron", "Emil", 6, "SeniorEngineer", "1850523046305");
		Employee e2 = new Employee("Marica", "Alex", 2, "SeniorEngineer", "1840705344103");
		Employee e3 = new Employee("Nan", "Mariu", 9, "Manager", "1780705216655");
		Employee e4 = new Employee("Alexa", "Alexandra", 1, "JuniorEngineer", "2901105216398");
		Employee e5 = new Employee("Varza", "Alin", 0, "JuniorEngineer", "1910705219239");
		Employee e6 = new Employee("Zagan", "Eugen", 3, "SeniorEngineer", "1860101046308");
		Employee e7 = new Employee("Oanca", "Ana", 3, "JuniorEngineer", "2880705349103");
		Employee e8 = new Employee("Umrea", "Any", 7, "ProjectManager", "2810701044532");
		Employee e9 = new Employee("Xxxx", "Dave", 6, "ProjectManager", "1720101042301");
		emps = new Employee[]{e1,e2,e3,e4,e5,e6,e7,e8,e9};

		//array sorted to be compared to.
		TreeSet<Employee> treeSet = new TreeSet<>(new NameComp());
		treeSet.add(e1); treeSet.add(e2); treeSet.add(e3); treeSet.add(e4); treeSet.add(e5);
		treeSet.add(e6); treeSet.add(e7); treeSet.add(e8); treeSet.add(e9);
		int i = 0;
		for (Employee employee : treeSet) {
			empsSorted [i] = employee;
			i++;
		}
	}
	
	//Integer
	@Test
	public void testSortInteger() {
		// given
		SortAlg sortAlg = new BubbleSort();
		Integer [] unsorted = new Integer [] {10, 5, 1, 2 , 15, 6, 13};
		Integer [] expected = new Integer [] {1, 2, 5, 6, 10, 13, 15};
		// when
		Integer [] sorted = sortAlg.sort(unsorted);
		// then
		assertArrayEquals(expected, sorted);
	}
	
	//test duplicated values
	@Test
	public void testSortIntegerDuplicatedValues() {
		// given
		SortAlg sortAlg = new BubbleSort();
		Integer [] unsorted = new Integer [] {10, 5, 10, 2 , 2, 6, 13};
		Integer [] expected = new Integer [] {2, 2, 5, 6, 10, 10, 13};
		// when
		Integer [] sorted = sortAlg.sort(unsorted);
		// then
		assertArrayEquals(expected, sorted);
	}
	
	//test array with only one element
	@Test
	public void testSortIntegerOneElement() {
		// given
		SortAlg sortAlg = new BubbleSort();
		Integer [] unsorted = new Integer [] {1};
		Integer [] expected = new Integer [] {1};
		// when
		Integer [] sorted = sortAlg.sort(unsorted);
		// then
		assertArrayEquals(expected, sorted);
	}
	
	//Double
	@Test
	public void testSortDouble() {
		// given
		SortAlg sortAlg = new BubbleSort();
		Double [] unsorted = new Double [] {10.4, 5.5, 5.5, 1.4, 2.0 };
		Double [] expected = new Double [] {1.4, 2.0, 5.5, 5.5, 10.4};
		// when
		Double [] sorted = sortAlg.sort(unsorted);
		// then
		assertArrayEquals(expected, sorted);
	}
	
	//String
	@Test
	public void testSortString() {
		// given
		SortAlg sortAlg = new BubbleSort();
		String [] unsorted = new String [] {"ee", "bb",  "dd", "gg", "aa"};
		String [] expected = new String [] {"aa", "bb", "dd", "ee", "gg"};
		// when
		String [] sorted = sortAlg.sort(unsorted);
		// then
		assertArrayEquals(expected, sorted);
	}
	
	//Objects!
	@Test
	public void testSortObjects(){
		//given
		//when
		Employee [] actual = (new BubbleSort()).sort(emps, Employee.NAME_COMP); 
		//then
		assertArrayEquals(actual, empsSorted);
	}
	
	@Test
	public void testSortObjectsNotNull(){
		//given
		//when
		Employee [] actual = (new BubbleSort()).sort(emps, Employee.NAME_COMP); 
		//then
		assertEquals(actual.length, 9);
	}
	
	@Test
	public void testSortOneObject(){
		//given
		Employee [] employee = new Employee[1];
		Employee e1 = new Employee("Aaron", "Emil", 6, "SeniorEngineer", "1850523046305");
		employee[0] = e1;
		//when
		Employee [] actual = (new BubbleSort()).sort(employee, Employee.NAME_COMP); 
		//then
		assertEquals(actual.length, 1);
	}
	
	@Test
	public void testSortObjectVsManyFail(){
		//given
		Employee [] employee = new Employee[1];
		Employee e1 = new Employee("Aaron", "Emil", 6, "SeniorEngineer", "1850523046305");
		employee[0] = e1;
		//when
		Employee [] actual = (new BubbleSort()).sort(empsSorted, Employee.NAME_COMP); 
		//then
		assertFalse(actual.length == employee.length);
	}
	
	@Test
	public void testSortObjectsFailForOneLessObject(){
		//given
		Employee [] employee = new Employee[8];
		for (int i = 0; i < empsSorted.length -1; i++) {
			employee[i] = empsSorted[i];
		}
		//when
		Employee [] actual = (new BubbleSort()).sort(emps, Employee.NAME_COMP);  
		//then
		assertFalse(actual.length == employee.length);
	}
	
		//duplicated Object.
	@Test
	public void testSortObjectsDupicated(){
		//given
		emps[5] = new Employee("Xxxx", "Dave", 6, "ProjectManager", "1720101042301");
		empsSorted[8] = new Employee("Xxxx", "Dave", 6, "ProjectManager", "1720101042301");
		//when
		Employee [] actual = (new BubbleSort()).sort(emps, Employee.NAME_COMP); 
		//then
		assertArrayEquals(actual, empsSorted);
	}
}
