package collection;

/**
 * Contact class for COSC600_P4_TextIO
 * 
 * @author KathrynIrving
 * @version 3.9.2023_445
 */

public class Contact {
	
	/** Private fields which represent the file paths */
	private static String inputFile = "../COSC600_P4_TextInput.txt";
	private static String outputFile = "../COSC600_P4_TextOutput.txt";
	
	/** Private fields which represent the contact*/
	private String FirstName;
	private String LastName;
	private String Phone;
	private String Age;
	private String Relationship;
	
	/** Constructor that makes the contact fields empty */
	public Contact()

	{
		FirstName = "";
		LastName = "";
		Phone = "";
		Age = "";
		Relationship = "";
	}
		
	/** Method that sets the contact*/
		public void setContact(String FirstName, String LastName, String Phone, String Age, String Relationship) {
			this.FirstName = FirstName;
			this.LastName = LastName;
			this.Phone = Phone;
			this.Age = Age;
			this.Relationship = Relationship;
		}

		/** Method @returns FirstName*/
		public String getFirstName() {
			return FirstName;
		}

		/** Method @returns LastName  */
		public String getLastName() {
			return LastName;
		}

		/** Method @returns Phone */
		public String getPhone() {
			return Phone;
		}

		/** Method @returns Age */
		public String getAge() {
			return Age;
		}

		/** Method @returns Relationship */
		public String getRelationship() {
			return Relationship;
		}

		/** Method that puts all of the information for the contact into a string 
		 * @returns contact*/
	public String toString() {
	return "FirstName:" + FirstName + "\tLastName: " + LastName + "\tPhone: " + Phone + "\tAge: " + Age + "\tRelationship: " + Relationship;}
	}

	
