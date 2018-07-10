package main.entity;

/**
 * The room class for different in the movie theater.
 * @author Han-Tse Chiou
 */
public class Room extends Entity<String> {
	private String name;
	private RoomType type;
	private SeatMap seatMap;

	public Room(String id, RoomType RoomType, int rows, int cols) {
		this.id = id;
		type = RoomType;
		this.seatMap = new SeatMap(rows, cols);
	}
	
	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public SeatMap getSeatMap() {
		return seatMap;
	}
}
