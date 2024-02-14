/**
 * 
 */
package project;

import collection.SameDayTicket;
import collection.AdvanceTicket;
import collection.StudentAdvanceTicket;

/**
 * Ticket testing class
 * 
 * @author KathrynIrving
 * @version 2.21.2023_1225
 */

public class COSC600_P3_Ticket {

	/** defines cost */
	public static double cost;

	/** creates new tickets of different types */
	public static void test() {

		SameDayTicket t1 = new SameDayTicket();
		SameDayTicket t2 = new SameDayTicket();
		AdvanceTicket t3 = new AdvanceTicket(13);
		AdvanceTicket t4 = new AdvanceTicket(7);
		StudentAdvanceTicket t5 = new StudentAdvanceTicket(12, 779817);
		StudentAdvanceTicket t6 = new StudentAdvanceTicket(4, 779812);

		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		System.out.println(t4);
		System.out.println(t5);
		System.out.println(t6);

		cost = t1.getPrice() + t2.getPrice() + t3.getPrice() + t4.getPrice() + t5.getPrice() + t6.getPrice();

		System.out.println("\nTotal Cost:\t" + cost);
	}

}
