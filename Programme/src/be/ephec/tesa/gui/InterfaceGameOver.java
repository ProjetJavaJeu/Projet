package be.ephec.tesa.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import be.ephec.main.Constantes;

public class InterfaceGameOver extends BasicGameState {
private Graphics f;
	@Override
	public void init(GameContainer container, StateBasedGame interfJeu)
			throws SlickException {
		f = new Graphics();
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame interfJeu, Graphics g)
			throws SlickException {
		g.setColor(Color.white);
		g.setBackground(Color.black);
		g.drawString("GAME OVER", (container.getWidth() / 2) - 20, container.getHeight() / 2);
	}

	@Override
	public void update(GameContainer container, StateBasedGame interfJeu, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		return Constantes.GAME_OVER;
	}

}
