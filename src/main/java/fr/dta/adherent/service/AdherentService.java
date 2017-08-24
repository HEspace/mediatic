package fr.dta.adherent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dta.adherent.dao.AdherentDAO;
import fr.dta.adherent.model.Adherent;
import fr.dta.adherent.repository.AdherentRepository;
import fr.dta.media.model.Media;

@Service
public class AdherentService {

	@Autowired
	AdherentRepository ar;
	
	
	public void creer(Adherent adh){
		ar.save(adh);		
	}
	
	public List<Adherent> getAllAdherent(){
		return ar.findAll();
	}
	
	public List<Media> listEmpruntParAdherent(Adherent adherent){
		AdherentDAO adherentDao = AdherentDAO.instance();
		return adherentDao.listEmpruntParAdherent(adherent);
	}
	
	public List<Adherent> find(String chaine){
		AdherentDAO adherentDao = AdherentDAO.instance();
		List<Adherent> listA = new ArrayList<Adherent>();
		List<Adherent> listTmp = new ArrayList<Adherent>();
		boolean test = false;
		String[] chaineSplit = chaine.split(" ");
		for(String s : chaineSplit){
			listTmp = new ArrayList<Adherent>();
			listTmp.addAll(adherentDao.find(s));
			for(Adherent a1 : listTmp){
				test = false;
				for(Adherent a2 : listA){
					if(egalites(a1, a2)){
						test=true;
						break;
					}
				}
				if(!test) listA.add(a1);
			}
		}
		return listA;
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
