package GUI;

import java.awt.Dimension;
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
import javax.swing.JWindow;
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
		setTitle("The Epic School Adventure"); // On donne un titre à l'application
		setResizable(false); // On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // On dit à
														// l'application de se
														// fermer lors du clic
														// sur la croix
		
		setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);// On la rend visible
		setContentPane(buildContentPane());
		}

	/*
	 * private JMenuBar buildMenuBar() { JMenuBar panel = new JMenuBar(); JLabel
	 * label = new JLabel("Ceci est la MenuBar"); panel.add(label); return
	 * panel; }
	 */

	/*private void runImageDebut(){		//Créée une fenête avec notre image de début.
		JLabel label = (new JLabel(new ImageIcon("D:\\Cours\\Ephec\\2TL2\\Programmation avancée - Java\\Projet\\Rapport\\FICTIF.png")));
		add(label);
	}*/
	private JPanel buildContentPane() {
		JPanel panel1 = new JPanel(); // panel qui va contenir le bouton 1.
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS)); // je définis le "style" du panel avec BoxLayout et je lui dis de s'aligner sur la ligne. 
		JButton button1 = new JButton(new NouveauJeuAction(this,"Nouvelle Partie"));
		panel1.add(button1);
		JPanel panel2 = new JPanel(); // panel qui va contenir le bouton 2.
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
		JButton button2 = new JButton(new ContinueAction(this, "Charger partie"));
		panel2.add(button2);
		JPanel panel3 = new JPanel(); // panel qui va contenir le bouton 3.
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS)); 
		JButton button3 = new JButton(new OptionsAction(this, "Options"));
		panel3.add(button3);	
		JPanel panelContainer = new JPanel(); //panel qui va contenir les trois premiers panels.
		panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.PAGE_AXIS));
		panelContainer.add(panel1);
		panelContainer.add(panel2);
		panelContainer.add(panel3);
		return panelContainer;
	}
}