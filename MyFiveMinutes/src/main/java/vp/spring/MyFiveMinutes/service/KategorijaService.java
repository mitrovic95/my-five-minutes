package vp.spring.MyFiveMinutes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.MyFiveMinutes.data.KategorijaRepository;
import vp.spring.MyFiveMinutes.model.Kategorija;


@Component
public class KategorijaService {
	
	@Autowired
	KategorijaRepository kategorijaRepository;

	public Kategorija findOne(Long id) {
		return kategorijaRepository.findOne(id);
	}
	
	public List<Kategorija> findAll() {
		return kategorijaRepository.findAll();
	}
	


	
}
