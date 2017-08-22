package fr.dta.adherent.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import fr.dta.adherent.model.Adherent;
import fr.dta.repository.AbstractJpaRepository;

@Repository
public class AdherentRepository extends AbstractJpaRepository<Adherent> {

@Override
	protected Class<Adherent> getEntityClass() {
		return Adherent.class;
	}

    public List<Adherent> findAdherentNomPrenom(String nom, String prenom){

    }
    
}



