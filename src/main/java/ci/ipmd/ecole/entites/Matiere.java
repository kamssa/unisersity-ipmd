package ci.ipmd.ecole.entites;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Matiere {

	@Id
	private String id;
	private String libelle;
	private String code;
	private int credit;
	private String description;
	private int nombreHeure;
	
	public Matiere() {
		super();
	}
	
	public Matiere(String libelle, String code, int credit) {
		super();
		this.libelle = libelle;
		this.code = code;
		this.credit = credit;
	}

	public Matiere(String libelle, String code, int credit, String description) {
		super();
		this.libelle = libelle;
		this.code = code;
		this.credit = credit;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getId() {
		return id;
	}

	public int getNombreHeure() {
		return nombreHeure;
	}

	public void setNombreHeure(int nombreHeure) {
		this.nombreHeure = nombreHeure;
	}
	
	
}
