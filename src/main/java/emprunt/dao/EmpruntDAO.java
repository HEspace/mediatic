package emprunt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import adherent.model.Adherent;
import dao.DatabaseHelper;
import dao.GenericDAO;
import emprunt.model.Emprunt;
import media.model.Media;

public class EmpruntDAO extends GenericDAO<Emprunt> {

	private static EmpruntDAO dao;
	
	private EmpruntDAO() {
        super(Emprunt.class);
    }
	
	public static EmpruntDAO instance() {
        if (dao == null) {
            dao = new EmpruntDAO();
        }
        return dao;
    }

	public List<Media> listEmpruntParAdherent(Adherent adherent) {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Media> query = em.createQuery("",Media.class);
		query.setParameter("id", adherent.getId());
		return query.getResultList();
	}
	
}
