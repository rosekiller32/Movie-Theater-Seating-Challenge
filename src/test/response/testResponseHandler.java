/**
 * 
 */
package test.response;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.reservationDataBase;
import main.entity.Seat;
import main.entity.SeatType;
import main.entity.Theater;
import main.response.BookingResponse;
import main.response.BookingResponseHandler;

/**
 * @author Han-Tse Chiou
 *
 */
public class testResponseHandler {

	@Test
	public void responseHandlerTester() {
		reservationDataBase.initializeTheater(12, 20);
		Theater theater = reservationDataBase.THEATER_MAP.get("1");
		List<Seat> seats = new ArrayList<>();
		seats.add(new Seat("G1","R001", SeatType.RELAX));
		seats.add(new Seat("G2","R001", SeatType.RELAX));
		seats.add(new Seat("G3","R001", SeatType.RELAX));
		BookingResponse response = new BookingResponse("R001", seats, theater, theater.getRoom("1"));
		BookingResponseHandler resonseHandler = new BookingResponseHandler();
		assertEquals("R001 G1, G2, G3", resonseHandler.processResponse(response));
	}

}
