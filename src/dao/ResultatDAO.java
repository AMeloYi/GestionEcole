package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Cours;
import model.Etudiant;
import model.Resultat;

public class ResultatDAO {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/gestionEcole";
	static final String USER = "root";
	static final String PASS = "";
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public ResultatDAO() {
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
	
	public void ajouterEtudiantParCours(Resultat resultat) throws SQLException {
		connectionBDD();
		stmt.executeUpdate("INSERT INTO "
				+ "resultat (idetudiant,idcours) "
				+ "VALUES (" 
				+ resultat.getEtudiant().getIdEtudiant() + "," 
				+ resultat.getCours().getIdCours() + ")");
	}
	
	public void ajouterNote(Resultat resultat) throws SQLException {
		connectionBDD();
		stmt.executeUpdate("UPDATE resultat SET"
				+ " dateResultat='" + resultat.getDateResultat() + "',"
				+ "note=" + resultat.getNote() 
				+ " WHERE idCours=" + resultat.getCours().getIdCours()
				+ " AND idEtudiant=" + resultat.getEtudiant().getIdEtudiant());
	}
	
	public boolean droitExamen(Resultat resultat) throws SQLException {
		connectionBDD();
		rs = stmt.executeQuery("SELECT * FROM resultat WHERE"
				+ " idEtudiant=" + resultat.getEtudiant().getIdEtudiant() 
				+ " AND idCours=" + resultat.getCours().getIdCours());
		while(rs.next()){
			return true;
		}
		return false;
	}
	
	public boolean findResultat(int idCours, int idEtudiant) throws SQLException{
		Resultat resultat = new Resultat();
		connectionBDD();
		rs = stmt.executeQuery("SELECT * FROM resultat WHERE idCours=" + idCours + " AND idEtudiant=" + idEtudiant);
		while(rs.next()){
			return true;
		}
		return false;
	}
}
