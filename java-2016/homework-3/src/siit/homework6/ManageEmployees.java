/**
 * 
 */
package siit.homework6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author SN
 * Implementation of sorting employee objects based on Role
 */
public class ManageEmployees {

	@SuppressWarnings("rawtypes")
	private Collection initialList = new ArrayList();
	private TreeSet managerSet = new TreeSet(new NameComp());
	private TreeSet pMSet = new TreeSet(new NameComp());
	private TreeSet seniorSet = new TreeSet(new NameComp());
	private TreeSet juniorSet = new TreeSet(new NameComp());

	/**
	 * 
	 * @param initialList (ArrayList)
	 * @return a TreeSet with managers
	 */
	public TreeSet generateMList(ArrayList initialList) {

		for (Object e : initialList) {
			if (((Employee) e).getRole() == "Manager") {
				managerSet.add(e);
			}
		}
		return managerSet;
	}

	/**
	 * 
	 * @param initialList (ArrayList)
	 * @return a TreeSet with project managers
	 */
	public TreeSet generatePMList(ArrayList initialList) {

		for (Object e : initialList) {
			if (((Employee) e).getRole() == "ProjectManager") {
				pMSet.add(e);
			}
		}
		return pMSet;
	}

	/**
	 * 
	 * @param initialList (ArrayList)
	 * @return a TreeSet with senior engineers
	 */
	public TreeSet generateSEList(ArrayList initialList) {

		for (Object e : initialList) {
			if (((Employee) e).getRole() == "SeniorEngineer") {
				seniorSet.add(e);
			}
		}
		return seniorSet;
	}

	/**
	 * 
	 * @param initialList (ArrayList)
	 * @return a TreeSet with junior engineers
	 */
	public TreeSet generateJEList(ArrayList initialList) {

		for (Object e : initialList) {
			if (((Employee) e).getRole() == "JuniorEngineer") {
				juniorSet.add(e);
			}
		}
		return juniorSet;
	}

}
