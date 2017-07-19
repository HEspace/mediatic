package adherent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
	
	private String adress;
	
	private String cp;
	
	private String ville;
	
	@OneToOne
	private Cotisation cotisation;
	
	

}
