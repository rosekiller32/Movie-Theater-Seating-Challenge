/**
 * 
 */
package main.request;

import java.util.List;

import main.reservationDataBase;
import main.allocator.GroupAllocator;
import main.entity.Room;
import main.entity.Seat;
import main.entity.Theater;
import main.response.BookingResponse;

/**
 * The booking request handler class.
 * @author HanTse Chiou
 */
public class BookingRequestHandler extends RequestHandler<BookingRequest, BookingResponse>{
	private GroupAllocator seatAllocator = new GroupAllocator();
	@Override
	public BookingResponse processResquest(BookingRequest request) {
		Theater theater = reservationDataBase.THEATER_MAP.get(request.getTheaterId());
	    Room room = theater.getRoom(request.getRoomId());
	    List<Seat> reservedSeats = seatAllocator.allocate(room.getSeatMap(), request);
	    return new BookingResponse(request.getRequestId(), reservedSeats, theater, room);
	}

}
