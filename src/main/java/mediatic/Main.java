package mediatic;

import javax.persistence.EntityManager;

import adherent.model.Adherent;
import dao.DatabaseHelper;
import media.dao.MediaDAO;
import media.model.Media;
import media.model.Type;
import media.service.MediaService;

public class Main {
	public static void main(String args[]){
		
		MediaDAO mediadao = MediaDAO.instaceof();
		
		
		/**Création Médias*/
		MediaService ms = new MediaService();
		
		mediadao.creer(ms.creer("Livre1", "Husref BALTIC",Type.LIVRE));
		mediadao.creer(ms.creer("CD1", "Laurent SION", Type.CD));
		mediadao.creer(ms.creer("DVD1", "Hedy EL FILALI", Type.DVD));
		mediadao.creer(ms.creer("Livre2", "Hedy EL FILALI", Type.LIVRE));
		mediadao.creer(ms.creer("CD2", "Laurent SION", Type.CD));
		mediadao.creer(ms.creer("DVD2", "Husref BALTIC", Type.DVD));

		/**Création adhérents*/
		Adherent a1 = new Adherent();
		a1.setNom("BALTIC");
		a1.setPrenom("Husref");
		a1.setDateNaissance("11/05/1991");
		a1.setEmail("husref.baltic@gmail.com");
		
		Adherent a2 = new Adherent();
		a2.setNom("EL FILALI");
		a2.setPrenom("Hedy");
		a2.setDateNaissance("20/14/1877");
		a2.setEmail("elfilali.hedy@gmail.com");
		
		Adherent a3 = new Adherent();
		a3.setNom("SION");
		a3.setPrenom("Laurent");
		a3.setDateNaissance("18/07/1900");
		a3.setEmail("lau.sion@gmail.com");
		
		Adherent a4 = new Adherent();
		a4.setNom("BENGHAL");
		a4.setPrenom("Ayoub");
		a4.setDateNaissance("02/12/1515");
		a4.setEmail("youbizz@gmail.com");
		
	}
}
