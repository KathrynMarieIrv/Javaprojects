/**
 * 
 */
package collection;

/**
 * Java program that mimics counting coins in a PiggyBank.
 * 
 * @author KathrynIrving
 * @version 2.2.2023_540
 */
public class PiggyBank {

	/**
	 * private fields which represent the amount of coins in the PiggyBank
	 */
	public static void main(String[] args) {
		COSC600_P1_PiggyBank.test();
	}

	private int numPennies;
	private int numNickels;
	private int numDimes;
	private int numQuarters;

	/** Constructor that set the fields (amounts of coins) equal to zero */
	public PiggyBank()

	{
		numPennies = 0;
		numNickels = 0;
		numDimes = 0;
		numQuarters = 0;
	}

	/**
	 * Method that adds the specified amount (numPenniesToAdd) to the PiggyBank's numPennies
	 */
	public void addPennies(int numPenniesToAdd) {
		if (numPenniesToAdd > 0) {
			numPennies = numPennies + numPenniesToAdd;
		}
	}

	/**
	 * Method that adds the specified amount (numNickelsToAdd) to the PiggyBank's numNickels
	 */
	public void addNickels(int numNickelsToAdd) {
		if (numNickelsToAdd > 0) {
			numNickels = numNickels + numNickelsToAdd;
		}
	}

	/**
	 * Method that adds the specified amount (numDimesToAdd) to the PiggyBank's numDimes
	 */
	public void addDimes(int numDimesToAdd) {
		if (numDimes > 0) {
			numDimes = numDimes + numDimesToAdd;
		}
	}

	/**
	 * Method that adds the specified amount (numQuartersToAdd) to the PiggyBank's numQuarters
	 */
	public void addQuarters(int numQuartersToAdd) {
		if (numQuarters > 0) {
			numQuarters = numQuarters + numQuartersToAdd;
		}
	}

	/** Method that returns dollar amount using a float */
	public float getContents() {
		float dollarAmount = (float) 0.00;
		dollarAmount = dollarAmount + (float) numPennies / (float) 100;
		dollarAmount = dollarAmount + (float) numNickels / (float) 20;
		dollarAmount = dollarAmount + (float) numDimes / (float) 10;
		dollarAmount = dollarAmount + (float) numQuarters / (float) 4;
		return dollarAmount;
	}

	/** Method that returns the amount in the bank and then sets contents to zero */
	public float breakTheBank() {
		float dollarAmount = getContents();
		numPennies = 0;
		numNickels = 0;
		numDimes = 0;
		numQuarters = 0;
		return dollarAmount;
	}

}

