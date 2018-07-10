/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.List;

import main.Util.Util;
import main.request.BookingRequest;
import main.request.BookingRequestHandler;
import main.response.BookingResponse;
import main.response.BookingResponseHandler;

/**
 * The main service of the reservation system.
 * @author Han-Tse Chiou
 */
public class ReservationService {
	private static final String THEATER_ID = "1";
	private static final String ROOM_ID = "1";
	private BookingRequestHandler requestHandler = new BookingRequestHandler();
	private BookingResponseHandler responseHandler = new BookingResponseHandler();
	/**
	 * The main driver of the reservation service
	 * @param args The command line inputs
	 */
	public static void main(String[] args) {
		ReservationService service = new ReservationService();
		System.out.println("Please Enter the input in the format: --input={FILEPATH} --output={FILEPATH}");
		String inputFile = "";
		String outputFile = "";
		if (args.length == 2) {
			if (args[0].trim().equals("--input=")) {
				inputFile = args[1];
			} else {
				System.out.println("Wrong imput! Check your input again.");
			}
		} else if (args.length == 4) {
			if (args[0].trim().equals("--input=") && args[2].trim().equals("--output=")) {
				inputFile = args[1];
				outputFile = args[3];
			} else {
				System.out.println("Wrong imput! Check your input again.");
			}
		}
		service.bookTickets(inputFile, outputFile);
	}

	/**
	 * The function for booking the tickets.
	 * @param inputPath The path of the input file.
	 * @param outputPath The path of the output file.
	 */
	public void bookTickets(String inputPath, String outputPath) {
		reservationDataBase.initializeTheater(10,5);
		List<String> input = Util.readFile(inputPath);
		List<String> output = new ArrayList<String>();
		for (String str : input) {
			String[] s = str.split(" ");
			if (s.length == 2) {
				try {
					int requreNum = Integer.parseInt(s[1]);
					String id = s[0];
					if (!id.isEmpty()) {
						BookingResponse response = requestHandler.processResquest(new BookingRequest(id, requreNum, ROOM_ID, THEATER_ID));
						output.add(responseHandler.processResponse(response));
					} else {
						System.out.println("Incorrect input: " + str + ". Request Id cannot be empty.");
					}
				} catch (NumberFormatException e) {
					System.out.println("Incorrect input: " + str + "." + s[1] + " is not a number.");
				}
			} else {
				System.out.println("Incorrect input: " + str + ". Entry must be in the form - R001 3");
			}
		}
		Util.writeFile(output, outputPath);
	}
}
