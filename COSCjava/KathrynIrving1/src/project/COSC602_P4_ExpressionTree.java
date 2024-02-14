package project;

import java.io.*;
import Structure.MyDeque;
import Structure.MyStack;
import Structure.MyExpressionTree;
import Structure.MyBinaryTreeNode;

/**
 * This class reads in a series of mathematical expressions from a file, and
 * puts them into an expression tree with the use of MyStack class. The
 * expression tree is then printed to a file using a pre-order traversal,
 * in-order traversal, and post-order traversal of the tree. The expression tree
 * is then evaluated and the result is also printed to the file. Note: only
 * single digit numbers are allowed in the original equation.
 * 
 * @author KathrynIrving
 * @version 5.7.2023_1119
 */

public class COSC602_P4_ExpressionTree {

	/**
	 * Method that creates precedence order for operators
	 * 
	 * @param c
	 * @return
	 */
	public static int precedenceOrder(char c) {

		if (c == '+' || c == '-') {
			return 1;
		}

		if (c == '*' || c == '/' || c == '%') {
			return 2;
		}

		else {
			return -1;
		}

	}

	/**
	 * Test method for ExpressionTree project.
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void test() throws IOException {

		String inputFile = "../COSC602_P4_Input.txt";
		String outputFile = "../COSC602_P4_Output.txt";
		int result = 0;
		MyStack stack = new MyStack();
		MyDeque deque = new MyDeque();
		MyBinaryTreeNode rightNode;
		MyBinaryTreeNode leftNode;
		MyExpressionTree tree;
		FileWriter writer = new FileWriter(outputFile);
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(inputFile));
			String line = reader.readLine();
			writer = new FileWriter(outputFile);

			while (line != null) {
				stack.clear();
				deque.clear();

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
						writer.write("**Invalid Expression**" + "\r\n\r\n\r\n");
						continue;
					}

					if (Character.isDigit(line.charAt(i))) {
						deque.insertBack(new MyBinaryTreeNode(line.charAt(i)));

					}

					else if (line.charAt(i) == '(') {

						stack.push(line.charAt(i));

					}

					else if (line.charAt(i) == ')') {

						
						if (stack.isEmpty()) {
							isValid = false;

						} else {

							while (!stack.isEmpty() && ((Character) stack.top() != '(')) {

								rightNode = (MyBinaryTreeNode) deque.removeBack();
								leftNode = (MyBinaryTreeNode) deque.removeBack();
								deque.insertBack(new MyBinaryTreeNode(stack.pop(), leftNode, rightNode));

							}

							if (!stack.isEmpty() && ((Character) stack.top() == '(')) {

								new MyBinaryTreeNode(stack.pop());

							}
						}
					}

					else {

						if (!stack.isEmpty() && precedenceOrder(line.charAt(i)) > precedenceOrder((char) stack.top())) {

							stack.push(line.charAt(i));
						} else {
							while (!stack.isEmpty()
									&& precedenceOrder(line.charAt(i)) <= precedenceOrder((char) stack.top())) {
								rightNode = (MyBinaryTreeNode) deque.removeBack();
								leftNode = (MyBinaryTreeNode) deque.removeBack();
								deque.insertBack(new MyBinaryTreeNode(stack.pop(), leftNode, rightNode));

							}

							stack.push(line.charAt(i));
						}

					}

				}

				while (!stack.isEmpty() && ((Character) stack.top() != '(')) {

					rightNode = (MyBinaryTreeNode) deque.removeBack();
					leftNode = (MyBinaryTreeNode) deque.removeBack();
					deque.insertBack(new MyBinaryTreeNode(stack.pop(), leftNode, rightNode));

				}

				if (!stack.isEmpty() && ((Character) stack.top() == '(')) {
					isValid = false;
				}

				if (isValid == false) {
					writer.write("Original Infix: " + line + "\r\n");
					writer.write("**Invalid Expression**" + "\r\n\r\n\r\n");
					line = reader.readLine();
					continue;
				}

				if (isValid) {

					tree = new MyExpressionTree((MyBinaryTreeNode) deque.back());

					writer.write("Original Infix: " + line + "\r\n");
					writer.write("Pre-Order Traversal: " + tree.preorderTraversal());
					writer.write("In-Order Traversal: " + tree.inorderTraversal());
					writer.write("Post-Order Traversal: " + tree.postorderTraversal());
					result = tree.evaluate((MyBinaryTreeNode) deque.back());
					writer.write("Evaluation Result: = " + result + "\r\n\r\n");

					line = reader.readLine();

				}

			}

		} finally {
			reader.close();
			writer.close();
		}
	}
}
