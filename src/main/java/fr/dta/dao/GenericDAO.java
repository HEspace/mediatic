package fr.dta.dao;

import javax.persistence.EntityManager;

public class GenericDAO<T> {
	
	private Class<T> cl;
	
	public GenericDAO(Class<T> cl){
		this.cl = cl;
	}
	
	public T creer(T obj){
		EntityManager em = DatabaseHelper.createEntityManager();
		try{
			
			DatabaseHelper.beginTx(em);
			em.persist(obj);
			DatabaseHelper.commitTxAndClose(em);
			
			
		}catch(Exception e){
			DatabaseHelper.rollbackTxAndClose(em);
			throw new RuntimeException(e);
		}
		return obj;
	}

	public T modifier(T obj){
		EntityManager em = DatabaseHelper.createEntityManager();
		try{
			
			DatabaseHelper.beginTx(em);
			em.merge(obj);
			DatabaseHelper.commitTxAndClose(em);
			
			
		}catch(Exception e){
			DatabaseHelper.rollbackTxAndClose(em);
			throw new RuntimeException(e);
		}
		return obj;
	}
	
}
