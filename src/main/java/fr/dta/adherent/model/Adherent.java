package fr.dta.adherent.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotNull;

import fr.dta.cotisation.model.Cotisation;
import fr.dta.emprunt.model.Emprunt;
import fr.dta.localDateJson.LocalDateDeserializer;
import fr.dta.localDateJson.LocalDateSerializer;
import fr.dta.persistence.IoEntity;

@Entity
@Table(name = "adherent")
public class Adherent implements IoEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	private String nom;
	
	@NotBlank
	private String prenom;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@NotNull
	private LocalDate dateNaissance; 
	
	@NotBlank
	private String email;
	
	private String rue;
	
	private String codePostale;
	
	private String ville;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dateCotisation;
	
	
	private Float montant;
	
	@OneToMany(mappedBy = "adherent")
	private List<Emprunt> listEmprunt = new ArrayList<Emprunt>();
	

	
	public Adherent(){
		
	}

	
	public Adherent(@NotBlank String nom, @NotBlank String prenom,
			@NotBlank String email, @NotBlank LocalDate dateNaissance , String rue, String codePostale, String ville) {
		
			this.nom = nom;
			this.prenom = prenom;
			this.dateNaissance = dateNaissance;
			this.email = email;
				if(rue != ""){
					this.rue = rue;
				}
				if(codePostale != ""){
				this.codePostale = codePostale;
				}
				if(ville != ""){
				this.ville = ville;
				}
		
			
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Emprunt> getListEmprunt() {
		return listEmprunt;
	}

	public void setListEmprunt(List<Emprunt> listEmprunt) {
		this.listEmprunt = listEmprunt;
	}

	public String getAdress() {
		return rue;
	}

	public void setAdress(String adress) {
		this.rue = adress;
	}

	public String getCp() {
		return codePostale;
	}

	public void setCp(String cp) {
		this.codePostale = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Float getMontant(){
		return this.montant;
	}

	public void setMontant(Float montant){
		this.montant = montant;
	}

	public void setDateCotisation(LocalDate date){
		this.dateCotisation = date;
	}

	public LocalDate getDateCotisation(){
		return this.dateCotisation;
	}

	

}

