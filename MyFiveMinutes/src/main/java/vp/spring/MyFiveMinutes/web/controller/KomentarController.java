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

import vp.spring.MyFiveMinutes.model.Komentar;
import vp.spring.MyFiveMinutes.service.KomentarService;
import vp.spring.MyFiveMinutes.web.dto.KomentarDTO;
import vp.spring.MyFiveMinutes.web.dto.KorisnikDTO;


@RestController
public class KomentarController {
	@Autowired
	KomentarService komentarService;
	
	@RequestMapping(value = "api/projekti/{id}/komentari", method = RequestMethod.GET)
	public ResponseEntity<List<KomentarDTO>> getProjektiPage(@PathVariable Long id, Pageable page) {
		
		Page<Komentar> komentari = komentarService.findByProjekat(page, id);
		
		HttpHeaders headers = new HttpHeaders();
		long ukupnoKomentara = komentari.getTotalElements();
		headers.add("X-Total-Count", String.valueOf(ukupnoKomentara));
		
		List<KomentarDTO> retVal = convertListaKomentaraToDTO(komentari.getContent());
		
		return new ResponseEntity<> (retVal, headers, HttpStatus.OK);
	}
	

	private List<KomentarDTO> convertListaKomentaraToDTO(List<Komentar> komentari){
		
		List<KomentarDTO> retVal = new ArrayList<>();
		
		for(Komentar komentar: komentari){
			KomentarDTO komentarDTO = new KomentarDTO(komentar);
			if(komentarDTO.getGost() == null ){
			komentarDTO.setKorisnik(new KorisnikDTO(komentar.getOdKorisnika()));
			}
			retVal.add(komentarDTO);
		}
		return retVal;
	}
	
	

	
	
}
