/**
 * 
 */
package siit.homework6;

/**
 * @author SN
 *	Implementation of employee class
 */
public class Employee {

	private String lastName;
	private String firstName;
	private int yearsInTheCompany; 
	private String role;
	private String cnp;
	/**
	 * Constructor
	 * @param lastName
	 * @param firstName
	 * @param yearsInTheCompany
	 * @param role
	 * @param cnp
	 */
	public Employee(String lastName, String firstName, int yearsInTheCompany, String role, String cnp) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.yearsInTheCompany = yearsInTheCompany;
		this.role = role;
		this.cnp = cnp;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the yearsInTheCompany
	 */
	public int getYearsInTheCompany() {
		return yearsInTheCompany;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the CNP
	 */
	public String getCnp() {
		return cnp;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [lastName=" + lastName + ", firstName=" + firstName + ", yearsInTheCompany="
				+ yearsInTheCompany + ", role=" + role + ", cnp=" + cnp + "]";
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
		result = prime * result + ((cnp == null) ? 0 : cnp.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + yearsInTheCompany;
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
		Employee other = (Employee) obj;
		if (cnp == null) {
			if (other.cnp != null)
				return false;
		} else if (!cnp.equals(other.cnp))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (yearsInTheCompany != other.yearsInTheCompany)
			return false;
		return true;
	}

}
