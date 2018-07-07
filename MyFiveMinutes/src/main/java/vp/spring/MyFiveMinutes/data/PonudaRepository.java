package vp.spring.MyFiveMinutes.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import vp.spring.MyFiveMinutes.model.Ponuda;
import vp.spring.MyFiveMinutes.model.Projekat;


@Component
public interface PonudaRepository extends JpaRepository<Ponuda, Long> {

	
	List<Ponuda> findByProjekatOrderByNovcanaObavezaAsc (Projekat projekat);
	
}
