package media.service;

import java.util.ArrayList;
import java.util.List;

import adherent.dao.AdherentDAO;
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
	

	
	public List<Media> find(String chaine){
		MediaDAO mdao = MediaDAO.instance();
		List<Media> listA = new ArrayList<Media>();
		List<Media> listTmp = new ArrayList<Media>();
		boolean test = false;
		String[] chaineSplit = chaine.split(" ");
		for(String s : chaineSplit){
			listTmp = new ArrayList<Media>();
			listTmp.addAll(mdao.find(s));
			for(Media a1 : listTmp){
				test = false;
				for(Media a2 : listA){
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
	
	public boolean egalites(Media m1, Media m2){
		return m1.getAuteur().equals(m2.getAuteur()) && m1.getTitre().equals(m2.getTitre()) && m1.getType().equals(m2.getType());
	}
}
