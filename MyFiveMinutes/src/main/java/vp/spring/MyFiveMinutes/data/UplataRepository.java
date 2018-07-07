package vp.spring.MyFiveMinutes.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import vp.spring.MyFiveMinutes.model.Projekat;
import vp.spring.MyFiveMinutes.model.Uplata;


@Component
public interface UplataRepository extends JpaRepository<Uplata, Long> {

	
	List<Uplata> findByProjekat (Projekat projekat);
	
}
