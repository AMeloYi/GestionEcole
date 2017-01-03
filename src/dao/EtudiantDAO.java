package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Etudiant;

public class EtudiantDAO{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/gestionEcole";
	static final String USER = "root";
	static final String PASS = "";
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public EtudiantDAO() {
		conn = null;
		stmt = null;
		rs = null;
	}
	
	public void connectionBDD() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ajouterEtudiant(Etudiant etudiant) throws Exception {
		connectionBDD();
		stmt.executeUpdate("INSERT INTO "
				+ "etudiant (nomEtudiant,prenomEtudiant,ddn,adress,anneeInscription) VALUES ('" 
				+ etudiant.getNomEtudiant() + "','" 
				+ etudiant.getPrenomEtudiant() + "','" 
				+ etudiant.getDateDN() + "','" 
				+ etudiant.getAdress() + "','" 
				+ etudiant.getAnneeInscription() + "')");
	}
	
	public boolean siEtudiantExiste(Etudiant etudiant) throws SQLException {
		connectionBDD();
		rs =stmt.executeQuery("SELECT idEtudiant FROM etudiant WHERE idEtudiant="+etudiant.getIdEtudiant());
		while(rs.next()){
			return true;
		}
		return false;
	}
	
	public Etudiant findEtudiant(int id) throws SQLException {
		Etudiant etudiant = new Etudiant();
		connectionBDD();
		rs = stmt.executeQuery("SELECT * FROM etudiant WHERE idEtudiant=" + id);
		while(rs.next()){
			etudiant.setIdEtudiant(rs.getInt("idEtudiant"));
			etudiant.setAdress(rs.getString("adress"));
			etudiant.setNomEtudiant(rs.getString("nomEtudiant"));
			etudiant.setPrenomEtudiant(rs.getString("prenomEtudiant"));
			etudiant.setDateDN(rs.getString("DDN"));
			etudiant.setAnneeInscription(rs.getString("anneeInscription"));
			return etudiant;
		}
		return null;
	}
}
