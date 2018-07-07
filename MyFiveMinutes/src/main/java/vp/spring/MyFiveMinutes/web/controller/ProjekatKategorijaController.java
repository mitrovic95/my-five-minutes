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

import vp.spring.MyFiveMinutes.model.Projekat;
import vp.spring.MyFiveMinutes.model.ProjekatKategorija;
import vp.spring.MyFiveMinutes.service.ProjekatKategorijaService;
import vp.spring.MyFiveMinutes.web.dto.KategorijaDTO;
import vp.spring.MyFiveMinutes.web.dto.KorisnikDTO;
import vp.spring.MyFiveMinutes.web.dto.ProjekatDTO;


@RestController
public class ProjekatKategorijaController {
	
	
	@Autowired
	ProjekatKategorijaService projekatKategorijaService;
	
	
	@RequestMapping(value = "api/projekti?kategorija={id}", method = RequestMethod.GET)
	public ResponseEntity<List<ProjekatDTO>> getProjektiPage(@PathVariable Long id, Pageable page) {
		
		Page<ProjekatKategorija> projekatKategorije = projekatKategorijaService.findByKategorija(page, id);
		
		
		HttpHeaders headers = new HttpHeaders();
		long ukupnoPronadjeno = projekatKategorije.getTotalElements();
		headers.add("X-Total-Count", String.valueOf(ukupnoPronadjeno));
		
		List<ProjekatDTO> retVal = convertListaProjekataKategorijaToDTO(projekatKategorije.getContent());
		
		return new ResponseEntity<> (retVal, headers, HttpStatus.OK);
	}
	
	//metode
	private List<ProjekatDTO> convertListaProjekataKategorijaToDTO(List<ProjekatKategorija> projekatKategorije){
		
		List<ProjekatDTO> retVal = new ArrayList<>();
		
		
		for(ProjekatKategorija projekatKategorija: projekatKategorije){
			
			Projekat projekat = projekatKategorija.getProjekat();
			
			ProjekatDTO projekatDTO = new ProjekatDTO(projekat);
			
			for (ProjekatKategorija projekatKategorijaa: projekat.getProjekatKategorija()){
				projekatDTO.getKategorije().add(new KategorijaDTO(projekatKategorijaa.getKategorija()));
			}
			projekatDTO.setKorisnik(new KorisnikDTO(projekat.getKorisnik()));
			projekatDTO.setBrojLajkova(projekat.getLajkovi().size());
		}
		
		return retVal;

	}
	
}
