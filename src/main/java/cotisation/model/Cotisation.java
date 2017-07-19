package cotisation.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import adherent.model.Adherent;

@Entity
public class Cotisation {
	
	@OneToOne(mappedBy = "cotisation")
	private Adherent adherent;
	
	
	private String date_paiement;
	
	
	private float montant;
}
