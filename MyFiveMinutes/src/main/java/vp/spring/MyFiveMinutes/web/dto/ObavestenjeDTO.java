package vp.spring.MyFiveMinutes.web.dto;

import java.util.Date;

import vp.spring.MyFiveMinutes.model.Obavestenje;

public class ObavestenjeDTO {

	private Long id;

	private String tekstObavestenja;

	private Date datum;

	private boolean pregledan;

	private TipObavestenjaDTO tipObavestenja;

	public ObavestenjeDTO(Long id, String tekstObavestenja, Date datum, boolean pregledan,
			TipObavestenjaDTO tipObavestenja) {
		this.id = id;
		this.tekstObavestenja = tekstObavestenja;
		this.datum = datum;
		this.pregledan = pregledan;
		this.tipObavestenja = tipObavestenja;
	}

	public ObavestenjeDTO(Obavestenje obavestanja) {
		this.id = obavestanja.getId();
		this.tekstObavestenja = obavestanja.getTekstObavestenja();
		this.datum = obavestanja.getDatum();
		this.pregledan = obavestanja.isPregledan();
		this.tipObavestenja = new TipObavestenjaDTO(obavestanja.getTipObavestenja());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTekstObavestenja() {
		return tekstObavestenja;
	}

	public void setTekstObavestenja(String tekstObavestenja) {
		this.tekstObavestenja = tekstObavestenja;
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

	public TipObavestenjaDTO getTipObavestenja() {
		return tipObavestenja;
	}

	public void setTipObavestenja(TipObavestenjaDTO tipObavestenja) {
		this.tipObavestenja = tipObavestenja;
	}

	public ObavestenjeDTO() {

	}

}
