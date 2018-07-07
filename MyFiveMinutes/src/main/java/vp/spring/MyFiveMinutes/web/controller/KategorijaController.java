package vp.spring.MyFiveMinutes.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.MyFiveMinutes.model.Kategorija;
import vp.spring.MyFiveMinutes.service.KategorijaService;
import vp.spring.MyFiveMinutes.web.dto.KategorijaDTO;


@RestController
public class KategorijaController {
	@Autowired
	KategorijaService kategorijaService;
	
	@RequestMapping(value = "api/kategorije", method = RequestMethod.GET)
	public ResponseEntity<List<KategorijaDTO>> getAllKategorije() {
		
		List<Kategorija> kategorije = kategorijaService.findAll();
		
		List<KategorijaDTO> retVal = new ArrayList<>();
		
		for (Kategorija kategorija: kategorije){
			retVal.add(new KategorijaDTO(kategorija));
		}
		

	
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
}
