package fr.dta.utilisateur.repository;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.repository.AbstractJpaRepository;
import fr.dta.utilisateur.model.Utilisateur;

@Repository
public class UtilisateurRepository extends AbstractJpaRepository<Utilisateur>{


    public Utilisateur getAuthen(String utilisateur, String password){
		Criteria c = getSession().createCriteria(Utilisateur.class);
        c.add(Restrictions.eq("utilisateur",utilisateur));
        Utilisateur u = (Utilisateur) c.uniqueResult();
        if(u != null && !u.getMotDePasse().equals(password))
            u=null;
        return u;
	}
    
    
    @Override
    protected Class<Utilisateur> getEntityClass() {
        // TODO Auto-generated method stub
        return Utilisateur.class;
    }

    public void deleteAll(){
        for (Utilisateur u : this.findAll()) {
            this.delete(u);
        }
    }



    @Transactional
    public void lancementApp(){

    }

}