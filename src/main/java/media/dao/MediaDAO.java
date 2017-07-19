package media.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import adherent.model.Adherent;
import dao.DatabaseHelper;
import dao.GenericDAO;
import media.model.Media;

public class MediaDAO extends GenericDAO<Media>{

	private static MediaDAO dao;
	
	private MediaDAO() {
		super(Media.class);
		
	}
	
	public static MediaDAO instance(){
		if(dao == null)
			dao = new MediaDAO();
		return dao;
	}	
	
	public List<Adherent> listEmprunteur(Media m){
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Adherent> query = em.createQuery(
				"select a " +
				"from Media m " +
				"inner join m.listEmprunt as le " +
				"where le.id=:id ", Adherent.class);
		query.setParameter("id", m.getId());
		List<Adherent> l = query.getResultList();
		return l;
	}
	

}
