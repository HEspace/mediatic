package fr.dta.utilisateur.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.utilisateur.model.Utilisateur;
import fr.dta.utilisateur.service.UtilisateurService;

@RestController
@RequestMapping("/private/login")
public class UtilisateurControlleur{


    @Autowired
    UtilisateurService us;

    @RequestMapping(value ="/{utilisateur}/{password}",  method = RequestMethod.GET)
    public Utilisateur getAuthen(@PathVariable String utilisateur, @PathVariable String password){
        return us.getAuthen(utilisateur, password);
    }

}