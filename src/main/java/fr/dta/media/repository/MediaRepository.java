package fr.dta.media.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import fr.dta.media.model.Media;
import fr.dta.media.model.Type;
import fr.dta.repository.AbstractJpaRepository;

@Transactional
@Repository
public class MediaRepository extends AbstractJpaRepository<Media> {


	@Transactional
	@Override
	protected Class<Media> getEntityClass() {
		// TODO Auto-generated method stub
		return Media.class;
	}

	public List<Media> listeMediaDVD(){
		Criteria c = getSession().createCriteria(Media.class);
		c.add(Restrictions.eq("type",Type.DVD));
		return (List<Media>) c.list();
	}

	public List<Media> listeMediaCD(){
		Criteria c = getSession().createCriteria(Media.class);
		c.add(Restrictions.eq("type",Type.CD));
		return (List<Media>) c.list();
	}

	public List<Media> listeMediaLivre(){
		Criteria c = getSession().createCriteria(Media.class);
		c.add(Restrictions.eq("type",Type.LIVRE));
		return (List<Media>) c.list();
	}
	
	public List<Media> findMediaType(String chaine, Type[] tab) {
		String req ="select m ";
		req += "from Media m ";
		req += "where (lower(m.titre) LIKE :chaine or lower(m.auteur) LIKE :chaine) and (m.type = :type1 ";
		if(tab.length > 1){
			req += "or m.type = :type2) ";
			Query query = getSession().createQuery(req);
			query.setParameter("type1", tab[0]);
			query.setParameter("type2", tab[1]);
			query.setParameter("chaine", "%"+chaine.toLowerCase()+"%");
			List<Media> results = query.list();
			return results;
		}
		req += ")";
		Query query = getSession().createQuery(req);
		query.setParameter("type1", tab[0]);
		query.setParameter("chaine", "%"+chaine.toLowerCase()+"%");
		List<Media> results = query.list();
		return results;
	}

	public List<Media> find(String chaine) {
		String hql = "select m "
		+ "from Media m "
		+ "where lower(m.auteur) LIKE :chaine "
		+ "or lower(m.titre) LIKE :chaine ";
		Query query = getSession().createQuery(hql);
		query.setString("chaine", "%"+chaine.toLowerCase()+"%");
		List<Media> results = query.list();
		return results;
	}

}