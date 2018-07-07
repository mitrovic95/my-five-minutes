package vp.spring.MyFiveMinutes.web.dto;

import java.util.Date;

import vp.spring.MyFiveMinutes.model.Lajk;



public class LajkDTO {
	
	private Long id;
	private Date datum;
	private String gost;
	private KorisnikDTO korisnik;

	public LajkDTO(Long id, Date datum, String gost, KorisnikDTO korisnik) {
		this.id = id;
		this.datum = datum;
		this.gost = gost;
		this.korisnik = korisnik;
	}

	public LajkDTO(Lajk lajk) {
		this.id = lajk.getId();
		this.datum = lajk.getDatum();
		this.gost = lajk.getGost();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public KorisnikDTO getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(KorisnikDTO korisnik) {
		this.korisnik = korisnik;
	}

	public LajkDTO() {  
		
	}

}
