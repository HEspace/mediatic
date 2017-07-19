package emprunt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import adherent.model.Adherent;
import media.model.Media;

@Entity
public class Emprunt {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	@ManyToOne
	private Adherent adherent;
	
	@NotBlank
	@ManyToOne
	private Media media;
	
	@NotBlank
	private String date_emprunt;
	
	@NotBlank
	private String date_retour_prevu;
	
	private String date_retour_effective;
	
	
}
