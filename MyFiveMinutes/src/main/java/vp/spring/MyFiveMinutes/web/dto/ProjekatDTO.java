package vp.spring.MyFiveMinutes.web.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vp.spring.MyFiveMinutes.model.Projekat;

public class ProjekatDTO {

	private Long id;
	private String nazivProjekta;
	private String opisProjekta;
	private KorisnikDTO korisnik = new KorisnikDTO();
	private List<KategorijaDTO> kategorije = new ArrayList<KategorijaDTO>();
	private String slikaUrl;
	private String videoUrl;
	private Date datumObjave;
	private Date datumIsteka;
	private List<LajkDTO> lajkovi = new ArrayList<LajkDTO>();
	private List<KomentarDTO> komentari = new ArrayList<KomentarDTO>();
	private Long brojPregleda;
	private Long racun;
	private Long trazenaSvota;
	private boolean odobren;
	private int brojLajkova = 0;
	private int brojKomentara = 0;



	public ProjekatDTO(Projekat projekat) {
		this.id = projekat.getId();
		this.nazivProjekta = projekat.getNazivProjekta();
		this.opisProjekta = projekat.getOpisProjekta();
		this.slikaUrl = projekat.getSlikaUrl();
		this.videoUrl = projekat.getVideoUrl();
		this.datumObjave = projekat.getDatumObjave();
		this.datumIsteka = projekat.getDatumIsteka();
		this.brojPregleda = projekat.getBrojPregleda();
		this.racun = projekat.getRacun();
		this.trazenaSvota = projekat.getTrazenaSvota();
		this.odobren = projekat.isOdobren();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivProjekta() {
		return nazivProjekta;
	}

	public void setNazivProjekta(String nazivProjekta) {
		this.nazivProjekta = nazivProjekta;
	}

	public String getOpisProjekta() {
		return opisProjekta;
	}

	public void setOpisProjekta(String opisProjekta) {
		this.opisProjekta = opisProjekta;
	}

	public KorisnikDTO getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(KorisnikDTO korisnik) {
		this.korisnik = korisnik;
	}

	public List<KategorijaDTO> getKategorije() {
		return kategorije;
	}

	public void setKategorije(List<KategorijaDTO> kategorije) {
		this.kategorije = kategorije;
	}

	public String getSlikaUrl() {
		return slikaUrl;
	}

	public void setSlikaUrl(String slikaUrl) {
		this.slikaUrl = slikaUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public Date getDatumObjave() {
		return datumObjave;
	}

	public void setDatumObjave(Date datumObjave) {
		this.datumObjave = datumObjave;
	}

	public Date getDatumIsteka() {
		return datumIsteka;
	}

	public void setDatumIsteka(Date datumIsteka) {
		this.datumIsteka = datumIsteka;
	}

	public List<LajkDTO> getLajkovi() {
		return lajkovi;
	}

	public void setLajkovi(List<LajkDTO> lajkovi) {
		this.lajkovi = lajkovi;
	}

	public List<KomentarDTO> getKomentari() {
		return komentari;
	}

	public void setKomentari(List<KomentarDTO> komentari) {
		this.komentari = komentari;
	}

	public Long getBrojPregleda() {
		return brojPregleda;
	}

	public void setBrojPregleda(Long brojPregleda) {
		this.brojPregleda = brojPregleda;
	}

	public Long getRacun() {
		return racun;
	}

	public void setRacun(Long racun) {
		this.racun = racun;
	}

	public Long getTrazenaSvota() {
		return trazenaSvota;
	}

	public void setTrazenaSvota(Long trazenaSvota) {
		this.trazenaSvota = trazenaSvota;
	}

	public boolean isOdobren() {
		return odobren;
	}

	public void setOdobren(boolean odobren) {
		this.odobren = odobren;
	}
	
	public int getBrojLajkova() {
		return brojLajkova;
	}

	public void setBrojLajkova(int brojLajkova) {
		this.brojLajkova = brojLajkova;
	}

	public int getBrojKomentara() {
		return brojKomentara;
	}

	public void setBrojKomentara(int brojKomentara) {
		this.brojKomentara = brojKomentara;
	}

	public ProjekatDTO() {

	}

}
