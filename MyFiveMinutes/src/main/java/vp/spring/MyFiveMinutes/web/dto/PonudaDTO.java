package vp.spring.MyFiveMinutes.web.dto;

import vp.spring.MyFiveMinutes.model.Ponuda;


public class PonudaDTO {
	

		private Long id;
		private String naslov;
		private String tekst;
		private int novcanaObaveza;

		public PonudaDTO(Long id, String naslov, String tekst, int novcanaObaveza) {
			this.id = id;
			this.naslov = naslov;
			this.tekst = tekst;
			this.novcanaObaveza = novcanaObaveza;
		}

		public PonudaDTO(Ponuda ponuda) {
			this.id = ponuda.getId();
			this.naslov = ponuda.getNaslov();
			this.tekst = ponuda.getTekst();
			this.novcanaObaveza = ponuda.getNovcanaObaveza();
		}
		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNaslov() {
			return naslov;
		}

		public void setNaslov(String naslov) {
			this.naslov = naslov;
		}

		public String getTekst() {
			return tekst;
		}

		public void setTekst(String tekst) {
			this.tekst = tekst;
		}

		public int getNovcanaObaveza() {
			return novcanaObaveza;
		}

		public void setNovcanaObaveza(int novcanaObaveza) {
			this.novcanaObaveza = novcanaObaveza;
		}

		public PonudaDTO() {
			
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}




		
		
		

