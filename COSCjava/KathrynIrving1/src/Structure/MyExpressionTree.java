package Structure;

/**
 *My Expression Tree class 
 * 
 * @author KathrynIrving
 * @version 5.7.2023_1119
 */

public class MyExpressionTree extends MyBinaryTree {

/**
 * Default constructor for MyExpressionTree
 */
	public MyExpressionTree() {
		root = null;
	}

	/**
	 * Method that assigns the root of the Binary Tree
	 * @param rt
	 */
	public MyExpressionTree(MyBinaryTreeNode rt) {
		root = rt;
	}

	/**
	 * Method to evaluate the nodes on Binary Tree
	 * @param rt
	 * @return -1
	 */
	public int evaluate(MyBinaryTreeNode rt) {
		if (rt == null) {
			return -1;
		}

		if (rt.left == null && rt.right == null) {
			return Character.getNumericValue((Character) rt.data);
		}

		switch ((Character) rt.data) {
		case '-':
			return evaluate(rt.left) - evaluate(rt.right);
		case '+':
			return evaluate(rt.left) + evaluate(rt.right);
		case '*':
			return evaluate(rt.left) * evaluate(rt.right);
		case '/':
			return evaluate(rt.left) / evaluate(rt.right);
		case '%':
			return evaluate(rt.left) % evaluate(rt.right);

		}

		return -1;
	}

	/**
	 * String method to create pre-order traversal of Binary Tree nodes 
	 */
	public String preorderTraversal() {
		return preorderHelper(root) + "\n";
	}

	/*
	 * Private helper method for pre-order traversal
	 */
	private String preorderHelper(MyBinaryTreeNode rt) {
		if (rt == null) {
			return "";
		}
		return rt.data + " " + preorderHelper(rt.left) + " " + preorderHelper(rt.right);
	}

	/**
	 * String method to create in-order traversal of Binary Tree nodes 
	 */
	public String inorderTraversal() {
		return inorderHelper(root) + "\n";
	}

	/*
	 * Private helper method for in-order traversal
	 */
	private String inorderHelper(MyBinaryTreeNode rt) {
		if (rt == null) {
			return "";
		}
		return inorderHelper(rt.left) + " " + rt.data + " " + inorderHelper(rt.right);
	}

	/**
	 * String method to create post-order traversal of Binary Tree nodes 
	 */
	public String postorderTraversal() {
		return postorderHelper(root) + "\n";
	}

	/*
	 * Private helper method for post-order traversal
	 */
	private String postorderHelper(MyBinaryTreeNode rt) {
		if (rt == null) {
			return "";
		}
		return postorderHelper(rt.left) + " " + postorderHelper(rt.right) + " " + rt.data;
	}

}