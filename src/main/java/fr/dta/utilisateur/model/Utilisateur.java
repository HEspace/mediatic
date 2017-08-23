package fr.dta.utilisateur.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import fr.dta.persistence.IoEntity;



@Entity
@SequenceGenerator(name = "seq_by2", sequenceName="seq_by2", initialValue = 1, allocationSize = 1)
public class Utilisateur implements IoEntity{
    
    @Id
    @GeneratedValue(generator = "seq_by2")
    private Long id;


    private String utilisateur;


    private String motDePasse;


    private Integer droit;



    /**
     * @return the droit
     */
    public Integer getDroit() {
        return droit;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the motDePasse
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * @return the utilisateur
     */
    public String getUtilisateur() {
        return utilisateur;
    }

    /**
     * @param droit the droit to set
     */
    public void setDroit(Integer droit) {
        this.droit = droit;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param motDePasse the motDePasse to set
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    /**
     * @param utilisateur the utilisateur to set
     */
    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }





}