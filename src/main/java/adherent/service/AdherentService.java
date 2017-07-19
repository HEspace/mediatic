package adherent.service;

import adherent.model.Adherent;
import cotisation.model.Cotisation;

public class AdherentService {
	
	public Adherent cree(String nom, String prenom, String Email, String DateNaissance,
			String adress, String cp, String ville, Cotisation cotisation){
		Adherent ad = new Adherent();
		ad.setNom(nom);
		ad.setPrenom(prenom);
		ad.setEmail(Email);
		ad.setDateNaissance(DateNaissance);
		ad.setAdress(adress);
		ad.setCp(cp);
		ad.setVille(ville);
		ad.setCotisation(cotisation);
		return ad;

		
	}
	


}
