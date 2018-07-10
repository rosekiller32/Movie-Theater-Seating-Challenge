package main.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * The seat row class of the certain row in the room of the theater.
 * @author Han-Tse Chiou
 */
public class SeatRow {
	private String rowId;
	private List<Seat> seats;
	public SeatRow(String id) {
		this.rowId = id;
		this.seats = new ArrayList<Seat>();
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public String getRowId() {
		return rowId;
	}
}
