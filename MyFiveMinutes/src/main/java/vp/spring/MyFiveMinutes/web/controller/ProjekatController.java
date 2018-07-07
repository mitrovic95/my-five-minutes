package vp.spring.MyFiveMinutes.web.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.MyFiveMinutes.model.Kategorija;
import vp.spring.MyFiveMinutes.model.Korisnik;
import vp.spring.MyFiveMinutes.model.Projekat;
import vp.spring.MyFiveMinutes.model.ProjekatKategorija;
import vp.spring.MyFiveMinutes.model.Uplata;
import vp.spring.MyFiveMinutes.service.KategorijaService;
import vp.spring.MyFiveMinutes.service.KorisnikService;
import vp.spring.MyFiveMinutes.service.ProjekatKategorijaService;
import vp.spring.MyFiveMinutes.service.ProjekatService;
import vp.spring.MyFiveMinutes.service.UplataService;
import vp.spring.MyFiveMinutes.web.dto.KategorijaDTO;
import vp.spring.MyFiveMinutes.web.dto.KorisnikDTO;
import vp.spring.MyFiveMinutes.web.dto.ProjekatDTO;
import vp.spring.MyFiveMinutes.web.dto.UplataDTO;


@RestController
public class ProjekatController {
	@Autowired
	ProjekatService projekatService;
	
	@Autowired
	KorisnikService korisnikService;
	
	@Autowired
	KategorijaService kategorijaService;
	
	@Autowired
	ProjekatKategorijaService projekatKategorijaService;
	
	@Autowired
	UplataService uplataService;
	
	
	
