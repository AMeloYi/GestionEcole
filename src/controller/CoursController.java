package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.CoursDAO;
import dao.EnseignantDAO;
import dao.EtudiantDAO;
import dao.ResultatDAO;
import model.Cours;
import model.Enseignant;
import model.Etudiant;
import model.Resultat;

public class CoursController implements ActionListener {

	JTextField text_nom;
	JTextField text_description;
	JTextField text_enseignant;
	private String str;

	public void setJTextField_Nom(JTextField text) {
		this.text_nom = text;
	}

	public void setJTextField_Description(JTextField text) {
		this.text_description = text;
	}

	public void setJTextField_Enseignant(JTextField text) {
		this.text_enseignant = text;
	}

	public void initStr() {
		this.str = "A";
	}
	
	public void initTextField(){
		text_nom.setText("");
		text_description.setText("");
		text_enseignant.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		CoursDAO coursDAO = new CoursDAO();
		Cours cours = new Cours();
		EnseignantDAO enseignantDAO = new EnseignantDAO();
		EtudiantDAO etudiantDAO = new EtudiantDAO();
		ResultatDAO resultatDAO = new ResultatDAO();
		Resultat resultat = new Resultat();

		cours.setNomCours(text_nom.getText());
		cours.setDescription(text_description.getText());
		cours.setEnseignant(Integer.parseInt(text_enseignant.getText()));
		
		try{
			if(enseignantDAO.findEnseignant(Integer.parseInt(text_enseignant.getText())) == null){
				JOptionPane.showMessageDialog(null, "L'enseignant n'exite pas!", "ERREUR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				coursDAO.ajouterCours(cours);
				initStr();
				while (str != null) {
					str = JOptionPane.showInputDialog(null, "idEtudiant", "Ajouter Etudiant", JOptionPane.PLAIN_MESSAGE);
					if(str != null){
						if(etudiantDAO.findEtudiant(Integer.parseInt(str)) == null){
							JOptionPane.showMessageDialog(null, "L'etudiant n'exite pas!", "ERREUR", JOptionPane.ERROR_MESSAGE);
						}
						else{
							resultat.setCours(cours);
							resultat.setEtudiant(etudiantDAO.findEtudiant(Integer.parseInt(str)));
							resultatDAO.ajouterEtudiantParCours(resultat);
						}
						}
					}
				}
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		initTextField();
		}
}

