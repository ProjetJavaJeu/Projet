package gui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Combat;
import main.Constantes;
import main.Game;
import PPersonnages.MonstresCommuns;

public class InterfaceCombat extends JFrame implements ActionListener {

	
	private Game game; // ATTENTION ! VERIFIER SI INTERFACECOMBAT A VRAIMENT
						// BESOIN DE game.
	private Combat combat;
	private JLabel etatAttaque;
	private JLabel labelInfo;

	public InterfaceCombat( Game game, Combat combat ) {
		this.game = game;
		this.combat = combat;
	
	}
	public void afficherRemarqueCoup(char attaque, char type) {
		switch (attaque) {
		case 'C':
			etatAttaque.setText(Constantes.CRITIQUE);
			break;

		case 'F':
			etatAttaque.setText(Constantes.FAIL);
			break;

		case 'E':
			System.out
					.println("Il y a une erreur à propos du champ d'infoCoup.");
		}
		etatAttaque.setVisible(true);
		if (type == 'M' | type == 'G') {
			etatAttaque.setBackground(Color.GREEN);
		} else {
			etatAttaque.setBackground(Color.RED);
		}

		try {
			Thread.sleep(2000); // Permet d'attendre deux secondes avant
								// d'effectuer l'attaque adverse.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Post : renvoie un message signifiant que le joueur a gagné ou perdu.
	 */
	public void messageFinDeCombat(String message) {
		labelInfo.setText("message");
	}

	/*
	 * Post : Appelle la méthode messageFinDeCombat et lui passe en paramètre un
	 * String contenant Victoire ou Defaite.
	 */
	public void checkCombat() { // Vérifie si le joueur a gagné ou perdu.
		if (combat.getMonstreKO() == true) {
			messageFinDeCombat(VICTOIRE);
		} else if (combat.getJoueurKO() == true) {
			messageFinDeCombat(DEFAITE);
		}

		try {
			Thread.sleep(3000);
			this.dispose();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void majInformations(int frappe, char typeAttaquant) {
		if (typeAttaquant == 'M' | typeAttaquant == 'G') {
			labelInfo.setText("Vous infligez " + frappe
					+ " points de dégats ! ");
		} else {
			labelInfo.setText("Le monstre vous inflige " + frappe
					+ " points de dégats");
		}
	}

	@Override
	/*
	 * Lorsque l'utilisateur clique sur le bouton attaque, une attaque est
	 * lancée du joueur sur le monstre.
	 */
	public void actionPerformed(ActionEvent arg0) {
		combat.setMonstre((MonstresCommuns) combat.attaque(combat.getJoueur(),
				combat.getMonstre())); // Typecast c'est la vie ! <3 <3 <3
		majInformations(combat.getFrappe(), combat.getJoueur().getType());
		afficherRemarqueCoup(combat.getEtatAttaque(), combat.getJoueur()
				.getType());
		checkCombat();

		game.setJoueur(combat.attaque(combat.getJoueur(), combat.getMonstre()));
		majInformations(combat.getFrappe(), combat.getMonstre().getType());
		afficherRemarqueCoup(combat.getEtatAttaque(), combat.getMonstre()
				.getType());
		checkCombat();
	}
}
