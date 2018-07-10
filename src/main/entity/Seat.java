package main.entity;

public class Seat extends Entity<String> {
	private SeatType type;
	private String resId;

	public Seat(String seatId, String reservationId, SeatType seatType) {
		id = seatId;
		resId = reservationId;
		type = seatType;
	}

	public SeatType getType() {
		return type;
	}

	public void setType(SeatType type) {
		this.type = type;
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String reservationId) {
		resId = reservationId;
	}
}
