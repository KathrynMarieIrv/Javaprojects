/**
 * 
 */
package collection;

/**
 * Java program that defines a subclass of Student Advance Ticket, inheriting
 * from Advance Ticket class
 * 
 * @author KathrynIrving
 * @version 2.24.2023_219
 * @Param Student Id number
 */
public class StudentAdvanceTicket extends AdvanceTicket {

	private int studentId;

	/**
	 * Constructor that creates a student advance ticket using parameters from
	 * Advance Ticket
	 */
	public StudentAdvanceTicket(int daysInAdvance, int studentId) {
		super(daysInAdvance);
		this.studentId = studentId;
	}

	/**
	 * Method that records a student Id number
	 * 
	 * @return student Id number
	 */
	public int getStudentId() {
		return this.studentId = studentId;
	}

	/**
	 * Method that returns a half price ticket
	 * 
	 * @return half price student ticket
	 */
	public double getPrice() {
		return price / 2;
	}

	/** toString method that creates student advance ticket info as a string */
	public String toString() {
		return "\n" + "\nThis is a student advance ticket.\nTicket Id: " + this.ticketId + "\tDays In Advance: "
				+ this.daysInAdvance + "\tAdvance Day Price: " + this.getPrice() + "\tStudent Id: "
				+ this.getStudentId();

	}
}
