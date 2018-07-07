package vp.spring.MyFiveMinutes.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import vp.spring.MyFiveMinutes.model.Lajk;
import vp.spring.MyFiveMinutes.model.Projekat;


@Component
public interface LajkRepository extends JpaRepository<Lajk, Long> {

	
	Page<Lajk> findByProjekat (Projekat projekat, Pageable pageable);
	
}
