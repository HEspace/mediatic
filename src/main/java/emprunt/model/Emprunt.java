package emprunt.model;

import java.time.LocalDate;
import java.util.Date;

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
	private LocalDate dateEmprunt;
	
	@NotBlank
	private LocalDate dateRetourPrevu;
	
	private LocalDate dateRetourEffective;
	
	

	public Emprunt(){
		
	}

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

	public LocalDate getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(LocalDate dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public LocalDate getDateRetourPrevu() {
		return dateRetourPrevu;
	}

	public void setDateRetourPrevu(LocalDate dateRetourPrevu) {
		this.dateRetourPrevu = dateRetourPrevu;
	}

	public LocalDate getDateRetourEffective() {
		return dateRetourEffective;
	}

	public void setDateRetourEffective(LocalDate dateRetourEffective) {
		this.dateRetourEffective = dateRetourEffective;
	}
	
}
