package data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




public class Answers implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	
	@Id
	
	@Column(name="EHDOKAS_ID")
	private int ehdokas_id;
	@Column(name="KYSYMYS_ID")
	private int kysymys_id;
	@Column(name="VASTAUS")
	private int vastaus;
	@Column(name="KOMMENTTI")
	private String kommentti;
	
	public Answers(String ehdokas_id, String kysymys_id, String vastaus, String kommentti) {
		// TODO Auto-generated constructor stub
		setEhdokas_id(ehdokas_id);

		this.kommentti=kommentti;

	}
	/**
	 * This method find questions
	 */
	public Answers() {
		// TODO Auto-generated constructor stub
	}
	
		
	public int getEhdokas_id() {
		return ehdokas_id;
	}
	public void setEhdokas_id(String ehdokas_id) {
		try {
		this.ehdokas_id = Integer.parseInt(ehdokas_id);
	}
	catch(NumberFormatException | NullPointerException e) {
		//Do nothing - the value of id won't be changed
	}
	}
	public int getKysymys_id() {
		return kysymys_id;
	}
	public void setKysymys_id(String kysymys_id) {
		try {
			this.kysymys_id = Integer.parseInt(kysymys_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}	
	}
	public int getVastaus() {
		return vastaus;
	}
	public void setVastaus(String vastaus) {
		try {
			this.vastaus = Integer.parseInt(vastaus);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}	
	}
	public String getKommentti() {
		return kommentti;
	}
	public void setKommentti(String kommentti) {
		this.kommentti = kommentti;
	}

	
	
}
