package vp.spring.MyFiveMinutes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(catalog = "db_my_five_minutes", name = "lajk") 
public class Lajk {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Korisnik odKorisnika;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	private Projekat projekat;

	private Date datum;
	
	@Column(nullable = true, length = 200, unique = false)
	private String gost;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Korisnik getOdKorisnika() {
		return odKorisnika;
	}

	public void setOdKorisnika(Korisnik odKorisnika) {
		this.odKorisnika = odKorisnika;
	}

	public Projekat getProjekat() {
		return projekat;
	}

	public void setProjekat(Projekat projekat) {
		this.projekat = projekat;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getGost() {
		return gost;
	}

	public void setGost(String gost) {
		this.gost = gost;
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
		Lajk other = (Lajk) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Lajk(Long id, Korisnik odKorisnika, Projekat projekat, Date datum, String gost) {
		super();
		this.id = id;
		this.odKorisnika = odKorisnika;
		this.projekat = projekat;
		this.datum = datum;
		this.gost = gost;
	}
	
	
	public Lajk() {  
		
	}
	
	
	
	
	
}
