package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int ehdokas_id;
	private int kysymys_id;
	private int vastaus;
	private String kommentti;
	public int getEhdokas_id() {
		return ehdokas_id;
	}
	public void setEhdokas_id(int ehdokas_id) {
		this.ehdokas_id = ehdokas_id;
	}
	public int getKysymys_id() {
		return kysymys_id;
	}
	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}
	public int getVastaus() {
		return vastaus;
	}
	public void setVastaus(int vastaus) {
		this.vastaus = vastaus;
	}
	public String getKommentti() {
		return kommentti;
	}
	public void setKommentti(String kommentti) {
		this.kommentti = kommentti;
	}

	


	

}
