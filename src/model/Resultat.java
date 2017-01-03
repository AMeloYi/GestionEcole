package model;

public class Resultat {

	private Cours cours;
	private Etudiant etudiant;
	private String dateResultat;
	private int note;
	
	public Resultat() {
		this.cours = null;
		this.etudiant = null;
		this.dateResultat = null;
		this.note = 0;
	}
	
	public void setCours(Cours cours) {this.cours = cours;}
	
	public void setEtudiant(Etudiant etudiant) {this.etudiant = etudiant;}
	
	public void setDateResultat(String date) {this.dateResultat = date;}
	
	public void setNote(int note) {this.note = note;}
	
	public Cours getCours() {return this.cours;}
	
	public Etudiant getEtudiant() {return this.etudiant;}
	
	public String getDateResultat() {return this.dateResultat;}
	
	public int getNote() {return this.note;}
}
