package vp.spring.MyFiveMinutes.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(catalog = "db_my_five_minutes", name = "projekatKategorija") 
public class ProjekatKategorija {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Projekat projekat;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Kategorija kategorija;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Projekat getProjekat() {
		return projekat;
	}

	public void setProjekat(Projekat projekat) {
		this.projekat = projekat;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}
	

	public ProjekatKategorija(Long id, Projekat projekat, Kategorija kategorija) {
		super();
		this.id = id;
		this.projekat = projekat;
		this.kategorija = kategorija;
	}

	public ProjekatKategorija() {  
		
	}
	
	public ProjekatKategorija(Long id) {
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
		ProjekatKategorija other = (ProjekatKategorija) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
