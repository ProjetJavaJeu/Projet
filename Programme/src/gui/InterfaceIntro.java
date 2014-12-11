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
	private MouseOverArea boutonNouvellePartie;
	private Image image;

	public InterfaceIntro(Game game) {
		this.game = game;
	}

	@Override
	public void init(GameContainer container, StateBasedGame interfJeu)
			throws SlickException {
		image = new Image("/ressources/map/sunrise.png");
	}/*MouseOverArea nouvJeuArea = new MouseOverArea(container, image, 353, 182,
			(int) Constantes.LARGEUR_BOUTTON,
			(int) Constantes.HAUTEUR_BOUTTON);
*/
	@Override
	public void render(GameContainer container, StateBasedGame interfJeu,
			Graphics g) throws SlickException {

		// float xInitial= (container.getWidth() - Constantes.LARGEUR_BOUTTON) /
		// 2;
		// float yInitial = (container.getHeight() - Constantes.HAUTEUR_BOUTTON)
		// / 2 * 0.75f;
		g.drawString("InterfaceIntro", 100, 100);
		g.drawImage(image, 0, 75);
		/*
		 * g.drawRect(xInitial, yInitial, Constantes.LARGEUR_BOUTTON,
		 * Constantes.HAUTEUR_BOUTTON); g.drawString(Constantes.NOUV_PARTIE,
		 * xInitial + 7, yInitial + 7); // + x : Permet de centrer le texte.
		 * g.drawRect(xInitial, yInitial + 50, Constantes.LARGEUR_BOUTTON,
		 * Constantes.HAUTEUR_BOUTTON); g.drawString(Constantes.CONT_PARTIE,
		 * xInitial + 7, yInitial + 58);
		 */
	}

	@Override
	public void update(GameContainer container, StateBasedGame interfJeu,
			int delta) throws SlickException {
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
		 * monstres. game.getInit() .initPerso(game, choix); // On cr�e le //
		 * personnages
		 */

	}

	@Override
	public int getID() {
		return ID;
	}

}
