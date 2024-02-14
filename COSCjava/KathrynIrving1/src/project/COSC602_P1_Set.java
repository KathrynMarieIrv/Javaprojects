package project;

import Structure.MySet;

/**
 * Project 1 Testing Class
 * 
 * @author KathrynIrving
 * @version 3.28.2023_1112
 */

public class COSC602_P1_Set implements Cloneable {

	/**
	 * Test method for Project 1 creates two instances of MySet: primeNumSet and
	 * fibonacciNumSet
	 * 
	 * @throws CloneNotSupportedException
	 */
	public static void test() throws CloneNotSupportedException {

		System.out.println("COSC602 Project 1 Set Test Starting ==========>>\n");

		MySet fibonacciNumSet = new MySet();
		MySet primeNumSet = new MySet();

		int temp1 = 0, temp2 = 1, fibNum;
		fibonacciNumSet.add(temp1);
		fibonacciNumSet.add(temp2);
		for (int i = 2; i <= 30; ++i) {
			fibNum = temp1 + temp2;
			temp1 = temp2;
			temp2 = fibNum;
			fibonacciNumSet.add(fibNum);

		}

		int num = 2;
		while (primeNumSet.cardinality() < 30) {
			if (isPrime(num)) {
				primeNumSet.add(num);
			}
			num++;
		}

		System.out.print("The Original Fibonacci Number Set:\n\n" + fibonacciNumSet.toString());
		System.out.print("\n\nThe Original Prime Number Set:\n\n" + primeNumSet.toString());

		MySet intersection = primeNumSet.intersection(fibonacciNumSet);
		System.out.print("\n\nIntersection\n\n" + intersection.toString());

		MySet symmetricDifference = primeNumSet.symmetricDifference(fibonacciNumSet);
		System.out.print("\n\nSymmetric Difference\n\n" + symmetricDifference.toString());

		MySet union = primeNumSet.union(fibonacciNumSet);
		System.out.println("\n\nUnion \n\n" + union.toString());
	}

	private static boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}