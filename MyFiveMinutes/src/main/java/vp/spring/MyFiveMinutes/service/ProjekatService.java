package vp.spring.MyFiveMinutes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import vp.spring.MyFiveMinutes.data.ProjekatKategorijaRepository;
import vp.spring.MyFiveMinutes.data.ProjekatRepository;
import vp.spring.MyFiveMinutes.model.Projekat;


@Component
public class ProjekatService {
	
	@Autowired
	ProjekatRepository projekatRepository;
	
	@Autowired
	ProjekatKategorijaRepository projekatKategorijaRepository;

	public Page<Projekat> findAll(Pageable page) {
		return projekatRepository.findAll(page);
	}
	
	public Projekat findOne(Long id) {
		return projekatRepository.findOne(id);
	}
	
	public Projekat save(Projekat projekat) {
		return projekatRepository.save(projekat);
	}
	
	

	
}
