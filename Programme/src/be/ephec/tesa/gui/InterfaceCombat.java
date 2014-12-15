package be.ephec.tesa.gui;

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
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import be.ephec.main.Combat;
import be.ephec.main.Constantes;
import be.ephec.main.Game;
import be.ephec.tesa.personnages.MonstresCommuns;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceCombat extends BasicGameState implements
		ComponentListener {

	private Game game;
	private Combat combat;
	private int etatCombat; // 0 = début, 1 = init, 2 = combat, 3 = combat fini, 4 = victoire, 5 = defaite;
	private Image imageJoueur;
	private Image imageMonstre;
	private Image imageOrc;
	private Image imageMurloc;
	private Image imageMage;
	private Image imageGuerrier;
	private Image imageFond;
	private Rectangle rectAttaque;
	private Rectangle infosCombatPersonnage;
	private Rectangle infosCombatMonstre;
	private Rectangle finDeCombat;
	private Graphics f;
	private MouseOverArea boutonAttaque;
	private MouseOverArea boutonFinDeCombat;
	private int xPositionBoutonAttaque;
	private int yPositionBoutons;
	private boolean finCombat;
	
	public InterfaceCombat(Game game) {
		this.game = game;
		etatCombat = 0;
		finCombat = false;
	}

	@Override
	public void init(GameContainer container, StateBasedGame interfJeu)
			throws SlickException {
		
		imageMage = new Image(Constantes.PATH_MAGE);
		imageGuerrier = new Image(Constantes.PATH_GUERRIER);
		imageOrc = new Image(Constantes.PATH_ORC);
		imageMurloc = new Image(Constantes.PATH_MURLOC);
		imageFond = new Image(Constantes.PATH_IMAGEFOND);
		
		xPositionBoutonAttaque = 80;
		yPositionBoutons = (container.getHeight() - 200);
		f = new Graphics();

		rectAttaque = new Rectangle(xPositionBoutonAttaque, yPositionBoutons,
				200, 50);
		
		boutonAttaque = new MouseOverArea(container, new Image(
				xPositionBoutonAttaque, yPositionBoutons),
				xPositionBoutonAttaque, yPositionBoutons, 200, 70, this);
		
		boutonFinDeCombat = new MouseOverArea(container, new Image(
				(container.getWidth() - 200) / 2,
				(container.getHeight() - 50) / 2),
				(container.getWidth() - 200) / 2,
				(container.getHeight() - 50) / 2, 200, 50, this);

		infosCombatPersonnage = new Rectangle((container.getWidth()
				- Constantes.MARGE_IMAGE - 300), yPositionBoutons, 300, 60);
		infosCombatMonstre = new Rectangle((container.getWidth()
				- Constantes.MARGE_IMAGE - 300), yPositionBoutons + 70, 300, 60);

		finDeCombat = new Rectangle((container.getWidth() - 200) / 2,
				(container.getHeight() - 50) / 2, 200, 50);
	}

	@Override
	public void render(GameContainer container, StateBasedGame interfJeu,
			Graphics g) throws SlickException {
		if (etatCombat == 0) {
			initCombat(); 			//Crée l'objet qui va éxecuter les actions du combat. Initialise un monstre.
		}
		
		setImageJoueur();
		setImageMonstre();
		g.setColor(Color.black);
		f.setColor(new Color(212, 129, 47));
		g.drawImage(imageFond, 0, 0);
		g.drawImage(imageJoueur, Constantes.MARGE_IMAGE, 180);
		g.drawImage(imageMonstre, container.getWidth() - Constantes.MARGE_IMAGE
				- imageMonstre.getWidth(), 180);
		f.draw(rectAttaque);
		f.fill(rectAttaque);
		f.draw(infosCombatPersonnage);
		f.fill(infosCombatPersonnage);
		f.draw(infosCombatMonstre);
		f.fill(infosCombatMonstre);

		g.drawString("Attaquer", xPositionBoutonAttaque + 60,
				yPositionBoutons + 15);

		if (etatCombat == 2) {
			g.drawString("Vous infligez " + combat.getFrappePersonnage()
					+ " dégats",
					(container.getWidth() - Constantes.MARGE_IMAGE - 300),
					yPositionBoutons);
			g.drawString(combat.getMonstre().getNom() + " vous inflige "
					+ combat.getFrappeMonstre() + " dégats",
					(container.getWidth() - Constantes.MARGE_IMAGE - 300),
					yPositionBoutons + 70);
		}

		else if (combat.getMonstreKO() == true) {
			
			g.drawString(Constantes.VICTOIRE, (container.getWidth()
					- Constantes.MARGE_IMAGE - 300), yPositionBoutons);
			g.drawString("Vous gagnez " + combat.getMonstre().xpDonnee()
					+ " points d'éxpériences", container.getWidth()
					- Constantes.MARGE_IMAGE - 300, yPositionBoutons + 70);
			f.draw(finDeCombat);
			f.fill(finDeCombat);
			g.drawString("RETOUR A LA CARTE", (container.getWidth() - 200) / 2,
					(container.getHeight() - 30) / 2);
		} 
		else if (combat.getJoueurKO() == true){
			g.drawString(Constantes.DEFAITE, (container.getWidth()
					- Constantes.MARGE_IMAGE - 300), yPositionBoutons);
			f.draw(finDeCombat);
			f.fill(finDeCombat);
			g.drawString("OK", (container.getWidth() - 200) / 2,
					(container.getHeight() - 30) / 2);
		}

		boutonAttaque.render(container, g);
		boutonFinDeCombat.render(container, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame interfJeu,
			int delta) throws SlickException {
		if (finCombat == true){
			interfJeu.enterState(etatCombat);
		}
	}

	@Override
	public int getID() {
		return Constantes.COMBAT;
	}

	public void initCombat() {
		combat = new Combat(game);
		etatCombat = 1;
	}

	public void setImageJoueur() {
		if (combat.getJoueur().getType() == 'M') {
			imageJoueur = imageMage;
		} else {
			imageJoueur = imageGuerrier;
		}
	}

	public void setImageMonstre() {
		if (combat.getMonstre().getType() == '1') {
			imageMonstre = imageOrc;
		}

		else {
			imageMonstre = imageMurloc;
		}
	}

	public void frappePersonnage() {
		combat.setMonstre(combat.attaqueSurMonstre());
	}

	public void frappeMonstre() {
		game.setJoueur(combat.attaqueSurPersonnage());
				
	}

	@Override
	public void componentActivated(AbstractComponent e) {
		if ((e.getX()== 80) & (combat.getJoueurKO() == false) & (combat.getMonstreKO() == false)){
			etatCombat = 2;
			frappePersonnage();
			if (combat.getMonstreKO()){
				etatCombat = 5;
			}
			
			if (combat.getMonstreKO() == false) {
				frappeMonstre();
				if (combat.getJoueurKO()){
					etatCombat = 7;
				}
			}
		}
		else if(e.getX() == 540){
			finCombat = true;	
		}
	}
}
