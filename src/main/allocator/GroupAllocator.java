/**
 * 
 */
package main.allocator;

import java.util.ArrayList;
import java.util.List;

import main.entity.Seat;
import main.entity.SeatMap;
import main.entity.SeatRow;
import main.request.BookingRequest;

/**
 * The allocator class to allocate the seat.
 * @author HanTse Chiou
 */
public class GroupAllocator implements ISeatAllocator{
	/* The allocate algorithm to allocate the seat.
	 * @see main.allocator.ISeatAllocator#allocate(main.entity.SeatMap, main.request.BookingRequest)
	 *
	 * The algorithm works in the following:
	 * 
	 * 1. The system starts to allocate the seats in the middle rows of the room. This is because the audiences like to
	 * 	  sit in the middle row of the room.
	 * 
	 * 2. We will have two pointer up pointer and down pointer. Up pointer will start to move from the middle rows to
	 *    the upper row until it meets the last row. Down pointer will also start to move from the middle rows to the
	 *    downer row until it meets the first rows of the room.
	 * 
	 * 3. The system will assign the seat adjacently. If that rows is filled, then two pointers will keep going to
	 *    move down and up until all the request are meet.
	 *    
	 * The time complexity of the O(n) where the n is the number of the seats in the room.
	 */
	@Override
	public List<Seat> allocate(SeatMap seatMap, BookingRequest req) {
		List<Seat> assignedResult = null;
		int numberOfReuest = req.getNumberOfReuest();
		if (seatMap.avaiNumberOfSeats() - numberOfReuest < 0) {
			return assignedResult;
		}
		assignedResult = new ArrayList<Seat>();
		int mid = seatMap.getNumberOfRow() / 2;
		//The down pointer will start to move from the middle row.
		int down = mid;
		//The up pointer will start to move from the middle + 1 row.
		int up = mid + 1;
		while (numberOfReuest > 0 && (down >= 0 || up <= seatMap.getNumberOfRow() - 1)) {
			//Number of available seat at the up pointer's row.
			int numOfUpAvai = 0;
			//Number of available seat at the down pointer's row.
			int numOfDownAvai = 0;
			//The max column of the theater.
			int maxCol = seatMap.getNumberOfCol();
			//If the up pointer haven't meet the last row, then got the available seat at up row.
			if (up <= seatMap.getNumberOfRow() - 1) {
				numOfUpAvai = maxCol - seatMap.getSeatRow(up).getSeats().size();
			}
			//If the down pointer haven't meet the first row, then got the available seat at down row.
			if (down >= 0) {
				numOfDownAvai = maxCol - seatMap.getSeatRow(down).getSeats().size();
			}
			//Get the up row and find the available column index
			SeatRow seatRow = seatMap.getSeatRow(up);
			int col = seatRow.getSeats().size() + 1;
			//Start to allocate the seats to the upper row, then put them into result list.
			while (Math.min(numberOfReuest, numOfUpAvai) > 0) {
				Seat seat = new Seat(seatRow.getRowId() + col, req.getRequestId(), null);
				seatMap.occupySeat(up, seat);
				assignedResult.add(seat);
				numOfUpAvai--;
				numberOfReuest--;
				col++;
			}
			//Get the down row and find the available column index
			seatRow = seatMap.getSeatRow(down);
			col = seatRow.getSeats().size() + 1;
			//Start to allocate the seats to the downer row, then put them into result list.
			while (Math.min(numberOfReuest, numOfDownAvai) > 0) {
				Seat seat = new Seat(seatRow.getRowId() + col, req.getRequestId(), null);
				seatMap.occupySeat(down, seat);
				assignedResult.add(seat);
				numOfDownAvai--;
				numberOfReuest--;
				col++;
			}
			// Move the down pointer to the downer row and move the up pointer to the upper row.
			down--;
			up++;
		}
		return assignedResult;
	}
}