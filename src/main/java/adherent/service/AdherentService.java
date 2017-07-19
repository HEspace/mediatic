package adherent.service;

import java.util.List;

import adherent.dao.AdherentDAO;
import adherent.model.Adherent;
import media.model.Media;


public class AdherentService {
	
	
	public void creer(Adherent adh){
		AdherentDAO adao = AdherentDAO.instance(); 
		adao.creer(adh);
		
	}
	
	public List<Media> listEmpruntParAdherent(Adherent adherent){
		AdherentDAO adherentDao = AdherentDAO.instance();
		return adherentDao.listEmpruntParAdherent(adherent);
	}


}
