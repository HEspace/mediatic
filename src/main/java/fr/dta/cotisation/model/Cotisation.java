package fr.dta.cotisation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import fr.dta.adherent.model.Adherent;

@Entity
public class Cotisation {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	private String dateCotisation;
	
	
	private Float montant;
}
