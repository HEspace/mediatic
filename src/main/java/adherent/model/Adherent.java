package adherent.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import cotisation.model.Cotisation;
import emprunt.model.Emprunt;

@Entity
@Table(name = "adherent")
public class Adherent {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	private String nom;
	
	@NotBlank
	private String prenom;
	
	@NotBlank
	private LocalDate dateNaissance; 
	
	@NotBlank
	private String email;
	
	private String adress;
	
	private String cp;
	
	private String ville;
	
	@OneToOne
	private Cotisation cotisation;
	
	
	@OneToMany(mappedBy = "adherent")
	private List<Emprunt> listEmprunt = new ArrayList<Emprunt>();
	

	
	public Adherent(){
		
	}

	
	public Adherent(@NotBlank String nom, @NotBlank String prenom, @NotBlank LocalDate dateNaissance,
			@NotBlank String email, String adress, String cp, String ville) {
		
			this.nom = nom;
			this.prenom = prenom;
			this.dateNaissance = dateNaissance;
			this.email = email;
				if(adress != ""){
					this.adress = adress;
				}
				if(cp != ""){
				this.cp = cp;
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
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Cotisation getCotisation() {
		return cotisation;
	}

	public void setCotisation(Cotisation cotisation) {
		this.cotisation = cotisation;
	}

	

}
