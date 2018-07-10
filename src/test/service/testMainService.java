package test.service;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

import main.ReservationService;
import main.Util.Util;

/**
 * @author Han-Tse Chiou
 *
 */
public class testMainService {

	@Test
	public void MainServiceTester() {
		String inputFilePath =  System.getProperty("user.dir") + "/src/test/files/input_test.txt";
		String outputFilePath =  System.getProperty("user.dir") + "/src/test/files/output_test.txt";
		ReservationService.main(new String[] { "--input=", inputFilePath, " --output=", outputFilePath });
		List<String> l = Util.readFile(outputFilePath); 
		assertEquals(3, l.size());
		assertEquals("R001 F1, F2, F3", l.get(0));
		assertEquals("R002 F4, F5, F6", l.get(1));
		assertEquals("R003 F7, F8, F9, F10, F11", l.get(2));
	}

}
