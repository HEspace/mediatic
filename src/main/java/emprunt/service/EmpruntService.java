package emprunt.service;



import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import adherent.model.Adherent;
import emprunt.dao.EmpruntDAO;
import emprunt.model.Emprunt;
import media.model.Media;
import media.model.Type;

public class EmpruntService {
	
	public Emprunt creer(Adherent adherent, Media media ){
		EmpruntDAO emprundDao = EmpruntDAO.instance();
		Emprunt emp = new Emprunt();
		emp.setAdherent(adherent);
		emp.setMedia(media);
		emp.setDateEmprunt(LocalDate.now());
		emp.setDateRetourPrevu(calculDateRetour(media));
		emprundDao.creer(emp);
		return emp;
	}
	
	public LocalDate calculDateRetour(Media media){
		LocalDate today = LocalDate.now();
		if(media.getType() == Type.CD || (media.getType() == Type.DVD))
			return today.plus(15, ChronoUnit.DAYS);
		else
			return today.plus(30, ChronoUnit.DAYS);
	}
	
	public List<Media> listEmpruntParAdherent(Adherent adherent){
		EmpruntDAO emprundDao = EmpruntDAO.instance();
		return emprundDao.listEmpruntParAdherent(adherent);
	}
}
