package vp.spring.MyFiveMinutes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.MyFiveMinutes.data.KorisnikRepository;
import vp.spring.MyFiveMinutes.model.Korisnik;



@Component
public class KorisnikService {
	
	@Autowired
	KorisnikRepository korisnikRepository;
	
	public List<Korisnik> findAll() {
		return korisnikRepository.findAll();
	}
	
	public Korisnik findOne(Long id) {
		return korisnikRepository.findOne(id);
	}
	
	public Optional<Korisnik> findOneByUsername(String username){
		return korisnikRepository.findByUsername(username);
	}
	
	public Korisnik save(Korisnik korisnik) {
		return korisnikRepository.save(korisnik);
	}

}
