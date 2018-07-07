package vp.spring.MyFiveMinutes.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.MyFiveMinutes.model.Ponuda;
import vp.spring.MyFiveMinutes.service.PonudaService;
import vp.spring.MyFiveMinutes.web.dto.PonudaDTO;


@RestController
public class PonudaController {
	@Autowired
	PonudaService ponudaService;
	
	@RequestMapping(value = "api/projekti/{id}/ponude", method = RequestMethod.GET)
	public ResponseEntity<List<PonudaDTO>> getProjektiPage(@PathVariable Long id) {
		
		List<Ponuda> ponude = ponudaService.findByProjekat(id);
		if (ponude != null) {
			List<PonudaDTO> retVal = convertListaPonudaToDTO(ponude);
			return new ResponseEntity<> (retVal, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	private List<PonudaDTO> convertListaPonudaToDTO(List<Ponuda> ponude){
		
		List<PonudaDTO> retVal = new ArrayList<>();
		
		for(Ponuda ponuda: ponude){
			PonudaDTO ponudaDTO = new PonudaDTO(ponuda);
		
			retVal.add(ponudaDTO);
		}
		return retVal;
	}
	
	

	
	
}
