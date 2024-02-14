package collection;

import java.io.*;

/**
 * ContactFileService class for COSC600_P4_TextIO
 * 
 * @author KathrynIrving
 * @version 3.9.2023_445
 */

public class ContactFileService {

	/** Private fields which represent the file paths */
	private static String inputFile = "../COSC600_P4_TextInput.txt";
	private static String outputFile = "../COSC600_P4_TextOutput.txt";

	/**
	 * codeNumber is the corresponding number value in the inputfile for each
	 * contact
	 * 
	 * @returns the number of lines to read after each codeNumber value
	 */
	private static int numberOfLinesByCodeNumber(String codeNumber) {

		if (codeNumber.equals("#0")) {
			return 3;
		}
		if (codeNumber.equals("#1")) {
			return 4;
		}
		if (codeNumber.equals("#2")) {
			return 5;
		}
		return 0;
	}

	/**
	 * Method that reads the input file line by line using try block and while loop.
	 * Sets the contact based on number of lines read. Write method included to write
	 * the contacts to the output file
	 * 
	 * @throws IOException and FileNotFoundException using catch
	 */
	public static void read(String inputFile, String outputFile) throws IOException {
		BufferedReader textIn = null;
		try {
			textIn = new BufferedReader(new FileReader(inputFile));
			String line = textIn.readLine();
			while (line != null) {
				if (line.isEmpty() == false && line.isBlank() == false) {
					int currentNumberOfLines = numberOfLinesByCodeNumber(line.trim());
					Contact contact = new Contact();
					if (currentNumberOfLines == 3) {
						contact.setContact(textIn.readLine(), textIn.readLine(), textIn.readLine(), "", "");
					}
					if (currentNumberOfLines == 4) {
						contact.setContact(textIn.readLine(), textIn.readLine(), textIn.readLine(), textIn.readLine(),
								"");
					}
					if (currentNumberOfLines == 5) {

						contact.setContact(textIn.readLine(), textIn.readLine(), textIn.readLine(), textIn.readLine(),
								textIn.readLine());
					}
					write(contact, outputFile);
				}
				line = textIn.readLine();

			}
		} catch (

		FileNotFoundException fnfe) {
			System.err.println("Input File not found.");
		} catch (IOException ioe) {
			System.err.println("Input file reading error.");
		} finally {
			textIn.close();
		}
	}

	/**
	 * Method that writes the contact as a string to the output file using try block
	 * 
	 * @throws IOException using catch
	 */
	public static void write(Contact contact, String outputFile) {
		FileWriter textOut;
		try {
			textOut = new FileWriter(outputFile, true);
			textOut.write(contact.toString() + "\n");
			System.out.println(contact.toString());
			textOut.close();
		} catch (IOException ioe) {
			System.err.println("Output file processing error.");
		}

	}
}