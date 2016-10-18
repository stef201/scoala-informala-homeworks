package siit.homework9;

public class Employee {

	
	private String name;
	private JobPosition poz;
	//private String jobPosition;
	private int workedHours;
	private int daysOff;
	private int prepaidSales;
	private int postpaidSales;
	
	
	public Employee() {
	}
	
	public Employee(String name, JobPosition poz, int workedHours, int daysOff, int prepaidSales, int postpaidSales) {
		this.name = name;
		this.poz = poz;
		this.workedHours = workedHours;
		this.daysOff = daysOff;
		this.prepaidSales = prepaidSales;
		this.postpaidSales = postpaidSales;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the poz
	 */
	public JobPosition getPoz() {
		return poz;
	}
	/**
	 * @param poz the poz to set
	 */
	public void setPoz(JobPosition poz) {
		this.poz = poz;
	}
	/**
	 * @return the workedHours
	 */
	public int getWorkedHours() {
		return workedHours;
	}
	/**
	 * @param workedHours the workedHours to set
	 */
	public void setWorkedHours(int workedHours) {
		this.workedHours = workedHours;
	}
	/**
	 * @return the daysOff
	 */
	public int getDaysOff() {
		return daysOff;
	}
	/**
	 * @param daysOff the daysOff to set
	 */
	public void setDaysOff(int daysOff) {
		this.daysOff = daysOff;
	}
	/**
	 * @return the prepaidSales
	 */
	public int getPrepaidSales() {
		return prepaidSales;
	}
	/**
	 * @param prepaidSales the prepaidSales to set
	 */
	public void setPrepaidSales(int prepaidSales) {
		this.prepaidSales = prepaidSales;
	}
	/**
	 * @return the postpaidSales
	 */
	public int getPostpaidSales() {
		return postpaidSales;
	}
	/**
	 * @param postpaidSales the postpaidSales to set
	 */
	public void setPostpaidSales(int postpaidSales) {
		this.postpaidSales = postpaidSales;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [name=" + name + ", poz=" + poz.name() + ", workedHours=" + workedHours + ", daysOff=" + daysOff
				+ ", prepaidSales=" + prepaidSales + ", postpaidSales=" + postpaidSales + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + daysOff;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + postpaidSales;
		result = prime * result + ((poz == null) ? 0 : poz.hashCode());
		result = prime * result + prepaidSales;
		result = prime * result + workedHours;
		return result;
	}
	/* (non-Javadoc)
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
		if (daysOff != other.daysOff)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (postpaidSales != other.postpaidSales)
			return false;
		if (poz != other.poz)
			return false;
		if (prepaidSales != other.prepaidSales)
			return false;
		if (workedHours != other.workedHours)
			return false;
		return true;
	}


	
}
