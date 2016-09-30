/**
 * 
 */
package siit.homework7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * The Class Student.
 */
public class Student {

	private String firstName;
	private String lastName;
	private String dateBirth;
	private String gender;
	private String cnp;

	/**
	 * Instantiates a new student.
	 *
	 * @param firstName
	 *            the first name
	 * @param lastName
	 *            the last name
	 * @param dateBirth
	 *            the date birth
	 * @param gender
	 *            the gender
	 * @param cnp
	 *            the cnp
	 */
	public Student(String firstName, String lastName, String dateBirth, String gender, String cnp) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.gender = gender;
		this.cnp = cnp;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Sets the date birth.
	 *
	 * @param dateBirth
	 *            the new date birth
	 */
	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender
	 *            the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Sets the cnp.
	 *
	 * @param cnp
	 *            the new cnp
	 */
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Gets the date birth.
	 *
	 * @return the date birth
	 */
	public String getDateBirth() {
		return dateBirth;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Gets the cnp.
	 *
	 * @return the cnp
	 */
	public String getCnp() {
		return cnp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [ lastName=" + lastName + ", firstName=" + firstName + ", dateBirth=" + dateBirth + ", gender="
				+ gender + ", cnp=" + cnp + "]";
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
		Student other = (Student) obj;
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
		return true;
	}

}
