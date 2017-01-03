package model;

public class Etudiant {

	private int idEtudiant;
	private String nomEtudiant;
	private String prenomEtudiant;
	private String dateDN;
	private String adress;
	private String anneeInscription;
	
	public Etudiant() {
		this.idEtudiant = 0;
		this.nomEtudiant = null;
		this.prenomEtudiant = null;
		this.dateDN = null;
		this.adress = null;
		this.anneeInscription = null;
	}
	
	public void setIdEtudiant(int id) {this.idEtudiant = id;}
	
	public void setNomEtudiant(String nom) {this.nomEtudiant = nom;}
	
	public void setPrenomEtudiant(String prenom) {this.prenomEtudiant = prenom;}
	
	public void setDateDN(String date) {this.dateDN = date;}
	
	public void setAdress(String adress) {this.adress = adress;}
	
	public void setAnneeInscription(String annee) {this.anneeInscription = annee;}
	
	public int getIdEtudiant() {return this.idEtudiant;}
	
	public String getNomEtudiant() {return this.nomEtudiant;}
	
	public String getPrenomEtudiant() {return this.prenomEtudiant;}
	
	public String getDateDN() {return this.dateDN;}
	
	public String getAdress() {return this.adress;}
	
	public String getAnneeInscription() {return this.anneeInscription;}
}
