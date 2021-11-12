package jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Position implements Serializable {
	@Id @GeneratedValue
	private long id;

	double latitude;
	double longitude;
	String emplacement;
	String etat; 
	


	public Position() {
	}
	
	public Position(	double latitude,	double longitude,	String emplacement,	String etat ) {
		this.emplacement = emplacement;
		this.latitude = latitude;
		this.emplacement = emplacement;
		this.etat = etat;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public long getId() {
		return id;
	}

}
