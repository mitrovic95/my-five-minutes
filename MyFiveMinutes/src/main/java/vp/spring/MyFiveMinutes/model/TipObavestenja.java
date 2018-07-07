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

@Entity
@Table(catalog = "db_my_five_minutes", name = "tipObavestenja") 
public class TipObavestenja {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy = "tipObavestenja", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Obavestenje> obavestenja = new HashSet<Obavestenje>();	  
	
	@Column(nullable = false, length = 200, unique = true)
	private String naziv;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Obavestenje> getObavestenja() {
		return obavestenja;
	}

	public void setObavestenja(Set<Obavestenje> obavestenja) {
		this.obavestenja = obavestenja;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public TipObavestenja() {  
		
	}
	
	public TipObavestenja(Long id, Set<Obavestenje> obavestenja, String naziv) {
		super();
		this.id = id;
		this.obavestenja = obavestenja;
		this.naziv = naziv;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipObavestenja other = (TipObavestenja) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
