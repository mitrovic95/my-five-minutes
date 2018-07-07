package vp.spring.MyFiveMinutes.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import vp.spring.MyFiveMinutes.model.Korisnik;
import vp.spring.MyFiveMinutes.security.TokenUtils;
import vp.spring.MyFiveMinutes.service.KorisnikService;
import vp.spring.MyFiveMinutes.web.dto.KorisnikDTO;
import vp.spring.MyFiveMinutes.web.dto.LoginDTO;
import vp.spring.MyFiveMinutes.web.dto.TokenDTO;


@RestController
public class KorisnikController {
	
	@Autowired
	KorisnikService korisnikService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	 @Autowired
	 TokenUtils tokenUtils;

	@RequestMapping(value = "api/korisnici/{id}", method = RequestMethod.GET)
	public ResponseEntity<KorisnikDTO> getKorisnika(@PathVariable Long id) {
		
		Korisnik korisnik = korisnikService.findOne(id);
		
		if (korisnik != null) {
			KorisnikDTO korisnikDTO = new KorisnikDTO(korisnik);
				
			return new ResponseEntity<>(korisnikDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "api/korisnici/", method = RequestMethod.POST)
	public ResponseEntity<KorisnikDTO> getKorisnika(@RequestBody KorisnikDTO korisnikDTO) {
		
		Optional<Korisnik> korisnik = korisnikService.findOneByUsername(korisnikDTO.getEmail());
		
		if (korisnik != null) {
			korisnikDTO = new KorisnikDTO(korisnik.get());
				
			return new ResponseEntity<>(korisnikDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "api/korisnici/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KorisnikDTO> updateKorisnika(@PathVariable Long id, @RequestBody KorisnikDTO korisnikDTO){
		
		Korisnik korisnik = korisnikService.findOne(id);
		
		if (korisnik == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		korisnik.setIme(korisnikDTO.getIme());
		korisnik.setPrezime(korisnikDTO.getPrezime());
		korisnik.setEmail(korisnikDTO.getEmail());
		korisnik.setRacun(korisnikDTO.getRacun());
		
		korisnik = korisnikService.save(korisnik);
		
		return new ResponseEntity<>(new KorisnikDTO(korisnik), HttpStatus.OK);
		
	}
	
	 @PostMapping(value = "/api/login")
	    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO) {
	        try {
	            final UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());
	            final Authentication authentication = authenticationManager.authenticate(token);
	            SecurityContextHolder.getContext().setAuthentication(authentication);
	            final UserDetails details = userDetailsService.loadUserByUsername(loginDTO.getUsername());
	            final String genToken = tokenUtils.generateToken(details);

	            return new ResponseEntity<>(new TokenDTO(genToken), HttpStatus.OK);
	        } catch (Exception ex) {
	            return new ResponseEntity<>(new TokenDTO(""), HttpStatus.BAD_REQUEST);
	        }
	    }
	
	
	
	
	
	
	
	

	
}
