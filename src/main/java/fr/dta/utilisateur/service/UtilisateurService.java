package fr.dta.utilisateur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dta.utilisateur.model.Utilisateur;
import fr.dta.utilisateur.repository.UtilisateurRepository;

@Service
public class UtilisateurService{

    @Autowired
    UtilisateurRepository ur;

    public Utilisateur getAuthen(String utilisateur, String password){
        return ur.getAuthen(utilisateur, password);
    }

}