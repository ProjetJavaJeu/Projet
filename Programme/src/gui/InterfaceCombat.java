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
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Combat;
import main.Constantes;
import main.Game;
import PPersonnages.MonstresCommuns;

public class InterfaceCombat extends BasicGameState implements
		ComponentListener {

	private Game game;
	private Combat combat;
	private boolean initCombat;
	private boolean clickBoutonAttaque;
	private Image imageJoueur;
	private Image imageMonstre;
	private Image imageOrc;
	private Image imageMurloc;
	private Image imageMage;
	private Image imageGuerrier;
	private Image imageFond;
	private Rectangle rectAttaque;
	private Rectangle infosCombat;
	private Graphics f;
	private MouseOverArea boutonAttaque;

	public InterfaceCombat(Game game) {
		this.game = game;
		clickBoutonAttaque = false;
	}

	@Override
	public void init(GameContainer container, StateBasedGame interfJeu)
			throws SlickException {
		imageMage = new Image(Constantes.PATH_MAGE);
		imageGuerrier = new Image(Constantes.PATH_GUERRIER);
		imageOrc = new Image(Constantes.PATH_ORC);
		imageMurloc = new Image(Constantes.PATH_MURLOC);
		imageFond = new Image(Constantes.PATH_IMAGEFOND);
		rectAttaque = new Rectangle((container.getWidth() - 200) / 2,
				(container.getHeight() - 100), 200, 50);
		infosCombat = new Rectangle((container.getWidth() + 200) / 2, (container.getHeight() - 100) , 200, 50);
		f = new Graphics();
		// container.getInput().addMouseListener(this);
		boutonAttaque = new MouseOverArea(container,
				new Image((container.getWidth() - 200) / 2, (container.getHeight() - 100)),(container.getWidth() - 200) / 2, (container.getHeight() - 100), 200, 50, this);
	}

	@Override
	public void render(GameContainer container, StateBasedGame interfJeu,
			Graphics g) throws SlickException {
		if (initCombat == false) {
			initCombat();
		}

		setImageJoueur();
		setImageMonstre();
		g.setColor(Color.black);
		f.setColor(new Color(212, 129, 47));
		g.drawImage(imageFond, 0, 0);
		g.drawImage(imageJoueur, 80, 180);
		g.drawImage(imageMonstre, 850, 180);
		f.draw(rectAttaque);
		f.fill(rectAttaque);
		f.draw(infosCombat);
		g.drawString("Attaquer", (float) ((container.getWidth() - 80) / 2),
				(float) ((container.getHeight() - 83)));
		if (combat.getFrappe() != 0) {
			g.drawString("Vous infligez " + combat.getFrappe() + " dégats",
					(container.getWidth() - 320) / 2,
					(container.getHeight() - 85));
		}
		boutonAttaque.render(container, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame interfJeu,
			int delta) throws SlickException {
		if (combat.getFrappe() != 0){
			frappeMonstre();
				
		}
	}

	@Override
	public int getID() {
		return Constantes.COMBAT;
	}

	public void initCombat() {
		combat = new Combat(game);
		initCombat = true;
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
	
	/*
	 * 
	 * 
	 * /* try { Thread.sleep(3000); } catch (InterruptedException e) {
	 * e.printStackTrace(); } }
	 */
	public void frappePersonnage() {
		combat.setMonstre(combat.attaqueSurMonstre(combat.getMonstre(), combat.getJoueur()));
		clickBoutonAttaque = true;
	}

	public void frappeMonstre(){
		try {
			Thread.sleep(2000); // Permet d'attendre deux secondes avant
								// d'effectuer l'attaque adverse.
			game.setJoueur(combat.attaqueSurPersonnage(combat.getJoueur(),
					combat.getMonstre()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void componentActivated(AbstractComponent e) {
		frappePersonnage();
	}
}
