package fr.dta.adherent.repository;

import java.util.List;


import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import fr.dta.adherent.model.Adherent;
import fr.dta.repository.AbstractJpaRepository;

@Repository
public class AdherentRepository extends AbstractJpaRepository<Adherent> {

@Override
	protected Class<Adherent> getEntityClass() {
		return Adherent.class;
	}


// Recherche un Adhérent par Nom et Prenom
    public List<Adherent> findAdherentNomPrenom(String chaine){
        String req ="select a";
        req += "from Adherent a";
        req += "where lower(a.nom) LIKE :chaine or lower(a.prenom) LIKE :chaine";
        Query query = getSession().createQuery(req);
        query.setString("chaine", "%"+chaine+"%");
        List<Adherent> results = query.list();
        return results;
    }

    	
    
}
