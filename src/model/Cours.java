package model;

public class Cours {

	private int idCours;
	private String nomCours;
	private String description;
	private int enseignant;
	
	public Cours() {
		this.idCours = 0;
		this.nomCours = null;
		this.description = null;
		this.enseignant = 0;
	}
	
	public void setIdCours(int id) {this.idCours = id;}
	
	public void setNomCours(String nom) {this.nomCours = nom;}
	
	public void setDescription(String description) {this.description = description;}
	
	public void setEnseignant(int enseignant) {this.enseignant = enseignant;}
	
	public int getIdCours() {return this.idCours;}
	
	public String getnomCours() {return this.nomCours;}
	
	public String getDescription() {return this.description;}
	
	public int getEnseignant() {return this.enseignant;}
	
}
