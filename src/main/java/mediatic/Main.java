package mediatic;

import javax.persistence.EntityManager;

import dao.DatabaseHelper;
import media.model.Media;

public class Main {
	public static void main(String args[]){
		EntityManager em = DatabaseHelper.createEntityManager();
		
		/**Cr�ation M�dias*/
		Media m1 = new Media();
		
	}
}
