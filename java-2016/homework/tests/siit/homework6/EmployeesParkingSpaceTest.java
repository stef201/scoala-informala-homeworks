/**
 * 
 */
package siit.homework6;

import java.util.ArrayList;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author SN
 *
 */
public class EmployeesParkingSpaceTest {
	
	@Test
	public void testAddTreeSetAllRoleLists(){
		//given
		EmployeesParkingSpace test = new EmployeesParkingSpace();
		TreeSet empSorted = new TreeSet(new SeniorityComp());
		ArrayList initialList = new ArrayList();
		Employee e6 = new Employee("Zagan", "Eugen", 3, "ProjectManager", "1860101046308");
		Employee e7 = new Employee("Oanca", "Ana", 3, "Manager", "2880705349103");
		Employee e8 = new Employee("Umrea", "Any", 7, "SeniorEngineer", "2810701044532");
		Employee e9 = new Employee("Aaron", "Emil", 6, "JuniorEngineer", "1850523046305");
		TreeSet pm = new TreeSet();
		initialList.add(e6);
		initialList.add(e7);
		initialList.add(e8);
		initialList.add(e9);
		//when
		empSorted = test.addTreeSetAllRoleLists(initialList);
		//then
		Assert.assertEquals(4, empSorted.size());
	}
	
	@Test
	public void testFailRoleAddTreeSetAllRoleLists(){
		//given
		EmployeesParkingSpace test = new EmployeesParkingSpace();
		TreeSet empSorted = new TreeSet(new SeniorityComp());
		ArrayList initialList = new ArrayList();
		Employee e6 = new Employee("Zagan", "Eugen", 3, "Junior", "1860101046308");
		Employee e7 = new Employee("Oanca", "Ana", 3, "Junior", "2880705349103");
		Employee e8 = new Employee("Umrea", "Any", 7, "Junior", "2810701044532");
		Employee e9 = new Employee("Aaron", "Emil", 6, "Junior", "1850523046305");
		TreeSet pm = new TreeSet();
		initialList.add(e6);
		initialList.add(e7);
		initialList.add(e8);
		initialList.add(e9);
		//when
		empSorted = test.addTreeSetAllRoleLists(initialList);
		//then
		Assert.assertTrue(empSorted.isEmpty());
	}

	@Test
	public void testWithParkingSpace(){
		//given
		ArrayList initialList = new ArrayList();
		Employee e8 = new Employee("Umrea", "Any", 7, "Manager", "2810701044532");
		initialList.add(e8);
		EmployeesParkingSpace test = new EmployeesParkingSpace();
		TreeSet parking = new TreeSet(new SeniorityComp());
		//when
		parking = test.withParkingSpace(initialList, 1);
		//then
		Assert.assertEquals(1, parking.size());
	}
	
	@Test
	public void testWithParkingSpaceFail(){
		//given
		
		ArrayList initialList = new ArrayList();
		Employee e8 = new Employee("Umrea", "Any", 7, "Manager", "2810701044532");
		Employee e1 = new Employee("Umrsea", "Asny", 7, "Manager", "2830701044532");
		initialList.add(e8);
		initialList.add(e1);
		EmployeesParkingSpace test = new EmployeesParkingSpace();
		TreeSet parking = new TreeSet(new SeniorityComp());
		//when
		parking = test.withParkingSpace(initialList, 1);
		//then
		Assert.assertFalse(parking.isEmpty());
	}
	
	@Test
	public void testWithParkingSpaceFail2(){
		//given
		
		ArrayList initialList = new ArrayList();
		Employee e8 = new Employee("Umrea", "Any", 7, "Manager", "2810701044532");
		Employee e1 = new Employee("Umrsea", "Asny", 7, "Manager", "2830701044532");
		initialList.add(e8);
		initialList.add(e1);
		EmployeesParkingSpace test = new EmployeesParkingSpace();
		TreeSet parking = new TreeSet(new SeniorityComp());
		//when
		parking = test.withParkingSpace(initialList, 0);
		//then
		Assert.assertTrue(parking.isEmpty());
	}
	
	@Test
	public void testWithoutParkingSpace(){
		//given
		ArrayList initialList = new ArrayList();
		Employee e8 = new Employee("Umrea", "Any", 7, "Manager", "2810701044532");
		initialList.add(e8);
		EmployeesParkingSpace test = new EmployeesParkingSpace();
		TreeSet parking = new TreeSet(new SeniorityComp());
		//when
		parking = test.noParkingSpace(initialList, 0);
		//then
		Assert.assertEquals(1, parking.size());
	}
	
	@Test
	public void testWithoutParkingSpaceFail(){
		//given
		
		ArrayList initialList = new ArrayList();
		Employee e8 = new Employee("Umrea", "Any", 7, "Manager", "2810701044532");
		Employee e1 = new Employee("Umrsea", "Asny", 7, "Manager", "2830701044532");
		initialList.add(e8);
		initialList.add(e1);
		EmployeesParkingSpace test = new EmployeesParkingSpace();
		TreeSet parking = new TreeSet(new SeniorityComp());
		//when
		parking = test.noParkingSpace(initialList, 1);
		//then
		Assert.assertFalse(parking.isEmpty());
	}
	
	@Test
	public void testWithoutParkingSpaceFail2(){
		//given
		
		ArrayList initialList = new ArrayList();
		Employee e8 = new Employee("Umrea", "Any", 7, "Manager", "2810701044532");
		Employee e1 = new Employee("Umrsea", "Asny", 7, "Manager", "2830701044532");
		initialList.add(e8);
		initialList.add(e1);
		EmployeesParkingSpace test = new EmployeesParkingSpace();
		TreeSet parking = new TreeSet(new SeniorityComp());
		//when
		parking = test.noParkingSpace(initialList, 0);
		//then
		Assert.assertFalse(parking.isEmpty());
	}
}
