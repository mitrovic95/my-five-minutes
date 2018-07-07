package vp.spring.MyFiveMinutes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import vp.spring.MyFiveMinutes.data.ProjekatKategorijaRepository;
import vp.spring.MyFiveMinutes.model.Kategorija;
import vp.spring.MyFiveMinutes.model.ProjekatKategorija;



@Component
public class ProjekatKategorijaService {
	
	@Autowired
	ProjekatKategorijaRepository projekatKategorijaRepository;
	

	public Page<ProjekatKategorija> findByKategorija(Pageable page, Long id) {
		Kategorija kategorija = new Kategorija();
		kategorija.setId(id);
		return projekatKategorijaRepository.findByKategorija(kategorija, page);
	}
	
	
	public ProjekatKategorija save(ProjekatKategorija ProjekatKategorija) {
		return projekatKategorijaRepository.save(ProjekatKategorija);
	}

}
