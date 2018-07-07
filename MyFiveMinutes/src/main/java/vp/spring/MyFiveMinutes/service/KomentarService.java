package vp.spring.MyFiveMinutes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import vp.spring.MyFiveMinutes.data.KomentarRepository;
import vp.spring.MyFiveMinutes.model.Komentar;
import vp.spring.MyFiveMinutes.model.Projekat;


@Component
public class KomentarService {
	
	@Autowired
	KomentarRepository komentarRepository;

	public Page<Komentar> findByProjekat(Pageable page, Long id) {
		Projekat projekat = new Projekat();
		projekat.setId(id);
		return komentarRepository.findByProjekat(projekat, page);
	}
	


	
}
