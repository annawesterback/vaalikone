package data;

/**
 * Date: 23.4.2022
 * Here are data values for candidates in Election Machine program where admin can add, edit and remove candidates.
 * @author owner group 20M Anna Westerback, Ansa Holttinen and Johanna Sieranoja TRTKM20A3
 * @version 1.0
 */
public class Candidates {
	/**
	 * int value for candidate id
	 */
	private int id;
	/**
	 * string value for candidate lastname
	 */
	private String sukunimi;
	/**
	 * string value for candidate firstname
	 */
	private String etunimi;
	/**
	 * int value for candidate age
	 */
	private int ika;
	/**
	 * string value for candidate city
	 */
	private String kunta;
	/**
	 * string value for candidate parliamentary party
	 */
	private String puolue;
	/**
	 * string value for candidate occupation
	 */
	private String ammatti;
	/**
	 * string value for explanation why candidate want in parliament
	 */
	private String miksi;
	/**
	 * string value for explanation what candidate want
	 */
	private String mita;

	
	/**
	 * @param id int value for candidate id
	 * @param sukunimi string value for candidate lastname
	 * @param etunimi string value for candidate firstname
	 * @param ika int value for candidate age
	 * @param kunta string value for candidate city
	 * @param puolue string value for candidate parliament
	 * @param ammatti string value for candidate work
	 * @param miksi string value for candidate why
	 * @param mita string value for candidate what
	 */
	public Candidates(String id, String sukunimi, String etunimi, String ika, String kunta, String puolue, 
			String ammatti, String miksi, String mita) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.sukunimi=sukunimi;
		this.etunimi=etunimi;
		setIka(ika);
		this.kunta=kunta;
		this.puolue=puolue;
		this.ammatti=ammatti;
		this.miksi=miksi;
		this.mita=mita;

	}
	/**
	 * This is method to find candidates
	 */
	public Candidates() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * This is method to get id
	 * @return return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * This is method to set candidate
	 * @param id value for id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * This is method to set id
	 * @param id
	 */
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
		
	}
	// SUKUNIMI
	/**
	 * This is method to fet lastname
	 * @return return lastname
	 */
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	// ETUNIMI
	/**
	 * This is method to find firstname
	 * @return return firstname
	 */
	public String getEtunimi() {
	return etunimi;
	}
	/**
	 * This is method to set firstname
	 * @param etunimi string value for firstname
	 */
	public void setEtunimi(String etunimi) {
	this.etunimi = etunimi;
	}
	
	// IKÄ
	
	/**
	 * This is method to get age
	 * @return return age
	 */
	public int getIka() {
		return ika;
	}
	/**
	 * This is method to set age
	 * @param ika value for age
	 */
	public void setIka(int ika) {
		this.ika = ika;
	}
	/**
	 * This is method to set age
	 * @param ika value for age
	 */
	public void setIka(String ika) {
		try {
			this.ika = Integer.parseInt(ika);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}

	// KUNTA
	/**
	 * This is method to find city
	 * @return retunr city
	 */
	public String getKunta() {
	return kunta;
	}
	/**
	 * This is method to set city
	 * @param kunta value for city
	 */
	public void setKunta(String kunta) {
	this.kunta = kunta;
	}
	
	// PUOLUE
	/**
	 * This is method to get parliament
	 * @return return parliament
	 */
	public String getPuolue() {
	return puolue;
	}
	/**
	 * This is method to set parliament
	 * @param puolue attribute for parliament
	 */
	public void setPuolue(String puolue) {
	this.puolue = puolue;
	}
	
	// AMMATTI
	/**
	 * This is method to get work
	 * @return return work
	 */
	public String getAmmatti() {
	return ammatti;
	}
	/**
	 * This is method to set work
	 * @param ammatti attribute for work
	 */
	public void setAmmatti(String ammatti) {
	this.ammatti = ammatti;
	}

	// MIKSI
	/**
	 * This is method to get why
	 * @return return why
	 */
	public String getMiksi() {
	return miksi;
	}
	/**
	 * This is method to set why
	 * @param miksi attribute for why
	 */
	public void setMiksi(String miksi) {
	this.miksi = miksi;
	}
	
	// MITA
	/**
	 * This is method to get what
	 * @return return what
	 */
	public String getMita() {
	return mita;
	}
	/**
	 * This is method to set what
	 * @param mita attribute for what
	 */
	public void setMita(String mita) {
	this.mita = mita;
	}
	public String toString() {
		return String.format("id:%s, sukunimi:%s, etunimi:%s, ika:%s, kunta:%s, puolue:%s, ammatti:%s, miksi:%s, mita:%s", id, sukunimi, etunimi, ika, kunta, puolue, ammatti, miksi, mita);
	}
}