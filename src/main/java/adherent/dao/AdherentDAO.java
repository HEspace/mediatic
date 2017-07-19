package adherent.dao;

import adherent.model.Adherent;
import dao.GenericDAO;

public class AdherentDAO extends GenericDAO<Adherent>  {
	
	private static AdherentDAO dao;
	
	private AdherentDAO(){
		super(Adherent.class);
	}
 
	public static AdherentDAO instance(){
		if (dao == null) {
			dao = new AdherentDAO();
		}
		return dao;
	}
	
}
