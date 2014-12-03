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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Combat;
import main.Game;
import main.Player;

import org.newdawn.slick.SlickException;

import PPersonnages.Personnage;

public class InterfaceCombat extends JFrame implements ActionListener {

	final static String PATH_GUERRIER = "ressources/imagesCombat/warrior.jpg";
	final static String PATH_MAGE = "ressources/imagesCombat/mage2.jpg";
	final static String PATH_ORC = "ressources/imagesCombat/orc2.jpg";
	final static String PATH_MURLOC = "ressources/imagesCombat/murloc.jpg";
	final static String CRITIQUE = " Coup Critique !!";
	final static String FAIL = "Rat� !";

	private static final long serialVersionUID = 2L;
	private Game game;									// ATTENTION ! VERIFIER SI INTERFACECOMBAT A VRAIMENT BESOIN DE game.
	private Combat combat;
	private JLabel etatAttaque;
	private JLabel labelInfo;
	
	public InterfaceCombat(Game game, Combat combat) {
		this.game = game;
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
		if (combat.getJoueur().getType() == 'G') {
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
		if (combat.getMonstre().getType() == '1') {
			enemyLabel
					.setIcon(new ImageIcon(PATH_ORC));
		} else if (combat.getMonstre().getType() == '2') {
			enemyLabel.setIcon(new ImageIcon(
					PATH_MURLOC));
		}
		enemyPanel.add(enemyLabel);
	}

	public void creationPanelAction() {
		// Panel avec le bouton d'attaque et le champ d'info.
		JPanel actionPanel = new JPanel();
		getContentPane().add(actionPanel, BorderLayout.SOUTH);
		JButton btnAttaque = new JButton("Attaque");
		btnAttaque.addActionListener(this);
		actionPanel.add(btnAttaque);
		labelInfo = new JLabel("C'est votre tour !");
		actionPanel.add(labelInfo);

		JPanel remarqueCoup = new JPanel();
		getContentPane().add(remarqueCoup, BorderLayout.NORTH);
		
		etatAttaque = new JLabel("");
		etatAttaque.setVisible(false);
		remarqueCoup.add(etatAttaque);
	}

	public void afficherRemarqueCoup(char attaque, char type){
		switch (attaque) {
		case 'C':
			etatAttaque.setText(CRITIQUE);
			break;

		case 'F':
			etatAttaque.setText(FAIL);
			break;

		case 'E':
			System.out.println("Il y a une erreur � propos du champ d'infoCoup.");
		}
		etatAttaque.setVisible(true);
		if (type == 'M' | type == 'G'){
			etatAttaque.setBackground(Color.GREEN);
		}
		else {
			etatAttaque.setBackground(Color.RED);
		}
			
		try {
			Thread.sleep(2000);	//Permet d'attendre deux secondes avant d'effectuer l'attaque adverse.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void messageFinDeCombat(){
		labelInfo.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		combat.setMonstre(afficherRemarqueCoup(combat.attaque(combat.getJoueur(), combat.getMonstre()), combat.getJoueur().getType()));
		if (combat.getMonstreKO() == true){
			messageFinDeCombat();
		}
		afficherRemarqueCoup(combat.attaque(combat.getJoueur(), combat.getMonstre()), combat.getJoueur().getType());
		
	}

}
