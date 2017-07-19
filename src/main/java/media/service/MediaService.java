package media.service;

import java.util.List;

import adherent.model.Adherent;
import media.dao.MediaDAO;
import media.model.Media;

public class MediaService {

	public void creer(Media m){
		MediaDAO mdao = MediaDAO.instance();
		mdao.creer(m);
	}
	
	public List<Adherent> listEmprunteur(Media m){
		MediaDAO mdao = MediaDAO.instance();
		return mdao.listEmprunteur(m);
	}
}
