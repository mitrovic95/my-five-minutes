package vp.spring.MyFiveMinutes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.MyFiveMinutes.data.UplataRepository;
import vp.spring.MyFiveMinutes.model.Uplata;


@Component
public class UplataService {
	
	@Autowired
	UplataRepository uplataRepository;
	
	public Uplata save(Uplata uplata) {
		return uplataRepository.save(uplata);
	}
}
