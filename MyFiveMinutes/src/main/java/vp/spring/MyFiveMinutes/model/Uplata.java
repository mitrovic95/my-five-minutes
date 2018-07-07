package vp.spring.MyFiveMinutes.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(catalog = "db_my_five_minutes", name = "uplata")
public class Uplata {

	@Id
	@GeneratedValue
	private Long id;

	
	@ManyToOne(fetch = FetchType.EAGER)
	private Projekat projekat;

	private String uplatilacGost;

	
	@ManyToOne(fetch = FetchType.EAGER)
	private Korisnik uplatilacKorisnik;

	private int suma;

	public Uplata(Long id, Projekat projekat, String uplatilacGost, Korisnik uplatilacKorisnik, int suma) {
		this.id = id;
		this.projekat = projekat;
		this.uplatilacGost = uplatilacGost;
		this.uplatilacKorisnik = uplatilacKorisnik;
		this.suma = suma;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Projekat getProjekat() {
		return projekat;
	}

	public void setProjekat(Projekat projekat) {
		this.projekat = projekat;
	}

	public String getUplatilacGost() {
		return uplatilacGost;
	}

	public void setUplatilacGost(String uplatilacGost) {
		this.uplatilacGost = uplatilacGost;
	}

	public Korisnik getUplatilacKorisnik() {
		return uplatilacKorisnik;
	}

	public void setUplatilacKorisnik(Korisnik uplatilacKorisnik) {
		this.uplatilacKorisnik = uplatilacKorisnik;
	}

	public int getSuma() {
		return suma;
	}

	public void setSuma(int suma) {
		this.suma = suma;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Uplata other = (Uplata) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Uplata() {

	}

}
