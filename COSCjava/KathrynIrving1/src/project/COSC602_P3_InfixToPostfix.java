package project;

import java.io.*;
import Structure.MyQueue;
import Structure.MyStack;

/**
 * This class reads in a series of mathematical expressions from a file, and
 * changes them from an infix expression to a postfix expression, while
 * utilizing the MyQueue and MyStack classes. After the expression is in
 * postfix, it is evaluated, again using MyQueue and MyStack, to provide the
 * mathematical answer to the expression. All portions are printed out to
 * another file. Note: Only single digit numbers are allowed in the original
 * equation.
 * 
 * @author KathrynIrving
 * @version 4.25.2023_207
 */ 

public class COSC602_P3_InfixToPostfix {

	/** Private fields which represent the file paths */
	private static String inputFile = "../COSC602_P3_InfixInput.txt";
	private static String outputFile = "../COSC602_P3_PostfixOutput.txt";

	/**
	 * Test method for Infix to Postfix project.
	 * 
	 * @throws IOException
	 */

	public static void test() throws IOException {

		MyStack stack = new MyStack();
		MyQueue queue = new MyQueue();

		// reads input file line by line and writes to output file
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			String line = reader.readLine();
			FileWriter writer = new FileWriter(outputFile);

			while (line != null) {
				stack.clear();
				queue.clear();

				boolean isValid = true;

				line = line.trim();
				if (line.length() == 0) {
					line = reader.readLine();
					continue;
				}

				int numbers = 0, operators = 0;
				for (int i = 0; i < line.length(); i++) {
					if (Character.isDigit(line.charAt(i))) {
						numbers++;
					} else if ("+-*/%".contains("" + line.charAt(i))) {
						operators++;
					}
				}

				if (numbers != operators + 1) {
					isValid = false;
				}

				for (int i = 0; i < line.length() && isValid; i++) {
					char c = line.charAt(i);
					if (c == ' ') {
						continue;
					}

					// Checks to make sure valid digits and operators are being used. 
					if ("0123456789+-*/%()".contains(c + "") == false) {
						isValid = false;
					}
					
					if (isValid == false) {
						writer.write("Original Infix: " + line + "\r\n");
						writer.write("**Invalid expression**" + "\r\n\r\n\r\n");
						continue;
					}

					// adds digits to queue, adds operators to stack.
					else if (Character.isDigit(c)) {
						queue.insertBack(c);
					} else if (c == '(') {
						stack.push(c);
					} else if (c == ')') {
						while (((Character) (stack.top()) != '(')) {
							queue.insertBack(stack.pop());
						}
						stack.pop();
					}
					
					else if (c == '*' || c == '/' || c == '%') {
						stack.push(c);
					} else if (c == '+' || c == '-') {
						while (!stack.isEmpty() && ((Character) (stack.top())) != '(') {
							queue.insertBack(stack.pop());
						}
						stack.push(c);
					}

				}

				while (!stack.isEmpty() && ((Character) (stack.top())) != '(') {
					queue.insertBack(stack.pop());
				}

				// if stack is not empty, will be invalid expression
				if (stack.isEmpty() == false) {
					isValid = false;
				}

				if (isValid == false) {
					writer.write("Original Infix: " + line + "\r\n");
					writer.write("**Invalid expression**" + "\r\n\r\n\r\n");
					line = reader.readLine();
					continue;
				}

				writer.write("Original Infix: \t" + line + "\r\n");
				writer.write("Corresponding Postfix: " + queue.toString() + "\r\n");

				while (queue.isEmpty() == false) {
					Character d = (Character) (queue.removeFront());
					if (Character.isDigit(d)) {
						stack.push(d);
					} else if (d.equals('*')) {
						int t1 = Integer.parseInt(stack.pop() + "");
						int t2 = Integer.parseInt(stack.pop() + "");
						stack.push(((Integer) t2) * ((Integer) t1));
					} else if (d.equals('/')) {
						int t1 = Integer.parseInt(stack.pop() + "");
						int t2 = Integer.parseInt(stack.pop() + "");
						stack.push(((Integer) t2) / ((Integer) t1));
					} else if (d.equals('%')) {
						int t1 = Integer.parseInt(stack.pop() + "");
						int t2 = Integer.parseInt(stack.pop() + "");
						stack.push(((Integer) t2) % ((Integer) t1));
					} else if (d.equals('+')) {
						int t1 = Integer.parseInt(stack.pop() + "");
						int t2 = Integer.parseInt(stack.pop() + "");
						stack.push(((Integer) t2) + ((Integer) t1));
					} else if (d.equals('-')) {
						int t1 = Integer.parseInt(stack.pop() + "");
						int t2 = Integer.parseInt(stack.pop() + "");
						stack.push(((Integer) t2) - ((Integer) t1));
					}
				}

				writer.write("Evaluation Result: " + stack.toString() + "\r\n\r\n\r\n");

				line = reader.readLine();

			}

			reader.close();
			writer.close();
		}
		/**
		 * @throws FileNotFoundException
		 */
		catch (FileNotFoundException e) {
		}
		/**
		 * @throws IOException
		 */
		catch (IOException e) {

		}
	}

}