package vp.spring.MyFiveMinutes.web.dto;

import vp.spring.MyFiveMinutes.model.Kategorija;


public class KategorijaDTO {
	
		private Long id;
		private String ime;
		
		public KategorijaDTO(Long id, String ime) {
			this.id = id;
			this.ime = ime;
		}
		
		public KategorijaDTO(Kategorija kategorija) {
			this.id = kategorija.getId();
			this.ime = kategorija.getIme();
		}


		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getIme() {
			return ime;
		}

		public void setIme(String ime) {
			this.ime = ime;
		}

		public KategorijaDTO() {  
			
		}
		
	}

