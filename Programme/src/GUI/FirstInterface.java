package GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Martouf.ContinueAction;
import Martouf.GetAction;
import Martouf.NouveauJeuAction;
import Martouf.OptionsAction;

public class FirstInterface extends JFrame {

	private JTextField textField;
	private JLabel label;

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
		// panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setLayout(new FlowLayout());
		JButton button = new JButton(new NouveauJeuAction(this,
				"Nouvelle Partie"));
		panel.add(button);
		JButton button2 = new JButton(new ContinueAction(this, "Continue"));
		panel.add(button2);
		JButton button3 = new JButton(new OptionsAction(this, "Options"));
		panel.add(button3);
		textField = new JTextField();
		textField.setColumns(10); // On lui donne un nombre de colonnes à
		panel.add(textField);
		label = new JLabel("Rien pour le moment");
		panel.add(label);
		JButton button4 = new JButton(new GetAction(this, "Changer le texte de place"));
		panel.add(button4);
	

		return panel;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JLabel getLabel() {
		return label;
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