package view;

import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ResultatController;

public class ResultatView extends JFrame {

	JTextField text_nom;
	JTextField text_date;
	JButton button;
	ResultatController listener;

	public ResultatView() throws HeadlessException {
		init();
		setVisible(true);
	}

	void init() {
		setResizable(false);
		setBounds(550, 350, 360, 300);
		setTitle("Resultat");
		setLayout(new FlowLayout());

		add(new JLabel("id de cours : "));
		text_nom = new JTextField(20);
		text_nom.addActionListener(listener);
		add(text_nom);
		
		add(new JLabel("date de examen : "));
		text_date = new JTextField(20);
		text_date.addActionListener(listener);
		add(text_date);

		button = new JButton("add Etudiant et note");
		listener = new ResultatController();
		listener.setJTextField_Nom(text_nom);
		listener.setJTextField_Date(text_date);
		button.addActionListener(listener);
		add(button);

	}
}
