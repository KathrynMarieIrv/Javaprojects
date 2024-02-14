/**
 * 
 */
package collection;

/**
 * Java program that defines a subclass of Same Day Ticket, using the superclass
 * Ticket
 * 
 * @author KathrynIrving
 * @version 2.24.2023_219
 */
public class SameDayTicket extends Ticket {

	/** Constructor that uses parameters from superclass Ticket */
	public SameDayTicket() {
		super();
	}

	/** toString method that creates same day ticket info as a string */
	public String toString() {
		return "\n" + "\nThis is a same day ticket. \nTicket Id:" + this.ticketId + "\tSame Day Price: "
				+ this.getPrice();

	}

}
