package fr.dta.cotisation.dao;

import fr.dta.cotisation.model.Cotisation;
import fr.dta.dao.GenericDAO;


public class CotisationDAO extends GenericDAO<Cotisation>{
	
	public static CotisationDAO dao;
	
	private CotisationDAO(){
		super(Cotisation.class);
	}
	
	public static CotisationDAO instance() {
        if (dao == null) {
            dao = new CotisationDAO();
        }
        return dao;
    }
}
