package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Enseignant;
import model.Etudiant;

public class EnseignantDAO {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/gestionEcole";
	static final String USER = "root";
	static final String PASS = "";
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public EnseignantDAO() {
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
	
	public void ajouterEnseignant(Enseignant enseignant) throws Exception {
		connectionBDD();
		stmt.executeUpdate("INSERT INTO "
				+ "enseignant (nomEnseignant,prenomEnseignant,dateEntree,salaire) "
				+ "VALUES ('" 
				+ enseignant.getNomEnseignant() + "','" 
				+ enseignant.getPrenomEnseignant() + "','"
				+ enseignant.getDateEntree() + "'," 
				+ enseignant.getSalaire() + ")");
		
		rs = stmt.executeQuery("SELECT MAX(idEnseignant) FROM cours");
		while(rs.next()){
			enseignant.setIdEnseignant(rs.getInt(1));
		}
	}
	
	public boolean siEnseignantExiste(Enseignant enseignant) throws SQLException{
		connectionBDD();
		rs = stmt.executeQuery("SELECT * FROM enseignant WHERE idEnseignant=" + enseignant.getIdEnseignant());
		while(rs.next()){
			return true;
		}
		return false;
	}
	
	public Enseignant findEnseignant(int id) throws SQLException {
		Enseignant enseignant = new Enseignant();
		connectionBDD();
		rs = stmt.executeQuery("SELECT * FROM enseignant WHERE idEnseignant=" + id);
		while(rs.next()){
			enseignant.setIdEnseignant(rs.getInt("idEnseignant"));
			enseignant.setNomEnseignant(rs.getString("nomEnseignant"));
			enseignant.setPrenomEnseignant(rs.getString("PrenomEnseignant"));
			enseignant.setDateEntree(rs.getString("dateEntree"));
			enseignant.setSalaire(rs.getInt("salaire"));
			return enseignant;
		}
		return null;
	}
	
}
