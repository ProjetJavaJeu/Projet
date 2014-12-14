package gui;

import main.Combat;
import main.Game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class InterfaceJeu extends StateBasedGame {
	private final static int MAX_FPS = 60;
	private AppGameContainer appGame;
	private Game game;
	public InterfaceJeu(String name, Game game) {
		super(name);
		this.game = game;
	}
	
	public void launchMap() throws SlickException{
		appGame = new AppGameContainer(this, 1280, 720, true);
		appGame.setTargetFrameRate(MAX_FPS);
		appGame.start();
		appGame.setAlwaysRender(false);
		appGame.setTargetFrameRate(MAX_FPS);
		appGame.setMaximumLogicUpdateInterval(MAX_FPS);
	}
	
	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new InterfaceIntro(game));
		addState(new InterfaceCreationPersonnage(game));
		addState(new InterfaceCarte());
		addState(new InterfaceCombat(game, new Combat(game)));
	}
}
