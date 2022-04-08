package data;

public class Questions {
	private int id;
	private String kysymys;
	
	public Questions(String id, String kysymys) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.kysymys=kysymys;

	}
	public Questions() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
		
	}
	// KYSYMYS
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
}