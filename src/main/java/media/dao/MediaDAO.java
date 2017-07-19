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
	
	public Media listEmprunteur(Media m){
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Media> query = em.createQuery(
				"select m " +
				"from Media m " +
				"inner join fetch m.listEmprunt" +
				"where m.id=:id ", Media.class);
		query.setParameter("id", m.getId());
		Media media = query.getSingleResult();
		return media;
	}
	

}
