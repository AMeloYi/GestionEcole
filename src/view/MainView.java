package view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView {
	public static void main(String[] args) throws Exception {
		MainFrame mf = new MainFrame();
	}
}

class MainFrame extends JFrame implements ActionListener{

	JLabel label_bienvenu;
	JButton button_Inscription_Enseignant;
	JButton button_Inscription_Etudiant;
	JButton button_Inscription_Cours;
	JButton button_Inscription_Resultat;
	
	public MainFrame() throws HeadlessException {
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void init() {
		setResizable(false);
		setBounds(500, 300, 340, 300);
		setTitle("Geation D'Ecole");
		setLayout(new FlowLayout());
		
		label_bienvenu = new JLabel("BienVenu!");
		label_bienvenu.setFont(new Font("", Font.BOLD, 40));
		add(label_bienvenu);
		
		button_Inscription_Enseignant = new JButton("Inscription d'un Enseignant");
		button_Inscription_Enseignant.addActionListener(this);
		add(button_Inscription_Enseignant);
		
		button_Inscription_Etudiant = new JButton("Inscription d'un Etudiant");
		button_Inscription_Etudiant.addActionListener(this);
		add(button_Inscription_Etudiant);
		
		button_Inscription_Cours = new JButton("Inscription d'un Cours");
		button_Inscription_Cours.addActionListener(this);
		add(button_Inscription_Cours);
		
		button_Inscription_Resultat = new JButton("Enregisrement des Resultats");
		button_Inscription_Resultat.addActionListener(this);
		add(button_Inscription_Resultat);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button_Inscription_Etudiant){EtudiantView ev = new EtudiantView();}
		else if(e.getSource() == button_Inscription_Cours){CoursView cv = new CoursView();}
		else if(e.getSource() == button_Inscription_Enseignant){EnseignantView env = new EnseignantView();}
		else {ResultatView rv = new ResultatView();}
	}
	}