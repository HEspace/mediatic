package mediatic;

import javax.persistence.EntityManager;

import databaseHelper.DatabaseHelper;

public class Main {
	public static void main(String args[]){
		EntityManager em = DatabaseHelper.createEntityManager();
	}
}
