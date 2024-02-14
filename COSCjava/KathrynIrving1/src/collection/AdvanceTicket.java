/**
 * 
 */
package collection;

/**
 * Java program that defines subclass of Advance Ticket, using the superclass
 * Ticket.
 * 
 * @author KathrynIrving
 * @version 2.24.2023_219
 * @paramdaysInAdvance , @paramdaysInAdvanceTenOrMore , @paramlastDay
 */
public class AdvanceTicket extends Ticket {

	protected int daysInAdvance;
	protected int daysInAdvanceTenOrMore = 10;
	protected int lastDay = 1;

	/**
	 * Constructor that uses parameters from superclass Ticket, sets the price
	 * depending on how many days in advance the ticket is bought using if else
	 * statement
	 */
	public AdvanceTicket(int daysInAdvance) {
		super();
		this.daysInAdvance = daysInAdvance;

		if (daysInAdvance >= daysInAdvanceTenOrMore) {
			super.price = price - 20.00;
		} else if (daysInAdvance < daysInAdvanceTenOrMore && daysInAdvance >= lastDay) {
			super.price = price - 10.00;
		} else {
			super.price = price;
		}
	}

	/** Method that returns the price based on the If / Else Statements above */
	public double getPrice() {
		return price;
	}

	/** toString method that creates advance ticket info as a string */
	public String toString() {
		return "\n" + "\nThis is an advance ticket. \nTicket Id:" + this.ticketId + "\tDays In Advance: "
				+ this.daysInAdvance + "\tAdvance Day Price: " + this.getPrice();

	}
}
