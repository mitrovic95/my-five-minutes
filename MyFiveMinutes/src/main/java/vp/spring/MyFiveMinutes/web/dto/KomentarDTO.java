package vp.spring.MyFiveMinutes.web.dto;

import java.util.Date;

import vp.spring.MyFiveMinutes.model.Komentar;

public class KomentarDTO {

	private Long id;
	private String tekst;
	private Date datum;
	private String gost = "";
	private KorisnikDTO korisnik = new KorisnikDTO();

	public KomentarDTO(Long id, String tekst, Date datum, String gost, KorisnikDTO korisnik) {
		this.id = id;
		this.tekst = tekst;
		this.datum = datum;
		this.gost = gost;
		this.korisnik = korisnik;
	}

	public KomentarDTO(Komentar komentar) {
		this.id = komentar.getId();
		this.tekst = komentar.getTekst();
		this.datum = komentar.getDatum();
		this.gost = komentar.getGost();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
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

	public KomentarDTO() {

	}

}
