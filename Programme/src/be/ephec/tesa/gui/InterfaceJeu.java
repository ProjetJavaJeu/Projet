package be.ephec.tesa.gui;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import be.ephec.main.Game;

public class InterfaceJeu extends StateBasedGame {
	// dans main.constantes?
	private final static int MAX_FPS = 60;
	private AppGameContainer appGame;
	private Game game;
	public InterfaceJeu(String name, Game game) {
		super(name);
		this.game = game;
	}
	
	public void demarrerJeu() throws SlickException{
		appGame = new AppGameContainer(this, 1280, 720, true);
		appGame.setTargetFrameRate(MAX_FPS);
		appGame.setAlwaysRender(false);
		appGame.setTargetFrameRate(MAX_FPS);
		appGame.setMaximumLogicUpdateInterval(MAX_FPS);
		appGame.start();
	}
	
	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new InterfaceIntro(game));
		addState(new InterfaceCreationPersonnage(game));
		addState(new InterfaceCarte(game));
		addState(new InterfaceCombat(game));
		addState(new InterfaceGameOver());
	}
}
