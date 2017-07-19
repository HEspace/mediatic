package mediatic;

import java.time.LocalDate;

import adherent.dao.AdherentDAO;
import adherent.model.Adherent;
import adherent.service.AdherentService;
import emprunt.service.EmpruntService;
import media.dao.MediaDAO;
import media.model.Media;
import media.model.Type;
import media.service.MediaService;

public class Main {
	public static void main(String args[]){
		
		/*Création Médias*/
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
		
		/*Création adhérents*/
		AdherentService as = new AdherentService();
		
		Adherent a1 = new Adherent("BALTIC", "Husref", "husref.baltic@gmail.com",LocalDate.of(2000,11,24), "", "", "");
		Adherent a2 = new Adherent("EL FILALI", "Hedy", "elfilali.hedy@gmail.com", LocalDate.now(), "", "", "");
		Adherent a3 = new Adherent("SION", "Laurent", "lau.sion@gmail.com", LocalDate.now(), "", "", "");
		Adherent a4 = new Adherent("BENGHAL", "Ayoub", "youbizz@gmail.com", LocalDate.now(), "", "", "");

		as.creer(a1);
		as.creer(a2);
		as.creer(a3);
		as.creer(a4);
		
		/*Création Emprunt*/
		EmpruntService emp = new EmpruntService();
		emp.creer(a1, m1);
		emp.creer(a1, m2);
		emp.creer(a2, m2);
		
//		System.out.println(as.listEmpruntParAdherent(a2));
//		System.out.println(ms.listEmprunteur(m3));
		System.out.println(as.find("e"));
	}
}
