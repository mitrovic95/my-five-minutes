package vp.spring.MyFiveMinutes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import vp.spring.MyFiveMinutes.data.LajkRepository;
import vp.spring.MyFiveMinutes.model.Lajk;
import vp.spring.MyFiveMinutes.model.Projekat;


@Component
public class LajkService {
	
	@Autowired
	LajkRepository lajkRepository;

	public Page<Lajk> findByProjekat(Pageable page, Long id) {
		Projekat projekat = new Projekat();
		projekat.setId(id);
		return lajkRepository.findByProjekat(projekat, page);
	}
	
}
