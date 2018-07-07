package vp.spring.MyFiveMinutes.web.dto;

import vp.spring.MyFiveMinutes.model.TipObavestenja;

public class TipObavestenjaDTO {
	
		private Long id;
		
		private String naziv;
		
		
		
		public TipObavestenjaDTO(Long id, String naziv) {
			this.id = id;
			this.naziv = naziv;
		}



		public TipObavestenjaDTO(TipObavestenja tipObavestenja) {
			this.id = tipObavestenja.getId();
			this.naziv = tipObavestenja.getNaziv();
		}
		
		


		@Override
		public String toString() {
			return "TipObavestenjaDTO [id=" + id + ", naziv=" + naziv + "]";
		}



		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public String getNaziv() {
			return naziv;
		}



		public void setNaziv(String naziv) {
			this.naziv = naziv;
		}



		public TipObavestenjaDTO() {  
			
		}
		
		
	
	
	
	
	

}
