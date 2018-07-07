package vp.spring.MyFiveMinutes.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(catalog = "db_my_five_minutes", name = "kategorija") 
public class Kategorija {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	@Column(nullable = false, length = 100, unique = true)
	private String ime;
	
	@JsonIgnore
	@OneToMany(mappedBy = "kategorija", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<ProjekatKategorija> projekatKategorija = new HashSet<ProjekatKategorija>();

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
	
	public Set<ProjekatKategorija> getProjekatKategorija() {
		return projekatKategorija;
	}

	public void setProjekatKategorija(Set<ProjekatKategorija> projekatKategorija) {
		this.projekatKategorija = projekatKategorija;
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
		Kategorija other = (Kategorija) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public Kategorija(Long id, String ime, Set<ProjekatKategorija> projekatKategorija) {
		super();
		this.id = id;
		this.ime = ime;
		this.projekatKategorija = projekatKategorija;
	}

	public Kategorija() {  
		
	}

	public Kategorija(Long id) {
		super();
		this.id = id;
	}
	
	
	

	
	
}
