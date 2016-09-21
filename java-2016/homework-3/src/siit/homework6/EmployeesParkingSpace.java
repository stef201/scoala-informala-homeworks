/**
 * 
 */
package siit.homework6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author SN
 *	Implements operations on TreeSet's to determine the people that
 *	have/don't have parking spots, reported to a given number of free spaces(@param noOfParkingSpots)
 */
public class EmployeesParkingSpace {

	private ManageEmployees x = new ManageEmployees();
	private TreeSet pm = new TreeSet();
	private TreeSet m = new TreeSet();
	private TreeSet se = new TreeSet();
	private TreeSet je = new TreeSet();
	TreeSet empSorted = new TreeSet(new SeniorityComp());

	/**
	 * Method returns a TreeSet with the employees that have a parking spot based on 
	 * the years in the Company 
	 * @param initialList ArrayList from which to extract the employees
	 * @param noOfParkingSpots int 
	 * @return
	 */
	public TreeSet withParkingSpace(ArrayList initialList, int noOfParkingSpots) {
		TreeSet empWithParking = new TreeSet(new SeniorityComp());
		empSorted = addTreeSetAllRoleLists(initialList);
		initialList.clear();
		int i = 1;
		for (Iterator iterator = empSorted.iterator(); iterator.hasNext();) {
			Employee object = (Employee) iterator.next();
			if (i <= noOfParkingSpots) {
				System.out.println(object.toString());
				empWithParking.add(object);
			}
			i++;
		}
		return empWithParking;
	}
	
	/**
	 * Method returns a TreeSet with the employees that don't have a parking spot based on 
	 * the years in the Company 
	 * @param initialList ArrayList from which to extract the employees
	 * @param noOfParkingSpots int 
	 * @return
	 */
	public TreeSet noParkingSpace(ArrayList initialList, int noOfParkingSpots) {
		TreeSet empWithoutParking = new TreeSet(new SeniorityComp());
		empSorted = addTreeSetAllRoleLists(initialList);
		initialList.clear();
		int i = 1;
		for (Iterator iterator = empSorted.iterator(); iterator.hasNext();) {
			Employee object = (Employee) iterator.next();
			if (i > noOfParkingSpots) {
				System.out.println(object.toString());
				empWithoutParking.add(object);
			}
			i++;
		}
		return empWithoutParking; 
	}
	
	/**
	 * Generate TreeSet list of employee objects from the initial list(ArrayList)
	 * @param initialList ArrayList
	 * @return TreeSet with all employee objects
	 */
	protected TreeSet addTreeSetAllRoleLists(ArrayList initialList) {
		TreeSet pm = x.generatePMList(initialList);
		TreeSet m = x.generateMList(initialList);
		TreeSet se = x.generateSEList(initialList);
		TreeSet je = x.generateJEList(initialList);

		for (Object e : pm) {
			empSorted.add(e);
		}
		pm.clear();
		for (Object e : m) {
			empSorted.add(e);
		}
		m.clear();
		for (Object e : se) {
			empSorted.add(e);
		}
		se.clear();
		for (Object e : je) {
			empSorted.add(e);
		}
		je.clear();
		
		return empSorted;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empSorted == null) ? 0 : empSorted.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeesParkingSpace other = (EmployeesParkingSpace) obj;
		if (empSorted == null) {
			if (other.empSorted != null)
				return false;
		} else if (!empSorted.equals(other.empSorted))
			return false;
		return true;
	}

}
