package fr.dta.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import fr.dta.utilisateur.repository.UtilisateurRepository;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent>{


    @Autowired
    UtilisateurRepository ur;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event){
        ur.lancementApp();
    }
}