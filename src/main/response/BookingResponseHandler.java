package main.response;

import main.entity.SeatMap;

/**
 * The booking response handler class.
 * @author Han-Tse Chiou
 */
public class BookingResponseHandler extends ResponseHandler<String, BookingResponse> {
	@Override
	public String processResponse(BookingResponse response) {
		if (response.getAssignedSeats() == null) {
			SeatMap map = response.getRoom().getSeatMap();
			return "No Extra seats! We only have " + map.avaiNumberOfSeats() + " seats.";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(response.getResponseId() + " ");
		for (int i = 0; i < response.getAssignedSeats().size(); i++) {
			sb.append(response.getAssignedSeats().get(i).getId());
			if (i < response.getAssignedSeats().size() - 1) { 
				sb.append(", ");
			}
		}
		return sb.toString();
	}
}
