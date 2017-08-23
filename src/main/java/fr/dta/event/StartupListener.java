package fr.dta.event;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import fr.dta.adherent.model.Adherent;
import fr.dta.adherent.service.AdherentService;
import fr.dta.media.service.MediaService;


@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    MediaService ms;

    @Autowired
    AdherentService as;


    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event){
        Adherent a = as.findByNom("Laurent", "Sion");
        if (a == null){
            as.creer(new Adherent("Sion", "Laurent", "lau.sion@gmail.com", LocalDate.of(1988, 4, 5), "134 rue jean jaures", "59172", "Roeulx"));
        }
        /* a = as.findByNom("Husref", "Baltic");
        if (a == null){
            as.creer(new Adherent("Baltic", "Husref", "husref.baltic@gouv.com", LocalDate.of(0000, 12, 25), "0001 rue de la seul maison", "00000", "Matignon"));
        } */
    }
}