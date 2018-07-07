package vp.spring.MyFiveMinutes.web.dto;

import vp.spring.MyFiveMinutes.model.Uplata;

public class UplataDTO {

	private Long id;

	private String uplatilacGost;
	
	private KorisnikDTO uplatilacKorisnik = new KorisnikDTO();

	private int suma;

	public UplataDTO(Long id, String uplatilacGost, KorisnikDTO uplatilacKorisnik,
			int suma) {
		this.id = id;
		this.uplatilacGost = uplatilacGost;
		this.uplatilacKorisnik = uplatilacKorisnik;
		this.suma = suma;
	}

	public UplataDTO(Uplata uplata) {
		this.id = uplata.getId();
		this.uplatilacGost = uplata.getUplatilacGost();
		this.suma = uplata.getSuma();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUplatilacGost() {
		return uplatilacGost;
	}

	public void setUplatilacGost(String uplatilacGost) {
		this.uplatilacGost = uplatilacGost;
	}

	

	public KorisnikDTO getUplatilacKorisnik() {
		return uplatilacKorisnik;
	}

	public void setUplatilacKorisnik(KorisnikDTO uplatilacKorisnik) {
		this.uplatilacKorisnik = uplatilacKorisnik;
	}

	public int getSuma() {
		return suma;
	}

	public void setSuma(int suma) {
		this.suma = suma;
	}

	public UplataDTO() {

	}

}
