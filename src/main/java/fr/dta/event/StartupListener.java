package fr.dta.event;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import fr.dta.adherent.model.Adherent;
import fr.dta.adherent.service.AdherentService;
import fr.dta.media.model.Media;
import fr.dta.media.model.Type;
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
        a = as.findByNom("Husref", "Baltic");
        if (a == null){
            as.creer(new Adherent("Baltic", "Husref", "husref.baltic@gouv.com", LocalDate.of(0000, 12, 25), "0001 rue de la seul maison", "00000", "Matignon"));
        }
        a = as.findByNom("Hedy", "El Filaly");
        if (a == null){
            as.creer(new Adherent("El Filaly", "Hedy", "Hedy.ElFilaly@gmail.com", LocalDate.of(2001, 9, 11), "69 Villa Rouge", "34000", "Montpellier"));
        }
        a = as.findByNom("Ayoub", "Benghal");
        if (a == null){
            as.creer(new Adherent("Benghal", "Ayoub", "formation.dta@gmail.com", LocalDate.of(2016, 6, 7), "69 Villa Rouge", "34000", "Montpellier"));
        }
        a = as.findByNom("Abdel", "Noar");
        if (a == null){
            as.creer(new Adherent("Noar", "Abdel", "formation.dta@gmail.com", LocalDate.of(2017, 6, 7), "69 Villa Rouge", "34000", "Montpellier"));
        }
        a = as.findByNom("Diogo", "Monteirro");
        if (a == null){
            as.creer(new Adherent("Monteirro", "Diogo", "formation.dta@gmail.com", LocalDate.of(2017, 6, 7), "69 Villa Rouge", "34000", "Montpellier"));
        }
        a = as.findByNom("Suzanne", "Thomas");
        if (a == null){
            as.creer(new Adherent("Thomas", "Suzanne", "formation.dta@gmail.com", LocalDate.of(2017, 6, 7), "69 Villa Rouge", "34000", "Montpellier"));
        }
        a = as.findByNom("Alex", "Dezier");
        if (a == null){
            as.creer(new Adherent("Dezier", "Alex", "formation.dta@gmail.com", LocalDate.of(2017, 6,7), "69 Villa Rouge", "34000", "Montpellier"));
        }
        a = as.findByNom("Aurelien", "TropFort");
        if (a == null){
            as.creer(new Adherent("TropFort", "Aurelien", "formation.dta@gmail.com", LocalDate.of(2017, 6, 7), "69 Villa Rouge", "34000", "Montpellier"));
        }
        a = as.findByNom("David", "Chépu");
        if (a == null){
            as.creer(new Adherent("Chépu", "David", "formation.dta@gmail.com", LocalDate.of(2017, 6, 7), "69 Villa Rouge", "34000", "Montpellier"));
        }
        a = as.findByNom("Plus", "Abo");
        if (a == null){
            as.creer(new Adherent("Plus", "Abo", "formation.dta@gmail.com", LocalDate.of(2005, 6, 7), "69 Villa Rouge", "34000", "Montpellier"));
        }

        Media m = ms.findID(1l);
        if (m==null){
            ms.creer(new Media("Husref se revolte", "Laurent", Type.LIVRE));
        }
        m = ms.findID(2l);
        if (m==null){
            ms.creer(new Media("Husref vs Macron", "Laurent", Type.LIVRE));
        }
        m = ms.findID(3l);
        if (m==null){
            ms.creer(new Media("Husref President", "Laurent", Type.LIVRE));
        }
        m = ms.findID(4l);
        if (m==null){
            ms.creer(new Media("Dictature Baltic", "Hedy", Type.LIVRE));
        }
        m = ms.findID(5l);
        if (m==null){
            ms.creer(new Media("Echec : Abdel vs Hedy", "Husref", Type.DVD));
        }
        m = ms.findID(6l);
        if (m==null){
            ms.creer(new Media("Abdel chante", "Abdel", Type.CD));
        }
        m = ms.findID(7l);
        if (m==null){
            ms.creer(new Media("Les tomates violettes", "Suzanne", Type.LIVRE));
        }
        m = ms.findID(8l);
        if (m==null){
            ms.creer(new Media("Comment découvrir les plaisirs solitaire", "Husref", Type.CD));
        }
        m = ms.findID(9l);
        if (m==null){
            ms.creer(new Media("H - la série", "Hedy", Type.DVD));
        }
        m = ms.findID(10l);
        if (m==null){
            ms.creer(new Media("Games of Thrones", "Laurent", Type.LIVRE));
        }


    }
}