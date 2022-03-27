package no.hvl.dat107;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AvdelingDAO {
	
	private  EntityManagerFactory emf;

    public AvdelingDAO() {
        emf = Persistence.createEntityManagerFactory("oblig3");
    }
    
    public Avdeling finnAvdelingMedId(int id) {
    	EntityManager em = emf.createEntityManager();
		
		Avdeling a = null;
		
		try {
			a = em.find(Avdeling.class, id);
		} finally {
			em.close();
		}
		return a;
    }
    
    public List<Avdeling> skrivUtAlleAnsatteFraAvdeling(int avdelingsId) {
    	EntityManager em = emf.createEntityManager();
		
		
		try {
			String q = "SELECT a FROM Avdeling AS a WHERE a.avdelingId = :avdId";
			//String q = "SELECT a.sjef FROM Avdeling AS a WHERE a.avdelingId = :avdId";
			
			TypedQuery<Avdeling> query = em.createQuery(q, Avdeling.class);
			query.setParameter("avdId", avdelingsId);
			
			return query.getResultList();
			
		} catch(NoResultException e) {
        	return null;
        	
        } finally {
			em.close();
		}
    }
    
    public boolean oppdaterAvdeling(int id, int avdeling) {
    	
    	//Metoden funker ikke som den skal
    	
    	EntityManager em = emf.createEntityManager();
    	
    	boolean oppdatert = false;

		try {
			em.getTransaction().begin();
			
			Ansatt a = em.find(Ansatt.class, id); 
			Avdeling nyAvdeling = finnAvdelingMedId(avdeling);
			
			Avdeling naaAvdeling = a.getAvdeling();
			
			
			if (naaAvdeling.getSjef() != id/*ikke sjef*/) {					
				a.setAvdeling(nyAvdeling);
				em.getTransaction().commit();
				
				oppdatert = true;
			}
			
			
		} catch (Throwable e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return oppdatert;
    }
    
    public Avdeling lagreNyAvdeling(String navnPaaNyAvdeling, Ansatt sjef) {
    	
    	//Metoden funker ikke helt som den skal
    	
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Avdeling nyAvdeling = null;
        
        try {
            tx.begin();
            
            Avdeling gammelAvdeling = sjef.getAvdeling();
            gammelAvdeling.fjernAnsatt(sjef);
            em.merge(gammelAvdeling);
            int sjefId = sjef.getAnsattId();
            
            nyAvdeling = new Avdeling();
            nyAvdeling.setAvdeling(navnPaaNyAvdeling);
            nyAvdeling.setSjef(sjefId);
            nyAvdeling.leggTilAnsatt(sjef);
            
            em.persist(nyAvdeling);
                       
            sjef.setAvdeling(nyAvdeling);
            em.merge(sjef);           
            
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        return nyAvdeling;
    }
}
