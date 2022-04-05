package data;

public class Candidates {
	private int id;
	private String sukunimi;
	private String etunimi;
//	private int ika;
	private String kunta;
	private String puolue;
	private String ammatti;
	private String miksi;
	private String mita;

	

	
	public Candidates(String id, String sukunimi, String etunimi, String kunta, String puolue, 
			String ammatti, String miksi, String mita) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.sukunimi=sukunimi;
		this.etunimi=etunimi;
//		this.ika=ika;
		this.kunta=kunta;
		this.puolue=puolue;
		this.ammatti=ammatti;
		this.miksi=miksi;
		this.mita=mita;


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
	// SUKUNIMI
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	// ETUNIMI
	public String getEtunimi() {
	return etunimi;
	}
	public void setEtunimi(String etunimi) {
	this.etunimi = etunimi;
	}

	// KUNTA
	public String getKunta() {
	return kunta;
	}
	public void setKunta(String kunta) {
	this.kunta = kunta;
	}
	
	// PUOLUE
	public String getPuolue() {
	return puolue;
	}
	public void setPuolue(String puolue) {
	this.puolue = puolue;
	}
	
	// AMMATTI
	public String getAmmatti() {
	return ammatti;
	}
	public void setAmmatti(String ammatti) {
	this.ammatti = ammatti;
	}

	// MIKSI
	public String getMiksi() {
	return miksi;
	}
	public void setMiksi(String miksi) {
	this.miksi = miksi;
	}
	
	// MITA
	public String getMita() {
	return mita;
	}
	public void setMita(String mita) {
	this.mita = mita;
	}
}