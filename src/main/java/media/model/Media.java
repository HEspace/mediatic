package media.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import emprunt.model.Emprunt;



@Entity
public class Media {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	private String titre;
	
	@NotBlank
	private String auteur;
	
	@NotBlank
	private Type type;
	
	@OneToMany(mappedBy = "media")
	private List<Emprunt> listeEmprunt = new ArrayList<Emprunt>();

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
