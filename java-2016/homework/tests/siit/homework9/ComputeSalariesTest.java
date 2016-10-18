package siit.homework9;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.*;
import org.junit.Test;



public class ComputeSalariesTest {

	@Test
	public void testSplitLineToString() {
		// given
		ComputeSalaries compute = new ComputeSalaries();
		String str = "Name|Age";
		String[] expected = new String[]{"Name", "Age"};
		// when
		String[] sorted = compute.splitLineToString(str); 
		// then
		assertArrayEquals(expected, sorted);
	}
	
	@Test
	public void testSplitLineToString1() {
		// given
		ComputeSalaries compute = new ComputeSalaries();
		String str = "Name|";
		String[] expected = new String[]{"Name", "0"};
		// when
		String[] sorted = compute.splitLineToString(str); 
		// then
		assertArrayEquals(expected, sorted);
	}
	
	@Test
	public void testSplitLineToString2() {
		// given
		ComputeSalaries compute = new ComputeSalaries();
		String str = " |";
		String[] expected = new String[]{" ", "0"};
		// when
		String[] sorted = compute.splitLineToString(str); 
		// then
		assertArrayEquals(expected, sorted);
	}
	
	@Test
	public void testCalculateSalary() {
		// given
		ComputeSalaries compute = new ComputeSalaries();
		int i = 0;
		Employee emp = new Employee("Jennifer Lawrence",JobPosition.MANAGER, i, i, i, i);
		int expected = 0;
		// when
		int actual = compute.calculateSalary(emp);
		// then
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateSalary2() {
		// given
		ComputeSalaries compute = new ComputeSalaries();
		int i = 0;
		int x=1;
		Employee emp = new Employee("Jennifer Lawrence",JobPosition.MANAGER, x, i, i, i);
		int expected = 40;
		// when
		int actual = compute.calculateSalary(emp);
		// then
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateSalary3() {
		// given
		ComputeSalaries compute = new ComputeSalaries();
		int i = 0;
		int x=1;
		Employee emp = new Employee("Jennifer Lawrence",JobPosition.MANAGER, i, x, i, i);
		int expected = 320;
		// when
		int actual = compute.calculateSalary(emp);
		// then
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateSalary4() {
		// given
		ComputeSalaries compute = new ComputeSalaries();
		int i = 0;
		int x=1;
		Employee emp = new Employee("Jennifer Lawrence",JobPosition.MANAGER, i, i, x, i);
		int expected = 15;
		// when
		int actual = compute.calculateSalary(emp);
		// then
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateSalary5() {
		// given
		ComputeSalaries compute = new ComputeSalaries();
		int i = 0;
		int x=1;
		Employee emp = new Employee("Jennifer Lawrence",JobPosition.MANAGER, i, i, i, x);
		int expected = 30;
		// when
		int actual = compute.calculateSalary(emp);
		// then
		assertEquals(expected, actual);
	}
}
