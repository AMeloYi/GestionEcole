package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.EnseignantDAO;
import model.Enseignant;

public class EnseignantController implements ActionListener {

	JTextField text_nom;
	JTextField text_prenom;
	JTextField text_date;
	JTextField text_salaire;

	public void setJTextField_Nom(JTextField text) {
		this.text_nom = text;
	}

	public void setJTextField_Prenom(JTextField text) {
		this.text_prenom = text;
	}

	public void setJTextField_Date(JTextField text) {
		this.text_date = text;
	}

	public void setJTextField_Salaire(JTextField text) {
		this.text_salaire = text;
	}
	
	public void initTextField(){
		text_nom.setText("");
		text_prenom.setText("");
		text_date.setText("");
		text_salaire.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		EnseignantDAO EnseignantDAO = new EnseignantDAO();
		Enseignant enseignant = new Enseignant();
		
		enseignant.setNomEnseignant(text_nom.getText());
		enseignant.setPrenomEnseignant(text_prenom.getText());
		enseignant.setDateEntree(text_date.getText());
		enseignant.setSalaire(Integer.parseInt(text_salaire.getText()));
		
		try {
			EnseignantDAO.ajouterEnseignant(enseignant);
			JOptionPane.showMessageDialog(null, "Cet enseignant est ajoute!", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
			this.initTextField();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
