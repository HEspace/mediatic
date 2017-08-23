package fr.dta.media.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;


import fr.dta.emprunt.model.Emprunt;
import fr.dta.persistence.IoEntity;



@Entity
@SequenceGenerator(name = "seq_by1", sequenceName="seq_by1", initialValue = 1, allocationSize = 1)
public class Media implements IoEntity {

	@Id
	@GeneratedValue(generator = "seq_by1")
	private Long id;
	
	@NotNull
	private String titre;
	
	@NotNull
	private String auteur;
	
	@NotNull
	private Type type;
	
	@JsonIgnore
	@OneToMany(mappedBy = "media")
	private List<Emprunt> listeEmprunt = new ArrayList<Emprunt>();

	
	
	public List<Emprunt> getListeEmprunt() {
		return listeEmprunt;
	}

	public void setListeEmprunt(List<Emprunt> listeEmprunt) {
		this.listeEmprunt = listeEmprunt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public Media(String titre, String auteur, Type type) {
		this.titre = titre;
		this.auteur = auteur;
		this.type = type;
	}
	
	public Media(){}


	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	
}
