/**
 * 
 */
package main.Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * The Util class to read and write the file.
 * @author Han-Tse Chiou
 */
public class Util {
	/**
	 * Reads the input file and returns its content as a {@link List<String>} with
	 * each line as a separate entry.
	 * 
	 * @param filepath - Path of the input file to read.
	 * @return list - List of string holding the file data in-memory.
	 */
	public static List<String> readFile(String filepath) {
		System.out.println(filepath);
		List<String> list = new ArrayList<String>();
		FileReader fr = null;
		try {
			fr = new FileReader(filepath);
			BufferedReader file = new BufferedReader(fr);
			String line = null;
			while ((line = file.readLine()) != null) {
				list.add(line.trim());
			}
			file.close();
		} catch (IOException e) {
			System.out.println("Error occurred while writing to: " + filepath);
			System.out.println("Error Message: " + e.getMessage());
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	/**
	 * Writes the given {@link List<String>} into a file at the given path. If the
	 * file is not present, than it is created. If the file is present than it is
	 * overwritten
	 * 
	 * 
	 * @param list     - List of string to write into file.
	 * @param filepath - Path of the file at which the List is to be written.
	 */
	public static void writeFile(List<String> list, String filepath) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filepath);
			Writer writer = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"));
			for (String line : list) {
				writer.write(line + "\n");
			}
			writer.flush();
			writer.close();
			System.out.println("File successfully written to: " + filepath);
		} catch (IOException e) {
			System.out.println("Error occurred while writing to: " + filepath);
			System.out.println("Error Message: " + e.getMessage());
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
