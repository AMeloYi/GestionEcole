package view;

import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.CoursController;

public class CoursView extends JFrame {

	JTextField text_nom;
	JTextField text_description;
	JTextField text_enseignant;
	JButton button;
	CoursController listener;

	public CoursView() throws HeadlessException {
		init();
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void init() {

		setResizable(false);
		setBounds(550, 350, 360, 300);
		setTitle("Cours");
		
		setLayout(new FlowLayout());

		add(new JLabel("nom de cours : "));
		text_nom = new JTextField(20);
		text_nom.addActionListener(listener);
		add(text_nom);

		add(new JLabel(" Description : "));
		text_description = new JTextField(20);
		text_description.addActionListener(listener);
		add(text_description);

		add(new JLabel(" Enseignant : "));
		text_enseignant = new JTextField(20);
		text_enseignant.addActionListener(listener);
		add(text_enseignant);

		button = new JButton("Ajouter Cours");
		listener = new CoursController();
		listener.setJTextField_Nom(text_nom);
		listener.setJTextField_Description(text_description);
		listener.setJTextField_Enseignant(text_enseignant);
		button.addActionListener(listener);

		add(button);

	}
}
