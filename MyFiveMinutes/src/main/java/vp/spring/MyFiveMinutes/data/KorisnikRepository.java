package vp.spring.MyFiveMinutes.data;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import vp.spring.MyFiveMinutes.model.Korisnik;


@Component
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
	
	Optional<Korisnik> findByUsername(String username);
	
	
	

}
