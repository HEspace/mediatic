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
        this.deleteAll();
        Utilisateur u1 = new Utilisateur();
        u1.setDroit(100);
        u1.setMotDePasse("password");
        u1.setUtilisateur("Hedy");
        Utilisateur u2 = new Utilisateur();
        u2.setDroit(100);
        u2.setMotDePasse("password");
        u2.setUtilisateur("Laurent");
        Utilisateur u3 = new Utilisateur();
        u3.setDroit(100);
        u3.setMotDePasse("password");
        u3.setUtilisateur("Husref");
        Utilisateur u4 = new Utilisateur();
        u4.setDroit(50);
        u4.setMotDePasse("password");
        u4.setUtilisateur("demi");
        Utilisateur u5 = new Utilisateur();
        u5.setDroit(0);
        u5.setMotDePasse("password");
        u5.setUtilisateur("zero");

        this.save(u1);
        this.save(u2);
        this.save(u3);
        this.save(u4);
        this.save(u5);

    }

}