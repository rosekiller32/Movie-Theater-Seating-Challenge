package main.entity;

import java.util.Map;
import java.util.TreeMap;

/**
 * The class of the seat map in the room.
 * @author Han-Tse Chiou
 */
public class SeatMap {
	private Map<Integer, SeatRow> seatMap;
	private int totalRows;
	private int totalCols;
	private int avaiSeat;
	/**
	 * The constructor for the seat map.
	 * @param rows The row size of the seat map.
	 * @param cols The column size of the seat map.
	 */
	public SeatMap(int rows, int cols) {
		seatMap = new TreeMap<Integer, SeatRow>();
		for (int i = 0; i < rows; i++) {
			seatMap.put(i, new SeatRow((char) (i + 64) + ""));
		}
		totalRows = rows;
		totalCols = cols;
		avaiSeat = rows * cols;
	}
	/**
	 * Get the the seat at the certain row and column.
	 * @param row The row index of the seat.
	 * @param col The column index of the seat.
	 * @return The seat object
	 */
	public Seat getSeat(int row, int col) {
		return seatMap.get(row).getSeats().get(col);
	}
	/**
	 * Get number of row in the room.
	 * @return the total number of the row.
	 */
	public int getNumberOfRow() {
		return totalRows;
	}
	/**
	 * Get number of column in the room.
	 * @return the total number of the column
	 */
	public int getNumberOfCol() {
		return totalCols;
	}
	/**
	 * Get the certain row in the room.
	 * @param index the index of the row
	 * @return the SeatRow object
	 */
	public SeatRow getSeatRow(int index) {
		return seatMap.get(index);
	}
	/**
	 * Get the maximum capacity of the room.
	 * @return maximum capacity
	 */
	public int maxCapacity() {
		return totalRows * totalCols;
	}
	/**
	 * Get the available seat in the room.
	 * @return available number of seat
	 */
	public int avaiNumberOfSeats() {
		return avaiSeat;
	}
	/**
	 * Increase the available seats in the room by certain value.
	 * @param value the value be increased
	 */
	public void increaseAvaiSeat(int value) {
		if (value < 0) {
			throw new RuntimeException("Invalid input. Value must be greater than 0");
		}
		avaiSeat += value;
	}
	/**
	 * Decrease the available seats in the room by certain value.
	 * @param value the value be decreased
	 */
	private void decreaseAvaiSeat(int value) {
		if (value < 0) {
			throw new RuntimeException("Invalid input. Value must be greater than 0");
		}
		avaiSeat += value;
	}
	/**
	 * Occupy the certain Seat in the seat map.
	 * @param row the index of that row which will be occupied.
	 * @param seat the index of that col which will be occupied.
	 */
	public void occupySeat(int row, Seat seat) {
		decreaseAvaiSeat(1);
		seatMap.get(row).getSeats().add(seat);
	}
}
