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
 * @author SN
 *
 */
public class ManageEmployeeTest {

	@Test
	public void testGenerateManagerListNoManager(){
		//given
		ManageEmployees x = new ManageEmployees();
		ArrayList initialList = new ArrayList();
		Employee e = new Employee("Alexa", "Alexandra", 1, "JuniorEngineer", "2901105216398");
		initialList.add(e);
		//when
		TreeSet m = x.generateMList(initialList);
		//then
		Assert.assertEquals(0, m.size());
	}
	
	@Test
	public void testGenerateManagerListWithManager(){
		//given
		ManageEmployees x = new ManageEmployees();
		ArrayList initialList = new ArrayList();
		Employee e = new Employee("Alexa", "Alexandra", 1, "Manager", "2901105216398");
		initialList.add(e);
		//when
		TreeSet m = x.generateMList(initialList);
		//then
		Assert.assertEquals(1, m.size());
	}
	
	@Test
	public void testGenerateManagerListOkDuplicatEmployee(){
		//given
		ManageEmployees x = new ManageEmployees();
		ArrayList initialList = new ArrayList();
		Employee e = new Employee("Alexa", "Alexandra", 1, "Manager", "2901105216398");
		initialList.add(e);
		initialList.add(e);
		//when
		TreeSet m = x.generateMList(initialList);
		//then
		Assert.assertEquals(1, m.size());
	}
	
	@Test
	public void testGeneratePMListNoProjectManager(){
		//given
		ManageEmployees x = new ManageEmployees();
		ArrayList initialList = new ArrayList();
		Employee e = new Employee("Alexa", "Alexandra", 1, "JuniorEngineer", "2901105216398");
		initialList.add(e);
		//when
		TreeSet m = x.generatePMList(initialList);
		//then
		Assert.assertEquals(0, m.size());
	}
	
	@Test
	public void testGeneratePMListWithProjectManager(){
		//given
		ManageEmployees x = new ManageEmployees();
		ArrayList initialList = new ArrayList();
		Employee e = new Employee("Alexa", "Alexandra", 1, "ProjectManager", "2901105216398");
		initialList.add(e);
		//when
		TreeSet m = x.generatePMList(initialList);
		//then
		Assert.assertEquals(1, m.size());
	}
	
	@Test
	public void testGeneratePMListOkDuplicatPM(){
		//given
		ManageEmployees x = new ManageEmployees();
		ArrayList initialList = new ArrayList();
		Employee e = new Employee("Alexa", "Alexandra", 1, "ProjectManager", "2901105216398");
		initialList.add(e);
		initialList.add(e);
		//when
		TreeSet m = x.generatePMList(initialList);
		//then
		Assert.assertEquals(1, m.size());
	}
	
	@Test
	public void testGenerateSEListNoSeniorEng(){
		//given
		ManageEmployees x = new ManageEmployees();
		ArrayList initialList = new ArrayList();
		Employee e = new Employee("Alexa", "Alexandra", 1, "JuniorEngineer", "2901105216398");
		initialList.add(e);
		//when
		TreeSet m = x.generateSEList(initialList);
		//then
		Assert.assertEquals(0, m.size());
	}
	
	@Test
	public void testGenerateSEListWithSeniorEng(){
		//given
		ManageEmployees x = new ManageEmployees();
		ArrayList initialList = new ArrayList();
		Employee e = new Employee("Alexa", "Alexandra", 1, "SeniorEngineer", "2901105216398");
		initialList.add(e);
		//when
		TreeSet m = x.generateSEList(initialList);
		//then
		Assert.assertEquals(1, m.size());
	}
	
	@Test
	public void testGenerateSEListOkDuplicatSeniorEng(){
		//given
		ManageEmployees x = new ManageEmployees();
		ArrayList initialList = new ArrayList();
		Employee e = new Employee("Alexa", "Alexandra", 1, "SeniorEngineer", "2901105216398");
		initialList.add(e);
		initialList.add(e);
		//when
		TreeSet m = x.generateSEList(initialList);
		//then
		Assert.assertEquals(1, m.size());
	}
	
	@Test
	public void testGenerateJEListNoJuniorEng(){
		//given
		ManageEmployees x = new ManageEmployees();
		ArrayList initialList = new ArrayList();
		Employee e = new Employee("Alexa", "Alexandra", 1, "JuniorXngineer", "2901105216398");
		initialList.add(e);
		//when
		TreeSet m = x.generateJEList(initialList);
		//then
		Assert.assertEquals(0, m.size());
	}
	
	@Test
	public void testGenerateJEListWithJuniorEng(){
		//given
		ManageEmployees x = new ManageEmployees();
		ArrayList initialList = new ArrayList();
		Employee e = new Employee("Alexa", "Alexandra", 1, "JuniorEngineer", "2901105216398");
		initialList.add(e);
		//when
		TreeSet m = x.generateJEList(initialList);
		//then
		Assert.assertEquals(1, m.size());
	}
	
	@Test
	public void testGenerateJEListOkDuplicatJuniorEng(){
		//given
		ManageEmployees x = new ManageEmployees();
		ArrayList initialList = new ArrayList();
		Employee e = new Employee("Alexa", "Alexandra", 1, "JuniorEngineer", "2901105216398");
		initialList.add(e);
		initialList.add(e);
		//when
		TreeSet m = x.generateJEList(initialList);
		//then
		Assert.assertEquals(1, m.size());
	}
}
