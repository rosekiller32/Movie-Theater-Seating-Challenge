/**
 * 
 */
package main.response;

import java.util.List;

import main.entity.Room;
import main.entity.Seat;
import main.entity.Theater;

/**
 * The booking response class.
 * @author HanTse Chiou
 */
public class BookingResponse implements IResponse<String> {
	private String responseId;
	private List<Seat> assignedSeats;
	private Theater theater;
	private Room room;
	public BookingResponse(String responseId, List<Seat> assignedSeats, Theater theater, Room room) {
		this.responseId = responseId;
		this.assignedSeats = assignedSeats;
		this.theater = theater;
		this.room = room;
	}
	public String getResponseId() {
		return responseId;
	}
	public List<Seat> getAssignedSeats() {
		return assignedSeats;
	}
	public Theater getTheater() {
		return theater;
	}
	public Room getRoom() {
		return room;
	}
}
