package emprunt.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Emprunt {
	
	@NotBlank
	private long id_adherent;
	
	@NotBlank
	private long id_media;
	
	@NotBlank
	private String date_emprunt;
	
	@NotBlank
	private String date_retour_prevu;
	
	private String date_retour_effective;
	
	
}
