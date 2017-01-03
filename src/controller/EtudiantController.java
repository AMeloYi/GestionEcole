package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.EtudiantDAO;
import model.Etudiant;

public class EtudiantController implements ActionListener{
	JTextField text_nom;
	JTextField text_prenom;
	JTextField text_adress;
	JTextField text_ddn;
	JTextField text_anneeInscription;


	public void setJTextField_Nom(JTextField text) {
		this.text_nom = text;
	}

	public void setJTextField_Prenom(JTextField text) {
		this.text_prenom = text;
	}

	public void setJTextField_Adress(JTextField text) {
		this.text_adress = text;
	}
	
	public void setJTextField_DDN(JTextField text){
		this.text_ddn = text;
	}

	public void setJTextField_Annee(JTextField text) {
		this.text_anneeInscription = text;
	}

	public void initTextField(){
		text_nom.setText("");
		text_prenom.setText("");
		text_adress.setText("");
		text_ddn.setText("");
		text_anneeInscription.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		EtudiantDAO etudiantDAO =new EtudiantDAO();
		Etudiant etudiant = new Etudiant();
		
		etudiant.setNomEtudiant(text_nom.getText());
		etudiant.setPrenomEtudiant(text_prenom.getText());
		etudiant.setAdress(text_adress.getText());
		etudiant.setDateDN(text_ddn.getText());
		etudiant.setAnneeInscription(text_anneeInscription.getText());

		try {
			etudiantDAO.ajouterEtudiant(etudiant);
			JOptionPane.showMessageDialog(null, "Cet etudiant est ajoute!", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
			this.initTextField();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
