/**
 * 
 */
package collection;

/**
 * Java program that defines a Ticket.
 * 
 * @author KathrynIrving
 * @version 2.24.2023_219
 * @ParamticketId
 * @Paramprice
 */
public class Ticket {

	protected int ticketId;
	protected double price = 50.00;

	private static int New_Ticket_Id = 1;

	/**
	 * constructor that defines default Ticket values, Id for new tickets made + 1
	 */
	public Ticket() {
		ticketId = New_Ticket_Id;
		New_Ticket_Id++;
	}

	/** Method that returns the price of the ticket */
	public double getPrice() {
		return price;

	}

	/** toString method that creates ticket info as a string */
	public String toString() {
		return "\n" + "\nTicket Info: \nTicket Id:" + this.ticketId + "\nTicket Price: " + this.getPrice();
	}
}
