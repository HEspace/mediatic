package fr.dta.emprunt.service;



import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dta.adherent.model.Adherent;
import fr.dta.adherent.service.AdherentService;
import fr.dta.emprunt.dao.EmpruntDAO;
import fr.dta.emprunt.model.Emprunt;
import fr.dta.emprunt.repository.EmpruntRepository;
import fr.dta.media.dao.MediaDAO;
import fr.dta.media.model.Media;
import fr.dta.media.model.Type;

@Service
public class EmpruntService {

	@Autowired
	private EmpruntRepository er;
	
	@Autowired
	private AdherentService as;
	
	
	public void creer(Emprunt e){
		if(e.getDateRetourEffective() == null){
			if(e.getMedia().getType() == Type.LIVRE)
				e.setDateRetourPrevu(e.getDateEmprunt().plusDays(30));
			else
				e.setDateRetourPrevu(e.getDateEmprunt().plusDays(15));
			e.getAdherent().setCompteur(e.getAdherent().getCompteur()+1);
			as.creer(e.getAdherent());
			er.save(e);
		}
		else{
			System.out.println(e.getId());
			er.save(e);
		}
	}
	
	public List<Emprunt> getAllEmprunt(){
		return er.findAll();
	}
	
	public List<Emprunt> listEmpruntByAdherent(Long id_adh){
		return er.getEmpruntByAdherent(id_adh);
	}
	
	
	public List<Emprunt> listEmprunteurByMedia(Long id_media){
		return er.getEmpruntByMedia(id_media);
	}
	
	
	public LocalDate calculDateRetour(Media media){
		LocalDate today = LocalDate.now();
		if(media.getType() == Type.CD || (media.getType() == Type.DVD))
			return today.plus(15, ChronoUnit.DAYS);
		else
			return today.plus(30, ChronoUnit.DAYS);
	}
	
}
