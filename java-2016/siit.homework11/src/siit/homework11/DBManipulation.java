package siit.homework11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManipulation {

	public void insertIntoDB(Accomodation accomod) {
		String sqlQuery = new StringBuilder()
				.append("INSERT INTO public.\"Accomodation\"(id, type, bed_type, max_guests, description) VALUES (")
				.append(accomod.getId()).append(",'").append(accomod.getType()).append("','")
				.append(accomod.getBedType()).append("',").append(accomod.getMaxGuests()).append(",'")
				.append(accomod.getDescription()).append("');").toString();
		connectAndInsertIntoDBUpdate(sqlQuery);
	}

	public void insertIntoDB(RoomFair room) {
		String sqlQuery = new StringBuilder().append("INSERT INTO public.room_fair(id, value, season)	VALUES (")
				.append(room.getId()).append(",").append(room.getValue()).append(",'").append(room.getSeason())
				.append("');").toString();
		connectAndInsertIntoDBUpdate(sqlQuery);
	}

	public void insertIntoDB(AccomodationFairRelation relation) {
		String sqlQuery = new StringBuilder()
				.append("INSERT INTO public.accomodation_fair_relation(id, id_accomodation, id_room_fair) VALUES (")
				.append(relation.getId()).append(",").append(relation.getIdAccomodation()).append(",")
				.append(relation.getIdRoomFair()).append(");").toString();
		connectAndInsertIntoDBUpdate(sqlQuery);
	}

	public ResultSet selectAllRoomsAndPricePrint() {
		String sqlQuery = "SELECT  a.id, a.type, a.bed_type, a.max_guests, a.description, "
				+ "r.id, r.value, r.season, " 
				+ "afr.id, afr.id_accomodation, afr.id_room_fair " 
				+ "FROM public.\"Accomodation\" AS a "
				+ "LEFT JOIN public.accomodation_fair_relation AS afr " 
				+ "ON a.id = afr.id_accomodation "
				+ "INNER JOIN public.room_fair AS r " 
				+ "on r.id = afr.id_room_fair "
				+ "ORDER BY a.id;";
		ResultSet rs = connectAndSelectFromDBQuery(sqlQuery);

		return rs;
	}

	protected Connection connect(String type, String host, int port, String dbName, String user, String pw) {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		DriverManager.setLoginTimeout(60);
		String url = new StringBuilder().append("jdbc:").append(type).append("://").append(host).append(":")
				.append(port).append("/").append(dbName).append("?user=").append(user).append("&password=").append(pw)
				.toString();
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.err.println("Cannnot connect to DB: " + e.getMessage());
		}
		return conn;
	}

	/**
	 * executeUpdate() - insert into DB
	 * 
	 * @param sqlQueryy
	 */
	protected void connectAndInsertIntoDBUpdate(String sqlQuery) {
		PreparedStatement ps = null;
		try (Connection conn = connect("postgresql", "localhost", 5432, "Booking", "postgres", "graf559360")) {
			ps = conn.prepareStatement(sqlQuery);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * executeQuery() - select from DB
	 * 
	 * @param sqlQueryy
	 * @return
	 */
	protected ResultSet connectAndSelectFromDBQuery(String sqlQuery) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = connect("postgresql", "localhost", 5432, "Booking", "postgres", "graf559360")) {
			ps = conn.prepareStatement(sqlQuery);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
