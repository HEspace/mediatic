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
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public String getDate_emprunt() {
		return date_emprunt;
	}

	public void setDate_emprunt(String date_emprunt) {
		this.date_emprunt = date_emprunt;
	}

	public String getDate_retour_prevu() {
		return date_retour_prevu;
	}

	public void setDate_retour_prevu(String date_retour_prevu) {
		this.date_retour_prevu = date_retour_prevu;
	}

	public String getDate_retour_effective() {
		return date_retour_effective;
	}

	public void setDate_retour_effective(String date_retour_effective) {
		this.date_retour_effective = date_retour_effective;
	}

	
}
