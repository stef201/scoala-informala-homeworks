package siit.homework11;

public class AccomodationFairRelation implements DB{

	private int id;
	private int idAccomodation;
	private int idRoomFair;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the idAccomodation
	 */
	public int getIdAccomodation() {
		return idAccomodation;
	}

	/**
	 * @param idAccomodation the idAccomodation to set
	 */
	public void setIdAccomodation(Accomodation accomodation) {
		this.idAccomodation = accomodation.getId();
	}

	/**
	 * @return the idRoomFair
	 */
	public int getIdRoomFair() {
		return idRoomFair;
	}

	/**
	 * @param idRoomFair the idRoomFair to set
	 */
	public void setIdRoomFair(RoomFair room) {
		this.idRoomFair = room.getId();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idAccomodation;
		result = prime * result + idRoomFair;
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
		AccomodationFairRelation other = (AccomodationFairRelation) obj;
		if (id != other.id)
			return false;
		if (idAccomodation != other.idAccomodation)
			return false;
		if (idRoomFair != other.idRoomFair)
			return false;
		return true;
	}
	
}
