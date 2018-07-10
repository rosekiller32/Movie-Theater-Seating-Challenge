package test.allocator;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import main.allocator.GroupAllocator;
import main.entity.Seat;
import main.entity.SeatMap;
import main.request.BookingRequest;

public class testSeatAllocator {
	
	@Test
	public void SeatAllocatorTester() {
		SeatMap map = new SeatMap(7, 3);
		BookingRequest req = new BookingRequest("R001", 5, "1", "1");
		List<Seat> l = new GroupAllocator().allocate(map, req);
		assertEquals(5, l.size());
		System.out.println(l.get(0).getId());
		assertEquals("D1", l.get(0).getId());
		assertEquals("R001", l.get(0).getResId());
		assertEquals("D2", l.get(1).getId());
		assertEquals("R001", l.get(1).getResId());
		assertEquals("D3", l.get(2).getId());
		assertEquals("R001", l.get(2).getResId());
		assertEquals("C1", l.get(3).getId());
		assertEquals("R001", l.get(3).getResId());
		assertEquals("C2", l.get(4).getId());
		assertEquals("R001", l.get(4).getResId());
	}
}
