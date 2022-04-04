package data;

public class Candidates {
	private int id;
	private String sukunimi;
	public Candidates(String id, String sukunimi) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.sukunimi=sukunimi;
	}
	public Candidates() {
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
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
}
