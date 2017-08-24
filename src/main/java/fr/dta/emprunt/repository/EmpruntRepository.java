package fr.dta.emprunt.repository;

import java.util.List;

import javax.transaction.Transactional;

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

	
	public List<Emprunt> getEmpruntByMedia(Long id_media){
		Criteria c = getSession().createCriteria(Emprunt.class)
		.add(Restrictions.eq("media.id",id_media));
		return (List<Emprunt>) c.list();
	}

	@Transactional
	public List<Emprunt> getEmpruntByAdherent(Long id_adh){
		Criteria c = getSession().createCriteria(Emprunt.class)
		.add(Restrictions.eq("adherent.id", id_adh));
		return (List<Emprunt>) c.list();
	
			
	}


}
