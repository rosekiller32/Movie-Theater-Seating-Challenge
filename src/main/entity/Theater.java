package main.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * The theater class for the reservation system
 * @author Han-Tse Chiou
 */
public class Theater extends Entity<String> {
	private String name;
	private Map<String, Room> rooms;

	public Theater(String id, String name) {
		this.id = id;
		this.name = name;
		this.rooms = new HashMap<String, Room>();
	}

	public String getName() {
		return name;
	}

	public void addRoom(Room room) {
		rooms.put(room.id, room);
	}

	public Room getRoom(String roomId) {
		return rooms.get(roomId);
	}

}
