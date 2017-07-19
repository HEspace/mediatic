package adherent.service;

import adherent.dao.AdherentDAO;
import adherent.model.Adherent;


public class AdherentService {
	
	
	public void creer(Adherent adh){
		AdherentDAO adao = AdherentDAO.instance(); 
		adao.creer(adh);
		
	}
	
	


}
