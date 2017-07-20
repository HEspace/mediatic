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
				"inner join m.listeEmprunt as le " +
				"inner join le.adherent as a " +
				"where m.id=:id ", Adherent.class);
		query.setParameter("id", m.getId());
		List<Adherent> l = query.getResultList();
		return l;
	}

	public List<Media> find(String chaine) {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Media> query = em.createQuery("select m "
				+ "from Media m "
				+ "where lower(m.auteur) LIKE :chaine "
				+ "or lower(m.titre) LIKE :chaine "
				+ "or m.id=:id",Media.class);
		query.setParameter("chaine", "%"+chaine.toLowerCase()+"%");
		try{
			query.setParameter("id", Long.parseLong(chaine));
			return query.getResultList();
		}
		catch(Exception e){
			query.setParameter("id",Long.parseLong("0"));
			return query.getResultList();
		}
	}
	

}
