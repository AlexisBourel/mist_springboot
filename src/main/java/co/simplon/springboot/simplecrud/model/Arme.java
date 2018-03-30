package co.simplon.springboot.simplecrud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "arme")
@Component

public class Arme implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3448346736577150605L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String typeArme;
	
	@Column
	private String typeMunition;
	
	@Column
	private String nomArme;
	
	@Column
	private String numeroSerieArme;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTypeArme() {
		return typeArme;
	}

	public void setTypeArme(String typeArme) {
		this.typeArme = typeArme;
	}

	public String getTypeMunition() {
		return typeMunition;
	}

	public void setTypeMunition(String typeMunition) {
		this.typeMunition = typeMunition;
	}

	public String getNomArme() {
		return nomArme;
	}

	public void setNomArme(String nomArme) {
		this.nomArme = nomArme;
	}

	public String getNumeroSerieArme() {
		return numeroSerieArme;
	}

	public void setNumeroSerieArme(String numeroSerieArme) {
		this.numeroSerieArme = numeroSerieArme;
	}
	
	

}
