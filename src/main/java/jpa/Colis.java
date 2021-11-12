package jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Representation d'une mesure.
 * 
 * Il s'agit d'une mesure de temperature dans une piece donnee a une date donnee.
 * 
 * @author Stephane
 *
 */
@Entity
public class Colis implements Serializable {
	/**
	 * Identifiant de la mesure (unique).
	 * 
	 * Il s'agit de la clef primaire associee a l'objet persistant.
	 * S'il est nul, il sera genere lors de l'ajout de la mesure dans la base de donnees.
	 */
	@Id @GeneratedValue
	private long id;

	private double Poid;
	private double valeur;
	private String origine;
	private String destination;
	//private Position position;
	

	public Colis() {
	}
	
	/**
	 * Contructeur permetant de creer un nouveau colis
	 * 
	 */
	public Colis(double poi , double valeur, String origin,String destination,Position position) {
		this.Poid = poi;
		this.valeur = valeur;
		this.origine = origin;
		this.destination = destination;
		//this.position = position;
	}

	public long getId() {
		return id;
	}

	public double getPoid() {
		return Poid;
	}

	public void setPoid(double poid) {
		Poid = poid;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Position getPosition() {
		return null;
		//return position;
	}

	public void setPosition(Position position) {
		//this.position = position;
	}

}
