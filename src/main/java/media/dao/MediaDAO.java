package media.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import adherent.model.Adherent;
import dao.DatabaseHelper;
import dao.GenericDAO;
import media.model.Media;
import media.model.Type;

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
				+ "or lower(m.titre) LIKE :chaine ",Media.class);
		query.setParameter("chaine", "%"+chaine.toLowerCase()+"%");
		return query.getResultList();
	}

	public Media findId(Long id) {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Media> query = em.createQuery("select m "
				+ "from Media m "
				+ "where m.id = :id ",Media.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	public List<Media> listeMediaDVD(){
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Media> query = em.createQuery("select m "
				+ "from Media m "
				+ "where m.type = 0 ",Media.class);
		return query.getResultList();
	}
	
	public List<Media> listeMediaLivre(){
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Media> query = em.createQuery("select m "
				+ "from Media m "
				+ "where m.type = 2 ",Media.class);
		return query.getResultList();
	}
	
	public List<Media> listeMediaCD(){
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Media> query = em.createQuery("select m "
				+ "from Media m "
				+ "where m.type = 1 ",Media.class);
		return query.getResultList();
	}

	public List<Media> findMediaType(String chaine, Type[] tab) {
		EntityManager em = DatabaseHelper.createEntityManager();
		String req ="select m ";
		req += "from Media m ";
		req += "where (m.titre LIKE :chaine or m.auteur LIKE :chaine) and (m.type = :type1 ";
		if(tab.length > 1){
			req += "or m.type = :type2) ";
			TypedQuery<Media> query = em.createQuery(req,Media.class);
			query.setParameter("type1", tab[0]);
			query.setParameter("type2", tab[1]);
			query.setParameter("chaine", "%"+chaine+"%");
			return query.getResultList();
		}
		req += ")";
		TypedQuery<Media> query = em.createQuery(req,Media.class);
		query.setParameter("type1", tab[0]);
		query.setParameter("chaine", "%"+chaine+"%");
		return query.getResultList();
		
	}
	

}
