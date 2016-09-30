package siit.homework7;
/*
 * @author SN
 */
import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.HashSet;
import org.junit.Test;

public class OperationStudentTest {

	/*
	 * tests for AddStudent
	 */
	// name
	@Test
	public void testAddStudentCheck()
			throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		// when
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "f", "2781205080085");
		// then
		assertEquals(1, test.size());
	}

	@Test
	public void testAddStudentCheck2()
			throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		Student stud = new Student("Marin", "ANA", "05 12 1978", "f", "2781205080085");
		// when
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "f", "2781205080085");
		// then
		assertTrue(test.contains(stud));
	}

	@Test
	public void testAddStudentCheck3NoDuplicates()
			throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		// when
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "f", "2781205080085");
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "f", "2781205080085");
		// then
		assertEquals(1, test.size());
	}

	@Test(expected = StudentUnknownNameException.class)
	public void testAddStudentWithoutFirstName()
			throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		// when
		test = op.addStudent(test, "", "ANA", "05 12 1978", "f", "2781205080085");
		// then -> Exception
	}

	@Test(expected = StudentUnknownNameException.class)
	public void testAddStudentWithoutLastName()
			throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		// when
		test = op.addStudent(test, "Marin", "", "05 12 1978", "f", "2781205080085");
		// then -> Exception
	}

	// birth date
	@Test(expected = IllegalArgumentException.class)
	public void testBirthDate() throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		// when
		test = op.addStudent(test, "Marin", "ANA", "abc", "f", "2781205080085");
		// then

	}

	@Test(expected = WrongBirthYearException.class)
	public void testBirthDate1() throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		// when
		test = op.addStudent(test, "Marin", "ANA", "05 12 1878", "f", "2781205080085");
		// then

	}

	@Test(expected = WrongBirthYearException.class)
	public void testBirthDate2() throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		// when
		test = op.addStudent(test, "Marin", "ANA", "05 12 2005", "f", "2781205080085");
		// then

	}

	@Test(expected = IllegalArgumentException.class)
	public void testBirthDate3WrongDayMonth()
			throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		// when
		test = op.addStudent(test, "Marin", "ANA", "55 42 1978", "f", "2781205080085");
		// then

	}

	// Gender
	@Test
	public void testGenderCheck1F()
			throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		Student stud = new Student("Marin", "ANA", "05 12 1978", "f", "2781205080085");
		// when
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "F", "2781205080085");
		// then
		assertTrue(test.contains(stud));
	}

	public void testGenderCheck1M()
			throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		Student stud = new Student("Marin", "ANA", "05 12 1978", "m", "2781205080085");
		// when
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "M", "2781205080085");
		// then
		assertTrue(test.contains(stud));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGenderCheck2()
			throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		// when
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "ff", "2781205080085");
		// then
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGenderCheck3()
			throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		// when
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "Fm", "2781205080085");
		// then
	}

	// CNP / ID
	@Test(expected = IllegalArgumentException.class)
	public void testCNPCheck1Null()
			throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		// when
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "m", "");
		// then
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCNPCheck1() throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		// when
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "mF", "2781205080085");
		// then
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCNPCheck2() throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		// when
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "F", "1781205080085");
		// then
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCNPCheck3() throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		// when
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "F", "22781205080085");
		// then
	}

	/*
	 * tests for deleteStudent
	 */
	@Test
	public void testDeleteCheck1() throws StudentNonExistentException, IllegalArgumentException,
			WrongBirthYearException, StudentUnknownNameException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "f", "2781205080085");
		// when
		test = op.deleteStudent(test, "2781205080085");
		// then
		assertTrue(test.isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeleteCheck2() throws IllegalArgumentException, WrongBirthYearException,
			StudentUnknownNameException, StudentNonExistentException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "f", "2781205080085");
		// when
		test = op.deleteStudent(test, "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeleteCheck3() throws IllegalArgumentException, WrongBirthYearException,
			StudentUnknownNameException, StudentNonExistentException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "f", "2781205080085");
		// when
		test = op.deleteStudent(test, "2781205");
	}

	@Test(expected = StudentNonExistentException.class)
	public void testDeleteCheck4() throws IllegalArgumentException, WrongBirthYearException,
			StudentUnknownNameException, StudentNonExistentException {
		// given
		HashSet<Student> test = new HashSet<>();
		OperationStudent op = new OperationStudent();
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "f", "2781205080085");
		// when
		test = op.deleteStudent(test, "1711205090080");
	}

	// retriveStudentsAgeX
	@Test
	public void testRetriveStudentsAgeX()
			throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException, ParseException {
		// given
		HashSet<Student> test = new HashSet<>();
		HashSet<Student> test2 = new HashSet<>();
		OperationStudent op = new OperationStudent();
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "f", "2781205080085");
		test = op.addStudent(test, "Ana-Maria", "Iordan", "05 07 1988", "f", "2880705341203");
		test = op.addStudent(test, "Ana", "Oanca", "05 07 1988", "f", "2880705349103");
		// when
		test2 = op.retriveStudentsAgeX(test, 28);
		// then
		assertEquals(2, test2.size());
	}
	
	@Test
	public void testRetriveStudentsAgeX1()
			throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException, ParseException {
		// given
		HashSet<Student> test = new HashSet<>();
		HashSet<Student> test2 = new HashSet<>();
		OperationStudent op = new OperationStudent();
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "f", "2781205080085");
		test = op.addStudent(test, "Ela"  , "Mana", "31 12 1987", "f", "2871231349109");
		test = op.addStudent(test, "Ana"  , "Oanca", "05 07 1988", "f", "2880705349103");
		// when
		test2 = op.retriveStudentsAgeX(test, 28);
		// then
		assertEquals(2, test2.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRetriveStudentsAgeX9()
			throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException, ParseException {
		// given
		HashSet<Student> test = new HashSet<>();
		HashSet<Student> test2 = new HashSet<>();
		OperationStudent op = new OperationStudent();
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "f", "2781205080085");
		// when
		test2 = op.retriveStudentsAgeX(test, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRetriveStudentsAgeX10()
			throws IllegalArgumentException, WrongBirthYearException, StudentUnknownNameException, ParseException {
		// given
		HashSet<Student> test = new HashSet<>();
		HashSet<Student> test2 = new HashSet<>();
		OperationStudent op = new OperationStudent();
		test = op.addStudent(test, "Marin", "ANA", "05 12 1978", "f", "2781205080085");
		// when
		test2 = op.retriveStudentsAgeX(test, 101);
	}
}
