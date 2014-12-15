package be.ephec.tesa.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * @author Baptiste Vergote & Martin Schreinemachers
 * @Class 2TL2
 * 
 */

public class Hud {
	
	private static final int P_BAR_X = 30;
	private static final int P_BAR_Y = 30;
	private static final Color LIFE_COLOR = new Color(255, 0, 0);
	private static final Color MANA_COLOR = new Color(0, 0, 255);
	private static final Color XP_COLOR = new Color(0, 255, 0);
	private static final int BAR_X = 30 + P_BAR_X;
	private static final int LIFE_BAR_Y = 4 + P_BAR_Y;
	private static final int MANA_BAR_Y = 15 + P_BAR_Y;
	private static final int XP_BAR_Y = 28 + P_BAR_Y;
	private static final int BAR_WIDTH = 80;
	private static final int BAR_HEIGHT = 8;
	
	private Image playerbars;
	

	public void init() throws SlickException {
		this.playerbars = new Image(
				"/ressources/map/HUD/playerBar.png");
	}

	public void render(Graphics g) {
		g.resetTransform();
		  g.setColor(LIFE_COLOR);
		  g.fillRect(BAR_X, LIFE_BAR_Y, .9f * BAR_WIDTH, BAR_HEIGHT);
		  g.setColor(MANA_COLOR);
		  g.fillRect(BAR_X, MANA_BAR_Y, .8f * BAR_WIDTH, BAR_HEIGHT);
		  g.setColor(XP_COLOR);
		  g.fillRect(BAR_X + 20, XP_BAR_Y, .2f * BAR_WIDTH, BAR_HEIGHT);
		  g.drawImage(this.playerbars, P_BAR_X, P_BAR_Y);
	}

}
