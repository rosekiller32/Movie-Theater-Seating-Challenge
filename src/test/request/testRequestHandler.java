package test.request;

import static org.junit.Assert.*;

import org.junit.Test;

import main.reservationDataBase;
import main.request.BookingRequest;
import main.request.BookingRequestHandler;
import main.response.BookingResponse;

public class testRequestHandler {

	@Test
	public void requestHandlerTester() {
		reservationDataBase.initializeTheater(12, 20);
	    BookingRequestHandler req = new BookingRequestHandler();
	    BookingResponse response = req.processResquest(new BookingRequest("R001", 5, "1", "1"));
	    assertEquals("R001", response.getResponseId());
	    assertEquals("1", response.getRoom().getId());
	    assertEquals("1", response.getTheater().getId());
	    assertEquals(5, response.getAssignedSeats().size());
	    assertEquals("G1", response.getAssignedSeats().get(0).getId());
	    assertEquals("R001", response.getAssignedSeats().get(0).getResId());
	    assertEquals("G2", response.getAssignedSeats().get(1).getId());
	    assertEquals("R001",response.getAssignedSeats().get(1).getResId());
	    assertEquals("G3", response.getAssignedSeats().get(2).getId());
	    assertEquals("R001", response.getAssignedSeats().get(2).getResId());
	    assertEquals("G4", response.getAssignedSeats().get(3).getId());
	    assertEquals("R001", response.getAssignedSeats().get(3).getResId());
	    assertEquals("G5", response.getAssignedSeats().get(4).getId());
	    assertEquals("R001", response.getAssignedSeats().get(4).getResId());
	}

}
