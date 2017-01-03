package model;

public class Enseignant {
	
	private int idEnseignant;
	private String nomEnseignant;
	private String prenomEnseignant;
	private String dateEntree;
	private double salaire;
	
	public Enseignant() {
		idEnseignant = 0;
		nomEnseignant = null;
		prenomEnseignant = null;
		dateEntree = null;
		salaire = 0;
	}
	
	public void setIdEnseignant(int id) {this.idEnseignant = id;}
	
	public void setNomEnseignant(String nom) {this.nomEnseignant = nom;}
	
	public void setPrenomEnseignant(String prenom) {this.prenomEnseignant = prenom;}
	
	public void setDateEntree(String date) {this.dateEntree = date;}
	
	public void setSalaire(double salaire) {this.salaire = salaire;}
	
	public int getIdEnseignant() {return this.idEnseignant;}
	
	public String getNomEnseignant() {return this.nomEnseignant;}
	
	public String getPrenomEnseignant() {return this.prenomEnseignant;}
	
	public String getDateEntree() {return this.dateEntree;}
	
	public double getSalaire() {return this.salaire;}
	
}
