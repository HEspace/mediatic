package fr.dta.emprunt.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import fr.dta.adherent.model.Adherent;
import fr.dta.media.model.Media;
import fr.dta.persistence.IoEntity;

@Entity
public class Emprunt implements IoEntity{
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@ManyToOne
	private Adherent adherent;
	
	@NotNull
	@ManyToOne
	private Media media;
	
	@NotNull
	private LocalDate dateEmprunt;
	
	@NotNull
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
