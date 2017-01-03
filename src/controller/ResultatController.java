package controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.CoursDAO;
import dao.EtudiantDAO;
import dao.ResultatDAO;
import model.Resultat;

public class ResultatController implements ActionListener {

	JTextField text_nom;
	JTextField text_date;
	private String str1;
	private String str2;

	public void setJTextField_Nom(JTextField text) {
		this.text_nom = text;
	}
	
	public void setJTextField_Date(JTextField text) {
		this.text_date = text;
	}

	public void initStr() {
		this.str1 = "A";
		this.str2 = "A";
	}
	
	public void initTextField(){
		text_nom.setText("");
		text_date.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int idCours = 0;
		Resultat resultat = new Resultat();
		CoursDAO coursDAO = new CoursDAO();
		ResultatDAO resultatDAO = new ResultatDAO();
		EtudiantDAO etudiantDAO = new EtudiantDAO();
		try {
			idCours = Integer.parseInt(text_nom.getText());
			if(coursDAO.findCours(idCours) == null){
				JOptionPane.showMessageDialog(null, "Cet cours n'existe pas!", "ERREUR ", JOptionPane.ERROR_MESSAGE);
			}
			else {
				resultat.setCours(coursDAO.findCours(idCours));
				resultat.setDateResultat(text_date.getText());
				initStr();
		
				while (str1 != null && str2 != null) {
					str1 = JOptionPane.showInputDialog(null, "idEtudiant", "input Etudiant", JOptionPane.PLAIN_MESSAGE);
					if(str1 != null){				
						resultat.setEtudiant(etudiantDAO.findEtudiant(Integer.parseInt(str1)));
						
						if(!resultatDAO.droitExamen(resultat)) {
							JOptionPane.showMessageDialog(null, "Cet etudiant n'a pas de doirt!", "ERREUR ", JOptionPane.ERROR_MESSAGE);
						}
						else {
							str2 = JOptionPane.showInputDialog(null, "note", "input note", JOptionPane.PLAIN_MESSAGE);
							if(str2 != null){
								resultat.setNote(Integer.parseInt(str2));
								resultatDAO.ajouterNote(resultat);
							}
						}
						
						
					}
				}
			}
			} catch (NumberFormatException | HeadlessException | SQLException e1) {
				e1.printStackTrace();
			}
		this.initTextField();
		}
	}
