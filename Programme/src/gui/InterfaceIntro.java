package gui;

import main.Game;
import main.Constantes;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class InterfaceIntro extends BasicGameState implements MouseListener {

	private final static int ID = 1;
	private int choix = 0;
	private Game game;
	private Image image;
	public InterfaceIntro(Game game) {
		this.game = game;
	}

	@Override
	public void init(GameContainer container, StateBasedGame interfJeu)
			throws SlickException {
		image = new Image("/ressources/map/sunrise.png");
		container.getInput().addMouseListener(this);
	}
	@Override
	public void render(GameContainer container, StateBasedGame interfJeu,
			Graphics g) throws SlickException {
		g.drawImage(image, 0, 75);
	}

	@Override
	public void update(GameContainer container, StateBasedGame interfJeu,
			int delta) throws SlickException {
			if (choix != 0){
				interfJeu.enterState(choix);
			}
		
		/*
		 * if (container.getInput().isButton1Pressed(1)){
		 * interfJeu.enterState(Constantes.CREATION_PERSO, new
		 * FadeOutTransition(), new FadeInTransition()); } else {
		 * interfJeu.enterState(Constantes.CARTE_JEU, new FadeOutTransition(),
		 * new FadeInTransition()); }
		 */

		/*
		 * A replacer
		 * 
		 * game.setTabMonstres(game.getInit().initMonstres(
		 * game.getTabMonstres())); // On remplit le(s) tableau(x) // de
		 * monstres. game.getInit() .initPerso(game, choix); // On crée le //
		 * personnages
		 */

	}

	@Override
	public int getID() {
		return ID;
	}
	
	public void mouseClicked(int button, int x, int y, int clickCount){
		if (x > 305 & x < 495){
			if (y > 125 & y < 160){
				choix = Constantes.CREATION_PERSO;
			}
			else if (y > 195 & y < 226){
				//choix = Constantes.CONT_JEU;
			}
			else if (y > 253 & y < 296){
				choix = Constantes.OPTIONS_JEU;
			}
		}
	}

}
