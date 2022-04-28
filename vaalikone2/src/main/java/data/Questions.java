package data;

/**
 * Date: 23.4.2022
 * Here are data values for questions in Election Machine program where admin can add, edit and remove questions.
 * @author owner group 20M Anna Westerback, Ansa Holttinen and Johanna Sieranoja TRTKM20A3
 * @version 1.0
 */
public class Questions {
	/**
	 * int value for question
	 */
	private int id;
	/**
	 * string value for question
	 */
	private String kysymys;
	
	/**
	 * @param id int value for question
	 * @param kysymys string value for question
	 */
	public Questions(String id, String kysymys) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.kysymys=kysymys;

	}
	/**
	 * This method find questions
	 */
	public Questions() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * This method get question using id
	 * @return returns question
	 */
	public int getId() {
		return id;
	}
	/**
	 * This method set question
	 * @param id value for question
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * This method changes id from string to int
	 * @param id value changed to int
	 */
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
		
	}
	// KYSYMYS
	/**
	 * This method get questions from database
	 * @return retunr question
	 */
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
}