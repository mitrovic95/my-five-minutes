package vp.spring.MyFiveMinutes.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(catalog = "db_my_five_minutes", name = "korisnik") 
public class Korisnik {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String ime;

	@Column(nullable = false, length = 100)
	private String prezime;

	@Column(nullable = false, length = 100, unique = true)
	private String email;

	@Column(nullable = false, unique = false)
	private Long racun;
	
	@JsonIgnore
	@OneToMany(mappedBy = "korisnik", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Obavestenje> obavestenja = new HashSet<Obavestenje>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "odKorisnika", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Obavestenje> poslataObavestenja = new HashSet<Obavestenje>();
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="korisnik")
	private Projekat projekat;
	
	@JsonIgnore
	@OneToMany(mappedBy = "odKorisnika", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Komentar> korisnikoviKomentari = new HashSet<Komentar>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "odKorisnika", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Lajk> korisnikoviLajkovi = new HashSet<Lajk>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "uplatilacKorisnik", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Uplata> uplate = new HashSet<Uplata>();
	
	private String slikaKorisnikaURL;
	
	//zastita
	
    private String username;
    
    private String password;
    
    @Enumerated(EnumType.STRING)
    private Role role;

	
	
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

	public Set<Obavestenje> getObavestenja() {
		return obavestenja;
	}

	public void setObavestenja(Set<Obavestenje> obavestenja) {
		this.obavestenja = obavestenja;
	}

	public Projekat getProjekat() {
		return projekat;
	}

	public void setProjekat(Projekat projekat) {
		this.projekat = projekat;
	}

	public Set<Komentar> getKorisnikoviKomentari() {
		return korisnikoviKomentari;
	}

	public void setKorisnikoviKomentari(Set<Komentar> korisnikoviKomentari) {
		this.korisnikoviKomentari = korisnikoviKomentari;
	}

	public Set<Lajk> getKorisnikoviLajkovi() {
		return korisnikoviLajkovi;
	}

	public void setKorisnikoviLajkovi(Set<Lajk> korisnikoviLajkovi) {
		this.korisnikoviLajkovi = korisnikoviLajkovi;
	}
	
	
	public String getSlikaKorisnikaURL() {
		return slikaKorisnikaURL;
	}

	public void setSlikaKorisnikaURL(String slikaKorisnikaURL) {
		this.slikaKorisnikaURL = slikaKorisnikaURL;
	}


	public Set<Uplata> getUplate() {
		return uplate;
	}

	public void setUplate(Set<Uplata> uplate) {
		this.uplate = uplate;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Korisnik(Long id, String ime, String prezime, String email, Long racun, Set<Obavestenje> obavestenja,
			Projekat projekat, Set<Komentar> korisnikoviKomentari, Set<Lajk> korisnikoviLajkovi, Set<Uplata> uplate,
			String slikaKorisnikaURL) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.racun = racun;
		this.obavestenja = obavestenja;
		this.projekat = projekat;
		this.korisnikoviKomentari = korisnikoviKomentari;
		this.korisnikoviLajkovi = korisnikoviLajkovi;
		this.uplate = uplate;
		this.slikaKorisnikaURL = slikaKorisnikaURL;
	}

	public Korisnik() {  
		
	}
	
	public Korisnik(Long id) {
		super();
		this.id = id;
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
		Korisnik other = (Korisnik) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
