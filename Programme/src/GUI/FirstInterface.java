package GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Martouf.ContinueAction;
import Martouf.NouveauJeuAction;
import Martouf.OptionsAction;

public class FirstInterface extends JFrame {

	public FirstInterface() {
		super();
		build();// On initialise notre fenêtre
	}

	private void build() {
		setTitle("Ma première fenêtre"); // On donne un titre à l'application
		setSize(800, 600); // On donne une taille à notre fenêtre
		setLocationRelativeTo(null); // On centre la fenêtre sur l'écran
		setResizable(false); // On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // On dit à
														// l'application de se
														// fermer lors du clic
														// sur la croix
		add(new JLabel(new ImageIcon("D:\\Cours\\Ephec\\2TL2\\Programmation avancée - Java\\Projet\\Rapport\\FICTIF.png")));
		setContentPane(buildContentPane());
		// setJMenuBar(buildMenuBar());
	}

	/*
	 * private JMenuBar buildMenuBar() { JMenuBar panel = new JMenuBar(); JLabel
	 * label = new JLabel("Ceci est la MenuBar"); panel.add(label); return
	 * panel; }
	 */

	private JPanel buildContentPane() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		JButton button = new JButton(new NouveauJeuAction(this,
				"Nouvelle Partie"));
		panel.add(button);
		JButton button2 = new JButton(new ContinueAction(this, "Continue"));
		panel.add(button2);
		JButton button3 = new JButton(new OptionsAction(this, "Options"));
		panel.add(button3);
	

		return panel;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FirstInterface fenetre = new FirstInterface();
				fenetre.setVisible(true);// On la rend visible
			}
		});
	}
}