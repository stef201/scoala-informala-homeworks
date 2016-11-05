package siit.homework11;

public class Accomodation implements DB{

	private int id;
	private String type;
	private String bedType;
	private int maxGuests;
	private String description;

	public Accomodation(int id, String type, String bedType, int maxGuests, String description) {
		this.id = id;
		this.type = type;
		this.bedType = bedType;
		this.maxGuests = maxGuests;
		this.description = description;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the bedType
	 */
	public String getBedType() {
		return bedType;
	}

	/**
	 * @return the maxGuests
	 */
	public int getMaxGuests() {
		return maxGuests;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Accomodation [id=" + id + ", type=" + type + ", bedType=" + bedType + ", maxGuests=" + maxGuests
				+ ", description=" + description + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bedType == null) ? 0 : bedType.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + maxGuests;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Accomodation other = (Accomodation) obj;
		if (bedType == null) {
			if (other.bedType != null)
				return false;
		} else if (!bedType.equals(other.bedType))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (maxGuests != other.maxGuests)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
