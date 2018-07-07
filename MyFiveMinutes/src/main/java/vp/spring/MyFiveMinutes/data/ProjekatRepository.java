package vp.spring.MyFiveMinutes.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import vp.spring.MyFiveMinutes.model.Projekat;


@Component
public interface ProjekatRepository extends JpaRepository<Projekat, Long> {

	
}
