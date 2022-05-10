package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType; 
import javax.persistence.Id;


/**
 * The persistent class for the vastaukset database table.
 * 
 */
@Entity
@NamedQuery(name="Vastaukset.findAll", query="SELECT v FROM Vastaukset v")
public class Vastaukset implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id

	private int id;

	private String kommentti;

	private int vastaus;

	//bi-directional many-to-one association to Ehdokkaat
	@ManyToOne(cascade = CascadeType.PERSIST)
//	@ManyToMany(cascade = CascadeType.PERSIST)
//	@ManyToMany(mappedBy="ehdokkaat",cascade = CascadeType.PERSIST)
	@JoinColumn(name="EHDOKAS_ID")	
	private Ehdokkaat ehdokkaat;

	//bi-directional many-to-one association to Kysymykset
	@ManyToOne(cascade = CascadeType.PERSIST)
//	@ManyToMany(cascade = CascadeType.PERSIST)
//	@ManyToMany(mappedBy="kysymykset",cascade = CascadeType.PERSIST)
	@JoinColumn(name="KYSYMYS_ID")
	private Kysymykset kysymykset;

	public Vastaukset() {
	}


	public Vastaukset(String id, String vastaus, String kommentti) {
		// TODO Auto-generated constructor stub



	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKommentti() {
		return this.kommentti;
	}

	public void setKommentti(String kommentti) {
		this.kommentti = kommentti;
	}

	public int getVastaus() {
		return this.vastaus;
	}

	public void setVastaus(int vastaus) {
		this.vastaus = vastaus;
	}

	public Ehdokkaat getEhdokkaat() {
		return this.ehdokkaat;
	}

	public void setEhdokkaat(Ehdokkaat ehdokkaat) {
		this.ehdokkaat = ehdokkaat;
	}

	public Kysymykset getKysymykset() {
		return this.kysymykset;
	}

	public void setKysymykset(Kysymykset kysymykset) {
		this.kysymykset = kysymykset;
	}
	public String toString() {
		return String.format("id:%s, vastaus:%s, kommentti:%s", id, vastaus, kommentti);
	}

}