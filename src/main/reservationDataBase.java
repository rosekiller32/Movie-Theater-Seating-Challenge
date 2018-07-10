/**
 * 
 */
package main;

import java.util.HashMap;
import java.util.Map;

import main.entity.Room;
import main.entity.RoomType;
import main.entity.Theater;

/**
 * The reservation database to take record of the reservation
 * @author Han-Tse Chiou
 */

public class reservationDataBase {
	private static final String ROOM_ID = "1";
	private static final RoomType ROOM_TYPE = RoomType.IMAX;
	private static final String THEATER_ID = "1";
	private static final String THEATER_NAME = "Taiwan Number One Cinnema";
	public static Map<String, Theater> THEATER_MAP = new HashMap<String, Theater>();

	/**
	 * Initialize the theater with the certain number of rows and cols.
	 * @param rows The number of rows in the theater
	 * @param cols The number of cols in the theater
	 */
	public static void initializeTheater(int rows, int cols) {
		Room room = new Room(ROOM_ID, ROOM_TYPE, rows, cols);
		Theater theater = new Theater(THEATER_ID, THEATER_NAME);
		theater.addRoom(room);
		THEATER_MAP.put(THEATER_ID, theater);
	}
}
