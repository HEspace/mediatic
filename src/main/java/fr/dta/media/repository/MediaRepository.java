package fr.dta.media.repository;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import fr.dta.media.model.Media;
import fr.dta.repository.AbstractJpaRepository;


@Repository
public class MediaRepository extends AbstractJpaRepository<Media> {


	@Override
	protected Class<Media> getEntityClass() {
		// TODO Auto-generated method stub
		return Media.class;
    }
}