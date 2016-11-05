package siit.homework11;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Please handle tests with care, because "@after" all records in the DB will be deleted 
 * @author stef
 *
 */
public class DBManipulationTests {

	@Before
	public void before() {
		DBManipulation db = new DBManipulation();
		Accomodation acc = new Accomodation(101, "ssingle", "old style", 2, "special bed as in ");
		RoomFair room = new RoomFair(102, 250, "all season");
		AccomodationFairRelation rel = new AccomodationFairRelation();
		rel.setId(103);
		rel.setIdAccomodation(acc);
		rel.setIdRoomFair(room);
		db.insertIntoDB(acc);
		db.insertIntoDB(room);
		db.insertIntoDB(rel);

	}

	@Test
	public void insertIntoDBTest1() throws SQLException {
		// given
		DBManipulation db = new DBManipulation();
		String query = "SELECT id, type, bed_type, max_guests, description FROM public.\"Accomodation\" WHERE id = 50;";
		Accomodation expected = new Accomodation(50, "ssingle", "old style", 2, "special bed as in ");
		// when
		db.insertIntoDB(expected);
		// then
		ResultSet rs = null;
		rs = db.connectAndSelectFromDBQuery(query);
		rs.next();
		Accomodation actual = new Accomodation(rs.getInt("id"), rs.getString("type"), rs.getString("bed_type"),
				rs.getInt("max_guests"), rs.getString("description"));

		assertEquals(expected, actual);
	}

	@Test
	public void insertIntoDBTest2() throws SQLException {
		// given
		DBManipulation db = new DBManipulation();
		String query = "SELECT id, value, season FROM public.room_fair WHERE id = 10;";
		RoomFair expected = new RoomFair(10, 265, "summer");
		// when
		db.insertIntoDB(expected);
		// then
		ResultSet rs = null;
		rs = db.connectAndSelectFromDBQuery(query);
		rs.next();
		RoomFair actual = new RoomFair(rs.getInt("id"), rs.getInt("value"), rs.getString("season"));

		assertEquals(expected, actual);
	}

	@Test
	public void insertIntoDBTest3() throws SQLException {
		// given
		DBManipulation db = new DBManipulation();
		String query = "SELECT*	FROM public.accomodation_fair_relation where id_accomodation = 20;";
		Accomodation accomodation = new Accomodation(20, "ssingle", "old style", 2, "special bed as in ");
		RoomFair room = new RoomFair(21, 265, "summer");
		db.insertIntoDB(accomodation);
		db.insertIntoDB(room);
		AccomodationFairRelation expected = new AccomodationFairRelation();
		expected.setId(22);
		expected.setIdAccomodation(accomodation);
		expected.setIdRoomFair(room);
		// when
		db.insertIntoDB(expected);
		// then
		ResultSet rs = null;
		rs = db.connectAndSelectFromDBQuery(query);
		rs.next();
		AccomodationFairRelation actual = new AccomodationFairRelation();
		actual.setId(rs.getInt("id"));
		actual.setIdAccomodation(accomodation);
		actual.setIdRoomFair(room);

		assertEquals(expected, actual);
	}

	@Test
	public void selectTest() throws SQLException {
		// given
		DBManipulation db = new DBManipulation();
		ResultSet rs = null;
		boolean hasNext;
		boolean rsNext = false;
		// when
		rs = db.selectAllRoomsAndPricePrint();
		// then
		try {
			while (hasNext = rs.next()) {
				if (hasNext) {
					rsNext = true;
				}
				System.out.println("Room: " + rs.getInt("id") + " price: " + rs.getInt("value") + " season: "
						+ rs.getString("season"));
			}
		} catch (SQLException e) {
			System.out.println("No records in db");
			e.printStackTrace();
		}
		assertTrue(rsNext);
	}

	@After
	public void after() {
		DBManipulation db = new DBManipulation();
		/*String query = "DELETE FROM public.accomodation_fair_relation;DELETE FROM public.\"Accomodation\";DELETE FROM public.room_fair;";
		db.connectAndInsertIntoDBUpdate(query);*/
		String[] query = new String[8];
		query[0] = "DELETE FROM public.accomodation_fair_relation WHERE id = 22;";
		query[1] = "DELETE FROM public.accomodation_fair_relation WHERE id = 103;";
		query[2] = "DELETE FROM public.\"Accomodation\" WHERE id = 101;";
		query[3] = "DELETE FROM public.\"Accomodation\" WHERE id = 50;";
		query[4] = "DELETE FROM public.\"Accomodation\" WHERE id = 20;";
		query[5] = "DELETE FROM public.room_fair WHERE id = 102;";
		query[6] = "DELETE FROM public.room_fair WHERE id = 10;";
		query[7] = "DELETE FROM public.room_fair WHERE id = 21;";
		for (int i = 0; i < query.length; i++) {
			db.connectAndInsertIntoDBUpdate(query[i]);
		}
	}
}
