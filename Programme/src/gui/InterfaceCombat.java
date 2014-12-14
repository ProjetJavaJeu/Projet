package gui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Combat;
import main.Constantes;
import main.Game;
import PPersonnages.MonstresCommuns;

public class InterfaceCombat extends BasicGameState implements ActionListener {

	private Game game;
	private Combat combat;
	private boolean initCombat;
	private Image imageJoueur;
	private Image imageMonstre;
	private Image imageOrc;
	private Image imageMurloc;
	private Image imageMage;
	private Image imageGuerrier;
	private Image imageFond;
	private Rectangle rectAttaque;
	private Graphics f;
	
	public InterfaceCombat(Game game) {
		this.game = game;
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame interfJeu)
			throws SlickException {
			imageMage = new Image(Constantes.PATH_MAGE);
			imageGuerrier = new Image(Constantes.PATH_GUERRIER);
			imageOrc = new Image(Constantes.PATH_ORC);
			imageMurloc = new Image(Constantes.PATH_MURLOC);
			imageFond = new Image(Constantes.PATH_FOND);
			rectAttaque = new Rectangle((container.getWidth() - 200) / 2, (container.getHeight() - 100) , 200, 50);
			f = new Graphics();
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame interfJeu, Graphics g)
			throws SlickException {
		if (initCombat == false){
			initCombat();
		}
		
		
		setImageJoueur();
		setImageMonstre();
		f.setColor(new Color(212, 129, 47));
		g.drawImage(imageFond, 0, 0);
		g.drawImage(imageJoueur, 80, 180);
		g.drawImage(imageMonstre, 850, 180);
		f.draw(rectAttaque);
		f.fill(rectAttaque);
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame interfJeu, int delta)
			throws SlickException {
		
	}
	
	@Override
	public int getID() {
		return Constantes.COMBAT;
	}
	
	public void initCombat(){
		combat = new Combat(game);
		initCombat = true;
	}
	
	public void setImageJoueur(){
		if (combat.getJoueur().getType() == 'M'){
			imageJoueur = imageMage;
		}
		else {
			imageJoueur = imageGuerrier;
		}
	}
	
	public void setImageMonstre(){
		if (combat.getMonstre().getType() == '1'){
			imageMonstre = imageMurloc;
		}
		else {
			imageMonstre = imageOrc;
		}
	}
	/*public void afficherRemarqueCoup(char attaque, char type) {
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
			messageFinDeCombat(Constantes.VICTOIRE);
		} else if (combat.getJoueurKO() == true) {
			messageFinDeCombat(Constantes.DEFAITE);
		}

		try {
			Thread.sleep(3000);
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
	public void actionPerformed(ActionEvent container) {
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
