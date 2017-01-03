package view;

import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.*;

import controller.EtudiantController;

@SuppressWarnings("serial")
public class EtudiantView extends JFrame{

	JTextField text_nom;
	JTextField text_prenom;
	JTextField text_adress;
	JTextField text_ddn;
	JTextField text_anneeInscription;
	JButton button;
	EtudiantController listener;

	public EtudiantView() throws HeadlessException {
		init();
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void init() {

		setResizable(false);
		setBounds(550, 350, 380, 300);
		setTitle("Etudiant");
		
		setLayout(new FlowLayout());

		add(new JLabel("nom :             "));
		text_nom = new JTextField(20);
		text_nom.addActionListener(listener);
		add(text_nom);

		add(new JLabel("prenom :          "));
		text_prenom = new JTextField(20);
		text_prenom.addActionListener(listener);
		add(text_prenom);

		add(new JLabel("adress :          "));
		text_adress = new JTextField(20);
		text_adress.addActionListener(listener);
		add(text_adress);
		
		add(new JLabel("date de naiss :   "));
		text_ddn = new JTextField(20);
		text_ddn.addActionListener(listener);
		add(text_ddn);

		add(new JLabel(" annee d'entree : "));
		text_anneeInscription = new JTextField(20);
		text_anneeInscription.addActionListener(listener);
		add(text_anneeInscription);

		button = new JButton("Ajouter Etudiant");
		listener = new EtudiantController();
		listener.setJTextField_Nom(text_nom);
		listener.setJTextField_Prenom(text_prenom);
		listener.setJTextField_Adress(text_adress);
		listener.setJTextField_DDN(text_ddn);
		listener.setJTextField_Annee(text_anneeInscription);
		button.addActionListener(listener);

		add(button);
	}
	
	public void initTextField(){
		text_nom.setText("");
		text_prenom.setText("");
		text_adress.setText("");
		text_ddn.setText("");
		text_anneeInscription.setText("");
	}

}