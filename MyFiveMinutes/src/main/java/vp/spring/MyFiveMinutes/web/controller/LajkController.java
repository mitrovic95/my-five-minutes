package vp.spring.MyFiveMinutes.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.MyFiveMinutes.model.Lajk;
import vp.spring.MyFiveMinutes.service.LajkService;
import vp.spring.MyFiveMinutes.web.dto.KorisnikDTO;
import vp.spring.MyFiveMinutes.web.dto.LajkDTO;


@RestController
public class LajkController {
	@Autowired
	LajkService lajkService;
	
	@RequestMapping(value = "api/projekti/{id}/lajkovi", method = RequestMethod.GET)
	public ResponseEntity<List<LajkDTO>> getProjektiPage(@PathVariable Long id, Pageable page) {
		
		Page<Lajk> lajkovi = lajkService.findByProjekat(page, id);
		
		HttpHeaders headers = new HttpHeaders();
		long ukupnoLajkova = lajkovi.getTotalElements();
		headers.add("X-Total-Count", String.valueOf(ukupnoLajkova));
		
		List<LajkDTO> retVal = convertListaLajkovaToDTO(lajkovi.getContent());
		
		return new ResponseEntity<> (retVal, headers, HttpStatus.OK);
	}
	
	//metoda
	private List<LajkDTO> convertListaLajkovaToDTO(List<Lajk> lajkovi){
		
		List<LajkDTO> retVal = new ArrayList<>();
		
		for(Lajk lajk: lajkovi){
			LajkDTO lajkDTO = new LajkDTO(lajk);
			if(lajkDTO.getGost() == null ){
				lajkDTO.setKorisnik(new KorisnikDTO(lajk.getOdKorisnika()));
			}
			retVal.add(lajkDTO);
		}
		return retVal;
	}
	
	

	
	
}
