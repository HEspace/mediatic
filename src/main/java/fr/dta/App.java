package fr.dta;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;

import fr.dta.adherent.model.Adherent;
import fr.dta.adherent.service.AdherentService;
import fr.dta.emprunt.service.EmpruntService;
import fr.dta.media.model.Media;
import fr.dta.media.model.Type;
import fr.dta.media.service.MediaService;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class App extends SpringBootServletInitializer {

	private static Class appClass = App.class;

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(appClass);
    }


	public static void main(String args[]){
		SpringApplication.run(App.class, args);
		
		
		/*
		MediaService ms = new MediaService();
		
		Media m1 = new Media("Livre1", "Husref BALTIC",Type.LIVRE);
		Media m2 = new Media("CD1", "Laurent SION", Type.CD);
		Media m3 = new Media("DVD1", "Hedy EL FILALI", Type.DVD);
		Media m4 = new Media("Livre2", "Hedy EL FILALI", Type.LIVRE);
		Media m5 = new Media("CD2", "Laurent SION", Type.CD);
		Media m6 = new Media("DVD2", "Husref BALTIC", Type.DVD);

		ms.creer(m1);
		ms.creer(m2);
		ms.creer(m3);
		ms.creer(m4);
		ms.creer(m5);
		ms.creer(m6);
		
		
		AdherentService as = new AdherentService();
		
		Adherent a1 = new Adherent("BALTIC", "Husref", "husref.baltic@gmail.com",LocalDate.of(2000,11,24), "", "", "");
		Adherent a2 = new Adherent("EL FILALI", "Hedy", "elfilali.hedy@gmail.com", LocalDate.now(), "", "", "");
		Adherent a3 = new Adherent("SION", "Laurent", "lau.sion@gmail.com", LocalDate.now(), "", "", "");
		Adherent a4 = new Adherent("BENGHAL", "Ayoub", "youbizz@gmail.com", LocalDate.now(), "", "", "");

		as.creer(a1);
		as.creer(a2);
		as.creer(a3);
		as.creer(a4);
		
		
		EmpruntService emp = new EmpruntService();
		emp.creer(a1, m1);
		emp.creer(a1, m2);
		emp.creer(a2, m2);
		
		//System.out.println(as.listEmpruntParAdherent(a2));
		System.out.println(ms.listEmprunteur(m2));
		for(Adherent adhAff : as.find("Baltic El FILALI")){
			System.out.println(adhAff.getPrenom()+" "+adhAff.getNom());
			
		}
		for(Media meAff : ms.find("Laurent Livre 1")){
			System.out.println(meAff.getAuteur()+" "+meAff.getTitre());
			
		}
		Type i[] = {Type.CD, Type.LIVRE} ;
		for(Media meAff : ms.findMediaType("Husref Laurent EL",i)){
			System.out.println(meAff.getAuteur()+" "+meAff.getTitre());
			
		}
		
		for(Media meAff : ms.listeMediaCD()){
			System.out.println(meAff.getAuteur()+" "+meAff.getTitre());
			
		}
		
		
		
//		System.out.println(as.findID("7").getPrenom() +" " +as.findID("7").getNom());
//		System.out.println(ms.findID("2").getAuteur() +" " +ms.findID("2").getTitre());*/
	}
}
