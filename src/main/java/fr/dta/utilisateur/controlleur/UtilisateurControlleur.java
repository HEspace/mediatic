package fr.dta.utilisateur.controlleur;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class UtilisateurControlleur{


    


    @RequestMapping("/user")
    @ResponseBody
    public Principal user(Principal user) {
        System.out.println(user.getName());
      return user;
    }

}