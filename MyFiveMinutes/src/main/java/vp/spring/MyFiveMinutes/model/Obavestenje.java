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
@Table(catalog = "db_my_five_minutes", name = "obavestenja") 
public class Obavestenje {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	private TipObavestenja tipObavestenja;
	
	@Column(nullable = false, length = 300, unique = false)
	private String tekstObavestenja;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	private Korisnik odKorisnika;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	private Korisnik korisnik;
	
	private Date datum;
	
	private boolean pregledan;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipObavestenja getTipObavestenja() {
		return tipObavestenja;
	}

	public void setTipObavestenja(TipObavestenja tipObavestenja) {
		this.tipObavestenja = tipObavestenja;
	}

	public String getTekstObavestenja() {
		return tekstObavestenja;
	}

	public void setTekstObavestenja(String tekstObavestenja) {
		this.tekstObavestenja = tekstObavestenja;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public boolean isPregledan() {
		return pregledan;
	}

	public void setPregledan(boolean pregledan) {
		this.pregledan = pregledan;
	}
	
	
	public Korisnik getOdKorisnika() {
		return odKorisnika;
	}

	public void setOdKorisnika(Korisnik odKorisnika) {
		this.odKorisnika = odKorisnika;
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
		Obavestenje other = (Obavestenje) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (korisnik == null) {
			if (other.korisnik != null)
				return false;
		} else if (!korisnik.equals(other.korisnik))
			return false;
		if (pregledan != other.pregledan)
			return false;
		if (tekstObavestenja == null) {
			if (other.tekstObavestenja != null)
				return false;
		} else if (!tekstObavestenja.equals(other.tekstObavestenja))
			return false;
		if (tipObavestenja == null) {
			if (other.tipObavestenja != null)
				return false;
		} else if (!tipObavestenja.equals(other.tipObavestenja))
			return false;
		return true;
	}
	
	public Obavestenje(Long id, TipObavestenja tipObavestenja, String tekstObavestenja, Korisnik odKorisnika,
			Korisnik korisnik, Date datum, boolean pregledan) {
		super();
		this.id = id;
		this.tipObavestenja = tipObavestenja;
		this.tekstObavestenja = tekstObavestenja;
		this.odKorisnika = odKorisnika;
		this.korisnik = korisnik;
		this.datum = datum;
		this.pregledan = pregledan;
	}

	public Obavestenje() {  
		
	}
	
	
}
