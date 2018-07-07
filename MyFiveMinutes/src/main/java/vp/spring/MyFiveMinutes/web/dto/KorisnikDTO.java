package vp.spring.MyFiveMinutes.web.dto;

import vp.spring.MyFiveMinutes.model.Korisnik;

public class KorisnikDTO {

	private Long id;
	private String ime;
	private String prezime;
	private String email;
	private Long racun;
	private String slikaKorisnikaURL;
	
	public KorisnikDTO(Long id, String ime, String prezime, String email, Long racun, String slikaKorisnikaURL) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.racun = racun;
		this.slikaKorisnikaURL = slikaKorisnikaURL;
	}
	
	public KorisnikDTO(Korisnik korisnik) {
		this.id = korisnik.getId();
		this.ime = korisnik.getIme();
		this.prezime = korisnik.getPrezime();
		this.email = korisnik.getEmail();
		this.racun = korisnik.getRacun();
		this.slikaKorisnikaURL = korisnik.getSlikaKorisnikaURL();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getRacun() {
		return racun;
	}

	public void setRacun(Long racun) {
		this.racun = racun;
	}

	public String getSlikaKorisnikaURL() {
		return slikaKorisnikaURL;
	}

	public void setSlikaKorisnikaURL(String slikaKorisnikaURL) {
		this.slikaKorisnikaURL = slikaKorisnikaURL;
	}

	public KorisnikDTO() {

	}

}
