/**
 * 
 */
package test.Util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.Util.Util;

/**
 * The JUnit test for the fileio.
 * @author Han-Tse Chiou
 */
public class testUtilFileIO {
	@Test
	public void readFromFileTester() {
		String filepath = System.getProperty("user.dir") + "/src/test/files/input_test.txt";
		List<String> res = Util.readFile(filepath);
		assertEquals("R001 3", res.get(0));
	    assertEquals("R002 3", res.get(1));
	    assertEquals("R003 5", res.get(2));
	}
	@Test
	public void writeToFileTester() {
		String filepath = System.getProperty("user.dir") + "/src/test/files/output_test.txt";
		List<String> res = new ArrayList<>();
		res.add("test5");
		res.add("test6");
		Util.writeFile(res, filepath);
		res = Util.readFile(filepath);
		assertEquals("test5", res.get(0));
	    assertEquals("test6", res.get(1));
	}
}
