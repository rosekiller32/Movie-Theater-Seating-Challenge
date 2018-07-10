package main.allocator;

import java.util.List;

import main.entity.Seat;
import main.entity.SeatMap;
import main.request.BookingRequest;

/**
 * The interface for the allocator.
 * @author Han-Tse Chiou
 */
public interface ISeatAllocator {
	public List<Seat> allocate(SeatMap seatMap, BookingRequest req);
}
