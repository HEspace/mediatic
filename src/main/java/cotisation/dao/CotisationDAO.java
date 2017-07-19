package cotisation.dao;

import cotisation.model.Cotisation;
import dao.GenericDAO;


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
