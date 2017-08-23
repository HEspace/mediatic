package fr.dta.emprunt.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import fr.dta.adherent.model.Adherent;
import fr.dta.localDateJson.LocalDateDeserializer;
import fr.dta.localDateJson.LocalDateSerializer;
import fr.dta.media.model.Media;
import fr.dta.persistence.IoEntity;

@Entity
@SequenceGenerator(name = "seqBy2", sequenceName="seqBy2", initialValue = 1, allocationSize = 1)
public class Emprunt implements IoEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "seqBy2")
	private Long id;
	
	@NotNull
	@ManyToOne
	private Adherent adherent;
	
	@NotNull
	@ManyToOne
	private Media media;
	
	@NotNull
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dateEmprunt;
	
	//@NotNull
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dateRetourPrevu;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
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
