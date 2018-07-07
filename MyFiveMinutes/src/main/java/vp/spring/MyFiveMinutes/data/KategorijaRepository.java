package vp.spring.MyFiveMinutes.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import vp.spring.MyFiveMinutes.model.Kategorija;



@Component
public interface KategorijaRepository extends JpaRepository<Kategorija, Long> {

	
	
}
