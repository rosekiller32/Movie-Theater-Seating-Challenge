/**
 * 
 */
package main.request;

/**
 * The booking request class.
 * @author HanTse Chiou
 */
public class BookingRequest implements IRequest<String> {
	private String reqId;
	private int numberOfReuest;
	private String theaterId;
	private String roomId;
	public BookingRequest(String id, int numberOfReuest, String roomId, String theaterId) {
		reqId = id;
		this.numberOfReuest = numberOfReuest;
		this.theaterId = theaterId;
		this.roomId = roomId;
	}
	public String getRequestId() {
		return reqId;
	}
	public int getNumberOfReuest() {
		return numberOfReuest;
	}
	public String getTheaterId() {
		return theaterId;
	}
	public String getRoomId() {
		return roomId;
	}
}
