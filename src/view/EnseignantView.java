package view;

import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.CoursController;
import controller.EnseignantController;

public class EnseignantView extends JFrame {

	JTextField text_nom;
	JTextField text_prenom;
	JTextField text_date;
	JTextField text_salaire;
	JButton button;
	EnseignantController listener;

	public EnseignantView() throws HeadlessException {
		init();
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void init() {

		setResizable(false);
		setBounds(550, 350, 340, 300);
		setTitle("Enseignant");
		
		setLayout(new FlowLayout());

		add(new JLabel("nom :           "));
		text_nom = new JTextField(20);
		text_nom.addActionListener(listener);
		add(text_nom);

		add(new JLabel("prenom :        "));
		text_prenom = new JTextField(20);
		text_prenom.addActionListener(listener);
		add(text_prenom);

		add(new JLabel("date d'entree : "));
		text_date = new JTextField(20);
		text_date.addActionListener(listener);
		add(text_date);
		
		add(new JLabel("salaire :       "));
		text_salaire = new JTextField(20);
		text_salaire.addActionListener(listener);
		add(text_salaire);

		button = new JButton("Ajouter Enseignant");
		listener = new EnseignantController();
		listener.setJTextField_Nom(text_nom);
		listener.setJTextField_Prenom(text_prenom);
		listener.setJTextField_Date(text_date);
		listener.setJTextField_Salaire(text_salaire);
		button.addActionListener(listener);

		add(button);

	}
}