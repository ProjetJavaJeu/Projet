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
	private int choix = 0;
	private Game game;
	private Image image;
	public InterfaceIntro(Game game) {
		this.game = game;
	}

	@Override
	public void init(GameContainer container, StateBasedGame interfJeu)
			throws SlickException {
		image = new Image(Constantes.IMAGE_INTRO);
		container.getInput().addMouseListener(this);
	}
	@Override
	public void render(GameContainer container, StateBasedGame interfJeu,
			Graphics g) throws SlickException {
		g.drawImage(image, 0, 0);
	}
	

	@Override
	public void update(GameContainer container, StateBasedGame interfJeu,
			int delta) throws SlickException {
			if (choix != 0 & choix != 3){
				initialiserTableauxEtPersonnages();
				container.getInput().removeMouseListener(this);
				interfJeu.enterState(choix, new FadeOutTransition(), new FadeInTransition());
			}
	}

	@Override
	public int getID() {
		return Constantes.NOUV_JEU;
	}
	
	public void mouseClicked(int button, int x, int y, int clickCount){
		
		if (x > 515 & x < 765){
			if (y > 250 & y < 310){
				choix = Constantes.CREATION_PERSO;
			}
			else if (y > 330 & y < 390){
				choix = Constantes.CARTE_JEU;
				System.out.println("Continuer");
			}
			else if (y > 410 & y < 40){
				//choix = Constantes.OPTIONS_JEU;
				System.out.println("Options");
			}
		}
	}
	
	public void initialiserTableauxEtPersonnages(){
		try {
			game.setTabMonstres(game.getInit().initMonstres(game.getTabMonstres()));
			game.getInit().initPerso(game, choix);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
