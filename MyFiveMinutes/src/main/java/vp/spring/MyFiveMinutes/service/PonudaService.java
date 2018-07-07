package vp.spring.MyFiveMinutes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.MyFiveMinutes.data.PonudaRepository;
import vp.spring.MyFiveMinutes.model.Ponuda;
import vp.spring.MyFiveMinutes.model.Projekat;


@Component
public class PonudaService {
	
	@Autowired
	PonudaRepository ponudaRepository;

	public List<Ponuda> findByProjekat(Long id) {
		Projekat projekat = new Projekat();
		projekat.setId(id);
		return ponudaRepository.findByProjekatOrderByNovcanaObavezaAsc(projekat);
	}
	


	
}
