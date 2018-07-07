package vp.spring.MyFiveMinutes.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import vp.spring.MyFiveMinutes.model.Kategorija;
import vp.spring.MyFiveMinutes.model.ProjekatKategorija;


@Component
public interface ProjekatKategorijaRepository extends JpaRepository<ProjekatKategorija, Long> {
	
	
	Page<ProjekatKategorija> findByKategorija (Kategorija kategorija, Pageable pageable);
	
	
	
}
