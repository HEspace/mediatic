package fr.dta.adherent.repository;

import java.util.List;

import javax.transaction.Transactional;

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
        
    
    @Transactional
    public Adherent findByNom(String prenom,String nom){
        String hql = "select a "
		+ "from Adherent a "
		+ "where a.prenom = :prenom "
		+ "or a.nom = :nom ";
		Query query = getSession().createQuery(hql);
		query.setString("prenom", prenom);
		query.setString("nom", nom);
		Adherent results = (Adherent) query.getSingleResult();
		return results;
    }
    
}
