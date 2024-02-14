package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.lang.System;
import java.util.ArrayList;

/**
 * Phone Number To Word Class
 * 
 * @author KathrynIrving
 * @version 4.11.2023_445
 */

public class COSC602_P2_PhoneNumberToWord {

	/** Private field which represents the file path */

	private static String wordFile = "../COSC602_P2_EnglishWordList.txt";

	/**
	 * method to check the validity of the phone number entered
	 * 
	 * @param phone number
	 */
	public static String check(String phoneNumber) {
		phoneNumber = phoneNumber.replace("-", "");
		if (phoneNumber.length() != 7 || phoneNumber.contains("0") || phoneNumber.contains("1"))
			System.out.println(
					"Please rerun the program and enter a valid 7 digit phone number, do not use 0 or 1 in phone Number");
		return phoneNumber;
	}

	/**
	 * method that converts numbers on keypad into characters
	 * 
	 * @param num number entered on keypad
	 * @return new character letter
	 */
	public static Character[] getCharacters(char num) {
		if (num == '2') {
			return new Character[] { 'a', 'b', 'c' };
		}
		if (num == '3') {
			return new Character[] { 'd', 'e', 'f' };
		}
		if (num == '4') {
			return new Character[] { 'g', 'h', 'i' };
		}
		if (num == '5') {
			return new Character[] { 'j', 'k', 'l' };
		}
		if (num == '6') {
			return new Character[] { 'm', 'n', 'o' };
		}
		if (num == '7') {
			return new Character[] { 'p', 'q', 'r', 's' };
		}
		if (num == '8') {
			return new Character[] { 't', 'u', 'v' };
		}
		if (num == '9') {
			return new Character[] { 'w', 'x', 'y', 'z' };
		}
		return null;
	}

	/**
	 * method that creates new array, mapping numbers to characters
	 * 
	 * @param phoneNumber
	 * @param length
	 * @param index
	 * @param s
	 * @return
	 */
	public static List<String> mapWord(char[] phoneNumber, int length, int index, String s) {
		List<String> stringList = new ArrayList<>();
		Character[][] numberToCharMap;
		numberToCharMap = new Character[10][5];
		numberToCharMap[0] = new Character[] { '\0' };
		numberToCharMap[1] = new Character[] { '\0' };
		numberToCharMap[2] = new Character[] { 'a', 'b', 'c' };
		numberToCharMap[3] = new Character[] { 'd', 'e', 'f' };
		numberToCharMap[4] = new Character[] { 'g', 'h', 'i' };
		numberToCharMap[5] = new Character[] { 'j', 'k', 'l' };
		numberToCharMap[6] = new Character[] { 'm', 'n', 'o' };
		numberToCharMap[7] = new Character[] { 'p', 'q', 'r', 's' };
		numberToCharMap[8] = new Character[] { 't', 'u', 'v' };
		numberToCharMap[9] = new Character[] { 'w', 'x', 'y', 'z' };
		for (int i = 0; i < numberToCharMap[phoneNumber[index]].length; i++) {
			String sCopy = String.copyValueOf(s.toCharArray());
			sCopy = sCopy.concat(numberToCharMap[phoneNumber[index]][i].toString());
			stringList.addAll(mapWord(phoneNumber, length, index + 1, sCopy));
		}
		return stringList;
	}

	/**
	 * This is the static testing method of PhoneNumberToWord class
	 * 
	 * @throws IOException
	 */
	public static void test() throws IOException {
		System.out.print("Enter a phone number : ");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String phoneNumber = reader.readLine();

		phoneNumber = check(phoneNumber);
		char[] numArr = phoneNumber.toCharArray();
		List<String> wordList = new ArrayList<String>();
		BufferedReader br = null;

		String sCurrentLine;
		br = new BufferedReader(new FileReader(wordFile));
		while ((sCurrentLine = br.readLine()) != null) {
			if (sCurrentLine != null && sCurrentLine.length() > 0) {
				wordList.add(sCurrentLine);
			}

		}
		List<String> tempWords = wordList.stream().filter(word -> word.length() == numArr.length).toList();
		for (int i = 0; i < numArr.length; i++) {

			List<Character> chars = Arrays.asList(getCharacters(numArr[i]));
			int index = i;
			tempWords = tempWords.stream().filter(word -> chars.contains(word.charAt(index))).toList();
		}
		System.out.print("Count of Words:\t" + tempWords.size() + "\n");
		tempWords.forEach(System.out::println);

	}
}
