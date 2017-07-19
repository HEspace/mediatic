package adherent.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import adherent.model.Adherent;
import dao.DatabaseHelper;
import dao.GenericDAO;
import media.model.Media;

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

	public List<Media> listEmpruntParAdherent(Adherent adherent) {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Media> query = em.createQuery("select m from Adherent a "
													+ "inner join a.listEmprunt e "
													+ "inner join e.media m "
													+ "where a.id=:id",Media.class);
		query.setParameter("id", adherent.getId());
		return query.getResultList();
	}

	public List<Adherent> find(String chaine) {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Adherent> query = em.createQuery("select a "
				+ "from Adherent a "
				+ "where lower(a.prenom) LIKE :chaine "
				+ "or lower(a.nom) LIKE :chaine "
				+ "or a.id=:id",Adherent.class);
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
