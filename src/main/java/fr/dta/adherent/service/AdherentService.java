package fr.dta.adherent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dta.adherent.dao.AdherentDAO;
import fr.dta.adherent.model.Adherent;
import fr.dta.adherent.repository.AdherentRepository;
import fr.dta.media.model.Media;
import fr.dta.media.model.Type;

@Service
public class AdherentService {

	@Autowired
	AdherentRepository ar;
	
	
	public void creer(Adherent adh){
		if(adh.getCompteur() == null)
			adh.setCompteur(0);
		ar.save(adh);		
	}
	
	public List<Adherent> getAllAdherent(){
		return ar.findAll();
	}
	
	public List<Adherent> find(String chaine){
		return ar.findAdherentNomPrenom(chaine);
	}
	
	public List<Adherent> findID(Long id){
		return ar.findById(id);
	}
	
	
	public Adherent findOne(Long id){
		return ar.findOne(id);
	}
	
	public Adherent findByNom(String prenom,String nom){
		return ar.findByNom(prenom,nom);
	}
	
	public boolean egalites(Adherent a1, Adherent a2){
		return a1.getNom().equals(a2.getNom()) && a1.getPrenom().equals(a2.getPrenom());
	}


}
