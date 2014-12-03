package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;

import main.Combat;
import main.Player;

import org.newdawn.slick.SlickException;

import PPersonnages.Personnage;

public class InterfaceCombat extends JFrame {
	final static String PATH_GUERRIER = "ressources/imagesCombat/warrior.jpg";
	final static String PATH_MAGE = "ressources/imagesCombat/mage2.jpg";
	private static final long serialVersionUID = 2L;
	private Combat combat;

	public InterfaceCombat(Combat combat) throws SlickException {
		this.combat = combat;
		// getContentPane().setBackground(Color.black);
		getContentPane().setLayout(new BorderLayout(0, 0));
		creationPanelJoueur();
		creationPanelMonstre();
		creationPanelAction();
	}

	public void creationPanelJoueur() {
		// Panel Joueur
		JPanel playerPanel = new JPanel();
		getContentPane().add(playerPanel, BorderLayout.WEST);
		playerPanel.setLayout(new BorderLayout(0, 0));
		// playerPanel.setBackground(Color.black);
		creationLabelJoueur(playerPanel);
		playerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}

	public void creationLabelJoueur(JPanel playerPanel) {
		JLabel playerLabel = new JLabel();
		// Chemin avec Slick mettre un slash pour commencer. Avec Swing PAS !
		if (combat.getPlayerType() == 'G') {
			playerLabel.setIcon(new ImageIcon(PATH_GUERRIER));
		} else {
			playerLabel.setIcon(new ImageIcon(PATH_MAGE));
		}
		playerPanel.add(playerLabel);
	}

	public void creationPanelMonstre() {
		// Panel monstre
		JPanel panelMonstre = new JPanel();
		getContentPane().add(panelMonstre, BorderLayout.EAST);
		panelMonstre.setLayout(new BorderLayout(0, 0));
		// enemyPanel.setBackground(Color.black);
		creationLabelMonstre(panelMonstre);
	}

	public void creationLabelMonstre(JPanel enemyPanel) {
		JLabel enemyLabel = new JLabel();
		if (combat.getMonstreType() == '1') {
			enemyLabel
					.setIcon(new ImageIcon("ressources/imagesCombat/orc2.jpg"));
		} else if (combat.getMonstreType() == '2') {
			enemyLabel.setIcon(new ImageIcon(
					"ressources/imagesCombat/murloc.jpg"));
		}
		enemyPanel.add(enemyLabel);
	}

	public void creationPanelAction() {
		// Panel avec le bouton d'attaque et le champ d'info.
		JPanel actionPanel = new JPanel();
		getContentPane().add(actionPanel, BorderLayout.SOUTH);
		JButton btnAttaque = new JButton("Attaque");
		actionPanel.add(btnAttaque);
		JLabel label = new JLabel("Zone de texte d'informations");
		actionPanel.add(label);
	}

}
