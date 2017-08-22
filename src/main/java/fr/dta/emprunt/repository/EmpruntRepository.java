package fr.dta.emprunt.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import fr.dta.emprunt.model.Emprunt;
import fr.dta.media.model.Media;
import fr.dta.media.model.Type;
import fr.dta.repository.AbstractJpaRepository;

@Repository
public class EmpruntRepository extends AbstractJpaRepository<Emprunt> {

	@Override
	protected Class<Emprunt> getEntityClass() {
		return Emprunt.class;
	}

	
	public List<Emprunt> getAllEmprunt(){
		Criteria c = getSession().createCriteria(Emprunt.class);
		return (List<Emprunt>) c.list();
	}
	
	public List<Emprunt> getEmpruntByMedia(int id_media){
		Criteria c = getSession().createCriteria(Emprunt.class)
		.add(Restrictions.eq("media_id",id_media));
		return (List<Emprunt>) c.list();
	}

	public List<Emprunt> getEmpruntByAdherent(int id_adh){
		Criteria c = getSession().createCriteria(Emprunt.class)
		.add(Restrictions.eq("adherent_id",id_adh));
		return (List<Emprunt>) c.list();
	}

}
