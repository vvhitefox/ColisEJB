package ejb;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import jpa.Colis;
import jpa.Mesure;
import jpa.Position;

@Stateless
@LocalBean
public class EJBColis {
	@PersistenceContext
	private EntityManager em;
	
	
	/**
	 * Constructeur sans parametre obligatoire
	 */
	public EJBColis() {
	}
	
	public Colis addColis(double poid,double valeur,String origin,String destination,Position p ) {
		Colis m = new Colis(poid, valeur, origin, destination, p);
		em.persist(m);
		em.flush();
		em.refresh(m);
		return m;
	}
 
	public Colis findColis(long id) {
		Colis m = em.find(Colis.class, id);
		return m;
	}
	
	public Position changePosition(long ColisId,double longitude,double lat,String origin,String destination) {
		Position m = new Position(longitude,lat, origin, destination);
		Colis c = findColis(ColisId);
		c.setPosition(m);
		em.persist(c);
		em.flush();
		return m;
	}
	
	public Position findPosition(long id) {
		Position m = em.find(Position.class, id);
		return m;
	}
	/**
	 * Ajout d'une nouvelle mesure.
	 * 
	 * @param piece piece ou la mesure a ete faite
	 * @param val temprerature mesuree
	 * @return mesure ajoutee dans la base
	 */



}