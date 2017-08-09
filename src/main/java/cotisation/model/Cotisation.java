package cotisation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import adherent.model.Adherent;

@Entity
public class Cotisation {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(mappedBy = "cotisation")
	private Adherent adherent;
	
	
	private String dateCotisation;
	
	
	private Float montant;
}
