package adherent.service;

import java.util.ArrayList;
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
	
	public Adherent findID(String chaine){
		AdherentDAO adherentDao = AdherentDAO.instance();
		Long id ;
		try{
			id = Long.parseLong(chaine);
			return adherentDao.findId(id);
		}
		catch(Exception e){
			return adherentDao.findId(Long.parseLong("0"));
		}
	}
	
	public boolean egalites(Adherent a1, Adherent a2){
		return a1.getNom().equals(a2.getNom()) && a1.getPrenom().equals(a2.getPrenom());
	}


}
