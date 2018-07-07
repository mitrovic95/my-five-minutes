package vp.spring.MyFiveMinutes.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(catalog = "db_my_five_minutes", name = "projekat") 
public class Projekat {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 200)
	private String nazivProjekta;
	
	@Column(length = 500)
	private String opisProjekta;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH) 
	private Korisnik korisnik;
	
	@JsonIgnore
	@OneToMany(mappedBy = "projekat", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<ProjekatKategorija> projekatKategorija = new HashSet<ProjekatKategorija>();
	
	@Column(length = 200, unique = true)
	private String slikaUrl;
	
	@Column(length = 200, unique = true)
	private String videoUrl;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datumObjave;
	
	@Column(nullable = false)
	private Date datumIsteka;
	
	@JsonIgnore
	@OneToMany(mappedBy = "projekat", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Lajk> lajkovi = new HashSet<Lajk>();
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "projekat", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Komentar> komentari = new HashSet<Komentar>();
	
	
	private Long brojPregleda;
	
	
	private Long racun;
	
	
	private Long trazenaSvota;
	
	@JsonIgnore
	@OneToMany(mappedBy = "projekat", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Ponuda> ponude = new HashSet<Ponuda>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "projekat", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Uplata> uplate = new HashSet<Uplata>();
	

	private boolean odobren;
	
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

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
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

	public Set<Lajk> getLajkovi() {
		return lajkovi;
	}

	public void setLajkovi(Set<Lajk> lajkovi) {
		this.lajkovi = lajkovi;
	}

	public Set<Komentar> getKomentari() {
		return komentari;
	}

	public void setKomentari(Set<Komentar> komentari) {
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

	public Set<Ponuda> getPonude() {
		return ponude;
	}

	public void setPonude(Set<Ponuda> ponude) {
		this.ponude = ponude;
	}

	public boolean isOdobren() {
		return odobren;
	}

	public void setOdobren(boolean odobren) {
		this.odobren = odobren;
	}
	

	public Set<Uplata> getUplate() {
		return uplate;
	}

	public void setUplate(Set<Uplata> uplate) {
		this.uplate = uplate;
	}

	public Set<ProjekatKategorija> getProjekatKategorija() {
		return projekatKategorija;
	}

	public void setProjekatKategorija(Set<ProjekatKategorija> projekatKategorija) {
		this.projekatKategorija = projekatKategorija;
	}

	public Projekat() {  
		
	}
	

	
	
	
	public Projekat(Long id, String nazivProjekta, String opisProjekta, Korisnik korisnik,
			Set<ProjekatKategorija> projekatKategorija, String slikaUrl, String videoUrl, Date datumObjave,
			Date datumIsteka, Set<Lajk> lajkovi, Set<Komentar> komentari, Long brojPregleda, Long racun,
			Long trazenaSvota, Set<Ponuda> ponude, Set<Uplata> uplate, boolean odobren) {
		super();
		this.id = id;
		this.nazivProjekta = nazivProjekta;
		this.opisProjekta = opisProjekta;
		this.korisnik = korisnik;
		this.projekatKategorija = projekatKategorija;
		this.slikaUrl = slikaUrl;
		this.videoUrl = videoUrl;
		this.datumObjave = datumObjave;
		this.datumIsteka = datumIsteka;
		this.lajkovi = lajkovi;
		this.komentari = komentari;
		this.brojPregleda = brojPregleda;
		this.racun = racun;
		this.trazenaSvota = trazenaSvota;
		this.ponude = ponude;
		this.uplate = uplate;
		this.odobren = odobren;
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
		Projekat other = (Projekat) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
