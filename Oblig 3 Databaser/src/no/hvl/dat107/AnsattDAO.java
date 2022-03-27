package no.hvl.dat107;

import java.util.Map;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class AnsattDAO {
	
	private  EntityManagerFactory emf;

    public AnsattDAO() {
        emf = Persistence.createEntityManagerFactory("oblig3");
    }
    
    public Ansatt finnAnsattMedId(int id) {
		EntityManager em = emf.createEntityManager();
		
		Ansatt a = null;
		
		try {
			a = em.find(Ansatt.class, id);
		} finally {
			em.close();
		}
		return a;
	}
    
    public Ansatt finnAnsattMedBrukernavn(String brukernavn) {
		EntityManager em = emf.createEntityManager();
		
		
		try {
			String q = "SELECT a from Ansatt AS a WHERE a.brukernavn = :brN";
			
			TypedQuery<Ansatt> query = em.createQuery(q, Ansatt.class);
			query.setParameter("brN", brukernavn);
			
			return query.getSingleResult();
			
		} catch(NoResultException e) {
        	return null;
        	
        } finally {
			em.close();
		}
    }
    
    public List<Ansatt> skrivUtAlleAnsatte() {
    	EntityManager em = emf.createEntityManager();
		
		
		try {
			String q = "SELECT a from Ansatt AS a";
			
			TypedQuery<Ansatt> query = em.createQuery(q, Ansatt.class);
			
			return query.getResultList();
			
		} catch(NoResultException e) {
        	return null;
        	
        } finally {
			em.close();
		}
    }
    
    public void oppdaterStilling(int id, String stilling) {
    	EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			
			Ansatt a = em.find(Ansatt.class, id); 
			a.setStilling(stilling);
		
			em.getTransaction().commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
    }
    
    public void oppdaterLonn(int id, int lonn) {
    	EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			
			Ansatt a = em.find(Ansatt.class, id); 
			a.setMndLonn(lonn);
		
			em.getTransaction().commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
    }
    
    public void leggTilAnsatt(Ansatt ansatt) {
    	EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(ansatt);
			tx.commit();
		
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
    }
}
