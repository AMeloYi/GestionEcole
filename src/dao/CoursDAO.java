package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Cours;

public class CoursDAO {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/gestionEcole";
	static final String USER = "root";
	static final String PASS = "";
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public CoursDAO() {
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
	
	public void ajouterCours(Cours cours) throws Exception {
		connectionBDD();
		stmt.executeUpdate("INSERT INTO "
				+ "cours (idenseignant,nomCours,description) "
				+ "VALUES (" 
				+ cours.getEnseignant() + ",'" 
				+ cours.getnomCours() + "','" 
				+ cours.getDescription() + "')");
		
		rs = stmt.executeQuery("SELECT MAX(idCours) FROM cours");
		while(rs.next()){
			cours.setIdCours(rs.getInt(1));
		}
	}
	
	public Cours findCours(int id) throws SQLException {
		Cours cours = new Cours();
		connectionBDD();
		rs = stmt.executeQuery("SELECT * FROM cours WHERE idCours=" + id);
		while(rs.next()){
			cours.setIdCours(id);
			cours.setDescription(rs.getString("description"));
			cours.setEnseignant(rs.getInt("idEnseignant"));
			cours.setNomCours(rs.getString("nomCours"));
			return cours;
		}
		return null;
	}
	
}
