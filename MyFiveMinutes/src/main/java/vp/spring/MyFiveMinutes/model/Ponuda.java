package vp.spring.MyFiveMinutes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(catalog = "db_my_five_minutes", name = "ponuda") 
public class Ponuda {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, length = 200)
	private String naslov;
	
	@Column(nullable = false, length = 500)
	private String tekst;
	
	@Column(nullable = false)
	private int novcanaObaveza;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	private Projekat projekat;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public int getNovcanaObaveza() {
		return novcanaObaveza;
	}

	public void setNovcanaObaveza(int novcanaObaveza) {
		this.novcanaObaveza = novcanaObaveza;
	}

	public Projekat getProjekat() {
		return projekat;
	}

	public void setProjekat(Projekat projekat) {
		this.projekat = projekat;
	}

	public Ponuda(Long id, String naslov, String tekst, int novcanaObaveza, Projekat projekat) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.tekst = tekst;
		this.novcanaObaveza = novcanaObaveza;
		this.projekat = projekat;
	}

	public Ponuda() {
		
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
		Ponuda other = (Ponuda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



