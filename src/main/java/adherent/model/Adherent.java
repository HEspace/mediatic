package adherent.model;

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
	private String dateNaissance; 
	
	@NotBlank
	private String email;
	
	@OneToMany(mappedBy = "adherent")
	private List<Emprunt> listEmprunt;
	
	private String adress;
	
	private String cp;
	
	private String ville;
	
	@OneToOne
	private Cotisation cotisation;
	
	

}
