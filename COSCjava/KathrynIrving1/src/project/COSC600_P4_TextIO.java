package project;

import java.io.*;
import collection.ContactFileService;

/**
 * Input and Output testing class.
 * 
 * @author KathrynIrving
 * @version 3.9.2023_445
 */

public class COSC600_P4_TextIO {
	
	/** Private fields which represent the file paths */
	private static String inputFile = "../COSC600_P4_TextInput.txt";
	private static String outputFile = "../COSC600_P4_TextOutput.txt";

	/**
	 * Test method for Text IO project.
	 * @throws IOException 
	 */

	public static void test() throws IOException {
		
		ContactFileService.read(inputFile, outputFile);
	
	}
 

}