	@RequestMapping(value = "api/projekti", method = RequestMethod.GET)
	public ResponseEntity<List<ProjekatDTO>> getProjektiPage(Pageable page) {
		
		Page<Projekat> projekti = projekatService.findAll(page);
		
		HttpHeaders headers = new HttpHeaders();
		long ukupnoProjekata = projekti.getTotalElements();
		headers.add("X-Total-Count", String.valueOf(ukupnoProjekata));
		
		List<ProjekatDTO> retVal = convertListaProjekataToDTO(projekti.getContent());
		
		return new ResponseEntity<> (retVal, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "api/projekti/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProjekatDTO> getProjekat(@PathVariable Long id){
		
		Projekat projekat = projekatService.findOne(id);
		
		if (projekat != null && projekat.isOdobren()) {
			ProjekatDTO projekatDTO = covertProjekatToDTO(projekat);
				
			return new ResponseEntity<>(projekatDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@RequestMapping(value = "api/projekti", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProjekatDTO> create (@RequestBody ProjekatDTO projekatDTO){
		
		
		
		if (korisnikService.findOne(projekatDTO.getKorisnik().getId()).getProjekat() != null) {				
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Projekat projekat = new Projekat();
		
		projekat.setNazivProjekta(projekatDTO.getNazivProjekta());
		projekat.setOpisProjekta(projekatDTO.getOpisProjekta());
	
		Date sadasnjeVreme = new Date();
		Timestamp datumObjave = new Timestamp(sadasnjeVreme.getTime());
		Calendar cal = Calendar.getInstance();
		cal.setTime(sadasnjeVreme);
		cal.add(Calendar.DATE, 90); 
		sadasnjeVreme = cal.getTime();
		Timestamp datumIsteka = new Timestamp(sadasnjeVreme.getTime());
		
		projekat.setDatumObjave(datumObjave);
		projekat.setDatumIsteka(datumIsteka);
		
		projekat.setKorisnik(new Korisnik(projekatDTO.getKorisnik().getId()));
		
		projekat.setBrojPregleda(0L);
		projekat.setOdobren(false);
		projekat.setVideoUrl(projekatDTO.getVideoUrl());
		projekat.setSlikaUrl(projekatDTO.getSlikaUrl());
		projekat.setTrazenaSvota(projekatDTO.getTrazenaSvota());
		projekat.setRacun(0L);
		
		projekat = projekatService.save(projekat);	
		
		for (KategorijaDTO kategorijaDTO: projekatDTO.getKategorije()){
			projekatKategorijaService.save(new ProjekatKategorija(null,projekat, new Kategorija(kategorijaDTO.getId())));
		}
		
		projekatDTO = covertProjekatToDTO(projekat);
		
		
		return new ResponseEntity<>(projekatDTO, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "api/projekti/{id}/uplate", method = RequestMethod.GET)
	public ResponseEntity<List<UplataDTO>> Uplate(@PathVariable Long id){
		
		Projekat projekat = projekatService.findOne(id);
		
		List<UplataDTO> uplateDTO = new ArrayList<>();
		
		for (Uplata uplata: projekat.getUplate()){
			
			UplataDTO uplataDTO = new UplataDTO(uplata);
			
			if(uplataDTO.getUplatilacGost() == null){
			uplataDTO.setUplatilacKorisnik(new KorisnikDTO(uplata.getUplatilacKorisnik()));
			}
			
			uplateDTO.add(uplataDTO);
			
			
		}
		
		return new ResponseEntity<>(uplateDTO, HttpStatus.FOUND);
		
	}
	
	@RequestMapping(value = "api/projekti/{id}/uplate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UplataDTO> UplateNaProjekat (@PathVariable Long id, @RequestBody UplataDTO uplataDTO){
		
		
		Uplata uplata = new Uplata();
		
		
		if(uplataDTO.getUplatilacGost() == null){
			Korisnik korisnik = korisnikService.findOne(uplataDTO.getUplatilacKorisnik().getId());
			uplata.setUplatilacKorisnik(korisnik);
			
			if(korisnik.getRacun()<uplataDTO.getSuma()){
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			korisnik.setRacun(korisnik.getRacun()-uplataDTO.getSuma());
		}else{
			uplata.setUplatilacGost(uplataDTO.getUplatilacGost());
		}
		
		uplata.setUplatilacGost(uplataDTO.getUplatilacGost());
		
		Projekat projekat = projekatService.findOne(id);
		projekat.setRacun(projekat.getRacun() + uplataDTO.getSuma());
		
		uplata.setProjekat(projekat);
		uplata.setSuma(uplataDTO.getSuma());
		
		uplata.setProjekat(projekat);
		uplata.setSuma(uplataDTO.getSuma());
		
		uplata = uplataService.save(uplata);
		uplataDTO = new UplataDTO(uplata);
		
		return new ResponseEntity<>(uplataDTO, HttpStatus.ACCEPTED);

	}
	
	
	

	
	//metode
	private List<ProjekatDTO> convertListaProjekataToDTO(List<Projekat> projekti){
		
		List<ProjekatDTO> retVal = new ArrayList<>();
		
		for(Projekat projekat: projekti){
			ProjekatDTO projekatDTO = new ProjekatDTO(projekat);
			for (ProjekatKategorija projekatKategorija: projekat.getProjekatKategorija()){
				projekatDTO.getKategorije().add(new KategorijaDTO(projekatKategorija.getKategorija()));
			}
			projekatDTO.setKorisnik(new KorisnikDTO(projekat.getKorisnik()));
			
			projekatDTO.setBrojKomentara(projekat.getKomentari().size());
			projekatDTO.setBrojLajkova(projekat.getLajkovi().size());
			
			retVal.add(projekatDTO);
		}
		return retVal;
	}
	
	private ProjekatDTO covertProjekatToDTO(Projekat projekat){
		
		ProjekatDTO projekatDTO = new ProjekatDTO(projekat);
		
		for (ProjekatKategorija projekatKategorija: projekat.getProjekatKategorija()){
			projekatDTO.getKategorije().add(new KategorijaDTO(projekatKategorija.getKategorija()));
		}
		
		projekatDTO.setKorisnik(new KorisnikDTO(projekat.getKorisnik()));
		projekatDTO.setBrojKomentara(projekat.getKomentari().size());
		projekatDTO.setBrojLajkova(projekat.getLajkovi().size());		
		
		return projekatDTO;
	}
	

	
	
}
