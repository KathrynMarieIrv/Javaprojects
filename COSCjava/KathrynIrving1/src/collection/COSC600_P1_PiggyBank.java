/**
 * 
 */
package collection;

/**
 * PiggyBank Project Tester
 * 
 * @author KathrynIrving
 * @version 2.2.2023_540
 */

public class COSC600_P1_PiggyBank {

	/**
	 * This static method is for testing the PiggyBank class.
	 */
	public static void test() {
		PiggyBank b = new PiggyBank();
		System.out.println("Program by Kathryn\n");

		b.addNickels(3);
		System.out.println("Have added 3 nickels");
		System.out.println("Bank has $" + b.getContents() + "in it\n");

		b.addPennies(4);
		System.out.println("Have added 4 pennies");
		System.out.println("Bank has $" + b.getContents() + "in it\n");

		System.out.println("Have added -18 pennies");
		b.addPennies(-18);
		System.out.println("Bank has $" + b.getContents() + "in it\n");

		System.out.println("Broke the bank and got $" + b.breakTheBank() + " from it");
		System.out.println("Bank has $" + b.getContents() + "in it");

	}

}

